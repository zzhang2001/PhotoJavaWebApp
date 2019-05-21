package photoapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import photoapp.service.PhotoDataAccess;

@WebServlet("/commentadd")
public class CommentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 30001L;
       
    public CommentAddServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long photoId = Long.parseLong(request.getParameter("photoId"));
		String commentBody = request.getParameter("commentBody");
		PhotoDataAccess da = new PhotoDataAccess();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		da.addComment(photoId, commentBody, username);
		da.Dispose();
		response.sendRedirect(request.getContextPath() + "/photodetails?photoid=" + photoId);
	}
}
