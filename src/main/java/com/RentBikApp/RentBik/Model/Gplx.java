package com.RentBikApp.RentBik.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "gplx")
public class Gplx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String rank;
//    @ManyToMany(
//            mappedBy = "gplxs",
//            cascade = CascadeType.ALL
//    )
//    @JsonBackReference
//    private List<Customer> customer;
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
