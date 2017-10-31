/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import locadora.entity.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
     
      
     @Test
     public void TestUsuario() {
     //UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario = new Usuario(login, senha, nome);
    
    assertEquals("camila", usuario.getLogin());
    assertEquals("12345", usuario.getSenha());
    assertEquals("camila", usuario.getNome());
     }


    }

     
