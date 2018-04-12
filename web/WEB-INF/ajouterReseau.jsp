<%-- 
    Document   : ajouterReseau
    Created on : 6 févr. 2018, 22:57:16
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

        <title>Ajouter Réseaux</title>

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

                        <li class="menu-list"><a href=""><i class="fa fa-users"></i> <span>Gestion utilisateurs</span></a>
                            <ul class="sub-menu-list">
                                <li><a href="AjouterUtilisateur"> Ajouter utilisateur</a></li>
                                <li><a href="#"> Gérer utilisateurs</a></li>
                            </ul>
                        </li>
                        <li class="menu-list nav-active"><a href=""><i class="fa fa-exchange"></i> <span>Gérer Réseau</span></a>
                            <ul class="sub-menu-list">
                                <li class="active"><a href="AjouterReseau"> Ajouter Réseau</a></li>
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
                                    Ajouter Réseau
                                </header>
                                <div class="panel-body">
                                    <c:if test="${ isAdded }">
                                        <div class="alert alert-success fade in">
                                            <button type="button" class="close close-sm" data-dismiss="alert">
                                                <i class="fa fa-times"></i>
                                            </button>
                                            Réseau ajouté avec succés
                                        </div>
                                    </c:if>
                                    <div class="form">
                                        <form class="cmxform form-horizontal adminex-form" method="post" action="AjouterReseau">
                                            <div class="form-group ">
                                                <label for="adresse" class="control-label col-lg-2">Adresse réseau</label>
                                                <div class="col-lg-10">
                                                    <input class=" form-control" id="adresse" name="adresse" type="text" placeholder="" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="masque" class="control-label col-lg-2">Masque</label>
                                                <div class="col-lg-10">
                                                    <select class="form-control" id="masque" name="masque">
                                                        <option disabled="">CLASSE A</option>
                                                        <option value="8">8 (255.0.0.0 - 16.777.214 hôtes)</option>
                                                        <option value="9">9 (255.128.0.0 - 8.388.606 hôtes)</option>
                                                        <option value="10">10 (255.192.0.0 - 4.194.302 hôtes)</option>
                                                        <option value="11">11 (255.224.0.0 - 2.097.150 hôtes)</option>
                                                        <option value="12">12 (255.240.0.0 - 1.048.574 hôtes)</option>
                                                        <option value="13">13 (255.248.0.0 - 524.286 hôtes)</option>
                                                        <option value="14">14 (255.252.0.0 - 262.142 hôtes)</option>
                                                        <option value="15">15 (255.254.0.0 - 131.070 hôtes)</option>
                                                        <option disabled="">CLASSE B</option>
                                                        <option value="16">16 (255.255.0.0 - 65.534 hôtes)</option>
                                                        <option value="17">17 (255.255.128.0 - 32766 hôtes)</option>
                                                        <option value="18">18 (255.255.192.0 - 16.382 hôtes)</option>
                                                        <option value="19">19 (255.255.224.0 - 8.190 hôtes)</option>
                                                        <option value="20">20 (255.255.240.0 - 4.094 hôtes)</option>
                                                        <option value="21">21 (255.255.248.0 - 2.046 hôtes)</option>
                                                        <option value="22">22 (255.255.252.0 - 1.022 hôtes)</option>
                                                        <option value="23">23 (255.255.254.0 - 510 hôtes)</option>
                                                        <option disabled="">CLASSE C</option>
                                                        <option value="24" selected="">24 (255.255.255.0 - 254 hôtes)</option>
                                                        <option value="25">25 (255.255.255.128 - 126 hôtes)</option>
                                                        <option value="26">26 (255.255.255.192 - 62 hôtes)</option>
                                                        <option value="27">27 (255.255.255.224 - 30 hôtes)</option>
                                                        <option value="28">28 (255.255.255.240 - 14 hôtes)</option>
                                                        <option value="29">29 (255.255.255.248 - 6 hôtes)</option>
                                                        <option value="30">30 (255.255.255.252 - 2 hôtes)</option>
                                                        <option value="31">31 (255.255.255.254 - 0 hôtes)</option>
                                                        <option value="32">32 (255.255.255.255 - 0 hôtes)</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="description" class="control-label col-lg-2">Description</label>
                                                <div class="col-lg-10">
                                                    <textarea class="form-control " id="description" name="description"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="commentaire" class="control-label col-lg-2">Commentaire</label>
                                                <div class="col-lg-10">
                                                    <input class="form-control " id="commentaire" name="commentaire" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="site" class="control-label col-lg-2">Site</label>
                                                <div class="col-lg-10">
                                                    <select class="form-control" id="site" name="site">
                                                        <option value="">Veuillez Choisir...</option>
                                                        <c:forEach var="site" items="${ sites }">
                                                            <option value="<c:out value="${ site.id }" />"><c:out value="${ site.nom }" /> </option>
                                                        </c:forEach>

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="departement" class="control-label col-lg-2">Departement</label>
                                                <div class="col-lg-10">
                                                    <select class="form-control" id="departement" name="departement">
                                                        <option value="">Veuillez Choisir...</option>
                                                    </select>
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
        <!--bootstrap input mask-->
        <script type="text/javascript" src="js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
        <!--add reseau script page-->
        <script src="js/add-reseau-init.js"></script>
        <!--common scripts for all pages-->
        <script src="js/scripts.js"></script>

    </body>
</html>
