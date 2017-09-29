<%-- 
    Document   : veiculo
    Created on : 28/09/2017, 13:06:32
    Author     : gaoli_000
--%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <script type="text/javascript">
        function gravar(){
            document.getElementById("action").value= "gravar";
        }
    </script>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Veiculos</title>
    </head>
        <jsp:useBean id="dao" class="projetolocadoracarros.dao.VeiculoDAO" />
            
    <body>
        <div align="center">
        <h1>Cadastro de Veiculos</h1>
        </div>
        
        <form action="veiculo" method="post">
            <input type="hidden" id="action" name="action" value="" />
            <div align="center">
                <label id="id"> ID: </label><input id="id" type="text" name="id" size="5">
            </div>
            <div align="center">
                <label id="placa"> Placa: </label><input id="placa" type="text" name="placa" size="5">
            </div>
            <div align="center">
                <label id="modelo"> Modelo: </label><input id="modelo" type="text" name="modelo" size="5">
            </div>
            <div align="center">
                <label id="marca"> Marca: </label><input id="marca" type="text" name="marca" size="5">
            </div>
            <div align="center">
                <label id="cor"> Cor: </label><input id="cor" type="text" name="cor" size="5">
            </div>
            <div align="center">
                <label id="arcondicionado"> Ar condicionado: </label><input id="arcondicionado" name="arcondiconado" type="text" size="5">
            </div>
            <div align="center">
                <label id="travaeletrica"> Trava Elétrica: </label><input id="travaeletrica" name="travaeletrica" type="text" size="5">
            </div>
           
            <br>
            <div align="center">
                <button id="gravar_submit" onclick="grava();" value="Gravar">Gravar</button>
            </div>
        </form>
    </body>
</html>
