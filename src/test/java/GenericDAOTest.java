/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import locadora.dao.GenericDAO;
import locadora.entity.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author camila
 */
public class GenericDAOTest {
    
    GenericDAO g = new GenericDAO();
    Usuario u = new Usuario();
    
    @Test
    public void GenericDAOTest() throws Exception {
    assertTrue(g.iniciarTransacao());
    assertTrue(g.alterar(u));
    
    try {
    g.iniciarTransacao();
  } catch (Exception e) {
    assertTrue(e instanceof NullPointerException);
  }
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
