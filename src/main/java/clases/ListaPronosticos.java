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
import java.util.List;
import java.util.Scanner;

/**
 * @author Grupo I Miembros: NESTOR DANIEL AVACA NORBERTO DIAZ RICARDO LUIS
 * MARTINEZ FABIAN SUAREZ BERNARDO VELAZQUEZ
 * @author
 */
public class ListaPronosticos {

    private List<Pronostico> pronosticos;
    private String nombreArchivo;

    public ListaPronosticos() {
        pronosticos = new ArrayList<>();
        nombreArchivo = "pronosticos.csv";
    }

    public ListaPronosticos(List<Pronostico> pronosticos, String nombreArchivo) {
        this.pronosticos = pronosticos;
        this.nombreArchivo = nombreArchivo;
    }

    void cargarDB(ListaPartidos partidos) {

        //Carga de database SQLite
        //establecemos el objeto Connection
        Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            // Crear el obj comando
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM pronosticos";

            // tomamos las filas y se guardan en el obj rs
            ResultSet rs = stmt.executeQuery(SQL);

            //recorremos el rs
            while (rs.next()) {

                // construír el objeto con datos leídos
                int idPronostico = rs.getInt("idPronostico");
                int idParticipante = rs.getInt("idParticipante");
                int idPartido = rs.getInt("idPartido");
                int equipo_nro = rs.getInt("idEquipo");
                String resultado = rs.getString("resultado");

                //obtenemos el partido del pronóstico
                Partido partido = partidos.getPartidoById(idPartido);

                //obtenemos el equipo de apuesta del pronóstico
                Equipo equipo = null;
                if (equipo_nro == 1) {
                    equipo = partido.getEquipo1();
                } else {
                    equipo = partido.getEquipo2();
                }
                
                //formamos el objeto pronóstico
                Pronostico pronostico = new Pronostico(
                        idPronostico,
                        idParticipante,
                        equipo,
                        partido,
                        resultado.charAt(0));
                
                //agregar a la lista de objetos
                this.addPronostico(pronostico);
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

    void cargarDeArchivo(ListaPartidos partidos) {
        // para las lineas del archivo csv
        String line;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Pronostico pronostico;
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
                int idPronostico = Integer.parseInt(vector[0]);
                int idParticipante = Integer.parseInt(vector[1]);
                int idPartido = Integer.parseInt(vector[2]);
                int equipoNro = Integer.parseInt(vector[3]);
                String resultado = vector[4];
                Partido partido = partidos.getPartidoById(idPartido);
                Equipo equipo = null;
                if (equipoNro == 1) {
                    equipo = partido.getEquipo1();
                } else {
                    equipo = partido.getEquipo2();
                }
                pronostico = new Pronostico(idPronostico, idParticipante, equipo, partido, resultado.charAt(1));
                this.addPronostico(pronostico);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    String listar() {
        String lista = "";
        for (Pronostico pronostico : this.getPronosticos()) {
            lista += "\n" + pronostico;
        }
        return lista;
    }
//--------------------------------------------------------

//--------------------------------------------------------    
    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    void addPronostico(Pronostico p) {
        this.pronosticos.add(p);
    }

    public Pronostico getPronosticoById(int idPronostico) {
        Pronostico pronostico = null;
        for (Pronostico p : this.getPronosticos()) {
            if (p.getIdPronostico() == idPronostico) {
                pronostico = p;
                break;
            }
        }

        return pronostico;
    }

    @Override
    public String toString() {
        return "ListaPronosticos{" + "pronosticos=" + pronosticos + ", nombreArchivo=" + nombreArchivo + '}';
    }

}
