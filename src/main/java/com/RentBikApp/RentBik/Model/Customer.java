package com.RentBikApp.RentBik.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cccd;
    private String fullname;
    private String birthday;
    @Column(unique = true)
    private String phoneNumber;
//    @ManyToMany
//    @JoinTable(
//            name = "customer_gplx",
//            joinColumns = @JoinColumn(name = "customer_id"),
//            inverseJoinColumns = @JoinColumn(name = "gplx_id")
//    )
//    @JsonManagedReference
//    private List<Gplx> gplxs;
    private String note;
    public Customer() {
    }

    public Customer(Integer id, String cccd, String fullname, String birthday, String phoneNumber, String note) {
        this.id = id;
        this.cccd = cccd;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
