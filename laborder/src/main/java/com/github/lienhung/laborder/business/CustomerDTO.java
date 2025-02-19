package com.github.lienhung.laborder.business;

public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private String phone;
    private boolean isVip;

    public CustomerDTO(String id, String name, String address, String phone, boolean isVip) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isVip = isVip;
    }

    public String getId() { return this.id; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return this.address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return this.phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public boolean getVipStatus() { return this.isVip; }

    public void setVipStatus(boolean isVip) { this.isVip = isVip; }
}
