<%-- 
    Document   : GererAdressesIP
    Created on : 23 mars 2018, 17:27:21
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
        <link rel="stylesheet" href="/STEG-HDM/js/data-tables/DT_bootstrap.css" />

        <link href="/STEG-HDM/css/style.css" rel="stylesheet">
        <link href="/STEG-HDM/css/style-responsive.css" rel="stylesheet">

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
                                    Ajouter une attribution de plage d'adresses
                                    <span class="tools pull-right">
                                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                                        <a href="javascript:;" class="fa fa-times"></a>
                                    </span>
                                </header>
                                <div class="panel-body">
                                    <c:if test="${ isAdded }">
                                        <div class="alert alert-success fade in">
                                            <button type="button" class="close close-sm" data-dismiss="alert">
                                                <i class="fa fa-times"></i>
                                            </button>
                                            Attribution ajouté avec succés
                                        </div>
                                    </c:if>
                                    <div class="form">
                                        <form class="cmxform form-horizontal adminex-form" method="post" action=<c:out value="${id_rsx}"/>>
                                            <div class="form-group ">
                                                <label for="adresse_debut" class="control-label col-lg-2">Adresse IP de début</label>
                                                <div class="col-md-2">
                                                    <input class=" form-control" id="adresse_debut" name="adresse_debut" type="text" placeholder="" />
                                                </div>
                                                <label for="adresse_fin" class="control-label col-lg-2">Adresse IP de fin</label>
                                                <div class="col-md-2">
                                                    <input class="form-control " id="adresse_fin" name="adresse_fin" type="text" />
                                                </div>
                                                <label for="type" class="control-label col-lg-2">Type</label>
                                                <div class="col-md-2">
                                                    <select class="form-control" id="masque" name="type">
                                                        <option disabled="">Veuillez choisir...</option>
                                                        <option value="DHCP">DHCP</option>
                                                        <option value="Statique">Statique</option>
                                                        <option value="Fixe">Fixe</option>
                                                        <option value="Usage privé">Usage privé</option>
                                                        <option value="Autres">Autres</option>
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
                                                    <th style="display:none;">Id</th>
                                                    <th>Adresse</th>
                                                    <th>Type hote</th>
                                                    <th>Categorie</th>
                                                    <th>Description</th>
                                                    <th>Informations hote</th>
                                                    <th>Modifier</th>
                                                    <th>Supprimer</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="adresseIP" items="${ adressesIP }" >
                                                    <tr class="">
                                                        <td style="display:none;"><c:out value="${adresseIP.id}"/></td>
                                                        <td><c:out value="${adresseIP.adresse}" /></td>
                                                        <td><c:out value="${adresseIP.typehote}" /></td>
                                                        <td class="center"><c:out value="${adresseIP.categorie}" /></td>
                                                        <td class="center"><c:out value="${adresseIP.desription}" /></td>
                                                        <td>
                                                            <c:if test="${adresseIP.utilisateur != null}">
                                                                <c:out value="${adresseIP.utilisateur.matricule}- ${adresseIP.utilisateur.nom}  ${adresseIP.utilisateur.prenom}" />
                                                                
                                                            </c:if>
                                                            <c:if test="${adresseIP.composant != null}">
                                                                <c:out value="${adresseIP.composant.matriculeInventaire}- ${adresseIP.composant.nom}" />
                                                                
                                                            </c:if>
                                                        </td>
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
        <script src="/STEG-HDM/js/jquery-1.10.2.min.js"></script>
        <script src="/STEG-HDM/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="/STEG-HDM/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="/STEG-HDM/js/bootstrap.min.js"></script>
        <script src="/STEG-HDM/js/modernizr.min.js"></script>
        <script src="/STEG-HDM/js/jquery.nicescroll.js"></script>

        <!--data table-->
        <script type="text/javascript" src="/STEG-HDM/js/data-tables/jquery.dataTables.js"></script>
        <script type="text/javascript" src="/STEG-HDM/js/data-tables/DT_bootstrap.js"></script>

        <!--common scripts for all pages-->
        <script src="/STEG-HDM/js/scripts.js"></script>

        <!--script for editable table-->
        <script src="/STEG-HDM/js/editable-table-ip.js"></script>
        
        
        <script>
            jQuery(document).ready(function() {
                EditableTable.init();
            });
        </script>

    </body>
</html>
