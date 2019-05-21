package photoapp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import photoapp.model.*;
import photoapp.service.*;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 20001L;
       
    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginViewModel vm = new UserLoginViewModel();
		vm.setUsername(request.getParameter("username"));
		vm.setPassword(request.getParameter("password"));
		if (vm.getUsername().isEmpty() || vm.getPassword().isEmpty()) {
			vm.setErrMsg("Either username or password can not be empty.");
			request.setAttribute("loginModel", vm);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/Login.jsp");
			rd.forward(request, response);
		} else {
			PhotoDataAccess da = new PhotoDataAccess();
			boolean isUserValid = da.isValidUser(vm.getUsername(), vm.getPassword());
			da.Dispose();
			if (isUserValid) {
				HttpSession session = request.getSession();
				session.setAttribute("username", vm.getUsername());
				response.sendRedirect(request.getContextPath() + "/photolist");
			} else {
				vm.setErrMsg("Username or password is not correct.");
				request.setAttribute("loginModel", vm);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/Login.jsp");
				rd.forward(request, response);
			}
		}
	}

}
