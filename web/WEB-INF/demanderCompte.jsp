<%-- 
    Document   : demanderCompte
    Created on : 13 mars 2018, 16:05:12
    Author     : MED
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <form class="form-signin" action="index.html">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">Demander compte</h1>
            <img src="images/logo.png" alt=""/>
        </div>


        <div class="login-wrap">
            <p>Entrez vos données personnels de compte</p>
            <input type="text" autofocus="" placeholder="Nom" class="form-control">
            <input type="text" autofocus="" placeholder="Prenom" class="form-control">
            <input type="text" autofocus="" placeholder="Adresse bureau" class="form-control">
            <input type="text" autofocus="" placeholder="Departement" class="form-control">
            <input type="text" autofocus="" placeholder="Site" class="form-control">
            <p> Entrez vos détails de compte</p>
            <input type="text" autofocus="" placeholder="Matricule" class="form-control">
            <input type="password" placeholder="Mot de Passe" class="form-control">
            <input type="password" placeholder="Retaper mot de passe" class="form-control">
            <label class="checkbox">
                <input type="checkbox" value="agree this condition"> J'accepte les termes de service des conditions
            </label>
            <button type="submit" class="btn btn-lg btn-login btn-block">
                <i class="fa fa-check"></i>
            </button>

            <div class="registration">
                Déja Enregistré.
                <a href="Connexion" class="">
                    Connexion
                </a>
            </div>

        </div>

    </form>

</div>



<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>

</body>
</html>
