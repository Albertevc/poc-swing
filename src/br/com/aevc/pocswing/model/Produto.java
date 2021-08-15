package br.com.aevc.pocswing.model;

public class Produto {

	private final String name;
	private final Double value;
	private final Integer amount;
	private final TypeEnum type;
	private final byte[] image;
	
	public Produto(String name, Double value, Integer amount, TypeEnum type, byte[] image) {
		super();
		this.name = name;
		this.value = value;
		this.amount = amount;
		this.type = type;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public Double getValue() {
		return value;
	}

	public Integer getAmount() {
		return amount;
	}

	public TypeEnum getType() {
		return type;
	}

	public byte[] getImage() {
		return image;
	}
	
	
	
}
