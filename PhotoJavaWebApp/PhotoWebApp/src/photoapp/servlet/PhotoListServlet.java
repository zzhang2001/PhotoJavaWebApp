package photoapp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photoapp.model.Photo;
import photoapp.service.PhotoDataAccess;

@WebServlet("/photolist")
public class PhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 10004L;
       
    public PhotoListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhotoDataAccess da = new PhotoDataAccess();
		List<Photo> photos = da.GetAllPhotos();
		da.Dispose();
		request.setAttribute("photoList", photos);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/PhotoList.jsp");
		rd.forward(request, response);
	}

}
