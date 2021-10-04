package br.com.aevc.pocswing.model;

public class Product {

	private final String name;
	private final String code;
	private final Double value;
	private final String type;
	private final byte[] image;

	public Product(String name, String code, Double value, String type, byte[] image) {
		this.name = name;
		this.code = code;
		this.value = value;
		this.type = type;
		this.image = image;
	}

	public String getName() {
		return name;
	}


	public String getCode() {
		return code;
	}

	public Double getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public byte[] getImage() {
		return image;
	}

}
