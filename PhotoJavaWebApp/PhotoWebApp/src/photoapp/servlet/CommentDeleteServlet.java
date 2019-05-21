package photoapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photoapp.service.PhotoDataAccess;

@WebServlet("/commentdelete")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 30002L;
       
    public CommentDeleteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long photoId = Long.parseLong(request.getParameter("photoId"));
		long commentId = Long.parseLong(request.getParameter("commentId"));
		PhotoDataAccess da = new PhotoDataAccess();
		da.deleteComment(commentId);
		da.Dispose();
		response.sendRedirect(request.getContextPath() + "/photodetails?photoid=" + photoId);
	}
}
