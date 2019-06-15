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
                <h1>Equipe ${operacao}</h1>
                <br/>
                <form action="ManterEquipeController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEquipe">
                    <div class="form-group" <c:if test="${operacao == 'Incluir'}"> style="display:none" </c:if>>
                        <%--@declare id="nomeequipe"--%><label for="idEquipe">Id Equipe</label>
                        <input type="text" class="form-control" id="idEquipe"  value="${equipe.getIdEquipe()}" name="txtIdEquipe" <c:if test="${operacao != 'Incluir'}"> readonly</c:if> placeholder="Id" >
                        </div>
                        <div class="form-group">
                        <%--@declare id="nomeequipe"--%><label for="nomeEquipe">Nome da Equipe</label>
                        <input type="text" class="form-control" id="nome" required <c:if test="${operacao != 'Incluir'}"> value="${equipe.getNomeEquipe()}" </c:if> name = "txtNomeEquipe"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> placeholder="Insira o nome da equipe">
                        </div>
                              <div class="form-group">
                        <label>Gestor</label>
                        <select class="form-control" name="txtIdGestor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                            <option value="null" disabled selected>Selecione o Gestor</option>
                                <c:forEach items="${gestores}" var="gestor">
                                    <option value="${gestor.getIdGestor()}"<c:if test="${equipe.gestor.getIdGestor() == gestor.getIdGestor()}"> selected</c:if>>${gestor.getNomeUsuario()}</option>  
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                        <%--@declare id="equipelogo"--%><label for="equipeLogo">Team Logo</label><br>
                        <input type="text" class="form-control" id="nome" required <c:if test="${operacao != 'Incluir'}"> value="${equipe.getLogo()}" </c:if> name = "txtLogoEquipe"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> placeholder="Insira a url da logo">              
                        <c:if test="${operacao != 'Incluir'}"><img src="${equipe.getLogo()}" alt="Team Logo" style="width:60px;height: 80px;"><br></c:if> 
                        </div>
                        <div class="form-group">

                        <%--@declare id="equipelogo"--%><label for="equipePlaybook">Team Playbook</label><br>                    
                        <input type="text" class="form-control" id="nome" required <c:if test="${operacao != 'Incluir'}"> value="${equipe.getPlaybook()}" </c:if> name = "txtPlaybookEquipe"<c:if test="${operacao == 'Excluir'}"> readonly</c:if> placeholder="Insira a url do Playbook">              
                        <c:if test="${operacao != 'Incluir'}"><h5><a href="${equipe.getPlaybook()}">Playbook</a></h5></c:if>  
                        </div>
                        <div class="form-group">
                        
                        <div class="form-group">
                        <label> Esporte</label>
                        <select class="form-control" name="txtIdEsporte" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                            <option value="" disabled selected>Selecione o esporte</option>
                                <c:forEach items="${esportes}" var="esporte">
                                    <option value="${esporte.getIdEsporte()}"<c:if test="${equipe.esporte.getIdEsporte() == esporte.getIdEsporte()}"> selected</c:if>>${esporte.getNomeEsporte()}</option>  
                                </c:forEach>
                            </select>
                        </div>
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
