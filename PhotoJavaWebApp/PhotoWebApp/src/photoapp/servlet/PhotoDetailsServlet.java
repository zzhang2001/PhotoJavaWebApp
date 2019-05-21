package photoapp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photoapp.model.Photo;
import photoapp.service.PhotoDataAccess;

@WebServlet("/photodetails")
public class PhotoDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 10003L;
       
    public PhotoDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long photoId = Long.parseLong(request.getParameter("photoid"));
		PhotoDataAccess da = new PhotoDataAccess();
		Photo photo = da.GetPhotoAndComments(photoId);
		da.Dispose();
		request.setAttribute("photo", photo);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/PhotoDetails.jsp");
		rd.forward(request, response);
	}
}
