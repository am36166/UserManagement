package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Impuser;
import dao.User;
import Model.ModelDao;

public class servlet extends HttpServlet{
	Impuser imp ;
	ModelDao model ;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		imp = new Impuser() ;
	}
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action != null) {
			if(action.equals("supp")) {
				Long id = Long.parseLong(request.getParameter("id"));
				imp.Delete(id);
				String feedback = new String("l'utilisateur a ete Bien Supprime");
				request.setAttribute("feedback", feedback);
			}
		}
		if(action != null) {
			if(action.equals("Ajouter")) {
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName") ;
				String email = request.getParameter("email");
				imp.addUser(new User(firstName,lastName,email));
			}
		}
		if(action != null) {
			if(action.equals("modif")) {
				Long id = Long.parseLong(request.getParameter("id"));
				User u = imp.getUser(id);
				request.setAttribute("user", u);
			}
		}
		if(action != null) {
			if(action.equals("Enregistrer")) {
				Long id = Long.parseLong(request.getParameter("id"));
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName") ;
				String email = request.getParameter("email");	
				User updated = new User();
			    updated.setId(id);
			    updated.setFirstName(firstName);
			    updated.setLastName(lastName);
			    updated.setEmail(email);
				imp.updateUser(updated);
				String feddback2 = "l'utilisateur a ete Bien modifiee" ;
				request.setAttribute("fed", feddback2);
			}
		}
		
		model = new ModelDao() ;
		List<User> users = imp.getUsers() ;
		model.setResults(users);
		request.setAttribute("modele", model);
		request.getRequestDispatcher("User.jsp").forward(request, response);

		
	}

}