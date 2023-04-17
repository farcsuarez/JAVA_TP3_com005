/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Grupo I Miembros: NESTOR DANIEL AVACA NORBERTO DIAZ RICARDO LUIS
 * MARTINEZ FABIAN SUAREZ BERNARDO VELAZQUEZ
 * @author
 */
public class ListaParticipantes {

    private List<Participante> participantes;
    private String nombreArchivo;

    public ListaParticipantes() {
        participantes = new ArrayList<>();
        nombreArchivo = "participantes.csv";
    }

    public ListaParticipantes(List<Participante> participantes, String nombreArchivo) {
        this.participantes = participantes;
        this.nombreArchivo = nombreArchivo;
    }

    void cargarDB(ListaPronosticos pronosticos) {

        //Carga de database SQLite
        //establecemos el objeto Connection
        Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            // Crear el obj comando
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM participantes";

            // tomamos las filas y se guardan en el obj rs
            ResultSet rs = stmt.executeQuery(SQL);

            //recorremos el rs
            while (rs.next()) {

                //lista filtrada
                List<Pronostico> pronostico_participante = new ArrayList<>();

                int idParticipante = rs.getInt("idParticipante");
                String nombre = rs.getString("Nombre");

                // buscar en lista de pronósticos, aquellos que son del participante
                for (Pronostico p : pronosticos.getPronosticos()) {
                    if (p.getIdParticipante() == idParticipante) {
                        //agregar al listado de pronóstico del participante
                        pronostico_participante.add(p);
                    }
                }

                //constrtuír objeto participante
                int puntaje = 0;
                Participante participante = new Participante(
                        idParticipante,
                        nombre,
                        pronostico_participante,
                        puntaje);

                //agregar a la lista
                this.addParticipante(participante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // conn close failed.
                System.out.println(e.getMessage());
            }
        }
    }

    void cargarDeArchivo(ListaPronosticos todos, ListaPartidos partidos) {
        // para las lineas del archivo csv
        String line;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Participante participante;
        int fila = 0;

        Scanner sc = null;
        try {
            sc = new Scanner(new File(this.getNombreArchivo()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                line = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosEquipo);  //muestra los datos levantados 
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vector = line.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int idParticipante = Integer.parseInt(vector[0]);
                String nombre = vector[1];

                // crea el objeto en memoria
                participante = new Participante(idParticipante, nombre);

                // cargo todos los pronósticos como parámetro
                participante.cargarPronosticos(todos, partidos);

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addParticipante(participante);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    void addParticipante(Participante p) {
        this.participantes.add(p);
    }

    void calcularPuntajes() {
        //no va, se traslada a clase Participante
        
        
        /*calcular puntaje de cada participante
        en base al acierto de sus pronósticos, se da un punto 
        por cada pronóstico acertado.
         */
        for (Participante p : this.getParticipantes()) {

            int puntaje = 0; //reset puntaje para c/participante

            //tomar pronósticos del participante
            List<Pronostico> pronosticos = p.getPronosticos();

            for (Pronostico pronostico : pronosticos) {

                //para cada pronóstico, establecer si hay acierto
                Equipo equipo = pronostico.getEquipo();
                Partido partido = pronostico.getPartido();
                char resultado_pronostico = pronostico.getResultado();
                char resultado_real = 'X';

                if (partido.getGolesEquipo1() == partido.getGolesEquipo2()) {
                    resultado_real = 'E'; //empate

                } else {

                    //uno de los equipos ganó
                    if (equipo.equals(partido.getEquipo1())) {

                        //se apostó por el equipo 1
                        if (partido.getGolesEquipo1() > partido.getGolesEquipo2()) {
                            resultado_real = 'G'; //ganó equipo 1
                        } else {
                            resultado_real = 'P'; //perdió equipo 1
                        }
                    } else {

                        //se apostó por el equipo 2
                        if (partido.getGolesEquipo2() > partido.getGolesEquipo1()) {
                            resultado_real = 'G'; //ganó equipo 2
                        } else {
                            resultado_real = 'P'; //perdió equipo 2
                        }
                    }
                }

                if (resultado_real == resultado_pronostico) {

                    //acierto, se suma un punto a l participante
                    puntaje++;
                }
            }

            //establecer puntaje al participante
            p.setPuntaje(puntaje);
        }
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    String listar() {
        String lista = "";
        for (Participante participante : this.getParticipantes()) {
            lista += "\n" + participante;
        }
        return lista;
    }

    List<Participante> getListaByPuntaje() {
        //lista puntaje de todos los participantes
        
        
        List<Participante> ordenada = new ArrayList<>();
        
        ordenada.addAll(this.getParticipantes());

        Collections.sort(ordenada, Collections.reverseOrder());
        return ordenada;
    }

    public void listarPronosticosId() {
        for (Participante p : this.getParticipantes()) {
            int idPart = p.getIdParticipante();
            String nombre = p.getNombre();
            List<Pronostico> pronosticos = p.getPronosticos();
            System.out.println("idPart:" + idPart + ":" + nombre + "\n");
            for (Pronostico pr : pronosticos) {
                System.out.println("Pronosticos ID:" + pr.getIdPronostico());
            }
            System.out.println("-------------------------------------");
        }
    }

////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
    public void listarNombres() {

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("                  | N°  |         NOMBRE        |");
        System.out.println("---------------------------------------------------------------------------");
        int t = participantes.size();
        for (int x = 0; x < t; x++) {
            System.out.print("                  | " + participantes.get(x).getIdParticipante() + cl(2, Integer.toString(participantes.get(x).getIdParticipante()))
                    + "  |" + "   " + participantes.get(x).getNombre() + cl(20, participantes.get(x).getNombre())
                    + "|"
                    + "\n");//

        }
        System.out.println("===========================================================================");
    }

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////
    private String cl(int e, String l) {//cl

        String sal = "";
        int t = l.length();

        if (t < e) {//if

            t = e - t;
            for (int x = 0; x < t; x++) {//for
                sal += " ";
            }//for
        } else {//else
            return sal;
        }//else 
        return sal;
    }//cl

/////////////////////////////////////////////////////   
///////////////////////////////////////////////////////////    
    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + ", nombreArchivo=" + nombreArchivo + '}';
    }

}
