package by.htp.ex.bean;

import java.io.Serializable;

public class NewUserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String login;
	private String password;
	private String confirmPassword;

	public NewUserInfo() {
	}

	public NewUserInfo(String firstName, String lastName, String gender, String email, String login, String password,
			String confirmPassword) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGender(gender);
		this.setEmail(email);
		this.setLogin(login);
		this.setPassword(password);
		this.setConfirmPassword(confirmPassword);

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
