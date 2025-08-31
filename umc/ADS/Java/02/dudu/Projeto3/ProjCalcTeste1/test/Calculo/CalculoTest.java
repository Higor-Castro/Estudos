/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Calculo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alunocmc
 */
public class CalculoTest {
    Calculo calc = new Calculo();
    
    public CalculoTest() {
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
     * Test of Somar method, of class Calculo.
     */
    @Test
    public void testSomar() {
        assertEquals(4,calc.Somar(2, 2));
    }

    /**
     * Test of NumPar method, of class Calculo.
     */
    @Test
    public void testNumPar() {
 
        assertTrue(calc.NumPar(10));
    }
    /**
     * Test of Area method, of class Calculo.
     */
    @Test
    public void testArea() {
        assertEquals(100,calc.Area(10, 10));
    }
    
}
