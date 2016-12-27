package com.maakesbe.services.models;

import javax.persistence.*;

@Entity
@Table(name = "pottery")
public class Pottery {

    @Id
    @Column(name = "pottery_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pottery_description")
    private String potteryDescription;

    @Column(name = "pottery_type")
    private String potteryType;

    public String getPotteryDescription() {
        return potteryDescription;
    }

    public void setPotteryDescription(String potteryDescription) {
        this.potteryDescription = potteryDescription;
    }

    public String getPotteryType() {
        return potteryType;
    }

    public void setPotteryType(String potteryType) {
        this.potteryType = potteryType;
    }
}
