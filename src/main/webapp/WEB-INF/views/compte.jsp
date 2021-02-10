<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout>
	<jsp:attribute name="title">
		Mon compte
	</jsp:attribute>

	<jsp:body>
		
      <div class="container">

        <div class="row">
        </div>

        

        <div class="row">
            <div class="col-2">
                
            </div>

            <div class="col-4">
              <div class="compte">
                <div>
                  <h5>Connectez-vous!</h5>
                </div>
                
                <div>
                  <h6>Vous êtes déjà inscrit</h6>
                </div>

                <div style="margin-bottom: 5px;">
                  Entrez votre adresse email et votre mot de passe pour 
                  modifier vos préférences et gérer vos abonnements :
                </div>
                
                <form method="POST">
                    <div class="mb-3">
                      <label for="email" class="form-label">Adresse mail</label>
                      <input type="email" class="form-control"
									id="email" name="email" aria-describedby="emailHelp">
                      <div id="emailHelp" class="form-text"></div>
                    </div>
                    <div class="mb-3">
                      <label for="password" class="form-label">Mot de passe</label>
                      <input type="password" class="form-control"
									id="password" name="password">
                    </div>
                    <div class="mb-3 form-check">
                      <input type="checkbox" class="form-check-input"
									id="Check">
                      <label class="form-check-label" for="Check">Rester connecté</label>
                    </div>
                    <button type="submit" class="btn btn-secondary">Connexion</button>
                </form>
              </div>
            </div>
            
            <div class="col-4">

                <div class="compte">
                    <div>
                      <h5>Inscription des particuliers</h5>
                    </div>
                    
                    <div>
                      <h6>Vous n'êtes pas encore inscrit</h6>
                    </div>

                    <div style="margin-bottom: 5px;">
                        Créez votre compte, il vous permettra de recevoir automatiquement 
                        par e-mail les nouvelles annonces qui correspondent à 
                        vos critères de recherche. 
                    </div>

                    <div>

                        <a href="inscription-adoptant"
								class="btn btn-secondary" role="button" aria-pressed="true">Créer mon compte</a>
                    </div>

                </div>

                <div class="compte">
                  <div>
                    <h5>Inscription des refuges et associations</h5>
                  </div>
                    <h6>Vous n'êtes pas encore inscrit</h6>
                  <div>

                  <div style="margin-bottom: 5px;">
                      En adhérant à Adopte un chat vous aurez la possibilité de vous faire connaitre 
                      et d’annoncer les animaux que vous offrez à l’adoption pour leur assurer une large 
                      diffusion sur Internet. 
                  </div>

                  <div>
                      <a href="inscription-refuge"
									class="btn btn-secondary" role="button" aria-pressed="true">Adhérer à Adopte un chat</a>
                  </div>
                </div>
                
            </div>

              <div class="col-2">
                
              </div>
          
          
        </div>

      </div>
     </div>
	
	</jsp:body>
</t:layout>