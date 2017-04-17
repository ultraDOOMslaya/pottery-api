package com.maakesbe.query.models;

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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pottery_type_id")
    private PotteryType potteryType;

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

    public PotteryType getPotteryType() {
        return potteryType;
    }

    public void setPotteryType(PotteryType potteryType) {
        this.potteryType = potteryType;
    }

    public String getPotteryFileName() {
        return potteryFileName;
    }

    public void setPotteryFileName(String potteryFileName) {
        this.potteryFileName = potteryFileName;
    }
}
