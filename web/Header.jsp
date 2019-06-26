<%-- 
    Document   : Header
    Created on : 26/06/2019, 10:55:57
    Author     : jonathan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>NyahFood</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Custom Theme files -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--webfont-->
        <link href='//fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Lobster+Two:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <!--Animation-->
        <script src="js/wow.min.js"></script>
        <link href="css/animate.css" rel='stylesheet' type='text/css' />
        <script>
            new WOW().init();
        </script>
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
                });
            });
        </script>
        <script src="js/simpleCart.min.js"></script>	
    </head>
    <body>
        <!-- header-section-starts -->
        <div class="header">
            <div class="container">
                <div class="top-header">
                    <div class="logo">
                        <a href="index.jsp"><h1>SIGAEEE</h1></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="menu-bar">
                <div class="container">
                    <div class="top-menu">
                        <ul>

                            <li class="active"><a href="index.jsp">Inicio</a></li>|
                            <!--  -->
                            <% if (session.getAttribute("tipo") == "1") { %>
                            <li><a href="PainelGestor">Painel</a></li>
                                <% } %>
                                <% if (session.getAttribute("tipo") == "2") { %>
                            <li><a href="PainelAtleta">Painel</a></li>
                                <% } %>
                                <% if (session.getAttribute("tipo") == "3") { %>
                            <li><a href="Administrador">Administrador</a></li>
                                <% } %>
                            <div class="clearfix"></div>
                        </ul>
                    </div>
                    <div class="login-section">
                        <ul>                      
                            <% if (session.getAttribute("tipo") == null) { %>
                            <% } else {%>
                            <% } %>
                            <% if (session.getAttribute("tipo") == null) { %>
                            <li><a href="LoginGeral?acao=preparar">Login</a></li>
                            <li><a href="CadastroAtleta?acao=prepararOperacao&operacao=Incluir">Cadastrar Atleta</a> </li>
                            <li><a href="CadastroGEstorController?acao=prepararOperacao&operacao=Incluir">Cadastrar Gestor</a> </li>
                                <% } else {%>
                                <% } %>
                            |
                            <% if (session.getAttribute("tipo") == null) { %>
                            <% } else {%>
                            <li id="BemVindo">Bem-Vindo <%=session.getAttribute("login")%></li>
                            <li ><a href="LogoutController" id="Logout">Deslogar</a></li>
                                <% }%>
                            <div class="clearfix"></div>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
    </body>
</html>
