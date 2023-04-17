/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maventpcom005;

import clases.PronosticoDeportivo;

/**
 *
 * @author
 */
public class MavenTPcom005 {

    public static PronosticoDeportivo PRODE;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("              SISTEMA DE SIMULACION DE PRONOSTICOS DEPORTIVOS.");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("");
        
        PRODE = new PronosticoDeportivo();

        PRODE.play();
    }
}
