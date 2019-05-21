package photoapp.model;

public class UserRegisterViewModel {
	private String username;
	private String usernameErrMsg;
	private String password;
	private String passwordErrMsg;
	private String confirmPassword;
	private String confirmPasswordErrMsg;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsernameErrMsg() {
		return usernameErrMsg;
	}
	public void setUsernameErrMsg(String usernameErrMsg) {
		this.usernameErrMsg = usernameErrMsg;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordErrMsg() {
		return passwordErrMsg;
	}
	public void setPasswordErrMsg(String passwordErrMsg) {
		this.passwordErrMsg = passwordErrMsg;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getConfirmPasswordErrMsg() {
		return confirmPasswordErrMsg;
	}
	public void setConfirmPasswordErrMsg(String confirmPasswordErrMsg) {
		this.confirmPasswordErrMsg = confirmPasswordErrMsg;
	}
}
