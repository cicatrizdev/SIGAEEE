<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">"
    <title>SIGAEE- Cadastro</title>
   
   <script type="text/javascript">
        function validar(){
            var nome = fmrGestor.txtNomeGestor.value;
            var email = fmrGestor.txtEmailGestor.value;
            var senha = fmrGestor.txtSenhaGestor.value;
            
            if(txtNomeGestor == ""){
                alert('Preencha o campo nome.');
                fmrGestor.txtNomeGestor.focus();
                return false;
            }
            
            if(txtEmailGestor == "" || txtEmailGestor.indexOf('@') == -1 ){
                alert('Preencha o campo E-mail.');
                fmrGestor.txtEmailGestor.focus();
                return false;
            }
            
            if(senha == "" || senha.length <= 5){
                alert('Preencha o campo senha com minimo 6 caracteres');
                fmrGestor.senha.focus();
                return false;
            }
        }
    </script>
</head>
<body id="page-top">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand text-white" href="index.jsp">SIGAEE</a>
        <a class="navbar-brand text-white" href="cadastro.jsp"> > Cadastro </a>
        <a class="navbar-brand text-white" href="cadastroGestor.jsp"> > Cadastro Gestor</a>
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
        <h1>Cadastro de Gestor</h1>
        <br/>
        <form action="ManterGestorController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="fmrGestor">
                     <div class="form-group" <c:if test="${operacao == 'Incluir'}"> style="display:none" </c:if>>
                        <label for="idEvento">Id Evento</label>
                        <input type="text" class="form-control" id="idGestor" name="txtIdGestor" <c:if test="${operacao == 'Incluir'}"> value ="0" </c:if> <c:if test="${operacao != 'Incluir'}"> value="${gestor.getIdGestor()}"  readonly</c:if> placeholder="Id">
                    </div>
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" class="form-control"name="txtNomeGestor" value="${gestor.getNomeUsuario()}" placeholder="Insira seu nome" >
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="txtEmailGestor" required value="${gestor.getEmail()}" placeholder="exemplo@email.com">
            </div>
            <div class="form-group">
                <label for="password">Senha</label>
                <input type="password" class="form-control"name="txtSenhaGestor" required value="${gestor.getSenha()}" placeholder="Password">
            </div>
            <div>
                <input type="submit" class="btn bg-dark text-white" onclick="return validar()" value="${operacao}"/>
            </div>
        </form>
    </div>
</section>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
