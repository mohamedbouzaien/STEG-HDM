d<%-- 
    Document   : gererReseau
    Created on : 16 févr. 2018, 02:12:31
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

        <title>Gerer Table</title>

        <!--data table-->
        <link rel="stylesheet" href="js/data-tables/DT_bootstrap.css" />

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
                        <li class="active"><a href="Dashboard"><i class="fa fa-home"></i> <span>Dashboard</span></a>

                        </li>

                        <li class="menu-list"><a href=""><i class="fa fa-users"></i> <span>Gestion utilisateurs</span></a>
                            <ul class="sub-menu-list">
                                <li><a href="AjouterUtilisateur"> Ajouter utilisateur</a></li>
                                <li><a href="#"> Gérer utilisateurs</a></li>
                            </ul>
                        </li>
                        <li class="menu-list nav-active"><a href=""><i class="fa fa-exchange"></i> <span>Gérer Réseau</span></a>
                            <ul class="sub-menu-list">
                                <li><a href="AjouterReseau"> Ajouter Réseau</a></li>
                                <li class="active"><a href="GererReseau"> Gérer Réseau</a></li>
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
                        Gérer Réseaux
                    </h3>
                    <ul class="breadcrumb">
                        <li>
                            <a href="#">Dashboard</a>
                        </li>
                        <li>
                            <a href="#">Data Table</a>
                        </li>
                        <li class="active"> Editable Table </li>
                    </ul>
                </div>
                <!-- page heading end-->

                <!--body wrapper start-->
                <div class="wrapper">
                    <div class="row">
                        
                            <div class="col-sm-12">
                                <section class="panel">
                                    <header class="panel-heading">
                                        Gérer Réseaux
                                        <span class="tools pull-right">
                                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                                            <a href="javascript:;" class="fa fa-times"></a>
                                        </span>
                                    </header>
                                    <div class="panel-body">
                                        <div class="adv-table editable-table ">
                                            <div class="clearfix">
                                                <div class="btn-group">
                                                    <button id="editable-sample_new" class="btn btn-primary">
                                                        Add New <i class="fa fa-plus"></i>
                                                    </button>
                                                </div>
                                                <div class="btn-group pull-right">
                                                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i>
                                                    </button>
                                                    <ul class="dropdown-menu pull-right">
                                                        <li><a href="#">Print</a></li>
                                                        <li><a href="#">Save as PDF</a></li>
                                                        <li><a href="#">Export to Excel</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="space15"></div>
                                            <table class="table table-striped table-hover table-bordered" id="editable-sample">
                                                <thead>
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Reseau</th>
                                                        <th>Masque</th>
                                                        <th>Description</th>
                                                        <th>Commentaire</th>
                                                        <th style="display:none;">idSite</th>
                                                        <th>Site</th>
                                                        <th style="display:none;">idDept</th>
                                                        <th>Departement</th>
                                                        <th>Afficher</th>
                                                        <th>Modifier</th>
                                                        <th>Supprimer</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="reseau" items="${ reseaux }" >
                                                        <tr class="">
                                                            <td><c:out value="${reseau.id}"/></td>
                                                            <td><c:out value="${reseau.adresse}" /></td>
                                                            <td><c:out value="${reseau.masque}" /></td>
                                                            <td class="center"><c:out value="${reseau.description}" /></td>
                                                            <td class="center"><c:out value="${reseau.commentaire}" /></td>
                                                            <td style="display:none;"><c:out value="${reseau.departement.site.id}" /></td>
                                                            <td class="center"><c:out value="${reseau.departement.site.nom}" /></td>
                                                            <td style="display:none;"><c:out value="${reseau.departement.id}" /></td>
                                                            <td class="center"><c:out value="${reseau.departement.nom}" /></td>
                                                            <td><a class="" href="AfficherAdressesIP/${reseau.id}">Afficher</a></td>
                                                            <td><a class="edit" href="javascript:;">Modifier</a></td>
                                                            <td><a class="delete" href="javascript:;">Supprimer</a></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
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

        <!--data table-->
        <script type="text/javascript" src="js/data-tables/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/data-tables/DT_bootstrap.js"></script>

        <!--common scripts for all pages-->
        <script src="js/scripts.js"></script>

        <!--script for editable table-->
        <script src="js/editable-table.js"></script>

        <!-- END JAVASCRIPTS -->
        <script>
            jQuery(document).ready(function () {
                EditableTable.init();
            });
        </script>

    </body>
</html>
