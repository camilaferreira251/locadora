/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import locadora.bean.PapelBean;
import locadora.entity.Papel;
import locadora.rn.PapelRN;
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
public class PapelBeanTest {
    
    PapelBean pb = new PapelBean();
    PapelRN prn = new PapelRN();
    List<Papel> papeis;
    Papel p = new Papel();

    @Test
    public void PapelBeanTest() {
    assertEquals("/admin/usuario/papel/lista-papel.xhtml", pb.salvar());
    }
    
    @Test
    public void PapelBeanNovoTest(){
    assertEquals("/admin/usuario/papel/papel.xhtml", pb.novo());
    }
    
    @Test
    public void PapelBeanExcluirTest(){
    assertEquals("/admin/usuario/papel/lista-papel.xhtml", pb.excluir());
    }
    
    @Test
    public void PapelBeanAlterarTest(){
    assertEquals("/admin/usuario/papel/papel.xhtml", pb.alterar());
    }
    
    @Test
    public void PapelBeanCancelarTest(){
    assertEquals("/admin/usuario/papel/lista-papel.xhtml", pb.cancelar());
    }
    
    @Test
    public void PapelBeanIrExcluirTest(){
    assertEquals("/admin/usuario/papel/remover-papel.xhtml", pb.irExcluir());
    }
    
    @Test
    public void PapelBeanGetPepeisTest(){
    pb.getPapeis();
    pb.setPapeis(papeis);
    assertEquals(p, pb.getPapel());
    pb.setPapel(p);
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
