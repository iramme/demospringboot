package com.example.demo.model;
import jakarta.persistence.*;
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String address;
private double moyenne;
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
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
public double getMoyenne() {
    return moyenne;
}
public void setMoyenne(double moyenne) {
    this.moyenne = moyenne;
}

}