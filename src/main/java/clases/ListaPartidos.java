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
 * SE USO PARA REALIZAR LOS RECUADROS UN SISTEMA LINUX CON
 * UN IDE NETBEANS QUE EN LAS OPCIONES DE BARRA DE MENUES:
 *
 * TOOLS ==> OPTIONS ==> FONTS & COLORS
 *
 * SI SE MIRA EN LA PARTE DE "CATEGORY"
 *
 * PARA LA OPCION DE CHARACTER  EL FONT QUE SE UTILIZO
 *
 * FUE "Inherited":(HEREDADO) 
 *
 * FONT Monospaced.
 * FONT STYLE Plain.
 * SIZE 15. 
 *
 * SELECCIONAR ESE FONT POR SI SURGE UN PROBLEMA
 * EN UN SISTEMA "WINDOWS" VER SI USANDO ESTA OPCION SE RESUELVE.
 * 
 * @author Grupo I Miembros: NESTOR DANIEL AVACA NORBERTO DIAZ RICARDO LUIS
 * MARTINEZ FABIAN SUAREZ BERNARDO VELAZQUEZ
 * @author
 */
public class ListaPartidos {

    private List<Partido> partidos;
    private String nombreArchivo;

    public ListaPartidos() {
        this.partidos = new ArrayList<>();
        this.nombreArchivo = "partidos.csv";
    }

    public ListaPartidos(List<Partido> partidos, String nombreArchivo) {
        this.partidos = partidos;
        this.nombreArchivo = nombreArchivo;
    }

    public void addPartido(Partido p) {
        this.partidos.add(p);
    }

    public Partido getPartidoById(int idPartido) {
        Partido p = null;
        for (Partido partido : this.getPartidos()) {
            if (partido.getIdPartido() == idPartido) {
                p = partido;
                break;
            }
        }
        return p;
    }

    void cargarDB(ListaEquipos equipos) {

        //Carga de database SQLite
        //establecemos el objeto Connection
        Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            // Crear el obj comando
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM partidos";

            // tomamos las filas y se guardan en el obj rs
            ResultSet rs = stmt.executeQuery(SQL);

            //recorremos el rs
            while (rs.next()) {

                // construír el objeto con datos leídos
                Equipo equipo1 = equipos.getEquipoById(rs.getInt("idEquipo1"));
                Equipo equipo2 = equipos.getEquipoById(rs.getInt("idEquipo2"));
                Partido partido = new Partido(
                        rs.getInt("idPartido"),
                        equipo1,
                        equipo2,
                        rs.getInt("golesEquipo1"),
                        rs.getInt("golesEquipo2"));

                //agregar a la lista de objetos
                this.addPartido(partido);
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

    void cargarDeArchivo(ListaEquipos equipos) {
        // para las lineas del archivo csv
        String line;
        // para los datos individuales de cada linea
        String vector[];
        // para el objeto en memoria
        Partido partido;
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
                int idPartido = Integer.parseInt(vector[0]);
                int idEquipo1 = Integer.parseInt(vector[1]);
                int idEquipo2 = Integer.parseInt(vector[2]);
                Equipo equipo1 = equipos.getEquipoById(idEquipo1);
                Equipo equipo2 = equipos.getEquipoById(idEquipo2);
                int golesEquipo1 = Integer.parseInt(vector[3]);
                int golesEquipo2 = Integer.parseInt(vector[4]);

                // crea el objeto en memoria
                partido = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);

                // llama al metodo add para grabar el objeto en la lista en memoria
                this.addPartido(partido);
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            //cierro scanner
            sc.close();
        }
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    String listar() {
        String lista = "";
        for (Partido partido : partidos) {
            lista += "\n" + partido;
        }
        return lista;
    }
/////////////////////////////////////////////////////
////////////////////////////////////////////////////

    public void listarSinGoles() {
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("");
//        System.out.println("---------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("╔═════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    LA LISTA DE PARTIDOS A JUGAR SON:                    ║█");
        System.out.println("║                                                                         ║█");
        System.out.println("╠════╦══════════════════════════════╦════════╦════════════════════════════╣█");
        System.out.println("║ N° ║        EQUIPO1 (LOCAL)       ║        ║    EQUIPO2 (VISITANTE)     ║█");
        System.out.println("╠════╬══════════════════════════════╬════════╬════════════════════════════╣█");
        

//        System.out.println("---------------------------------------------------------------------------");
//        System.out.println("| N° |        EQUIPO1 (LOCAL)       |========|     EQUIPO2 (VISITANTE)    |         ");
//        System.out.println("---------------------------------------------------------------------------");
        int t = partidos.size();
        for (int x = 0; x < t; x++) {
            System.out.print("║ " + partidos.get(x).getIdPartido() + "  ║"
                    + "  " + partidos.get(x).getEquipo1().getNombre() + cl(28, partidos.get(x).getEquipo1().getNombre())
                    + "║ " + "  VS  " + " ║"
                    + cl(28, partidos.get(x).getEquipo2().getNombre()) + partidos.get(x).getEquipo2().getNombre() + "║█" + "\n");//

        }
        System.out.println("╚════╩══════════════════════════════╩════════╩════════════════════════════╝█");
        System.out.println(" ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"); 
        System.out.println("");
        System.out.println("");
//        System.out.println("===========================================================================");
    }

/////////////////////////////////////////////////////
/////////////////////////////////////////////////////    
    public void listarConGoles() {

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("╔═════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║               LOS RESULTADOS DE LOS PARTIDOS JUGADOS SON:               ║█");
        System.out.println("║                                                                         ║█");
        System.out.println("╠════╦══════════════════════════════╦═══════╦═════════════════════════════╣█");
        System.out.println("║ N° ║        EQUIPO1 (LOCAL)       ║ GOLES ║     EQUIPO2 (VISITANTE)     ║█");
        System.out.println("╠════╬══════════════════════════════╬═══╦═══╬═════════════════════════════╣█");
        
        
//        System.out.println("---------------------------------------------------------------------------");
//        System.out.println("| N° |        EQUIPO1_LOCAL         | GOLES |       EQUIPO2_VISITANTE     |         ");
//        System.out.println("---------------------------------------------------------------------------");
        int t = partidos.size();
        for (int x = 0; x < t; x++) {
            System.out.print("║ " + partidos.get(x).getIdPartido() + "  ║"
                    + "  " + partidos.get(x).getEquipo1().getNombre() + cl(28, partidos.get(x).getEquipo1().getNombre())
                    + "║ " + partidos.get(x).getGolesEquipo1() + " ║ "
                    + partidos.get(x).getGolesEquipo2() + " ║ "
                    + cl(28, partidos.get(x).getEquipo2().getNombre()) + partidos.get(x).getEquipo2().getNombre() + "║█" + "\n");//
            //     " goles "+partidos.get(x).getGolesEquipo2()+
            //   "\n");//+cl(28,equipos.get(x).getNombre())+
            //    "DESCRIPCION:  "+equipos.get(x).getDescripcion()+"\n" );//   lista += "\n" + equipo;
        }
        
        System.out.println("╚════╩══════════════════════════════╩═══╩═══╩═════════════════════════════╝█");
        System.out.println(" ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"); 
        System.out.println("");
        
        System.out.println("");
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    
    }
//////////////////////////////////////////////////////
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
/////////////////////////////////////////////////////  
    @Override
    public String toString() {
        return "ListaPartidos{" + "partidos=" + partidos + ", nombreArchivo=" + nombreArchivo + '}';
    }

}
