/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

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

public class PronosticoDeportivo {
    
    ListaEquipos equipos = new ListaEquipos();
    ListaPartidos partidos = new ListaPartidos();
    ListaPronosticos pronosticos = new ListaPronosticos();
    ListaParticipantes participantes = new ListaParticipantes();
    ArrayList<Participante> ordenarParticipantes = new ArrayList<>();
    
//    Scanner ing = new Scanner(System.in);  
//    char accion= '\u0000';
    
    public void play() {
        
        equipos.cargarDB();
//        System.out.println("Equipos:" + equipos.listar());
        
        partidos.cargarDB(equipos);
//      System.out.println("\nPartidos:" + partidos.listar());
        
        pronosticos.cargarDB(partidos);
//      System.out.println("\nPronósticos:" + pronosticos.listar());
        
        //como el puntaje es dinámico, en este listado da cero en todos.
        participantes.cargarDB(pronosticos);
//        System.out.println("\nParticipantes:" + participantes.listar());

//_______________________LISTAS CON RECUADROS_______________________

           equipos.listarEquipos();//dentro de ListarEquipos.java muetras los equipos

           pausar(500);//demora un tiempo para mostar mas claro
           participantes.listarNombres();//dentro de ListaParticipantes
           pausar(400);
           partidos.listarSinGoles();//dentro de ListaPartidos
           pausar(400);
//         /* cargar y listamos los pronosticos por partixipantes
//            en esta versión se carga desde la base de datos sqlite
//        */
           
           PromosticosParticipantes();//ESTA EN ESTE MODULO
           pausar(500);
           partidos.listarConGoles();// dentro de ListaPartidos
           pausar(400);
//        acá se va a calcular dinámicamente los puntajes, en el método
//        getPuntaje() de la clase Participante

////____ LA FUNCION ListarFichas()realiza los calculos por getPuntaje___
//     System.out.println("LAS  FICHAS POR FUNCION: \n");   
        
       ListarFichas();
       pausar(400);
        
//_______________________FIN LISTAS CON RECUADROS___________________________       

//_______________________SE USO EN LA PARTE ANTERIOR _________
//        1 cargamos y listamos los equipos
//        equipos.cargarDeArchivo();
//        System.out.println(" LOS  EQUIPOS PARTICIPANTES SON: \n");
//        //System.out.println(equipos.listar());
//          equipos.listarEquipos();//dentro de ListarEquipos.java muetras los equipos
//          System.out.print("precione una tecla para continuar:  ");
//          System.in.read() ;
//          
//          accion=Character.toUpperCase(ing.next().charAt(0));
//
//        // cargar y listar partidos
//        // esto se usa para cargar y mostrar los partidos 
//        partidos.cargarDeArchivo(equipos);
//        
//        //System.out.println(partidos.listar());
//        partidos.listarSinGoles();//cambiar por listar sin sin goles
//        
//        //pronosticos.cargarDeArchivo(partidos);
//
//        //System.out.println(pronosticos.listar());
//        
//        // cargar y listar participantes; paso al método la lista
//        // completa de pronósticos
//        participantes.cargarDeArchivo(pronosticos, partidos);
//        
//        // 2 mostramos los participantes solos
//                
//        participantes.listarNombres();
//        //System.out.println(participantes.listar());
//
//        // aca mostramos los participantes y sus pronosticos
//        // aca mostramos los pronosticos por participantes
//        
//        //System.out.println(pronosticos.listar());
//        
//        // muestra los partidos y sus goles
       
//        partidos.listarConGoles();// ListaPartidos
//        //System.out.println(partidos.listar());
//        
////////---------------PARTE     FINAL ------------------------////////////         
//        cargarParaOrdenar();   
// 
//        Collections.sort(ordenarParticipantes);
// 
       
        listarOrdenado();
//        
    }//cierre del main

////////////////OTRAS FUNCIONES///////////////////////////////////////////    
//////////////////////////////////////////////////////////////////////////
public void ListarFichas(){

List<Participante> ordenada = participantes.getListaByPuntaje();
    
        System.out.println("\n");
        //System.out.println("                     FICHAS DE PRONOSTICOS ACERTADOS POR PARTICIPANTES");
        System.out.println("    ╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("    ║          FICHAS DE PRONOSTICOS INDIVIDUALES POR PARTICIPANTES:            ║█");
        System.out.println("    ║                                                                           ║█");
        System.out.println("    ╠═══════════════════════════════════════════════════════════════════════════╣█");
        System.out.println("    ╚═══════════════════════════════════════════════════════════════════════════╝█");
        System.out.println("     ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"); 
        System.out.println("");
        
        for (Participante p : ordenada) {
        System.out.print("\n");
        System.out.print("┌────────────────┬─────────────────────────────────────────┬───────────────────────────────────┐\n");
          System.out.print("│"+"N° Par: "+p.getIdParticipante()+cl2(8,String.valueOf(p.getIdParticipante())  ) +"│ NOMBRE: "+p.getNombre()+cl2(32,p.getNombre())+  "│ PUNTAJE: "+ p.getPuntaje()+ cl2(25,Integer.toString(p.getPuntaje()))  +"│"+"\n");
        System.out.print("├────────────────┴─────────┬───────┬───────────────────────┴──┬────────────────────────────┬───┤\n");
        System.out.print("│         Equipo 1         │ goles │         Equipo 2         │          Jugo que:         │Pun│\n");
        System.out.print("├──────────────────────────┼───┬───┼──────────────────────────┼──────────────────────────┬─┼───┤\n");
          

//            System.out.println(p.getNombre() + " puntaje:" + p.getPuntaje());
//            System.out.println("   Desgloce de pronosticos de " + p.getNombre());

              for (Pronostico pronostico : p.getPronosticos()) {
                
                String equipo = pronostico.getEquipo().getNombre();
                char resultado_pronosticado = pronostico.getResultado();
                String equipo1 = pronostico.getPartido().getEquipo1().getNombre();
                int golesEq1 = pronostico.getPartido().getGolesEquipo1();
                String equipo2 = pronostico.getPartido().getEquipo2().getNombre();
                int golesEq2 = pronostico.getPartido().getGolesEquipo2();
                String acierto = null;
                
                System.out.print("│" + equipo1 + cl2(26,equipo1)+
                "│ "+String.valueOf(golesEq1)+cl2(2,String.valueOf(golesEq1))+
                        "│ "+String.valueOf(golesEq2)+ cl2(2,String.valueOf(golesEq2)) +"│" +
                        cl2(26,equipo2)+equipo2+
//                         " resultado " + String.valueOf(golesEq1) + " - "
//                        + String.valueOf(golesEq2) + 
//                       " apuesta a " + equipo + " dice que " + 
                "│"+equipo+cl2(26,equipo)+
                "│"+ String.valueOf(resultado_pronosticado)+"│ "+

//                     public char Calp(String equi1,String equi2, String apuEqui, char res_pro,int golEqui1,int golEqui2){
                        
                  String.valueOf(Calp(equipo1,equipo2,equipo,resultado_pronosticado,golesEq1,golesEq2) ) +
            cl2(2, String.valueOf(Calp(equipo1,equipo2,equipo,resultado_pronosticado,golesEq1,golesEq2) ) ) +

                        "│"+"\n");
            }
            System.out.print("├──────────────────────────┴───┴───┴──────────────────────────┼──────────────────────────┴─┴───┤\n");
            System.out.print("│                                                             │    SUMA TOTAL DE PUNTAJE : "+ p.getPuntaje()+ cl2(4,Integer.toString(p.getPuntaje()))+"│\n");
            System.out.print("└─────────────────────────────────────────────────────────────┴────────────────────────────────┘\n");
            System.out.println("");
        pausar(100);
        }   
    
    
    
}

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

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
        List<Participante> ordenada = participantes.getListaByPuntaje();
        
        int x = 0;
        int lon = ordenada.size();
        System.out.println("");
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          LUEGO DE PROCESAR LOS DATOS ANTERIORES OBTENEMOS UNA             ║█");
        System.out.println("║           LISTA ORDENADA POR GANADORES EN ORDEN DESCENDENTE:              ║█");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣█");
        System.out.println("╠════════════════╦═════════════════════════════════════════╦════════════════╣█");

        for (x = 0; x < lon; x++) {//for
//            if (x < lon - 1) {                
                System.out.print("║ NUMERO:   " + ordenada.get(x).getIdParticipante() + cl2(5,  Integer.toString(ordenada.get(x).getIdParticipante() ) )+
                                 "║ NOMBRE:  " + ordenada.get(x).getNombre() + cl2(31,ordenada.get(x).getNombre())+
                                 "║ PUNTAJE:  " + ordenada.get(x).getPuntaje() + cl2(5,Integer.toString(ordenada.get(x).getPuntaje()) )  + "║█"+"\n");
//            } else {
//                System.out.print("║NUMERO:  " + ordenada.get(x).getIdParticipante() + "     " + "NOMBRE:  " + ordenada.get(x).getNombre() + "     "
//                        + "\t ║PUNTAJE:  " + ordenada.get(x).getPuntaje() + "║"+"\n");
//            }            
        }//for    

        System.out.println("╠════════════════╩═════════════════════════════════════════╩════════════════╣█");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣█");
        System.out.println("║                            GRACIAS POR PARTICIPAR                         ║█");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝█");
        System.out.println(" ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀"); 
        
        
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
        
    }//ordenar

//////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
    public void PromosticosParticipantes() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------    DESPLAZAR A LA DERECHA PARA VER LA LISTA COMPLETA  ===>>    -----------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|ProN° |   PARTICIPANTE    | N°|idP|             EQUIPO         |Pro|                      PARTIDO A JUGAR                     | ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        int t = pronosticos.getPronosticos().size();
        
        for (int x = 0; x < t; x++) {
            System.out.print("| " + pronosticos.getPronosticos().get(x).getIdPronostico()
                    + cl2(3, Integer.toString(pronosticos.getPronosticos().get(x).getIdPronostico())) + "  |"
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

public char Calp(String equi1,String equi2, String apuEqui, char res_pro,int golEqui1,int golEqui2){

    if(golEqui1==golEqui2 && res_pro == 'E')
   {
    return '1';   
     }
 if(golEqui1>golEqui2 && equi1.equals(apuEqui)&&res_pro=='G'||
    golEqui1>golEqui2 && equi2.equals(apuEqui)&&res_pro=='P'||
 
    golEqui1<golEqui2 && equi1.equals(apuEqui)&&res_pro=='P'||
    golEqui1<golEqui2 && equi2.equals(apuEqui)&&res_pro=='G'  )
    {
    return '1'; 
    }
     
 return '-';
 }

public void pausar(long tiempo){
    try {
		//	for (int i = 0; i < 2; i++) {
				Thread.sleep(tiempo);
				//System.out.println("Sleep "+i);
		//	}
		}catch(Exception e) {
			System.out.println(e);
		}
	//}
}    
/////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
}// cierre de clase

