package com.myproject.ecom_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;

@Entity
public class product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this will automatically generate the id upon addition of new products
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String descript; // Changed from 'desc' to 'descript'

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int price;
    private String brand;
    private String category;

    public product() {
    }

    public product(int id, String name, String descript, int price, String brand, String category, Date releasedate, int quantity, String imagename, byte[] imagedata, String imagetype) {
        this.id = id;
        this.name = name;
        this.descript = descript;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.releasedate = releasedate;
        this.quantity = quantity;
        this.imagename = imagename;
        this.imagedata = imagedata;
        this.imagetype = imagetype;
    }

    private Date releasedate;
    private int quantity;

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImagetype() {
        return imagetype;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", releasedate=" + releasedate +
                ", quantity=" + quantity +
                ", imagename='" + imagename + '\'' +
                ", imagetype='" + imagetype + '\'' +
                ", imagedata=" + Arrays.toString(imagedata) +
                '}';
    }

    public void setImagetype(String imagetype) {
        this.imagetype = imagetype;
    }

    public byte[] getImagedata() {
        return imagedata;
    }

    public void setImagedata(byte[] imagedata) {
        this.imagedata = imagedata;
    }

    //image
    private String imagename;
    private String imagetype;
    @Lob//large object
    private byte[] imagedata;
    //this can be string containing the url of the image on any dataabse

}