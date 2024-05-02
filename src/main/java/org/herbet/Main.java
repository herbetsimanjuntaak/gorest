package org.herbet;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        String streetName = faker.address().streetName();
        String number = faker.address().buildingNumber();
        String city = faker.address().city();
        String country = faker.address().country();


        System.out.println(streetName);
        System.out.println(number);
        System.out.println(city);
        System.out.println(country);

        String name = "";
        String allowedChars = "adsfasdfasdf"+"12342353"+"_+=.";
        String temp = RandomStringUtils.randomAlphanumeric(10); //panjang email 10 karakter
        name = temp+allowedChars;

        System.out.println(name);


    }
}