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
public class Equipo {
    private int idEquipo;
    private String Nombre;
    private String Descripcion;

    public Equipo(int idEquipo, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
    }

    public Equipo() {
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Equipo idEq=" + idEquipo + " " + Nombre;
    }
    
}
