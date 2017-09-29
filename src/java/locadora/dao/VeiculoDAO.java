/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolocadoracarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetolocadoracarros.classes.Veiculo;
import projetolocadoracarros.infra.ConnectionFactory;
import projetolocadoracarros.infra.DAO;

/**
 *
 * @author gaoli_000
 */
public class VeiculoDAO implements DAO<Veiculo> {
    
    private Connection con;

    public VeiculoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    @Override
    public void adiciona(Veiculo entidade) throws SQLException {
        String sql = "insert into veiculos(id,placa,marca, modelo, cor, descricao, arCondicionado,vidroEletrico,travaEletrica,cambioAutomatico, alugado) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        
        try{
            stmt = (PreparedStatement)con.prepareStatement(sql);
            
            stmt.setInt(1, entidade.getId());//depois gerar automatico
            stmt.setString(2, entidade.getPlaca());
            stmt.setString(3, entidade.getMarca());
            stmt.setString(4, entidade.getModelo());
            stmt.setString(5, entidade.getCor());
            stmt.setString(6, entidade.getDescricao());
            stmt.setBoolean(7, entidade.isArCondicionado());
            stmt.setBoolean(8, entidade.isVidroEletrico());
            stmt.setBoolean(9, entidade.isTravaEletrica());
            stmt.setBoolean(10, entidade.isCambioAutomatico());
            stmt.setBoolean(11, entidade.isAlugado());
            
            stmt.execute();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            stmt.close();
            con.close();
        }
    }

    

    @Override
    public Veiculo lista(String pesquisa) throws SQLException {
      Veiculo entidade = new Veiculo();
      String sql = "Select * from veiculos where id=?";
      PreparedStatement stmt=null;
      ResultSet rs = null;
      
       try{
            stmt = (PreparedStatement)con.prepareStatement(sql);
            
            stmt.setInt(1, entidade.getId());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                entidade.setId(rs.getInt("id"));
                entidade.setPlaca(rs.getString("placa"));
                entidade.setMarca(rs.getString("marca"));
                entidade.setModelo(rs.getString("modelo"));
                entidade.setCor(rs.getString("cor"));
                entidade.setDescricao(rs.getString("descricao"));
                entidade.setArCondicionado(rs.getBoolean("arcondicionado"));
                entidade.setVidroEletrico(rs.getBoolean("vidroeletrico"));
                entidade.setTravaEletrica(rs.getBoolean("travaeletrica"));
                entidade.setTravaEletrica(rs.getBoolean("cambioautomatico"));
                entidade.setAlugado(rs.getBoolean("alugado"));
            }
            
       }catch(SQLException e){
           
       }finally{
           stmt.close();
           rs.close();
           con.close();
       }
      return null;
    }

    @Override
    public List<Veiculo> listaTudo() throws SQLException {
        
        List<Veiculo> veiculos  = new ArrayList<Veiculo>();
        
        String sql = "select * from veiculos";
        
         PreparedStatement stmt=null;
         ResultSet rs = null;
      
       try{
            stmt = (PreparedStatement)con.prepareStatement(sql);
            
            
            rs = stmt.executeQuery();
            Veiculo entidade = null;
            
            while(rs.next()){
                entidade.setId(rs.getInt("id"));
                entidade.setPlaca(rs.getString("placa"));
                entidade.setMarca(rs.getString("marca"));
                entidade.setModelo(rs.getString("modelo"));
                entidade.setCor(rs.getString("cor"));
                entidade.setDescricao(rs.getString("descricao"));
                entidade.setArCondicionado(rs.getBoolean("arcondicionado"));
                entidade.setVidroEletrico(rs.getBoolean("vidroeletrico"));
                entidade.setTravaEletrica(rs.getBoolean("travaeletrica"));
                entidade.setTravaEletrica(rs.getBoolean("cambioautomatico"));
                entidade.setAlugado(rs.getBoolean("alugado"));
                
                veiculos.add(entidade);
            }
            
       }catch(SQLException e){
           
       }finally{
           stmt.close();
           rs.close();
           con.close();
       }
        return null;
        
    }
    
    
    
}
