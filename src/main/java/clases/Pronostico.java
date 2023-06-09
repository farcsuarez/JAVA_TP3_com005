/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

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
 *@author Grupo I 
 * Miembros:
 * NESTOR DANIEL AVACA
 * NORBERTO DIAZ
 * RICARDO LUIS MARTINEZ
 * FABIAN SUAREZ
 * BERNARDO VELAZQUEZ
 * @author 
 */
public class Pronostico {//clase
    private int idPronostico;
    private int idParticipante;
    private Equipo equipo;
    private Partido partido;
    private char resultado;

    
    public Pronostico(){
        
    }
    
///////////////////////////////////////////////////////    

    public Pronostico(int idPronostico, int idParticipante, Equipo equipo, Partido partido, char resultado) {
        this.idPronostico = idPronostico;
        this.idParticipante = idParticipante;
        this.equipo = equipo;
        this.partido = partido;
        this.resultado = resultado;
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    public int puntos(){
        return 0;
    }
    
    @Override
    public String toString() {
        return "Pron id:" + idPronostico + " idPart:" + idParticipante + " equipo=" + equipo + " partido=" + partido + " res=" + resultado;
    }
    
    
    
}//clase
