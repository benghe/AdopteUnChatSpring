<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout>
	<jsp:attribute name="title">
		 Modification de mes informations
	</jsp:attribute>

	<jsp:body>

    
        <div class="container">

            <form method="POST" oninput='confPassword.setCustomValidity(confPassword.value != inputPassword.value ? "Passwords do not match." : "")'>
            
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputLastname" style="width: 150px;" id="inputLastname" class="col-form-label">Nom</label>
	                </div>
	                <div class="col-auto">
	                    <input type="text" id="inputLastname" name="inputLastname" class="form-control" placeholder="${ personneAModifier.getNom() }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputFirstname" style="width: 150px;" class="col-form-label">Prénom</label>
	                </div>
	                <div class="col-auto">
	                    <input type="text" id="inputFirstname" name="inputFirstname" class="form-control" placeholder="${ personneAModifier.getPrenom() }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputEmail" style="width: 150px;" class="col-form-label">Email</label>
	                </div>
	                <div class="col-auto">
	                    <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="${ personneAModifier.getMail() }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputPhone" style="width: 150px;" class="col-form-label">Numéro de téléphone</label>
	                </div>
	                <div class="col-auto">
	                    <input type="tel" id="inputPhone" name="inputPhone" class="form-control" pattern="[0-9]{10}" placeholder="${ personneAModifier.getTelephone() }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputDateOfBirth" style="width: 150px;" class="col-form-label">Date de naissance</label>
	                </div>
	                <div class="col-auto">
	                    <input type="date" id="inputDateOfBirth" name="inputDateOfBirth" class="form-control" placeholder="${ personneAModifier.getDateNaissance() }">
	                </div>
	            </div>
	    
	            <div style="margin-top: 30px;">
	                <h5>
	                    Adresse:
	                </h5>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputAdresseNumber" style="width: 150px;" class="col-form-label">Numéro</label>
	                </div>
	                <div class="col-auto">
	                    <input type="text" id="inputAdresseNumber" name="inputAdresseNumber" class="form-control" placeholder="${ numero }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputAdresseStreet" style="width: 150px;" class="col-form-label">Voie</label>
	                </div>
	                <div class="col-auto">
	                    <input type="text" id="inputAdresseStreet" name="inputAdresseStreet" class="form-control" placeholder="${ voie }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputAdressePostalCode" style="width: 150px;" class="col-form-label">Code Postal</label>
	                </div>
	                <div class="col-auto">
	                    <input type="text" id="inputAdressePostalCode" name="inputAdressePostalCode" class="form-control" placeholder="${ codePostal }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputAdresseTown"  style="width: 150px;" class="col-form-label">Ville</label>
	                </div>
	                <div class="col-auto">
	                    <input type="text" id="inputAdresseTown" name="inputAdresseTown" class="form-control" placeholder="${ ville }">
	                </div>
	            </div>
	    
	            <div class="row" style="margin: 5px; margin-top:40px;">
	                <div class="col-auto">
	                    <label for="inputOldPassword" style="width: 150px;" class="col-form-label">Ancien mot de passe</label>
	                </div>
	                <div class="col-auto">
	                    <input type="password" id="inputOldPassword" name="inputOldPassword" class="form-control" aria-describedby="passwordHelpInline">
	                </div>
	    
	                
	            </div>
	    
	            <div class="row" style="margin: 5px;">
	                <div class="col-auto">
	                    <label for="inputPassword" style="width: 150px;" class="col-form-label"> Nouveau mot de passe</label>
	                </div>
	                <div class="col-auto">
	                    <input type="password" id="inputPassword" name="inputPassword" class="form-control" aria-describedby="passwordHelpInline">
	                </div>
	                <div class="col-auto">
	                    <span id="passwordHelpInline" class="form-text">
	                    Doit faire entre 8 et 20 caractères.
	                    </span>
	                </div>
	    
	                
	            </div>
	            
	            <div class="row" style="margin: 5px; margin-bottom: 20px;">
	                <div class="col-auto">
	                    <label for="confPassword" style="width: 150px;" class="col-form-label">Confirmer votre nouveau mot de passe</label>
	                </div>
	                <div class="col-auto">
	                    <input type="password" id="confPassword" name="confPassword" class="form-control" aria-describedby="passwordHelpInline">
	                </div>
	            </div>
	    
	            <a href="mon-espace" class="btn btn-secondary" role="button" aria-pressed="true">Annuler</a>
	            <button type="submit" class="btn btn-success">Enregistrer mes modifications</button>
	            
			</form>
    
        </div>
       
	</jsp:body>
</t:layout>


       
