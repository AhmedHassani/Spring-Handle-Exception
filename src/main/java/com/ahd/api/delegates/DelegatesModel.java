package com.ahd.api.delegates;


import javax.persistence.*;

@Entity
@Table(name = "delegates")
public class DelegatesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "almudhakher")
    private String almudhakher;

    public DelegatesModel() {
    }

    public DelegatesModel(String name, String phone, String email, String city, String almudhakher) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.almudhakher = almudhakher;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAlmudhakher() {
        return almudhakher;
    }

    public void setAlmudhakher(String almudhakher) {
        this.almudhakher = almudhakher;
    }


}
