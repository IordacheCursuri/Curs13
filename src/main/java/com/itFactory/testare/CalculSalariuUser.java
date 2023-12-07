package com.itFactory.testare;

public class CalculSalariuUser {


    public double calculeazaBonus(User user) {

        if(user.getVechimeInMunca() > 15){
            double bonus1 = user.getSalariulBrut() * 0.50;
            return bonus1;
        } else  {
            double bonus2 = user.getSalariulBrut() * 0.20;
            return bonus2;
        }
    }


    public User getUser(double salariu) {
        if(salariu > 100000) {
            return new User("Gigel", 200000, 25);
        }
        return null;
    }

    public boolean esteTanar(User user){
        if(user.getVechimeInMunca() < 15) {
            return true;
        } else {
            return false;

        }
    }


    public double calculeazaSalariulNet(User user) {

        if(user == null){
            return 0.0;
        }

        if(user.getVechimeInMunca() >= 15) {
            double salariulNet = user.getSalariulBrut() * 0.35;
            return salariulNet;
        }

        if(user.getSalariulBrut() > 20000){
            throw new SalariuPreaMareException("salariul este pre mare!");
        }


        double salariu = user.getSalariulBrut() * 0.60;
        return salariu;

    }










}
