package photoapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photoapp.model.Photo;
import photoapp.service.PhotoDataAccess;

@WebServlet("/displayimage")
public class DisplayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 40001L;

	public DisplayImageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long photoId = Long.parseLong(request.getParameter("id"));
		PhotoDataAccess da = new PhotoDataAccess();
		Photo photo = da.GetPhoto(photoId);
		byte[] byteBuffer = photo.getFileData();
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		try {
			out.write(byteBuffer);
		} finally {
			out.close();
		}
	}
}
