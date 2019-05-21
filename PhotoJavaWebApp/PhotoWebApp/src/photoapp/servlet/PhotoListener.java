package photoapp.servlet;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import photoapp.model.Comment;
import photoapp.model.Photo;
import photoapp.model.User;
import photoapp.service.PhotoUtil;

@WebListener
public class PhotoListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		String strRefreshData = servletContextEvent.getServletContext().getInitParameter("refreshData");
		boolean booRefreshData = Boolean.parseBoolean(strRefreshData);
		if (booRefreshData) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("PhotoContext");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.createNativeQuery("DROP TABLE IF EXISTS COMMENT;").executeUpdate();
			em.createNativeQuery("DROP TABLE IF EXISTS PHOTO;").executeUpdate();
			em.createNativeQuery("DROP TABLE IF EXISTS USER;").executeUpdate();
			String sql = PhotoUtil.getStringFromFile(servletContextEvent.getServletContext(), "/WEB-INF/sql/photo.sql");
			em.createNativeQuery(sql).executeUpdate();
			sql = PhotoUtil.getStringFromFile(servletContextEvent.getServletContext(), "/WEB-INF/sql/comment.sql");
			em.createNativeQuery(sql).executeUpdate();
			sql = PhotoUtil.getStringFromFile(servletContextEvent.getServletContext(), "/WEB-INF/sql/user.sql");
			em.createNativeQuery(sql).executeUpdate();

			ArrayList<Photo> lstPhotos = new ArrayList<Photo>();
			Photo p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of blackberries.");
			p.setFileData(PhotoUtil.loadImageFile(servletContextEvent.getServletContext(),
					"/WEB-INF/images/blackberries.JPG"));
			p.setFileName("blackberries.JPG");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Blackberries");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of coastalview.");
			p.setFileData(PhotoUtil.loadImageFile(servletContextEvent.getServletContext(),
					"/WEB-INF/images/coastalview.jpg"));
			p.setFileName("coastalview.jpg");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Coastalview");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of flower.");
			p.setFileData(
					PhotoUtil.loadImageFile(servletContextEvent.getServletContext(), "/WEB-INF/images/flower.JPG"));
			p.setFileName("flower.JPG");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Flower");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of fungi.");
			p.setFileData(
					PhotoUtil.loadImageFile(servletContextEvent.getServletContext(), "/WEB-INF/images/fungi.JPG"));
			p.setFileName("fungi.JPG");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Fungi");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of headland.");
			p.setFileData(
					PhotoUtil.loadImageFile(servletContextEvent.getServletContext(), "/WEB-INF/images/headland.jpg"));
			p.setFileName("headland.jpg");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Headland");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of orchard.");
			p.setFileData(
					PhotoUtil.loadImageFile(servletContextEvent.getServletContext(), "/WEB-INF/images/orchard.JPG"));
			p.setFileName("orchard.JPG");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Orchard");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of path.");
			p.setFileData(PhotoUtil.loadImageFile(servletContextEvent.getServletContext(), "/WEB-INF/images/path.JPG"));
			p.setFileName("path.JPG");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Path");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			p = new Photo();
			p.setCreateDate(new Date());
			p.setDescription("This is a phot of ripples.");
			p.setFileData(
					PhotoUtil.loadImageFile(servletContextEvent.getServletContext(), "/WEB-INF/images/ripples.jpg"));
			p.setFileName("ripples.jpg");
			p.setImageMimeType("image/jpeg");
			p.setModifiedDate(new Date());
			p.setTitle("Ripples");
			p.setUserName("testuser1");
			lstPhotos.add(p);
			for (Photo photo : lstPhotos) {
				em.persist(photo);
			}
			ArrayList<Comment> lstComments = new ArrayList<Comment>();
			Comment c = new Comment();
			c.setCommentBody("The blackberries show up very clearly.");
			c.setCreateDate(new Date());
			c.setUserName("testuser2");
			c.setPhoto(em.find(Photo.class, 0L));
			lstComments.add(c);
			c = new Comment();
			c.setCommentBody("It would be nice to have more colorful background..");
			c.setCreateDate(new Date());
			c.setUserName("testuser2");
			c.setPhoto(em.find(Photo.class, 0L));
			lstComments.add(c);
			for (Comment comment : lstComments) {
				em.persist(comment);
			}
			User u = new User();
			u.setUsername("testuser1");
			u.setPassword(PhotoUtil.genSha256Code("testuser1"));
			em.persist(u);
			u = new User();
			u.setUsername("testuser2");
			u.setPassword(PhotoUtil.genSha256Code("testuser2"));
			em.persist(u);
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
