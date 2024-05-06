<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Liste des Utilisateurs</title>
    <!-- Intégration de Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="container">

        <h1 class="mt-4 mb-4">Liste des Utilisateurs</h1>

        <form action="controllor.do" method="post" class="mb-3">
            <div class="form-row">
                <div class="col-md-3">
                    <input type="hidden" name="id" placeholder="Prénom" class="form-control" value="${user.id}" required>
                    <input type="text" name="firstName" placeholder="Prénom" class="form-control" value="${user.firstName}" required>
                </div>
                <div class="col-md-3">
                    <input type="text" name="lastName" placeholder="Nom" class="form-control" value="${user.lastName}" required>
                </div>
                <div class="col-md-3">
                    <input type="text" name="email" placeholder="Email" class="form-control" value="${user.email}" required>
                </div>
                <c:if test="${user==null}">
                   <div class="col-md-3">
                     <button type="submit" name="action" value="Ajouter" class="btn btn-primary">Ajouter</button>
                   </div>
                </c:if>
                  <c:if test="${user!=null}">
                   <div class="col-md-3">
                     <button type="submit" name="action" value="Enregistrer" class="btn btn-primary">Enregistrer</button>
                   </div>
                </c:if>
                
            </div>
        </form>

        <%-- Feedback stylisé --%>
        <div class="alert alert-success" role="alert">
            <c:if test="${not empty feedback}">
                ${feedback}
            </c:if>
        </div>
       <div class="alert  truc alert-success" role="alert">
            <c:if test="${not empty fed}">
                ${fed}
            </c:if>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${modele.results}">
                    <tr>
                        <td><c:out value="${u.id}" /></td>
                        <td><c:out value="${u.firstName}" /></td>
                        <td><c:out value="${u.lastName}" /></td>
                        <td><c:out value="${u.email}" /></td>
                        <td>
                            <a href="controllor.do?action=modif&id=${u.id}" class="btn btn-secondary btn-sm"><i class="fas fa-edit"></i> Modifier</a>
                            <a href="controllor.do?action=supp&id=${u.id}" class="btn btn-danger btn-sm"><i class="fas fa-trash-alt"></i> Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </div>
    <script>
        // Appeler la fonction pour masquer le feedback
        setTimeout(function() {
            document.querySelector('.alert').style.display = 'none';
        }, 3000);
        setTimeout(function() {
            document.querySelector('.truc').style.display = 'none';
        }, 3000);
    </script>
</body>
</html>

