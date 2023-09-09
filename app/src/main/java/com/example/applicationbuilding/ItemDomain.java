package com.example.applicationbuilding;

public class ItemDomain {
    private String title;
    private String address;
    private String description;
    private int price;
    private String pic;

    public ItemDomain(String title, String address, String description, int price, String pic) {
        this.title = title;
        this.address = address;
        this.description = description;
        this.price = price;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
