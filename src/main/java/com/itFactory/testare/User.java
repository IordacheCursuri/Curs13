package com.itFactory.testare;

import java.util.Objects;

public class User {

    private String username;
    private double salariulBrut;
    private int vechimeInMunca;

    public User(String username, double salariulBrut, int vechimeInMunca) {
        this.username = username;
        this.salariulBrut = salariulBrut;
        this.vechimeInMunca = vechimeInMunca;
    }

    public User(){

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSalariulBrut() {
        return salariulBrut;
    }

    public void setSalariulBrut(double salariulBrut) {
        this.salariulBrut = salariulBrut;
    }

    public int getVechimeInMunca() {
        return vechimeInMunca;
    }

    public void setVechimeInMunca(int vechimeInMunca) {
        this.vechimeInMunca = vechimeInMunca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(salariulBrut, user.salariulBrut) == 0 && vechimeInMunca == user.vechimeInMunca && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, salariulBrut, vechimeInMunca);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", salariulBrut=" + salariulBrut +
                ", vechimeInMunca=" + vechimeInMunca +
                '}';
    }
}
