package com.miniProject.subway.menu;

public class MenuDTO {  // TODO :: 메뉴 뼈대 만들기

    private String menuname;
    private int price;
    private String description;

    public MenuDTO() {
    }

    public MenuDTO(String name, int price, String description) {
        this.menuname = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return menuname;
    }

    public void setmenuName(String name) {
        this.menuname = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "name='" + menuname + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
