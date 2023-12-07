package com.itFactory.testare;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculSalariuUserTest {


    CalculSalariuUser underTest = new CalculSalariuUser();


    @Test
    @DisplayName("calculeaza bonusul cand vechimea in munca este mai mica de 15 ani")
    void shouldCalculateBonus() {
        //given
        User user = new User();
        user.setUsername("gigel");
        user.setSalariulBrut(1000);
        user.setVechimeInMunca(14);

        //when
        double actual = underTest.calculeazaBonus(user);

        //then
        Assertions.assertEquals(200, actual);
    }

    @Test
    @DisplayName("calculeaza bonusul daca vechimea in munca este mai mare de 15 ani")
    void shouldCalculateBonusIfAgeIsBiggerThan15() {
        //given
        User user = new User("ionel", 2000, 16);
        double expected = 1000;

        //when
        double actual = underTest.calculeazaBonus(user);

        //then
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void shouldReturnAValidUser() {
        //given
        double salariu = 300000000;

        //when
        User actual = underTest.getUser(salariu);

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals("Gigel", actual.getUsername());
        Assertions.assertEquals(200000, actual.getSalariulBrut());
        Assertions.assertEquals(25, actual.getVechimeInMunca());
    }

    @Test
    void shouldReturnAInvalidUser() {
        //given
        double salariu = 1000;

        //when
        User actual = underTest.getUser(salariu);

        //then
        Assertions.assertNull(actual);

    }

    @Test
    void shouldReturnTrueIfAgeIsLowerThanFifteen() {
        //given
        User user = new User("Andreea", 1000, 12);


        //when
        boolean actual = underTest.esteTanar(user);

        //then
        Assertions.assertTrue(actual);

    }

    @Test
    void shouldReturnTrueIfAgeIsBiggerThanFifteen() {
        //given
        User user = new User("Andreea", 1000, 16);


        //when
        boolean actual = underTest.esteTanar(user);

        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void shouldReturnZeroSalary() {
        //given
        User user = null;

        //when
        double actual = underTest.calculeazaSalariulNet(user);

        //then
        Assertions.assertEquals(0.0, actual);
    }

    @Test
    void shouldThrowSalariuPreaMareException() {
        //given
        User user = new User("Oana", 50000, 10);

        //when
        Exception actual = Assertions.assertThrows(SalariuPreaMareException.class, () -> underTest.calculeazaSalariulNet(user));


        //then
        Assertions.assertEquals("salariul este pre mare!", actual.getMessage());
    }

    @Test
    void shouldReturnSalaryInCaseAgeIsBiggerThan15() {
        //given
        User user = new User("Andrei", 1000, 16);

        //when
        double actual = underTest.calculeazaSalariulNet(user);

        //then
        Assertions.assertEquals(350, actual);

    }

    @Test
    void shouldCalculateSalary() {
        //given
        User user = new User("Ana", 1000, 10);

        //when
        double actual = underTest.calculeazaSalariulNet(user);

        //then
        Assertions.assertEquals(600, actual);
    }


}
