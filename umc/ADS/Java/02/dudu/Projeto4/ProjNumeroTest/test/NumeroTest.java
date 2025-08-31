/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

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
public class NumeroTest {
    
    Numero num = new Numero();
    
    public NumeroTest() {
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
     * Test of CalcSoma method, of class Numero.
     */
    @Test
    public void testCalcSoma() {
       assertEquals(10,num.CalcSoma(5, 5));
    }

    /**
     * Test of CalcIdade method, of class Numero.
     */
    @Test
    public void testCalcIdade() {
        assertEquals(40,num.CalcIdade(1980));
    }

    /**
     * Test of CalcAprovado method, of class Numero.
     */
    @Test
    public void testCalcAprovado() {
        assertTrue(num.CalcAprovado(5));
    }

    /**
     * Test of calcMaior method, of class Numero.
     */
    @Test
    public void testCalcMaior() {
        assertEquals(6,num.calcMaior(1, 6, 4));
    }

    /**
     * Test of calcularVolumeCilindro method, of class Numero.
     */
    @Test
  public void testCalcularVolumeCilindro() {
        
        // Teste com raio 1 e altura 5
        double resultado = num.calcularVolumeCilindro(1, 5);
        
        // O volume esperado é 5 * π ≈ 15.707
        double esperado = 5 * Math.PI;
        
        // Verifique se o valor calculado é aproximadamente igual ao esperado
        assertEquals(esperado, resultado, 0.0001);  // 0.0001 é a margem de erro para comparação de doubles
    }
}