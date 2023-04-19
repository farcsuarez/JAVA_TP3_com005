/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maventpcom005;

import clases.PronosticoDeportivo;

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
 *
 * @author
 */
public class MavenTPcom005 {

    public static PronosticoDeportivo PRODE;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║              SISTEMA DE SIMULACION DE PRONOSTICOS DEPORTIVOS.             ║█");
        System.out.println("║                                GRUPO I.                                   ║█");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝█");
        System.out.println(" ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        System.out.println("");
        
        PRODE = new PronosticoDeportivo();

        PRODE.play();
    }
}
