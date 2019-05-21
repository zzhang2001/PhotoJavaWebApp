package photoapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PHOTO")
public class Photo implements Serializable {
	private static final long serialVersionUID = 10001L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PHOTO_ID")
	private long photoId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="DESCRIPTION")
	private String description;

	@Lob
	@Column(name="FILE_DATA")
	private byte[] fileData;

	@Column(name="FILE_NAME")
	private String fileName;

	@Column(name="IMAGE_MIME_TYPE")
	private String imageMimeType;

	@Temporal(TemporalType.DATE)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name="TITLE")
	private String title;

	@Column(name="USER_NAME")
	private String userName;

	// One to many association to Comment
	@OneToMany(mappedBy="photo", cascade={CascadeType.ALL}, orphanRemoval=true)
	private List<Comment> comments;

	public Photo() {
	}

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getImageMimeType() {
		return imageMimeType;
	}

	public void setImageMimeType(String imageMimeType) {
		this.imageMimeType = imageMimeType;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}

