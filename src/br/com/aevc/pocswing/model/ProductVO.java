package br.com.aevc.pocswing.model;

public class ProductVO {

    private final String name;
    private final String code;
    private final Double value;
    private final String type;

    public ProductVO(String name, String code, Double value, String type) {
        this.name = name;
        this.code = code;
        this.value = value;
        this.type = type;
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
