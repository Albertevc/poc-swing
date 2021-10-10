package br.com.aevc.pocswing.model;

public class ProductSearchDTO {

    private String name;
    private String code;
    private String type;

    public ProductSearchDTO(String name, String code, String type) {
        this.name = name;
        this.code = code;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
