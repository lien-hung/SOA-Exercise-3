package com.github.lienhung.laborder.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "orders")
public class Order {
    
    @Id
    private String id;

    @Field(targetType = FieldType.OBJECT_ID)
    private String customerId;

    private LocalDate date;
    private double total;

    public Order() { }

    public Order(String customerId, LocalDate date, double total) {
        this.customerId = customerId;
        this.date = date;
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format(
            "Order[date: %s, total: %f]",
            date, total);
    }

    public String getId() { return this.id; }

    public String getCustomerId() { return this.customerId; }

    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public LocalDate getDate() { return this.date; }

    public void setDate(LocalDate date) { this.date = date; }

    public double getTotal() { return this.total; }

    public void setTotal(double total) { this.total = total; }
}
