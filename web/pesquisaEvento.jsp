<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">"
    <title>SIGAEE- Relatório</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand text-white" href="painelGestor.jsp">SIGAEE</a>
        <a class="navbar-brand text-white" href="pesquisaEvento.jsp"> > Relatório de Eventos </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="painelGestor.jsp">Painel
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sair</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <section class="py-5">
        <div class="container">
<h1>Pesquisa de Evento</h1>
<br/>
<table>
    <tr>
        <th>Código Evento</th>
        <th>Nome Evento</th>
        <th colspan=2>Ação</th>
    </tr>
    <c:forEach items="${eventos}" var="evento">
        <tr>
            <td><c:out value="${evento.getIdEvento()}"/></td>
            <td><c:out value="${evento.getNomeEvento()}" /></td>
            <td><a href="ManterEventoController?acao=prepararOperacao&operacao=Editar&idEvento=<c:out value="${evento.idEvento}"/>">Editar</a></td>
            <td><a href="ManterEventoController?acao=prepararOperacao&operacao=Excluir&idEvento=<c:out value="${evento.idEvento}"/>">Excluir</a></td>
        </tr>
    </c:forEach >
</table>
<form action="ManterEventoController?acao=prepararOperacao&operacao=Incluir" method="post">
    <input type="submit" name="btnIncluir" value="Incluir"/>
</form>
        </div>
</body>
</html>