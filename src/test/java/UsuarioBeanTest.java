/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.Map;
import locadora.bean.UsuarioBean;
import locadora.entity.Papel;
import locadora.entity.Usuario;
import static locadora.entity.Usuario_.login;
import locadora.rn.UsuarioRN;
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
public class UsuarioBeanTest {
    
    UsuarioBean ub = new UsuarioBean();
    Usuario u = new Usuario();
    UsuarioRN urn = new UsuarioRN();
    List<Usuario> usuarios;
    List<Papel> papeis;
    Map<String, Papel> mappapeis;
    String login = "camila";
    
    @Test
    public void UsuarioAministratorTest(){
    ub.isAdministrador();
    ub.isUser();
    }
    
    @Test
    public void UsuarioByLoginTest(){
    ub.getUsuarioByLogin(login);
    }
    
          
    @Test
    public void UsuarioBeanAlterarTest() {
    assertEquals("/admin/usuario/usuario.xhtml", ub.alterar());
    }
    
    @Test
    public void UsuarioBeanCancelarTest() {
    assertEquals("/admin/usuario/lista-usuario.xhtml", ub.cancelar());
    }
    
    @Test
    public void UsuarioBeanNovoTest() {
    assertEquals("/admin/usuario/usuario.xhtml", ub.novo());
    }
    
    @Test
    public void UsuarioBeanIrExcluirTest() {
    assertEquals("/admin/usuario/remover-usuario.xhtml", ub.irExcluir());
    }
    
 
    
    @Test
    public void UsuarioBeanGetUsuarioTest(){
    ub.getUsuario();
    ub.getUsuarios();
    ub.setUsuarios(usuarios);
    assertEquals(u, ub.getUsuario());
    ub.setUsuario(u);
    ub.getPapeis();
    ub.setMovies(mappapeis);
    }
    
    @Test
    public void UsuarioBeanNovousuarioTest(){
    assertEquals(u, ub.getNovoUsuario());
    ub.setNovoUsuario(u);
    }
    
    @Test
    public void UsuarioBeanSeleceionadosTest(){
    assertEquals(papeis, ub.getSelecionados());
    ub.setSelecionados(papeis);
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
