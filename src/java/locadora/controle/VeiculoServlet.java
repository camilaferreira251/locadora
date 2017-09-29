/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolocadoracarros.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetolocadoracarros.classes.Veiculo;
import projetolocadoracarros.dao.VeiculoDAO;

/**
 *
 * @author gaoli_000
 */
@WebServlet("/veiculo")
public class VeiculoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          
            
            VeiculoDAO dao = new VeiculoDAO();
            String action = request.getParameter("action");
            
            if(action != null && action.equals("gravar")){
                Integer id = 0;
                
                if(request.getParameter("id")!= null && !request.getParameter("id").equals("")){
                    id = Integer.parseInt(request.getParameter("id"));
                }
                
                String placa  = request.getParameter("placa");
                String marca  = request.getParameter("marca");
                String modelo  = request.getParameter("modelo");
                String cor  = request.getParameter("cor");
                String descricao  = request.getParameter("descricao");
                String arcondicionado  = request.getParameter("arcondicionado");
                String travaeletrica  = request.getParameter("travaeletrica");
                String cambioautomatico  = request.getParameter("cambioautomatico");
                String vidroeletrico  = request.getParameter("vidroeletrico");
                
                
                Veiculo veiculo = new Veiculo();
                
                veiculo.setPlaca(placa);
                veiculo.setMarca(marca);
                veiculo.setModelo(modelo);
                veiculo.setCor(cor);
                veiculo.setDescricao(descricao);
                veiculo.setArCondicionado(Boolean.parseBoolean(arcondicionado));
                veiculo.setTravaEletrica(Boolean.parseBoolean(travaeletrica));
                veiculo.setVidroEletrico(Boolean.parseBoolean(vidroeletrico));
                veiculo.setCambioAutomatico(Boolean.parseBoolean(cambioautomatico));
                veiculo.setAlugado(false);
                
                try{
                    if(id !=null && id>0){
                        veiculo.setId(new Integer(id));
                        //dao.altera(veiculo);
                    } else{
                        dao.adiciona(veiculo);
                    }
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("veiculo.jsp");
                    dispatcher.forward(request, response);
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    

