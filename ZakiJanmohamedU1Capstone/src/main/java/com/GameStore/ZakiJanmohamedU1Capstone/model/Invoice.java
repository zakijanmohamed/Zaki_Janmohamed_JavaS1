package com.GameStore.ZakiJanmohamedU1Capstone.model;

import nonapi.io.github.classgraph.json.Id;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {

    @NotNull
    private int invoice_id;
    @NotEmpty(message = "You must supply a name for the invoice.")
    @Size(max = 80, message = "The name can only be up to 80 characters.")
    private String name;
    @NotEmpty(message = "You must supply a street for the invoice.")
    @Size(max = 30, message = "The street can only be up to 30 characters.")
    private String street;
    @NotEmpty(message = "You must supply a city for the invoice.")
    @Size(max = 30, message = "The city can only be up to 30 characters.")
    private String city;
    @NotEmpty(message = "You must supply the two-letter abbreviations for your state.")
    @Size(max = 2, message = "The state must be 2 characters.")
    private String state;
    @NotEmpty(message = "You must supply a zipcode for the invoice.")
    @Size(max = 5, message = "The zipcode can only be up to 5 characters.")
    private String zipcode;
    @NotEmpty(message = "You must supply an item type for the invoice.")
    @Size(max = 20, message = "The item type can only be up to 20 characters.")
    private String item_type;
    @NotNull
    private int item_id;
    @DecimalMin(value = "0.01", message = "The price must be a positive non-zero value.")
    @Digits(integer = 5,fraction = 2,message = "Your total cannot be larger than $99,999.99")
    private BigDecimal unit_price;
    @Positive (message = "You must supply a value equals to, or greater than 1 for the quantity.")
    private int quantity;
    @DecimalMin(value = "0.01", message = "The subtotal must be a positive non-zero value.")
    @Digits(integer = 5,fraction = 2,message = "Your subtotal cannot be larger than $99,999.99")
    private BigDecimal subtotal;
    @DecimalMin(value = "0.01", message = "The tax must be a positive non-zero value.")
    @Digits(integer = 5,fraction = 2,message = "Your tax cannot be larger than $99,999.99")
    private BigDecimal tax;
    @DecimalMin(value = "0.01", message = "The processing fee must be a positive non-zero value.")
    @Digits(integer = 5,fraction = 2,message = "Your processing cannot be larger than $99,999.99")
    private BigDecimal processing_fee;
    @DecimalMin(value = "0.01", message = "The total must be a positive non-zero value.")
    @Digits(integer = 5,fraction = 2,message = "Your total cannot be larger than $99,999.99")
    private BigDecimal total;

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(BigDecimal processing_fee) {
        this.processing_fee = processing_fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoice_id == invoice.invoice_id && item_id == invoice.item_id && quantity == invoice.quantity && Objects.equals(name, invoice.name) && Objects.equals(street, invoice.street) && Objects.equals(city, invoice.city) && Objects.equals(state, invoice.state) && Objects.equals(zipcode, invoice.zipcode) && Objects.equals(item_type, invoice.item_type) && Objects.equals(unit_price, invoice.unit_price) && Objects.equals(subtotal, invoice.subtotal) && Objects.equals(tax, invoice.tax) && Objects.equals(processing_fee, invoice.processing_fee) && Objects.equals(total, invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_id, name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_id=" + invoice_id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_type='" + item_type + '\'' +
                ", item_id=" + item_id +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", processing_fee=" + processing_fee +
                ", total=" + total +
                '}';
    }
}
