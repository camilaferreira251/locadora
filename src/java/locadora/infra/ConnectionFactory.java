/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolocadoracarros.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author gaoli_000
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return
                    DriverManager.getConnection("jdbc:mysql://localhost/CadastroVeiculo","root","");
        }catch(SQLException ex){
            
        }catch(ClassNotFoundException e){
            
        }
        return null;
    } 
}
