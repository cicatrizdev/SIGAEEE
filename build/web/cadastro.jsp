<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">"
    <title>SIGAEE- Cadastro</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand text-white" href="index.jsp">SIGAEE</a>
        <a class="navbar-brand text-white" href="cadastro.jsp"> > Cadastro </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="cadastro.jsp">Cadastro
                        <span class="sr-only">(current)</span>
                    </a>
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
        <h1>Cadastro</h1>
    <div class="row">
        <div class="col-sm-6 text-center">
            <div class="card " style="width: 30rem;">
            <img class="card-img-top" src="" alt="Imagem">
                <div class="card-body">
                    <h5 class="card-title">Cadastro de Gestor</h5>
                    <p class="card-text">Gerencie seus atletas e seu time! Organize sua agenda e tenha todos os dados em seu controle.</p>
                    <a href="cadastroGestor.jsp" class="btn btn-primary">Cadastre-se</a>
            </div>
            </div>
        </div>
        <div class="col-sm-6 text-center">
            <div class="card " style="width: 30rem;">
            <img class="card-img-top" src="" alt="Imagem">
                <div class="card-body">
                    <h5 class="card-title">Cadastro de Atleta</h5>
                    <p class="card-text">Tenha acesso a todas as informações da sua equipe, esteja por dentro dos próximos compromissos.</p>
                    <a href="cadastroAtleta.jsp" class="btn btn-primary">Cadastre-se</a>
                </div>
            </div>
        </div>
    </div>
    </div>    