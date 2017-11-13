/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import locadora.conversores.VeiculoConversor;
import locadora.dao.GenericDAO;
import static locadora.entity.Aluguel_.id;
import locadora.rn.VeiculoRN;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author camila
 */
public class VeiculoConversorTest {
   
    String valor = "1";
    int id = 1;
            
    @Test
    public void VeiculoConversorTest() {
        VeiculoConversor vc = new VeiculoConversor();
        VeiculoRN vei = new VeiculoRN();
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
