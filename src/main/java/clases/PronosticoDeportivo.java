/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grupo I Miembros: NESTOR DANIEL AVACA NORBERTO DIAZ RICARDO LUIS
 * MARTINEZ FABIAN SUAREZ BERNARDO VELAZQUEZ
 * @author
 */

public class PronosticoDeportivo {
    
    ListaEquipos equipos = new ListaEquipos();
    ListaPartidos partidos = new ListaPartidos();
    ListaPronosticos pronosticos = new ListaPronosticos();
    ListaParticipantes participantes = new ListaParticipantes();
    ArrayList<Participante> ordenarParticipantes = new ArrayList<>();
    
    public void play() {
        
        equipos.cargarDB();
        System.out.println("Equipos:" + equipos.listar());
        
        partidos.cargarDB(equipos);
        System.out.println("\nPartidos:" + partidos.listar());
        
        pronosticos.cargarDB(partidos);
        System.out.println("\nPronósticos:" + pronosticos.listar());
        
        //como el puntaje es dinámico, en este listado da cero en todos.
        participantes.cargarDB(pronosticos);
        System.out.println("\nParticipantes:" + participantes.listar());
        
        //acá se va a calcular dinámicamente los puntajes, en el método
        //getPuntaje() de la clase Participante
        
        List<Participante> ordenada = participantes.getListaByPuntaje();
        System.out.println("\n\nRanking de participantes");
        for (Participante p : ordenada) {
            System.out.println(p.getNombre() + " puntaje:" + p.getPuntaje());
            
            System.out.println("   Desgloce de pronosticos de " + p.getNombre());
            for (Pronostico pronostico : p.getPronosticos()) {
                
                String equipo = pronostico.getEquipo().getNombre();
                char resultado_pronosticado = pronostico.getResultado();
                String equipo1 = pronostico.getPartido().getEquipo1().getNombre();
                int golesEq1 = pronostico.getPartido().getGolesEquipo1();
                String equipo2 = pronostico.getPartido().getEquipo2().getNombre();
                int golesEq2 = pronostico.getPartido().getGolesEquipo2();
                String acierto = null;
                
                System.out.println("   " + equipo1 + " vs " + equipo2
                        + " resultado " + String.valueOf(golesEq1) + " - "
                        + String.valueOf(golesEq2) + 
                        " apuesta a " + equipo + " dice que " + 
                        String.valueOf(resultado_pronosticado));
            }
            System.out.println("----------------------------------------------\n");
        }

        // 1 cargamos y listamos los equipos
//        equipos.cargarDeArchivo();
//        System.out.println("                    LOS  EQUIPOS PARTICIPANTES SON: \n");
//        //System.out.println(equipos.listar());
//        equipos.listarEquipos();
//
//        // cargar y listar partidos
//        // esto se usa para cargar y mostrar los partidos 
//        partidos.cargarDeArchivo(equipos);
//        System.out.println("");
//        System.out.println("---------------------------------------------------------------------------");
//        System.out.println("                         LOS PARTIDOS A JUGAR SON: ");
//        System.out.println("---------------------------------------------------------------------------");
//        //System.out.println(partidos.listar());
//        partidos.listarSinGoles();//cambiar por listar sin sin goles
//        
//        /* cargar y listamos los pronosticos por partixipantes
//            en esta versión se carga desde la base de datos sqlite
//        */
//        //pronosticos.cargarDeArchivo(partidos);
//
//        //pronosticos.listar2();
//        
//        //System.out.println(pronosticos.listar());
//        
//        // cargar y listar participantes; paso al método la lista
//        // completa de pronósticos
//        participantes.cargarDeArchivo(pronosticos, partidos);
//        
//        // 2 mostramos los participantes solos
//        System.out.println("\n   LOS NOMBRES DE LOS PARTICIPANTES QUE PRONOSTICARAN LOS PARTIDOS SON: ");
//        
//        participantes.listarNombres();
//        //System.out.println(participantes.listar());
//
//        // aca mostramos los participantes y sus pronosticos
//        // aca mostramos los pronosticos por participantes
//        System.out.println("");
//        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("|                     LOS PRONÓSTICOS CARGADOS POR LOS PARTICIPANTES SON: "+"                                                    |");
//        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
//        
//       // pronosticos.listar2();//hay que crear una funcion aca copiandise
//                              //de listaPronosticos listar2
//        
//        PromosticosParticipantes();
//                              
//        //System.out.println(pronosticos.listar());
//        
//        
//        
//        // muestra los partidos y sus goles
//        System.out.println("");
//        System.out.println("---------------------------------------------------------------------------");
//        System.out.println("                   LOS RESULTADOS DE LOS PARTIDOS JUGADOS SON: ");
//        System.out.println("---------------------------------------------------------------------------");
//        
//        partidos.listarConGoles();// ListaPartidos
//        //System.out.println(partidos.listar());
//        
////////---------------PARTE     FINAL ------------------------////////////         
//        cargarParaOrdenar();   
// 
//        Collections.sort(ordenarParticipantes);
// 
//        listarOrdenado();
//        
    }//cierre del main

////////////////OTRAS FUNCIONES/////////////////////    
    public void cargarParaOrdenar() {//cargar para ordenar
        
        Participante parti;
        int x = 0;
        int lon = participantes.getParticipantes().size();
        for (x = 0; x < lon; x++) {
            
            int id = participantes.getParticipantes().get(x).getIdParticipante();
            String nom = participantes.getParticipantes().get(x).getNombre();
            int pun = participantes.getParticipantes().get(x).getPuntaje();
            parti = new Participante(id, nom, null, pun);
            
            ordenarParticipantes.add(parti);
            //                participantes.getParticipantes().get(x).getPuntaje());
        }
    }//cargar para ordenar

    public void listarOrdenado() {//ordenar

        //   Participante parti;
        int x = 0;
        int lon = ordenarParticipantes.size();
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
        System.out.println("    LUEGO DE PROCESAR LOS DATOS ANTERIORES OBTENEMOS UNA ");
        System.out.println("     LISTA ORDENADA POR GANADORES EN ORDEN DESCENDENTE: ");
        System.out.println("-----------------------------------------------------------");
        for (x = 0; x < lon; x++) {//for
            if (x < lon - 1) {                
                System.out.print("NUMERO:   " + ordenarParticipantes.get(x).getIdParticipante() + "     " + "NOMBRE:  " + ordenarParticipantes.get(x).getNombre() + "     "
                        + "\t PUNTAJE:  " + ordenarParticipantes.get(x).getPuntaje() + "\n");
            } else {
                System.out.print("NUMERO:  " + ordenarParticipantes.get(x).getIdParticipante() + "     " + "NOMBRE:  " + ordenarParticipantes.get(x).getNombre() + "     "
                        + "\t PUNTAJE:  " + ordenarParticipantes.get(x).getPuntaje() + "\n");
            }            
        }//for    

        System.out.println("");
        System.out.println("                  GRACIAS POR PARTICIPAR    ");
        System.out.println("");
        
    }//ordenar

//////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
    public void PromosticosParticipantes() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------    DESPLAZAR A LA DERECHA PARA VER LA LISTA COMPLETA  ===>>    -----------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|ProN°|   PARTICIPANTE    | N°|idP|             EQUIPO         |Pro|                      PARTIDO A JUGAR                     | ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        int t = pronosticos.getPronosticos().size();
        
        for (int x = 0; x < t; x++) {
            System.out.print("| " + pronosticos.getPronosticos().get(x).getIdPronostico()
                    + cl2(2, Integer.toString(pronosticos.getPronosticos().get(x).getIdPronostico())) + "  |"
                    + participantes.getParticipantes().get(pronosticos.getPronosticos().get(x).getIdParticipante() - 1).getNombre()
                    + cl2(19, participantes.getParticipantes().get(pronosticos.getPronosticos().get(x).getIdParticipante() - 1).getNombre())
                    + "| " + pronosticos.getPronosticos().get(x).getIdParticipante()
                    + cl2(2, Integer.toString(pronosticos.getPronosticos().get(x).getIdParticipante()))
                    + //idPartido        
                    "| " + pronosticos.getPronosticos().get(x).getPartido().getIdPartido() + " |"
                    + //nombre del equipo pronosticado        
                    " " + pronosticos.getPronosticos().get(x).getEquipo().getNombre()
                    + cl2(27, pronosticos.getPronosticos().get(x).getEquipo().getNombre())
                    + "| " + pronosticos.getPronosticos().get(x).getResultado() + " |"
                    + //esta parte es de los equipo1 vs equipo2
                    pronosticos.getPronosticos().get(x).getPartido().getEquipo1().getNombre()
                    + cl2(27, pronosticos.getPronosticos().get(x).getPartido().getEquipo1().getNombre())
                    + "|VS|" + cl2(27, pronosticos.getPronosticos().get(x).getPartido().getEquipo2().getNombre())
                    + pronosticos.getPronosticos().get(x).getPartido().getEquipo2().getNombre()
                    + "|"
                    + "\n");//
            
        }
        System.out.println("===============================================================================================================================");
    }

//---------------         ACA PEGAR CL2      --------------------
    private String cl2(int e, String l) {//cl
        
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

/////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
}// cierre de clase

