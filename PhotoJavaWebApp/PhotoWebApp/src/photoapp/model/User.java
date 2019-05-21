package photoapp.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="USER")
public class User implements Serializable {
	private static final long serialVersionUID = 10003L;

	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
