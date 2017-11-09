/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigDecimal;
import java.util.Date;
import locadora.entity.Aluguel;
import locadora.entity.Usuario;
import locadora.entity.Veiculo;
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
public class AluguelTest {
    
    Integer id = 1;
    Date dataInicio = new Date();      
    Date dataFim = new Date();
    BigDecimal valor = new BigDecimal (100); 
    Usuario usuario;
    Veiculo veiculoId;
       
    @Test
    public void AluguelTest() {
    Aluguel a = new Aluguel(id, dataInicio,dataFim, valor);
    Aluguel al = new Aluguel(id);
    assertEquals(valor, a.getValor());
    assertEquals(dataInicio, a.getDataInicio());
    assertEquals(dataFim, a.getDataFim());
    
    a.setDataInicio(dataInicio);
    a.setDataFim(dataFim);
    a.setValor(valor);    
    a.getId();
    al.setId(id);
    
    }
    
    @Test
    public void AluguelUsuarioTest(){
    Aluguel a = new Aluguel();
    a.getUsuario();
    a.setUsuario(usuario);    
    }
    
    @Test
    public void AluguelVeiculoTest(){
    Aluguel a = new Aluguel();
    a.getVeiculoId();
    a.setVeiculoId(veiculoId);    
    }
    
    @Test
    public void AluguelHashTest(){
        Aluguel a = new Aluguel();
        a.hashCode();
    }
    
    @Test
    public void AluguelToString(){
        Aluguel a = new Aluguel();
        a.toString();
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
