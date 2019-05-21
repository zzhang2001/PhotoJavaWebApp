package photoapp.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import photoapp.model.PhotoAddViewModel;
import photoapp.service.PhotoDataAccess;

@WebServlet("/photoadd")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 20, maxRequestSize = 1024 * 1024
		* 50)
public class PhotoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 10001L;

	public PhotoAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			response.sendRedirect(request.getContextPath() + "/photolist");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/PhotoAdd.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PhotoAddViewModel vm = new PhotoAddViewModel();
		vm.setErrMsg("");
		vm.setTitle(request.getParameter("title"));
		vm.setDescription(request.getParameter("description"));
		Part filePart = request.getPart("fileData");

		if (vm.getTitle().isEmpty()) {
			vm.setErrMsg(vm.getErrMsg() + "Title can not be empty.");
		}
		if (vm.getDescription().isEmpty()) {
			vm.setErrMsg(vm.getErrMsg() + "Description can not be empty.");
		}
		if (filePart.getSize() == 0) {
			vm.setErrMsg(vm.getErrMsg() + "Please select an image file");
		}
		if (!vm.getErrMsg().isEmpty()) {
			request.setAttribute("addModel", vm);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/PhotoAdd.jsp");
			rd.forward(request, response);
		} else {
			String fileName = "";
			for (String s : filePart.getHeader("Content-Disposition").split(";")) {
				if (s.trim().startsWith("filename")) {
					fileName = s.substring(s.indexOf("=") + 1).trim().replace("\"", "");
					fileName = fileName.substring(fileName.lastIndexOf("/") + 1)
							.substring(fileName.lastIndexOf("\\") + 1);
				}
			}
			String imageMimeType = filePart.getContentType();
			InputStream inputStream = filePart.getInputStream();
			byte[] byteArray = new byte[(int) filePart.getSize()];
			inputStream.read(byteArray, 0, (int) filePart.getSize());
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			PhotoDataAccess da = new PhotoDataAccess();
			da.AddPhoto(vm.getTitle(), vm.getDescription(), fileName, imageMimeType, byteArray, username);
			da.Dispose();
			response.sendRedirect(request.getContextPath() + "/photolist");
		}
	}
}
