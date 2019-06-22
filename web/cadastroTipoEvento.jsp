<%-- 
    Document   : cadastroTipoEvento
    Created on : 14/06/2019, 21:27:11
    Author     : admin
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="/css/bootstrap.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">"
        <title>SIGAEE- Cadastro de Equipe</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand text-white">SIGAEE</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="cadastroGestor.jsp">Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <section class="py-5">
            <div class="container">
                <h1>Tipo de Evento ${operacao}</h1>
                <br/>
                <form action="ManterTipoEventoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterTipoEvento">
                    <div class="form-group" <c:if test="${operacao == 'Incluir'}"> style="display:none" </c:if>>
                        <label for="idTipoEvento">Id Tipo de Evento</label>
                        <input type="text" class="form-control" id="idTipoEvento"  value="${tipoEvento.getIdTipoEvento()}" name="intIdTipoEvento" <c:if test="${operacao != 'Incluir'}"> readonly</c:if> placeholder="Id" >
                        </div>
                        <div class="form-group">
                        <label for="nomeTipoEvento">Nome da Tipo de Evento</label>
                        <input type="text" class="form-control" id="nome" required <c:if test="${operacao != 'Incluir'}"> value="${tipoEvento.getNomeTipoEvento()}" </c:if> name = "txtNomeTipoEvento"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> placeholder="Insira o nome do Tipo de Evento">
                        </div>
                        
                    <div>
                        <input type="submit" name="btnConfirmar" value="${operacao}"/>
                    </div>
                </form>
            </div>

        </section>

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
