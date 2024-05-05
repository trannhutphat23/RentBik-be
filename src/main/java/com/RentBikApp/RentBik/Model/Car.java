package com.RentBikApp.RentBik.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.RentBikApp.RentBik.EnumData.Status;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String licensePlate;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "brand_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_brand_car"))
    private Brand brand;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "series_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_series_car"))
    private Series series;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "type_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_type_car"))
    private Type type;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "insurance_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_insurance_car"))
    private Insurance insurance;

    @OneToMany(mappedBy = "car")
    @JsonManagedReference
    private List<Maintenance> maintenances;
    @OneToMany(mappedBy = "car")
    @JsonManagedReference
    private List<Rent> rents;
    private Float purchasePrice;
    private LocalDate purchaseDate;
    private Float hirePrice;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String carNote;

    public Car() {
    }

    public Car(Integer id, String licensePlate, Brand brand) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Float getHirePrice() {
        return hirePrice;
    }

    public void setHirePrice(Float hirePrice) {
        this.hirePrice = hirePrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCarNote() {
        return carNote;
    }

    public void setCarNote(String carNote) {
        this.carNote = carNote;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
