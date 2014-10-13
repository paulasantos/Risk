<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML>
<html lang="pt_br">
    <head>	<fmt:setLocale value="pt_br" />
	<link rel="stylesheet" type="text/css" href="/risk/css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/risk/css/bootstrap/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/risk/css/bootstrap/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="/risk/css/fontAwesome/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="/risk/css/fontAwesome/font-awesome.min.css">
	
	
	<link rel="stylesheet" type="text/css" href="/risk/css/fontAwesome/font-awesome.min.css">
	
		
	<script type="text/javascript" src="/risk/jquery/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="/risk/js/bootstrap.js"></script>
	
</head>
<body>
	<c:if test="${logado == true}">
		<div id="menu-principal">
			<nav class="navbar navbar-inverse" role="navigation">
	      <div class="container-fluid">
	        <!-- Brand and toggle get grouped for better mobile display -->
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
	          </button>
	          <a class="navbar-brand" href="#">RISK</a>
	        </div>
	
	        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
	          <ul class="nav navbar-nav">
				<c:if test="${logado == true}">
		            <li class="active"><a href="#"><i class="fa fa-home fa-fw" style="padding-right: 5px;"></i>Home</a></li>
		            <li><a href="#">Sala de treinamento</a></li>
		            <li><a href="#">Ranking</a></li>
				</c:if>
				
	          </ul>
	        </div><!-- /.navbar-collapse -->
	      </div><!-- /.container-fluid -->
	    </nav>
		</div>
	</c:if>
	<div id="content" class="content">