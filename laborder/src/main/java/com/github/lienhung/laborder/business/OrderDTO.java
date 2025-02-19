package com.github.lienhung.laborder.business;

import java.time.LocalDate;

public class OrderDTO {
    private String id;
    private String customerId;
    private LocalDate date;
    private double total;

    public OrderDTO(String id, String customerId, LocalDate date, double total) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.total = total;
    }

    public String getId() { return this.id; }

    public String getCustomerId() { return this.customerId; }

    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public LocalDate getDate() { return this.date; }

    public void setDate(LocalDate date) { this.date = date; }

    public double getTotal() { return this.total; }

    public void setTotal(double total) { this.total = total; }
}
