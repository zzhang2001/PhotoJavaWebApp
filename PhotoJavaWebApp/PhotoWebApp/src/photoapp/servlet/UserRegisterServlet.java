package photoapp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import photoapp.model.UserRegisterViewModel;
import photoapp.service.PhotoDataAccess;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 20003L;

	public UserRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/Register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserRegisterViewModel vm = new UserRegisterViewModel();
		vm.setUsername(request.getParameter("username"));
		vm.setPassword(request.getParameter("password"));
		vm.setConfirmPassword(request.getParameter("confirmPassword"));
		boolean modelValid = true;
		if (vm.getUsername().isEmpty()) {
			vm.setUsernameErrMsg("User name can not be empty.");
			modelValid = false;
		}
		if (vm.getPassword().isEmpty()) {
			vm.setPasswordErrMsg("Password can not be empty.");
			modelValid = false;
		}
		if (vm.getConfirmPassword().isEmpty()) {
			vm.setConfirmPasswordErrMsg("Confirm password can not be empty.");
			modelValid = false;
		}
		if (!vm.getPassword().equals(vm.getConfirmPassword())) {
			vm.setConfirmPasswordErrMsg("Passwords do not match!");
			modelValid = false;
		}
		if (modelValid) {
			PhotoDataAccess da = new PhotoDataAccess();
			da.addUser(vm.getUsername(), vm.getPassword());
			da.Dispose();
			HttpSession session = request.getSession();
			session.setAttribute("username", vm.getUsername());
			response.sendRedirect(request.getContextPath() + "/photolist");
		} else {
			request.setAttribute("registerModel", vm);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/Register.jsp");
			rd.forward(request, response);
		}
	}
}
