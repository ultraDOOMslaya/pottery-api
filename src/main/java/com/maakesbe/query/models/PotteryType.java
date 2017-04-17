package com.maakesbe.query.models;

import javax.persistence.*;

@Entity
@Table(name = "pottery_types")
public class PotteryType {

    @Id
    @Column(name = "pottery_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pottery_type")
    private String potteryType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPotteryType() {
        return potteryType;
    }

    public void setPotteryType(String potteryType) {
        this.potteryType = potteryType;
    }
}
