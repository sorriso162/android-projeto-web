<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp" />

<div class="wrapper">
    <header class="header">
        <div class="container">
          <div class="row">
            <div class="col-md-5 col-md-offset-1">
                <div class="content">
                  <div class="pull-middle">
                    <h1 class="page-header">Olá, <p class="capitalize" style="color: #5cb85c;">${usuario.nome}.</p></h1>
                    <p class="lead">Baixe logo o nosso Aplicativo e agilize seus chamados!</p>
                    <div class="panel panel-default">
                        <div class="panel-body">
                <center>
                <a href="https://play.google.com/store">
           	    <img class="img-responsive img-rounded" src="https://play.google.com/intl/en_us/badges/images/badge_new.png">
           	    </a>
           	    </center>
                        </div>
                    </div>
                  </div>              
                </div>
            </div>
            <div class="col-md-4 col-md-offset-1 text-center mt-100 mb-100">
           	    <img class="img-responsive img-rounded" src="http://www.suportegratuito.com.br/wp-content/uploads/2016/08/google-play.png">
            </div>
          </div>
        </div>
    </header>
    <section class="section">
        <div class="container">
            <div class="row">
               <div class="col-md-4 col-md-offset-1 text-center mt-100 mb-100">
                    <div class="phone">
                        <img class="img-responsive img-rounded" src="http://placemi.com/djlnr/263x480">
                    </div>
                </div>
                <div class="col-md-5 col-md-offset-1">
                    <div class="content">
                        <div class="pull-middle">
                            <h2 class="h1 page-header">Discover more about features.</h2>
                            <ul class="media-list">
                              <li class="media">
                                <a class="media-left" href="#">
                                  <span class="glyphicon glyphicon-cloud icon text-success"></span>
                                </a>
                                <div class="media-body">
                                  <h3 class="media-heading">Praesent porttitor urna ut enim.</h3>
                                  <p>Maecenas vitae ex iaculis, efficitur est eu, fermentum quam.</p>
                                </div>
                              </li>
                              <li class="media">
                                <a class="media-left" href="#">
                                  <span class="glyphicon glyphicon-lock icon text-success"></span>
                                </a>
                                <div class="media-body">
                                  <h3 class="media-heading">Cras consequat est et elit.</h3>
                                  <p>Integer suscipit massa at tellus semper, at aliquam ante bibendum.</p>
                                </div>
                              </li>
                              <li class="media">
                                <a class="media-left" href="#">
                                  <span class="glyphicon glyphicon-user icon text-success"></span>
                                </a>
                                <div class="media-body">
                                  <h3 class="media-heading">Aenean vel enim quis dui blandit.</h3>
                                  <p>Maecenas vitae ex iaculis, efficitur est eu, fermentum quam.</p>
                                </div>
                              </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-3 text-right">
                    <div class="content">
                        <div class="pull-middle">
                            <h4><strong>Describe your product.</strong></h4>
                            <p>Proin sapien neque, consequat ac tempus aliquam, gravida in urna. Phasellus et lectus in odio imperdiet tempus. Aenean posuere, nunc a tristique imperdiet, massa dolor dictum eros, sit amet tempor turpis turpis vel tortor.</p>
                            <small>Phasellus feugiat at lorem a tincidunt. Nam hendrerit leo vitae orci pellentesque, nec euismod dolor condimentum.</small>
                        </div>
                    </div>
                </div>
               <div class="col-md-4 col-md-offset-1 mt-100 mb-100">
                    <div class="phone">
                        <img class="img-responsive img-rounded" src="http://placemi.com/djlnr/263x480">
                    </div>
                </div>
                <div class="col-md-3 col-md-offset-1">
                    <div class="content">
                        <div class="pull-middle">
                            <h4><strong>Even more stuff.</strong></h4>
                            <p>Proin sapien neque, consequat ac tempus aliquam, gravida in urna. Phasellus et lectus in odio imperdiet tempus. Aenean posuere, nunc a tristique imperdiet, massa dolor dictum eros, sit amet tempor turpis turpis vel tortor.</p>
                            <a class="btn btn-success btn-circle" href="#">Sign up for free</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<c:import url="footer.jsp" />