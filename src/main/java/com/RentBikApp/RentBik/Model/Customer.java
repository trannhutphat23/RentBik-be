package com.RentBikApp.RentBik.Model;

import com.RentBikApp.RentBik.DTO.GplxDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable(
        name = "customer_gplx",
        joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "gplx_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private Set<Gplx> gplxs = new HashSet<Gplx>();
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
    public void addGplx(Gplx gplx){
        this.gplxs.add(gplx);
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
    public Set<Gplx> getGplxs() {
        return gplxs;
    }

    public void setGplxs(Set<Gplx> gplxs) {
        this.gplxs = gplxs;
    }
}
