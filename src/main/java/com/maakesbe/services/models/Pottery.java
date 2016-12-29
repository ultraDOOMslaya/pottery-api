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

    @Column(name = "pottery_file_name")
    private String potteryFileName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getPotteryFileName() {
        return potteryFileName;
    }

    public void setPotteryFileName(String potteryFileName) {
        this.potteryFileName = potteryFileName;
    }
}
