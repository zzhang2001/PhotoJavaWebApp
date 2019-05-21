package photoapp.service;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import photoapp.model.*;

public class PhotoDataAccess {
	EntityManagerFactory emf;
	EntityManager em;

	public PhotoDataAccess() {
		emf = Persistence.createEntityManagerFactory("PhotoContext");
		em = emf.createEntityManager();
	}

	public List<Photo> GetAllPhotos() {
		TypedQuery<Photo> tq = em.createQuery("select a from Photo a", Photo.class);
		List<Photo> photos = tq.getResultList();
		return photos;
	}

	public Photo GetPhoto(long id) {
		return em.find(Photo.class, id);
	}

	public Photo GetPhotoAndComments(long photoId) {
		TypedQuery<Photo> tq = em.createQuery("select o from Photo o left join fetch o.comments where o.photoId = :photoId", Photo.class);
		Photo photo = tq.setParameter("photoId", photoId).getSingleResult();
		return photo;
	}
	
	public void AddPhoto(String title, String description, String fileName, String imageMimeType, byte[] fileData,
			String userName) {
		em.getTransaction().begin();

		Photo p = new Photo();
		p.setCreateDate(new Date());
		p.setDescription(description);
		p.setFileData(fileData);
		p.setFileName(fileName);
		p.setImageMimeType(imageMimeType);
		p.setModifiedDate(new Date());
		p.setTitle(title);
		p.setUserName(userName);

		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void deletePhoto(long photoId) {
		em.getTransaction().begin();
		Photo photo = em.find(Photo.class, photoId);
		em.remove(photo);
		em.getTransaction().commit();
	}

	public void deleteComment(long commentId) {
		em.getTransaction().begin();
		Comment comment = em.find(Comment.class, commentId);
		em.remove(comment);
		em.getTransaction().commit();
	}

	public void addComment(long photoId, String commentBody, String userName) {
		em.getTransaction().begin();
		Comment comment = new Comment();
		comment.setCommentBody(commentBody);
		comment.setCreateDate(new Date());
		comment.setUserName(userName);
		Photo photo = em.find(Photo.class, photoId);
		comment.setPhoto(photo);
		em.persist(comment);
		em.getTransaction().commit();
	}
	
	public void addUser(String username, String password) {
		em.getTransaction().begin();
		User user = new User();
		user.setUsername(username);
		user.setPassword(PhotoUtil.genSha256Code(password));
		em.persist(user);
		em.getTransaction().commit();
	}

	public boolean isValidUser(String username, String password) {
		String hashedPassword = PhotoUtil.genSha256Code(password);
		TypedQuery<User> tq = em.createQuery(
				"select u from User u where u.username = :username and u.password = :password", User.class);
		List<User> userList = tq.setParameter("username", username).setParameter("password", hashedPassword)
				.getResultList();
		if (userList.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void Dispose() {
		em.close();
		emf.close();
	}
}

