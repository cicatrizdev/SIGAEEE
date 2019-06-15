<%-- 
    Document   : administrador
    Created on : 29/11/2018, 00:17:14
    Author     : Familia
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">"
    <title>SIGAEE- Painel</title>
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
                <li class="nav-item active">
                    <a class="nav-link" href="/Administrador">Painel
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Login?acao=deslogar">Sair</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<section class="py-5">
    <div class="container">
        <h1>Painel Administrativo</h1>
        <div class="list-group">
            <a href="PesquisaAtletaController" class="list-group-item list-group-item-action">Mostrar Atletas</a>
            <a href="PesquisaGestorController" class="list-group-item list-group-item-action">Mostrar Gestores</a>
            <a href="PesquisaEquipeController" class="list-group-item list-group-item-action">Mostrar Equipes</a>
            <a href="PesquisaEventoController" class="list-group-item list-group-item-action">Mostrar Eventos</a>
            <a href="PesquisaEsporteController" class="list-group-item list-group-item-action">Mostrar Esportes</a>
            <a href="PesquisaPosicaoController" class="list-group-item list-group-item-action">Mostrar Posições</a>
            <a href="PesquisaTipoEvento" class="list-group-item list-group-item-action">Mostrar Tipo de Eventos</a>
        </div>
    </div>
</section>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>

