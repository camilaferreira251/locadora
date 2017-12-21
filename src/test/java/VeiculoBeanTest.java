/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import locadora.bean.VeiculoBean;
import locadora.entity.Veiculo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author camila
 */
public class VeiculoBeanTest {
    
    VeiculoBean v = new VeiculoBean();
    Veiculo vei = new Veiculo();
    
    UploadedFile arquivo;
    List<Veiculo> veiculos;
    
    DefaultStreamedContent d = new DefaultStreamedContent();
    
    @Test
    public void VeiculoBeanTest() {
    v.getVeiculo();
    v.setVeiculo(vei);
    v.getArquivo();
    v.setArquivo(arquivo);
    }
    
       
    @Test
    public void NextStepText(){
    assertEquals("/restrito/aluguel/formAluguel.xhtml", v.nextStep());
    }
    
    @Test
    public void ExcluirTest(){
    assertEquals("/restrito/veiculo/listarVeiculos.xhtml?faces-redirect=true", v.excluir(vei));    
    }
    
    @Test
    public void AlterarTest(){
    assertEquals("/restrito/veiculo/formVeiculo.xhtml", v.alterar(vei));
    }
    
    @Test
    public void GetVeiculosTest(){
    v.getVeiculos();
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
