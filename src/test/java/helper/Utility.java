package helper;

import com.github.javafaker.Faker;

import java.io.File;

public class Utility {
    static Faker faker = new Faker();
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateName(){
        return faker.name().fullName();
    }

    public static String generateEmails(){
        return faker.name().username()+"@gmail.com";
    }
}
