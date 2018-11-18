<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">"
    <title>SIGAEE- Cadastro de Atleta</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand text-white" href="index.jsp">SIGAEE</a>
        <a class="navbar-brand text-white" href="cadastro.jsp"> > Cadastro </a>
        <a class="navbar-brand text-white" href="cadastroAtleta.jsp"> > Cadastro Atleta</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="cadastro.jsp">Cadastro</a>
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
    <h1> Cadastro Atleta ${operacao}</h1>
    <br/>
    <form action="ManterAtletaController?acao=confirmarOperacao&operacao=${operacao}" method="post">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" name="txtNomeAtleta" value="${atleta.nome}" placeholder="Insira seu nome">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="txtEmailAtleta" value="${atleta.email}" placeholder="exemplo@email.com">
        </div>
        <div class="form-group">
            <label for="password">Senha</label>
            <input type="password" class="form-control" name="txtSenhaAtleta" value="${atleta.senha}" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="nome">Data de Nascimento</label>
            <input type="text" class="form-control" name="txtDataNascimentoAtleta" value="${atleta.dataNascimento}" placeholder="01/01/2000">
        </div>
        <div class="form-group">
            <label for="nome">Altura</label>
            <input type="text" class="form-control" name="txtAlturaAtleta" value="${atleta.altura}" placeholder="ex.: 1.80">
        </div>
        <div class="form-group">
            <label for="nome">Peso</label>
            <input type="text" class="form-control" name="txtPesoAtleta" value="${atleta.peso}" placeholder="ex.: 85.7">
        </div>
        <div>
            <input type="submit" class="btn bg-dark text-white" value="${operacao}"/>
        </div>
        <!--
        <table>
            <tr>
                <td>Código Atleta</td>
                <td><input type="text" name="txtIdAtleta" value="${atleta.id}"></td>
            </tr>
            <tr>
                <td>Nome</td>
                <td><input type="text" name="txtNomeAtleta" value="${atleta.nome}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="txtEmailAtleta" value="${atleta.email}"></td>
            </tr>
            <tr>
                <td>Senha</td>
                <td><input type="password" name="txtSenhaAtleta" value="${atleta.senha}"></td>
            </tr>
            <tr>
                <td>Peso</td>
                <td><input type="text" name="txtPesoAtleta" value="${atleta.peso}"></td>
            </tr>
            <tr>
                <td>Altura</td>
                <td><input type="text" name="txtAlturaAtleta" value="${atleta.altura}"></td>
            </tr>
            <tr>
                <td>Data Nascimento</td>
                <td><input type="text" name="txtDataNascimentoAtleta" value="${atleta.dataNascimento}"></td>
            </tr>
        </table>
        --> 
    </form>
    <!--
    <div>
        <button type="button" class="btn bg-dark text-white">Enviar</button>
    </div>
    -->
    </div>
</section>
</body>
</html>
