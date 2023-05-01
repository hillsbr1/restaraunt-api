package com.example;

import java.util.Date;

public class Menu {
    private Long id;
    private String name;
    private Integer type;
    private Integer price;
    private Integer status;
    Menu(Long id, String name, Integer type, Integer price, Integer status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}