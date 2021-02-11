<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout>
	<jsp:attribute name="title">
		Réglages
	</jsp:attribute>

	<jsp:body>
	
	<div>
		<a class="btn btn-primary" href="reglages?r=comptes" role="button">Comptes</a>
		<a class="btn btn-primary" href="reglages?r=races" role="button">Races</a>
		<a class="btn btn-primary" href="reglages?r=couleurs" role="button">Couleurs</a>
		<a class="btn btn-primary" href="reglages?r=regions" role="button">Régions</a>
		<a class="btn btn-primary" href="reglages?r=departements" role="button">Départements</a>
	
	</div>
	
	<c:if test="${ reglagesSection==null || reglagesSection.equals('comptes') }">
	
	
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Email</th>
			      <th scope="col">Type</th>
			      <th scope="col">Actions</th>
			     
			    </tr>
			  </thead>
			  <tbody>
			  
			  	<c:forEach var="personne" items="${ personnes }">
			  		
			  		<tr>
				      <th scope="row">${ personne.id }</th>
				      <td>${ personne.mail }</td>
				      <td>${ personne.type }</td>
				      <td>
				      	<c:if test="${ connexionId!= personne.id }">
				      	
				        	<a href="reglages/supprimer?r=comptes&id=${ personne.id }"> <i style="color:red;" class="far fa-trash-alt"></i> </a>
				      	
				      	</c:if>
				      </td>
				      
				     
			    	</tr>
			  		
			  		
			  	</c:forEach>
			  	
			  </tbody>
			</table>
			
			
	
	</c:if>
	
	
	<c:if test="${ reglagesSection.equals('races') }">
	
		<form method="POST">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Libellé</th>
			      <th scope="col">Actions</th>
			     
			    </tr>
			  </thead>
			  <tbody>
			  
			  	<c:forEach var="race" items="${ races }">
			  		
			  		<tr>
				      <th scope="row">${ race.id }</th>
				      <td>${ race.libelle }</td>
				      <td>
				      	
				        <a href="reglages/supprimer?r=races&id=${ race.id }"> <i style="color:red;" class="far fa-trash-alt"></i> </a>
				        <a href="reglages/modifier?r=races&id=${ race.id }"> <i style="color:grey;" class="fas fa-edit"></i> </a>
				      	
				      </td>
				      
				     
			    	</tr>
			  		
			  		
			  	</c:forEach>
			  	
			  	<c:if test="${ addRace }">
				     	<tr>
						     	<td> 
						     	</td>
						     	<td> 
						     		<input type="text" name="addLibelle" class="form-control" placeholder="Libellé" required>
						     	</td>
						     	
						     	<td> 
						     		<button type="submit" class="btn btn-success">Valider</button>
						     	</td>
				     	</tr>
				     	
				</c:if> 
			  	
			  </tbody>
			</table>
		</form>
			<a class="btn btn-success" href="reglages/add?r=races" role="button">Ajouter</a>
	
	</c:if>
	
	<c:if test="${ reglagesSection.equals('couleurs') }">
	
		<form method="POST">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Libellé</th>
			      <th scope="col">Actions</th>
			     
			    </tr>
			  </thead>
			  <tbody>
			  
			  	<c:forEach var="couleur" items="${ couleurs }">
			  		
			  		<tr>
				      <th scope="row">${ couleur.id }</th>
				      <td>${ couleur.libelle }</td>
				      <td>
				      	
				        <a href="reglages/supprimer?r=couleurs&id=${ couleur.id }"> <i style="color:red;" class="far fa-trash-alt"></i> </a>
				      	
				      </td>
				      
				     
			    	</tr>
			  		
			  		
			  	</c:forEach>
			  	
			  	<c:if test="${ addCouleur }">
				     	<tr>
						     	<td> 
						     	</td>
						     	<td> 
						     		<input type="text" name="addLibelle" class="form-control" placeholder="Libellé" required>
						     	</td>
						     	
						     	<td> 
						     		<button type="submit" class="btn btn-success">Valider</button>
						     	</td>
				     	</tr>
				     	
				</c:if> 
			  	
			  </tbody>
			</table>
		</form>
			<a class="btn btn-success" href="reglages/add?r=couleurs" role="button">Ajouter</a>
	
	</c:if>
	
	<c:if test="${ reglagesSection.equals('regions') }">
	
		<form method="POST">
	
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Libellé</th>
			      <th scope="col">Actions</th>
			     
			    </tr>
			  </thead>
			  <tbody>
			  
			  	<c:forEach var="region" items="${ regions }">
			  		
			  		<tr>
				      <th scope="row">${ region.id }</th>
				      <td>${ region.libelle }</td>
				      <td>
				      	
				        <a href="reglages/supprimer?r=regions&id=${ region.id }"> <i style="color:red;" class="far fa-trash-alt"></i> </a>
				      	
				      </td>
				     
				     
			    	</tr>
			  		
			  		
			  	</c:forEach>
				     <c:if test="${ addRegion }">
				     	<tr>
						     	<td> 
						     	</td>
						     	<td> 
						     		<input type="text" name="addLibelle" class="form-control" placeholder="Libellé" required>
						     	</td>
						     	
						     	<td> 
						     		<button type="submit" class="btn btn-success">Valider</button>
						     	</td>
				     	</tr>
				     	
				     </c:if> 

			  </tbody>
			</table>
		</form>
			<a class="btn btn-success" href="reglages/add?r=regions" role="button">Ajouter</a>
	
	</c:if>
	
	<c:if test="${ reglagesSection.equals('departements') }">
	
		<form method="POST">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Libellé</th>
			      <th scope="col">Région</th>
			      <th scope="col">Actions</th>
			     
			    </tr>
			  </thead>
			  <tbody>
			  
			  	<c:forEach var="departement" items="${ departements }">
			  		
			  		<tr>
				      <th scope="row">${ departement.id }</th>
				      <td>${ departement.libelle }</td>
				      <td>${ departement.region.libelle }</td>
				      <td>
				      	
				        <a href="reglages/supprimer?r=departements&id=${ departement.id }"> <i style="color:red;" class="far fa-trash-alt"></i> </a>
				      	
				      </td>
				      
				     
			    	</tr>
			  		
			  		
			  	</c:forEach>
			  	
			  	 <c:if test="${ addDepartement }">
				     	<tr>
						     	<td> 
						     	</td>
						     	
						     	<td> 
						     		<input type="text" name="addLibelle" class="form-control" placeholder="Libellé" required>
						     	</td>
						     	
						     	<td> 
						     		<select name="regionName" class="form-control">
						     			<c:forEach var="region" items="${ regions }">
										  <option value="${ region.libelle }">${ region.libelle }</option>
										 </c:forEach>
									</select>
						     	</td>
						     	
						     	<td> 
						     		<button type="submit" class="btn btn-success">Valider</button>
						     	</td>
				     	</tr>
				     	
				 </c:if> 
			  	
			  </tbody>
			</table>
		</form>	
			<a class="btn btn-success" href="reglages/add?r=departements" role="button">Ajouter</a>
	
	</c:if>
				
			

	</jsp:body>
</t:layout>