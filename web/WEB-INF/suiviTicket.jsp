<%-- 
    Document   : suiviTicket
    Created on : 17 avr. 2018, 15:17:34
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

        <title>Ticket</title>

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

            <div class="ticket-ajout">
                <div class="ticket-ajout-heading text-center">
                    <h1 class="ticket-title">Suivi de votre ticket</h1>
                    <img src="images/logo.png" alt=""/>
                </div>
                <div class="login-wrap">
                <h3 class="text-center">Votre ticket a été ajouté avec succés</h3>
                <div class="progress">
                    <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar"
                         aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width:10%">
                        10% Completé
                    </div>
                </div>
                </div>
            </div>
        </div>


            <!-- Placed js at the end of the document so the pages load faster -->

            <!-- Placed js at the end of the document so the pages load faster -->
            <script src="js/jquery-1.10.2.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/modernizr.min.js"></script>
            <script src="js/ajouter-ticket-utilisateur.js"></script>

    </body>
</html>
