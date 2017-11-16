/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import locadora.entity.Aluguel;
import locadora.rn.AluguelRN;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author camila
 */
public class AluguelRNTest {
    AluguelRN a = new AluguelRN();
    Aluguel al = new Aluguel();
    
    @Test
    public void AluguelRNTest() {
         
    Assert.assertTrue(a.salvar(al)); 
    }
    
    @Test
    public void ExcluirTest(){    
    Assert.assertFalse(a.excluir(al));
    
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
