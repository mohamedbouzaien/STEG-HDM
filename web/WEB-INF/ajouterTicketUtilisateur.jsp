<%-- 
    Document   : ajouterTicketUtilisateur
    Created on : 12 avr. 2018, 19:00:55
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

        <title>Registration</title>

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

            <form class="ticket-ajout" action="index.html">
                <div class="ticket-ajout-heading text-center">
                    <h1 class="ticket-title">Ajouter ticket de reclamation</h1>
                    <img src="images/logo.png" alt=""/>
                </div>


                <div class="login-wrap">
                    <p>Entrez les détails du ticket</p>
                    <input type="text" autofocus="" placeholder="<c:out value="${ code }"/>" class="form-control" disabled>
                    <select class="form-control" id="urgence" name="urgence">
                        <option value="">Urgence...</option>
                        <option value="0">Cruciale</option>
                        <option value="1">Moyenne</option>
                        <option value="2">Insinifiante</option>
                    </select>
                    <select class="form-control" id="peripherique" name="peripherique">
                        <option value="">Peripherique...</option>
                        <option value="Aucun">Aucun</option>
                        <option value="Ordinateur">Ordinateur</option>
                        <option value="Cablage">Cablage</option>
                        <option value="Imprimante">Imprimante</option>
                        <option value="Autre">Autre</option>
                    </select>
                    <input type="text" autofocus="" placeholder="Titre" class="form-control" name="titre">
                    <textarea class="form-control " id="description" name="description" placeholder="Description"></textarea>
                    <input type="file" class="btn btn-default" name="fichier" id="fichier" />
                    <input type="text" autofocus="" placeholder="Matricule" name="matricule" id="matricule" class="form-control">
                    <div id="details">
                        <p> Entrez vos détails personnel</p>
                        <input type="text" autofocus="" placeholder="Nom" name="nom" id="nom" class="form-control">
                        <input type="text" placeholder="Prenom" name="prenom" id="prenom" class="form-control">
                        <input type="text" placeholder="Adresse bureau" name="adresse" id="adresse" class="form-control">
                    </div>
                    <button type="submit" id="envoyer" class="btn btn-lg btn-login btn-block" disabled>
                        <i class="fa fa-check"></i>
                    </button>
                </div>
            </form>
        </div>



        <!-- Placed js at the end of the document so the pages load faster -->

        <!-- Placed js at the end of the document so the pages load faster -->
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/modernizr.min.js"></script>
        <script src="js/ajouter-ticket-utilisateur.js"></script>

    </body>
</html>

