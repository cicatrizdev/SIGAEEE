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
        <title>SIGAEE- Cadastro de Evento - ${operacao}</title>
    </head>
    <body id="page-top">
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
                        <li class="nav-item">
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
                <h1>Cadastro de Evento</h1>
                <br/>
                <form action="ManterEventoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEvento">
                    <div class="form-group" <c:if test="${operacao == 'Incluir'}"> style="display:none" </c:if>>
                        <label for="idEvento">Id Evento</label>
                        <input type="text" class="form-control" id="idEvento" value="${evento.getIdEvento()}" name="txtIdEvento" <c:if test="${operacao != 'Incluir'}"> readonly</c:if> placeholder="Id">
                    </div>
                    <div class="form-group">
                        <label for="titulo">Nome</label>
                        <input type="text" class="form-control" id="titulo" value="${evento.getNomeEvento()}" name="txtNomeEvento" placeholder="Insira o titulo para o evento">
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição</label>
                        <input type="text" class="form-control" id="descricao" value="${evento.getDescricaoEvento()}" name="txtDescricaoEvento" placeholder="Insira a descrição do evento">
                    </div>
                    <div class="form-group">
                        <label for="data">Data</label>
                        <input type="text" class="form-control" id="data" value="${evento.getDataEvento()}" name="txtDataEvento">
                    </div>
                    <div class="form-group">
                        <label for="logradouro">Local</label>
                        <input type="text" class="form-control" id="logradouro" value="${evento.getLogradouroEvento()}" name="txtLougradouroEvento">
                    </div>
                    <div class="form-group">
                        <label for="tipoEvento">Tipo de Evento</label>
                        <select class="form-control" id="tipoEvento" name="intIdTipoEvento">
                            <option value="" disabled selected>Selecione o Tipo de Evento</option>
                            <c:forEach items="${tiposEvento}" var="tipoEvento">
                             <option value="${tipoEvento.getIdTipoEvento()}" 
                                        <c:if test="${ evento.getIdTipoEvento() == tipoEvento.getIdTipoEvento()}"> selected</c:if> > ${tipoEvento.getNomeTipoEvento()}</option>  
                            </c:forEach>
                        </select>

                    </div>
                    <div class="form-group">
                        <label for="Equipe">Equipe</label>
                        <select class="form-control" id="Equipe" name="intIdEquipe">
                            <option value="" disabled selected>Selecione o Tipo de Evento</option>
                            <c:forEach items="${equipes}" var="equipe">
                             <option value="${equipe.getIdEquipe()}" <c:if test="${ evento.getIdEquipe() == evento.getIdEquipe()}"> selected</c:if> > ${equipe.getNomeEquipe()}</option>  
                            </c:forEach>
                        </select>

                    </div>
                    <div class="form-group">
                        <h6> Inserir link para cadastro de tipo de evento <h6>
                                </div>
                                <div>
                                    <input type="submit" class="btn bg-dark text-white" name="btnConfirmar" value="${operacao}"/>
                                </div>
                                </form>
                                </div>
                                </section>

                                <script src="vendor/jquery/jquery.min.js"></script>
                                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                </body>
                                </html>
