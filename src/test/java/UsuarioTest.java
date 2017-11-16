/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import locadora.entity.Aluguel;
import locadora.entity.Papel;
import locadora.entity.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author camila
 */
public class UsuarioTest {
    
    
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
     String login = "camila";
     String senha = "12345";
     String nome = "camila";
     List<Papel> papelList;
     List<Aluguel> aluguelList;
      
     @Test
     public void TestUsuario() {
     //UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario = new Usuario(login, senha, nome);
    
    assertEquals("camila", usuario.getLogin());
    assertEquals("12345", usuario.getSenha());
    assertEquals("camila", usuario.getNome());
    
    usuario.setLogin(login);
    usuario.setNome(nome);
    usuario.setSenha(senha);
     }
     
     @Test
     public void UsuarioIdTest(){
     Usuario u = new Usuario(login);
     u.getLogin();
     }     

     @Test
     public void UsuarioPapelListTest(){
     Usuario u = new Usuario();
     u.getPapelList();
     u.setPapelList(papelList);
     }
     
     @Test
     public void UsuarioAluguelListTest(){
     Usuario u = new Usuario();
     u.getAluguelList();
     u.setAluguelList(aluguelList);
     }
     
     @Test
    public void UsuarioHashTest(){
        Usuario u = new Usuario();
        u.hashCode();
    }
    Usuario u = new Usuario();
    @Test
    public void UsuarioToString(){
        u.toString();
    }
    
    @Test
    public void UsuarioEqualsTest(){
        assertTrue(u.equals(u));
    }
     
    Aluguel a = new Aluguel();
    @Test
    public void UsuarioEqualsFalseTest(){
    assertFalse(u.equals(a));
    }
    
     
    }

     
