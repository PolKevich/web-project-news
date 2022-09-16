package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class NewUserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	private String confirmPassword;

	public NewUserInfo() {
	}

	public NewUserInfo(String firstName, String lastName, String email, String login, String password,
			String confirmPassword) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUserInfo nui = (NewUserInfo) o;
        return Objects.equals(firstName, nui.firstName) && Objects.equals(lastName, nui.lastName) 
        		&& Objects.equals(email, nui.email) && Objects.equals(login, nui.login) 
   && Objects.equals(password, nui.password) && Objects.equals(confirmPassword, nui.confirmPassword);
    }

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, login, password, confirmPassword);
	}
	
    @Override
    public String toString() {
        return "NewUserInfo{" +
                "firstName ='" + firstName + '\'' + ", lastName ='" + lastName + '\'' +
                ", email ='" + email + '\'' + ", login ='" + login + '\'' +
                ", password ='" + password + '\'' + ", confirmPassword ='" + confirmPassword + '\'' + '}';
    }

}
