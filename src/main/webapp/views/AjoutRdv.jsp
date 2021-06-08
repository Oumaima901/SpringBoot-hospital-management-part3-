<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/css/form.css"/>">
<link rel="stylesheet" href="<c:url value="/css/sidebar.css"/>">
 <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
<ul class="sidebar">
  <li class="sidebar-brand"><a href="welcome">Gestion Hospitaliere</a></li>
      
     <li><a href="AffichageListeRDV"> <i class="fa fa-hand-o-left" aria-hidden="true"></i><span class="ml-1">retourne </span></a></li>
      </ul>
 <center>
    <div class="main">

        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Ajouter un RendezVous</h4>
                  <p class="card-category">Les informations du RendezVous</p>
                </div>
                <div class="card-body">
                <!-- modelAttribute formulaire a besion d'un model le controller va creer se model action c'est notre route ajouterDoc -->
                  <form:form modelAttribute="RendezVous" method="POST" action="AjouterRDV">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                         <form:label path="date" class="bmd-label-floating">Date</form:label>
                           <form:input path="date" type ="date"   class="form-control" />
                            <form:errors path="date"/>
                        </div>
                      </div>
 
                      <div class="col-md-6">
                         <div class="form-group">
                         <form:label path="heure" class="bmd-label-floating">Heure</form:label>
                           <form:input path="heure" type ="time"   class="form-control" />
                            <form:errors path="heure"/>
                        </div>
                      </div>
                       </div>	
                    <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                     <form:label path="patient">Nom du Patient</form:label>
	                        <form:select path="patient" class="custom-select" style="width:200px;" >
	                   <c:forEach items="${ListPatient}" var = "pat">
	 			 <form:option value="${pat.id}"> ${pat.nom}  </form:option>
				  </c:forEach>
					</form:select>
					 </div>
                    </div>
                     </div>
                   
                        <button type="submit" value="submit" class="btn btn-primary pull-right" >Ajouter Rendez-vous</button>
                    <div class="clearfix"></div>
                  </form:form>
                </div>
              </div>
            </div>
              </div>
        </div>
   </div>
      
  </center>    





</body>
</html>