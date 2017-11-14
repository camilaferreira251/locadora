/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import locadora.bean.AluguelBean;
import locadora.bean.UsuarioBean;
import locadora.entity.Aluguel;
import locadora.entity.Veiculo;
import locadora.rn.AluguelRN;
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
public class AluguelBeanTest {
    
    AluguelBean ab = new AluguelBean();
    AluguelRN arn = new AluguelRN();
    VeiculoRN vrn = new VeiculoRN();
    UsuarioBean ub = new UsuarioBean();
    Aluguel a = new Aluguel();
    Veiculo v = new Veiculo();
    
    @Test
    public void AluguelBeanTest() {
    assertEquals(a, ab.getAluguel());
    ab.setAluguel(a);
    }
    
    @Test
    public void AluguelVeiculoTest(){
    assertEquals(v, ab.getVeiculo());
    ab.setVeiculo(v);
    }
    
    @Test
    public void ExcluirAluguelTest(){
    assertEquals("/restrito/aluguel/cadastrarAluguel.xhtml?faces-redirect=true", ab.excluir(a));
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
