package com.ahd.api.company;


import javax.persistence.*;

@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "manager_name")
    private String manger_name;

    public CompanyModel() {
    }

    public CompanyModel( String name, String manger_name) {
        this.name = name;
        this.manger_name = manger_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManger_name() {
        return manger_name;
    }

    public void setManger_name(String manger_name) {
        this.manger_name = manger_name;
    }
}
