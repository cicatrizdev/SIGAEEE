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
        <title>SIGAEE- Cadastro de Posicao - ${operacao}</title>
        <script type="text/javascript">
            function validar(){
                var nome = fmrPosicao.txtNomePosicao.value;
                var idPosicao = fmrPosicao.txtIdPosicao.value;
                                
                if(txtNomePosicao == ""){
                    alert('Preencha o campo nome.');
                    fmrPosicao.nome.focus();
                    return false;
                }
                
                if(senha == "" ){
                    alert('Preencha o campo id da Posicao');
                    fmrPosicao.idPosicao.focus();
                    return false;
                }
            }
        </script>
    
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
                            <a class="nav-link" href="Home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ManterGestorController">Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Login">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="py-5">
            <div class="container">
                <h1>Cadastro de Posicao</h1>
                <br/>
                <form action="ManterPosicaoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterPosicao">
                    <div class="form-group" <c:if test="${operacao == 'Incluir'}"> style="display:none" </c:if>>
                            <label for="idPosicao">Id Posicao</label>
                            <input type="text" class="form-control" id="idPosicao"  name="txtIdPosicao"<c:if test="${operacao == 'Incluir'}"> value ="0" </c:if> <c:if test="${operacao != 'Incluir'}">  value="${posicao.getIdPosicao()}" readonly</c:if> placeholder="Id">
                        </div>
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" id="nome" value="${posicao.getNomePosicao()}" name="txtNomePosicao" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> placeholder="Insira o nome da posicao" required>
                    </div>
                    <div class="form-group">
                        <label> Esporte</label>
                        <select class="form-control" name="txtIdEsporte" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> 
                                <option value="" disabled selected>Selecione o esporte</option>
                            <c:forEach items="${esportes}" var="esporte">
                                <option value="${esporte.getIdEsporte()}"<c:if test="${posicao.getIdEsporte() == esporte.getIdEsporte()}"> selected</c:if>>${esporte.getNomeEsporte()}</option>  
                            </c:forEach>
                        </select>
                    </div>

            </div>
            <div class="form-group">
            </div>
            <div>
                <input type="submit" class="btn bg-dark text-white" onclick="return validar()" name="btnConfirmar" value="${operacao}"/>
            </div>
        </form>
    </div>
</section>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
