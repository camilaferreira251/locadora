/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigDecimal;
import java.util.List;
import locadora.entity.Aluguel;
import locadora.entity.Usuario;
import locadora.entity.Veiculo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author camila
 */
public class VeiculoTest {
    
    String placa = "jjj1234";
    String modelo = "modelo";
    String marca = "fiat";
    String cor = "vermelho";
    String ano = "1990";
    BigDecimal valorDiaria = new BigDecimal (100);      
    Integer id = 1;
    Boolean arCondicionado = true;
    Boolean travaEletrica = true;
    List<Aluguel> aluguelList;
    int hash = 1;
    byte[]  imagem;
    
 

    @Test    
    public void VeiculoTest() {
                
    Veiculo veiculo = new Veiculo(id, placa, modelo, marca, cor, ano, valorDiaria);
    
    assertEquals("jjj1234", veiculo.getPlaca());
    assertEquals("modelo", veiculo.getModelo());
    assertEquals("fiat", veiculo.getMarca());
    assertEquals("vermelho", veiculo.getCor());
    assertEquals("1990", veiculo.getAno());
    assertEquals(valorDiaria, veiculo.getValorDiaria());
    
    veiculo.setId(id);
    veiculo.setPlaca(placa);
    veiculo.setModelo(modelo);
    veiculo.setMarca(marca);
    veiculo.setCor(cor);
    veiculo.setAno(ano);
    veiculo.setValorDiaria(valorDiaria);
    }

    @Test
    public void VeiculoIdTest(){
       Veiculo v = new Veiculo(id);
       v.getId();
    }
    
    @Test
    public void VeiculoArCondicionadoTest(){
       Veiculo v = new Veiculo();
       v.getArCondicionado();
       v.setArCondicionado(arCondicionado);
    }
    
    @Test
    public void VeiculoTravaEletrica(){
       Veiculo v = new Veiculo();
       v.getTravaEletrica();
       v.setTravaEletrica(travaEletrica);
    }
    
    @Test
    public void VeiculoListasTest(){
       Veiculo v = new Veiculo();
       v.getAluguelList();
       v.setAluguelList(aluguelList);
    }
    
    @Test
    public void VeiculoHashTest(){
        Veiculo v = new Veiculo();
        v.hashCode();
    }
    Veiculo v = new Veiculo();
    
    @Test
    public void VeiculoToString(){
        v.toString();
    }
    
    @Test
    public void VeiculoEqualsTest(){
        assertTrue(v.equals(v));
    }
    
    Usuario u = new Usuario();
    
    @Test
    public void VeiculoEqualsFalseTest(){
    assertFalse(v.equals(u));
    assertFalse(v.equals(id));
    }
    
    @Test
    public void VeiculoImagemTest(){
    v.getImagem();
    v.setImagem(imagem);
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
