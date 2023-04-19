/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package clases;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

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
 * SICE 15. 
 *
 * SELECCIONAR ESE FONT POR SI SURGE UN PROBLEMA
 * EN UN SISTEMA "WINDOWS" VER SI USANDO ESTA OPCION SE RESUELVE.
 * 
 * @author Grupo I Miembros: NESTOR DANIEL AVACA NORBERTO DIAZ RICARDO LUIS
 * MARTINEZ FABIAN SUAREZ BERNARDO VELAZQUEZ
 * @author
 */
public class ParticipanteTest {
    
    public ParticipanteTest() {
    }

    /**
     * Test of addPronostico method, of class Participante.
     */
    @Test
    public void testAddPronostico() {
        System.out.println("addPronostico");
        Pronostico p = null;
        Participante instance = new Participante();
        instance.addPronostico(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIdParticipante method, of class Participante.
     */
    @Test
    public void testGetIdParticipante() {
        System.out.println("getIdParticipante");
        Participante instance = new Participante();
        int expResult = 0;
        int result = instance.getIdParticipante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdParticipante method, of class Participante.
     */
    @Test
    public void testSetIdParticipante() {
        System.out.println("setIdParticipante");
        int idParticipante = 0;
        Participante instance = new Participante();
        instance.setIdParticipante(idParticipante);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Participante.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Participante instance = new Participante();
        String expResult = null;
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Participante.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Participante instance = new Participante();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPronosticos method, of class Participante.
     */
    @Test
    public void testGetPronosticos() {
        System.out.println("getPronosticos");
        Participante instance = new Participante(0,null,null,1);
        List<Pronostico> expResult = null;
        List<Pronostico> result = instance.getPronosticos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPronosticos method, of class Participante.
     */
    @Test
    public void testSetPronosticos() {
        System.out.println("setPronosticos");
        List<Pronostico> pronosticos = null;
        Participante instance = new Participante();
        instance.setPronosticos(pronosticos);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntaje method, of class Participante.
     */
    @Test
    public void testGetPuntaje() {
        System.out.println("getPuntaje");
        Participante instance = new Participante();
        int expResult = 0;
        int result = instance.getPuntaje();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPuntaje method, of class Participante.
     */
    @Test
    public void testSetPuntaje() {
        System.out.println("setPuntaje");
        int puntaje = 0;
        Participante instance = new Participante();
        instance.setPuntaje(puntaje);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Participante.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Participante instance = new Participante();
        String expResult = "Particip id=0 null pronost=[] puntaje=0}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}//fin de la clase
