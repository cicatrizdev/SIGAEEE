/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cicatriz
 */
public class AtletaTest {
    
    public AtletaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class Atleta.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Atleta instance = new Atleta();
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Atleta.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Atleta instance = new Atleta();
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Atleta.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Long id = null;
        Atleta expResult = null;
        Atleta result = Atleta.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class Atleta.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Atleta> expResult = null;
        List<Atleta> result = Atleta.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class Atleta.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Atleta instance = new Atleta();
        instance.inserir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class Atleta.
     */
    @Test
    public void testAlterar() {
        System.out.println("alterar");
        Atleta instance = new Atleta();
        instance.alterar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdAtleta method, of class Atleta.
     */
    @Test
    public void testGetIdAtleta() {
        System.out.println("getIdAtleta");
        Atleta instance = new Atleta();
        String expResult = "";
        String result = instance.getIdAtleta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class Atleta.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Atleta instance = new Atleta();
        instance.excluir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
