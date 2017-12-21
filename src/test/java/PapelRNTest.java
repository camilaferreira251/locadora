/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import locadora.entity.Papel;
import locadora.rn.PapelRN;
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
public class PapelRNTest {
    PapelRN pr = new PapelRN();
    @Test
    public void  PapelRNTest() {
    
    Papel p = new Papel();
       
//    Assert.assertTrue(pr.salvar(p)); 
//    Assert.assertTrue(pr.excluir(p));
        
    }
    Integer id;
    
    @Test
    public void ObterPapelTest(){
    pr.obter(id);
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
