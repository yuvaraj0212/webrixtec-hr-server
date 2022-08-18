package webrix.hr.pojo;

import javax.validation.constraints.NotNull;

public class signinRequest {
	@NotNull(message = "email is empty")
	private String email;
	@NotNull(message = "password is empty")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public signinRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public signinRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
