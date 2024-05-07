package helper;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.*;

public class Models {

    private static RequestSpecification requestSpecification;
    Faker faker = new Faker();
    public static void setUpHeaders() {
        requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 2259048ef8b50ff36a730b1d6dcd5962cd3c9aa5210a7b4ca68b92c36d8abfc9");
    }

    public static Response getListUsers(String endpoint) {
        System.out.println("Endpoint yang dilempar : " + endpoint);
        setUpHeaders();
        return requestSpecification.when().get(endpoint);
    }

    public static String prepareUrlId(String endpoint, int user_id ) {
        String finalEndpoint = endpoint + "/" + user_id;
        System.out.println("Endpoint yang dilempar : " + finalEndpoint);

        return finalEndpoint;
    }

    public static Response hitUserById(String endpoint ) {
        setUpHeaders();

        return requestSpecification.when().get(endpoint);
    }

    public static Response hitUpdate(String endpoint ) {

        String name = generateName()+" Edit";
        String email = generateEmails();
        String status = "active";
        String gender = "male";


        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("email", email);
        payload.put("status", status);
        payload.put("gender", gender);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().put(endpoint);
    }

    public static Response deleteUserById(String endpoint ) {
        setUpHeaders();

        return requestSpecification.when().delete(endpoint);
    }

    public static Response createNewUser(String endpoint) {
        String name = generateName();
        String gender = "female";
        String email = generateEmails();
        System.out.println(email);
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

    public static Response createNameBlank(String endpoint) {
        String name = "";
        String gender = "male";
        String email = generateEmails();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

    public static Response createGenderBlank(String endpoint) {
        String name = generateName();
        String gender = "";
        String email = generateEmails();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

    public static Response hitAPICreateNewUserGenderNotFemale(String endpoint) {
        String name = generateName();
        String gender = "pria";
        String email = generateEmails();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

    public static Response createStatusBlank(String endpoint) {
        String name = generateName();
        String gender = "male";
        String email = generateEmails();
        String status = "";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

    public static Response createEmailBlank(String endpoint) {
        String name = generateName();
        String gender = "male";
        String email = "";
        String status = "status";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

    public static Response createInvalidEmail(String endpoint) {
        String name = generateName();
        String gender = "male";
        String email = "asu";
        String status = "active";
        System.out.println(name+" is name");
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

    public static Response createNewUserOver(String endpoint) {
        String name = "sdfasSDFASFdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSDFASFdfdfasSSFdfdfasSDFASFdfdf";
        String gender = "male";
        String email = generateEmails();
        System.out.println(email);
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return requestSpecification.body(payload.toString()).when().post(endpoint);

    }

}
