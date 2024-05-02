package helper;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class Utility {
    static Faker faker = new Faker();
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail(){
        String allowedChars = "adsfasdfasdf"+"12342353"+"_+=.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); //panjang email 10 karakter
        email = temp+"@testdata.com";
        return email;
    }

    public static String generateRandomName(){
        String allowedChars = "adsfasdfasdf"+"12342353"+"_+=.";
        String name = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); //panjang email 10 karakter
        name = temp+"@testdata.com";
        return name;
    }

    public static String generateName(){
        String name = faker.name().fullName();
        return name;
    }

    public static String generateEmails(){
        String name = faker.name()+"@gmail.com";
        return name;
    }
}
