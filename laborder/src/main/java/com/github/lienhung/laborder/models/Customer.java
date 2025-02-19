package com.github.lienhung.laborder.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
    
    @Id
    private String id;

    private String name;
    private String address;
    private String phone;
    private boolean isVip;

    public Customer() { }

    public Customer(String name, String address, String phone, boolean isVip) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        String customerInfo = String.format(
            "Customer[id: %s, name: %s, address: %s, phone: %s]", 
            id, name, address, phone);
        String vipInfo = isVip ? " (VIP)" : "";
        return customerInfo + vipInfo;
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
