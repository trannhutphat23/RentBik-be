package com.RentBikApp.RentBik.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gplx")
public class Gplx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String rank;
    @ManyToMany(
            mappedBy = "gplxs",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Customer> customer = new ArrayList<>();
    public Gplx() {
    }

    public Gplx(Integer id, String rank) {
        this.id = id;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
