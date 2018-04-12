<%-- 
    Document   : connexion
    Created on : 13 mars 2018, 01:46:37
    Author     : MED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="ThemeBucket">
        <link rel="shortcut icon" href="#" type="image/png">

        <title>Connexion</title>

        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="login-body">

        <div class="container">

            <form class="form-signin" action="Connexion" method="post">
                <div class="form-signin-heading text-center">
                    <h1 class="sign-title">Connexion</h1>
                    <img src="images/logo.png" alt=""/>
                </div>
                <c:if test="${ erreur == false}">
                    <div class="alert alert-danger fade in">
                        <button type="button" class="close close-sm" data-dismiss="alert">
                            <i class="fa fa-times"></i>
                        </button>
                        Matricule ou mot de passe erroné
                    </div>
                </c:if>
                <div class="login-wrap">
                    <input type="text" class="form-control" name="matricule" placeholder="Matricule" autofocus>
                    <input type="password" class="form-control" name="motdepasse" placeholder="Mot de passe">

                    <button class="btn btn-lg btn-login btn-block" type="submit">
                        <i class="fa fa-check"></i>
                    </button>

                    <div class="registration">
                        Pas encore membre?
                        <a class="" href="DemanderCompte">
                            Demander un compte
                        </a>
                    </div>
                    <label class="checkbox">
                        <input type="checkbox" value="remember-me"> Se souvenir de moi
                        <span class="pull-right">
                            <a data-toggle="modal" href="#myModal"> Mot de passe oublié?</a>

                        </span>
                    </label>

                </div>

                <!-- Modal -->
                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">Mot de passe oublié ?</h4>
                            </div>
                            <div class="modal-body">
                                <p>Veuillez entrer votre matricule pour réinitialiser le mot de passe.</p>
                                <input type="text" name="email" placeholder="Matricule" autocomplete="off" class="form-control placeholder-no-fix">

                            </div>
                            <div class="modal-footer">
                                <button data-dismiss="modal" class="btn btn-default" type="button">Annuler</button>
                                <button class="btn btn-primary" type="button">Valider</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- modal -->

            </form>

        </div>



        <!-- Placed js at the end of the document so the pages load faster -->

        <!-- Placed js at the end of the document so the pages load faster -->
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/modernizr.min.js"></script>

    </body>
</html>

