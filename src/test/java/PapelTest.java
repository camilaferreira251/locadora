/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import junit.framework.Assert;
import locadora.entity.Papel;
import locadora.entity.Usuario;
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
public class PapelTest {
    Integer id = 1;
    String descricao = "descricao";
    List<Usuario> usuarioList;
    
    @Test
    public void PapelTest(){
    Papel p = new Papel(id, descricao);
    assertEquals("descricao", p.getDescricao());
    
    p.setDescricao(descricao);
    }
    
    @Test
    public void PapelIdtest(){
    Papel p = new Papel(id);
    p.getId();
    p.setId(id);
    }
    
    @Test
    public void PapelListasTest(){
       Papel p = new Papel();
       p.getUsuarioList();
       p.setUsuarioList(usuarioList);
    }
    
    @Test
    public void PapelHashTest(){
        Papel p = new Papel();
        p.hashCode();
    }
    
    @Test
    public void PapelToString(){
        Papel p = new Papel();
        p.toString();
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
