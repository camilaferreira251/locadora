/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import locadora.entity.Papel;
import locadora.entity.Usuario;
import locadora.rn.UsuarioRN;
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
public class UsuarioRNTest {
    UsuarioRN u = new UsuarioRN();
    Usuario us = new Usuario();
    String id;
    String login = "camila";
    String papel = "adm";
    List<Papel> papeis;
    
    @Test
    public void UsuarioRNTest() {
    Assert.assertTrue(u.salvar(us)); 
    Assert.assertFalse(u.excluir(us));
    
    u.obter(id);
    u.obterSelecionados(us);
    u.atualizarPapeis(us);
    }
    
    @Test
    public void UsuarioPapelTest(){
    assertFalse(u.papel(papel, us));
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
