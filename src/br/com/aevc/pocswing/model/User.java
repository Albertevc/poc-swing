package br.com.aevc.pocswing.model;

public class User {
	
	private String name;
	private Integer age;
	private String registration;
	private String password;

	public User(String name, Integer age, String registration, String password) {
		this.name = name;
		this.age = age;
		this.registration = registration;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
