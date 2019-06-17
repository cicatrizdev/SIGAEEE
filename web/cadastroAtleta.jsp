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
        <title>SIGAEE- Cadastro de Atleta</title>

        <script type="text/javascript">
            function validar(){
                var nome = fmrAtleta.txtNomeAtleta.value;
                var email = fmrAtleta.txtEmailAtleta.value;
                var senha = fmrAtleta.txtSenhaAtleta.value;
                
                if(nome === ""){
                    alert('Preencha o campo nome.');
                    fmrAtleta.txtNomeAtleta.focus();
                    return false;
                }
                
                if(email == "" || txtEmailAtleta.indexOf('@') == -1 ){
                    alert('Preencha o campo E-mail.');
                    fmrAtleta.txtEmailAtleta.focus();
                    return false;
                }
                
                if(senha == "" || txtSenhaAtleta.length <= 5){
                    alert('Preencha o campo senha com minimo 6 caracteres');
                    fmrGestor.txtSenhaAtleta.focus();
                    return false;
                }
            }
        </script>
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
                    <div class="form-group" <c:if test="${operacao == 'Incluir'}"> style="display:none" </c:if>>
                            <label for="idEvento">Id Evento</label>
                            <input type="text" class="form-control" id="idEvento"  name="txtIdAtleta" <c:if test="${operacao == 'Incluir'}">value = "0"</c:if> <c:if test="${operacao != 'Incluir'}">value="${atleta.getIdUsuario()}" readonly</c:if> placeholder="Id">
                        </div>
                        <div class="form-group">
                            <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="txtNomeAtleta" value="${atleta.getNomeUsuario()}" placeholder="Insira seu nome" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="txtEmailAtleta" value="${atleta.getEmail()}" placeholder="exemplo@email.com" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input type="password" class="form-control" name="txtSenhaAtleta" value="${atleta.getSenha()}" placeholder="Password" required>
                    </div>
                    <div class="form-group">
                        <label for="nome">Data de Nascimento</label>
                        <input type="text" class="form-control" name="txtDataNascimentoAtleta" value="${atleta.getDataNascimento()}" placeholder="01/01/2000">
                    </div>
                    <div class="form-group">
                        <label for="nome">Altura</label>
                        <input type="text" class="form-control" name="txtAlturaAtleta" value="${atleta.getAltura()}" placeholder="ex.: 1.80" required>
                    </div>
                    <div class="form-group">
                        <label for="nome">Peso</label>
                        <input type="text" class="form-control" name="txtPesoAtleta" value="${atleta.getPeso()}" placeholder="ex.: 85.7" required>
                    </div>
                    <div class="form-group">
                        <label for="Equipe">Equipe</label>
                        <select class="form-control" id="Equipe" name="txtIdEquipe">
                            <option value="" disabled selected>Selecione a Equipe</option>
                            <c:forEach items="${equipes}" var="equipe">
                                <option value="${equipe.getIdEquipe()}" <c:if test="${ equipe.getIdEquipe().equals(atleta.equipe.getIdEquipe())}"> selected</c:if> > ${equipe.getNomeEquipe()}</option>  
                            </c:forEach>
                        </select>

                    </div>
                    <div class="form-group">
                        <label for="Posicao">Posição</label>
                        <select class="form-control" id="Posicao" name="txtIdPosicao">
                            <option value="" disabled selected>Selecione a Posição</option>
                            <c:forEach items="${posicoes}" var="posicao">
                                <option value="${posicao.getIdPosicao()}" <c:if test="${ posicao.getIdPosicao().equals(atleta.posicao.getIdPosicao())}"> selected</c:if> > ${posicao.getNomePosicao()}</option>  
                            </c:forEach>
                        </select>

                    </div>
                    <div>
                        <input type="submit" class="btn bg-dark text-white" value="${operacao}"/>
                    </div>
                </form>

            </div>
        </section>
    </body>
</html>
