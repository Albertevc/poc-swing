package br.com.aevc.pocswing.model;

public class LoginDTO {

	private String registration;
	private char[] password;

	public LoginDTO(String registration, char[] password) {
		super();
		this.registration = registration;
		this.password = password;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
}
