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
  <li class="sidebar-brand"><a href="Accueil">Gestion Hospitaliere</a></li>
      <li><a href="ajouterPatient"><i class="fa fa-plus-square" aria-hidden="true"></i><span class="ml-1">Ajouter un patient</span></a></li>
 
       <li><a href="AffichageListePatient"> <i class="fa fa-hand-o-left" aria-hidden="true"></i><span class="ml-1">retourne </span></a></li>
      </ul>
       <center>
 <div class="main">

        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Modifier un patient</h4>
                  <p class="card-category">Les informations du patient</p>
                </div>
                <div class="card-body">
                <!-- modelAttribute formulaire a besion d'un model le controller va creer se model action c'est notre route ajouterDoc -->
                  <form:form modelAttribute="patient" method="POST" action="editsavepat">
                  
                    <div class="row">
                      <div class="col-md-5">
                        <div class="form-group">
                         <form:label path="id" class="bmd-label-floating">ID</form:label>
                         <form:input path="id"  type='text'   class="form-control" />
                          <form:errors path="id"/>
                        </div>
                      </div>
                      <div class="col-md-3">
                        <div class="form-group">
                         <form:label path="nom" class="bmd-label-floating">Nom</form:label>
                         <form:input path="nom"  type='text'    class="form-control" />
                          <form:errors path="nom"/>
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                           <form:label path="prenom" class="bmd-label-floating">Prenom</form:label>
                           <form:input path="prenom"   type='text'    class="form-control"/>
                          <form:errors path="prenom"/>
                        </div>
                      </div>
                     
                    </div>
                    <div class="row">
                       <div class="col-md-6">
                        <div class="form-group">
                     <form:label path="docteur" class="bmd-label-floating">Nom du Docteur</form:label>
	                        <form:select path="docteur"  class="custom-select" style="width:200px;" >
	                   <c:forEach items="${ListDoc}" var = "doc">
	 			 <form:option value="${doc.id}"> ${doc.nom}  </form:option>
				  </c:forEach>
					</form:select>
					 </div>
                    </div>
                     
                      <div class="col-md-6">
                        <div class="form-group">
                          <form:label path="numero" class="bmd-label-floating">Numero de t?l?phone</form:label>
                          <form:input path="numero"  type='text'   class="form-control"/>
                          <form:errors path="numero"/>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <form:label path="Adresse" class="bmd-label-floating">Adresse</form:label>
                          <form:input path="Adresse" type='text'  class="form-control"/>
                         <form:errors path="Adresse"/>
                        </div>
                      </div>
                       <div class="col-md-6">
                        <div class="form-group">
                           <form:label  path="email" class="bmd-label-floating">Email address</form:label>
                          <form:input path="email"   type='text'  class="form-control"/>
                           <form:errors path="email"/>
                        </div>
                      </div>
                    </div>
                   
                        <button type="submit" value="submit" class="btn btn-primary pull-right" >Modifier </button>
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