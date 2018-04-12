<%-- 
    Document   : ajouterUtilisateur
    Created on : 30 janv. 2018, 02:32:48
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

        <title>Ajouter Utilisateur</title>

        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="sticky-header">

        <section>
            <!-- left side start-->
            <div class="left-side sticky-left-side">

                <!--logo and iconic logo start-->
                <div class="logo">
                    <a href="Dashboard"><img src="images/logo.png" alt=""></a>
                </div>

                <div class="logo-icon text-center">
                    <a href="Dashboard"><img src="images/logo_icon.png" alt=""></a>
                </div>
                <!--logo and iconic logo end-->

                <div class="left-side-inner">

                    <!-- visible to small devices only -->
                    <div class="visible-xs hidden-sm hidden-md hidden-lg">
                        <div class="media logged-user">
                            <img alt="" src="images/photos/${sessionScope.utilisateur.photo}" class="media-object">
                            <div class="media-body">
                                <h4><a href="#">${sessionScope.utilisateur.prenom} ${sessionScope.utilisateur.nom}</a></h4>
                                <span>"Bienvenu..."</span>
                            </div>
                        </div>

                        <h5 class="left-nav-title">Information de compte</h5>
                        <ul class="nav nav-pills nav-stacked custom-nav">
                            <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
                            <li><a href="#"><i class="fa fa-cog"></i> <span>Paramétres</span></a></li>
                            <li><a href="#"><i class="fa fa-sign-out"></i> <span>Déconnecter</span></a></li>
                        </ul>
                    </div>

                    <!--sidebar nav start-->
                    <ul class="nav nav-pills nav-stacked custom-nav">
                        <li><a href="Dashboard"><i class="fa fa-home"></i> <span>Dashboard</span></a>

                        </li>

                        <li class="menu-list nav-active"><a href=""><i class="fa fa-users"></i> <span>Gestion utilisateurs</span></a>
                            <ul class="sub-menu-list">
                                <li class="active"><a href="AjouterUtilisateur"> Ajouter utilisateur</a></li>
                                <li><a href="#"> Gérer utilisateurs</a></li>
                            </ul>
                        </li>
                        <li class="menu-list"><a href=""><i class="fa fa-exchange"></i> <span>Gérer Réseau</span></a>
                            <ul class="sub-menu-list">
                                <li><a href="AjouterReseau"> Ajouter Réseau</a></li>
                                <li><a href="GererReseau"> Gérer Réseau</a></li>
                                <li><a href="#"> Scan du conflit</a></li>
                            </ul>
                        </li>
                        <li class="menu-list"><a href=""><i class="fa fa-file-text"></i> <span>Gestion tickets</span></a>
                            <ul class="sub-menu-list">
                                <li><a href="AjouterTicket"> Ajouter Ticket</a></li>
                                <li><a href="#"> Lister Tickets</a></li>
                                <li><a href="#"> Mes Tickets</a></li>
                            </ul>
                        </li>
                        <li class="menu-list"><a href=""><i class="fa fa-cogs"></i> <span>Gérer Composants</span></a>
                            <ul class="sub-menu-list">
                                <li><a href="GererSitesDepartements"> Gérer Sites et Departements</a></li>
                                <li><a href="#"> Gérer composants</a></li>
                            </ul>
                        </li>

                        <li><a href="#"><i class="fa fa-cloud"></i> <span>Serveur FTP</span></a></li>

                    </ul>
                    <!--sidebar nav end-->

                </div>
            </div>
            <!-- left side end-->

            <!-- main content start-->
            <div class="main-content" >

                <!-- header section start-->
                <div class="header-section">

                    <!--toggle button start-->
                    <a class="toggle-btn"><i class="fa fa-bars"></i></a>
                    <!--toggle button end-->


                    <!--notification menu start -->
                    <div class="menu-right">
                        <ul class="notification-menu">
                            <li>
                                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    <img src="images/photos/${sessionScope.utilisateur.photo}" alt="" />
                                    ${sessionScope.utilisateur.prenom} ${sessionScope.utilisateur.nom}
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                                    <li><a href="#"><i class="fa fa-user"></i>  Profile</a></li>
                                    <li><a href="#"><i class="fa fa-cog"></i>  Paramétres</a></li>
                                    <li><a href="#"><i class="fa fa-sign-out"></i> Deconnecter</a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                    <!--notification menu end -->

                </div>
                <!-- header section end-->

                <!-- page heading start-->
                <div class="page-heading">
                    <h3>
                        Form Validation
                    </h3>
                    <ul class="breadcrumb">
                        <li>
                            <a href="#">Form</a>
                        </li>
                        <li class="active"> Form Validation </li>
                    </ul>
                </div>
                <!-- page heading end-->

                <!--body wrapper start-->

                <div class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Ajouter Utilisateur
                                </header>
                                <div class="panel-body">
                                    <c:if test="${ isAdded }">
                                        <div class="alert alert-success fade in">
                                            <button type="button" class="close close-sm" data-dismiss="alert">
                                                <i class="fa fa-times"></i>
                                            </button>
                                            Utilisateur ajouté avec succées
                                        </div>
                                    </c:if>
                                    <div class="form">
                                        <form class="cmxform form-horizontal adminex-form" method="post" action="AjouterUtilisateur">
                                            <div class="form-group ">
                                                <label for="prenom" class="control-label col-lg-2">Prénom</label>
                                                <div class="col-lg-10">
                                                    <input class=" form-control" id="prenom" name="prenom" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="nom" class="control-label col-lg-2">Nom</label>
                                                <div class="col-lg-10">
                                                    <input class=" form-control" id="nom" name="nom" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="matricule" class="control-label col-lg-2">Matricule</label>
                                                <div class="col-lg-10">
                                                    <input class="form-control " id="matricule" name="matricule" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="motdepasse" class="control-label col-lg-2">Mot de passe</label>
                                                <div class="col-lg-10">
                                                    <input class="form-control " id="motdepasse" name="motdepasse" type="password" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="confirmer_pass" class="control-label col-lg-2">Confirmer mot de passe</label>
                                                <div class="col-lg-10">
                                                    <input class="form-control " id="confirmer_pass" name="confirmer_pass" type="password" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="adresse" class="control-label col-lg-2">Adresse</label>
                                                <div class="col-lg-10">
                                                    <input class=" form-control" id="adresse" name="adresse" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="departement" class="control-label col-lg-2">Département</label>
                                                <div class="col-lg-10">
                                                    <input class=" form-control" id="departement" name="departement" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="role" class="control-label col-lg-2">Rôle</label>
                                                <div class="col-lg-10">
                                                    <select class="form-control" id="role" name="role">
                                                        <option value="">Veuillez Choisir...</option>
                                                        <option value="Directeur">Directeur</option>
                                                        <option value="HelpDesk">HelpDesk</option>
                                                        <option value="Agent">Agent</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="fichier" class="control-label col-lg-2">Photo de profil</label>
                                                <div class="col-lg-10">
                                                    <input type="file" class="btn btn-default" name="fichier" id="fichier" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-lg-offset-2 col-lg-10">
                                                    <button class="btn btn-primary" type="submit">Save</button>
                                                    <button class="btn btn-default" type="button">Cancel</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <!--body wrapper end-->

                <!--footer section start-->
                <footer>
                    2014 &copy; AdminEx by ThemeBucket
                </footer>
                <!--footer section end-->


            </div>
            <!-- main content end-->
        </section>

        <!-- Placed js at the end of the document so the pages load faster -->
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="js/jquery-migrate-1.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/modernizr.min.js"></script>
        <script src="js/jquery.nicescroll.js"></script>

        <script type="text/javascript" src="js/jquery.validate.min.js"></script>
        <script src="js/validation-init_utilisateur.js"></script>

        <!--common scripts for all pages-->
        <script src="js/scripts.js"></script>

    </body>
</html>