package com.RentBikApp.RentBik.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ReturnCard")
public class ReturnCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "rent_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_rent_car"))
    private Rent rent;

    private LocalDate returnedDate;
    private Float fine;

    public ReturnCard() {
    }

    public ReturnCard(Integer id, Rent rent, LocalDate returnedDate, Float fine) {
        this.id = id;
        this.rent = rent;
        this.returnedDate = returnedDate;
        this.fine = fine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Float getFine() {
        return fine;
    }

    public void setFine(Float fine) {
        this.fine = fine;
    }
}
