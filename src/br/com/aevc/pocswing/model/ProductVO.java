package br.com.aevc.pocswing.model;

public class ProductVO {

    private final Long id;
    private final String name;
    private final String code;
    private final Double value;
    private final String type;

    public ProductVO(Long id, String name, String code, Double value, String type) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.value = value;
        this.type = type;
    }

    public Long getId() {
        return id;
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

}
