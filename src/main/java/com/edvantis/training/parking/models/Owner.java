package com.edvantis.training.parking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by taras.fihurnyak on 2/2/2017.
 */

@Entity
@Table(name = "OWNER")
public class Owner {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "DOB")
    private LocalDate dob;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner", fetch = FetchType.EAGER)
    private Set<Vehicle> userVehicles = new HashSet<>();

    public Owner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public void setDOB(LocalDate age) {
        this.dob = age;
    }

    public Vehicle getVehicleByNumber(String vehicleNumber) {
        Vehicle vehicle = null;
        for (Vehicle v : userVehicles) {
            if (v.getNumber().equals(vehicleNumber))
                vehicle = v;
        }
        return vehicle;
    }

    public void addVehicleToOwner(Vehicle vehicle) {
        userVehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", userVehicles=" + userVehicles +
                '}';
    }
}
