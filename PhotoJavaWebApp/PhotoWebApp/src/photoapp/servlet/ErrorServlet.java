package photoapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photoapp.model.ErrorViewModel;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 50001L;
       
    public ErrorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ErrorViewModel vm = new ErrorViewModel();
		vm.setRequestUri((String)request.getAttribute("javax.servlet.error.request_uri"));
		vm.setStatusCode((Integer)request.getAttribute("javax.servlet.error.status_code"));
		vm.setServletName((String)request.getAttribute("javax.servlet.error.servlet_name"));
		Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
		if (throwable != null) {
			vm.setExceptionName(throwable.getClass().getName());
			vm.setExceptionMessage(throwable.getMessage());
		}
		request.setAttribute("errorViewModel", vm);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/ErrorInfo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
