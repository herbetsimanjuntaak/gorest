package pages;

import helper.Endpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static helper.Utility.getJSONSchemaFile;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setUrl, finalEndpoint;

    Response response;

    public void prepareTheUrlFor(String url) {
        switch (url) {
            case "CREATE_NEW_USERS":
                setUrl = Endpoint.CREATE_NEW_USERS;
                break;
            case "GET_LIST_USERS":
                setUrl = Endpoint.GET_LIST_USERS;
                break;
            case "DELETE_USERS":
                setUrl = Endpoint.DELETE_USERS;
                break;
            case "POST_USERS":
                setUrl = Endpoint.POST_USERS;
                break;
            case "PATCH_USERS":
                setUrl = Endpoint.PATCH_USERS;
                break;
            case "PUT_USERS":
                setUrl = Endpoint.PUT_USERS;
                break;
            case "GET_ENDPOINT_WRONG":
                setUrl = Endpoint.GET_ENDPOINT_WRONG;
                break;
            case "GET_LIST_USER_BY_ID":
                setUrl = Endpoint.GET_LIST_USER_BY_ID;
                break;
            default:
                System.out.println("input valid url :)");
        }
    }


    public void hitAPIGetListUsers() {
        response = getListUsers(setUrl);
    }

    public void validationStatusCodeIsEquals(int statusCode) {
        assertThat(response.statusCode()).isEqualTo(statusCode);

    }

    public void validationResponseBodyGetListUsers() {

        List<Object> id = response.jsonPath().getList("id");
        List<Object> name = response.jsonPath().getList("name");
        List<Object> email = response.jsonPath().getList("email");
        List<Object> gender = response.jsonPath().getList("gender");
        List<Object> status = response.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");


    }

    public void validationResponseJsonWithJSONSchema(String fileName) {
        File JSONFile = getJSONSchemaFile(fileName);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitAPICreateNewUsers() {
        response = createNewUser(setUrl);
    }


    public void validationResponseBodyGetCreateNewUser() {


        JsonPath jsonPathEvaluator = response.jsonPath();

        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");


    }

    public void hitAPICreateNewUserBlank() {
        response = createNameBlank(setUrl);
    }

    public void validationCreateBlankName() {

        JsonPath jsonPathEvaluator = response.jsonPath();


        String fieldName = jsonPathEvaluator.getString("[0].field");
        String message = jsonPathEvaluator.getString("[0].message");

        assertThat(fieldName).isEqualTo("name");
        assertThat(message).isEqualTo("can't be blank");


    }

    public void hitAPICreateNewUserGenderBlank() {
        response = createGenderBlank(setUrl);
    }

    public void validationCreateBlankGender() {
        JsonPath jsonPathEvaluator = response.jsonPath();


        String fieldName = jsonPathEvaluator.getString("[0].field");
        String message = jsonPathEvaluator.getString("[0].message");

        assertThat(fieldName).isEqualTo("gender");
        assertThat(message).isEqualTo("can't be blank, can be male of female");


    }

    public void hitAPICreateNewUserStatusBlank() {
        response = createStatusBlank(setUrl);
    }

    public void validationCreateBlankStatus() {
        JsonPath jsonPathEvaluator = response.jsonPath();


        String fieldName = jsonPathEvaluator.getString("[0].field");
        String message = jsonPathEvaluator.getString("[0].message");

        assertThat(fieldName).isEqualTo("status");
        assertThat(message).isEqualTo("can't be blank");


    }


    public void hitAPICreateNewUserEmailBlank() {
        response = createEmailBlank(setUrl);
    }

    public void validationCreateEmailStatus() {
        JsonPath jsonPathEvaluator = response.jsonPath();


        String fieldName = jsonPathEvaluator.getString("[0].field");
        String message = jsonPathEvaluator.getString("[0].message");

        assertThat(fieldName).isEqualTo("email");
        assertThat(message).isEqualTo("can't be blank");


    }

    public void hitAPICreateNewUserInvalidEmail() {
        response = createInvalidEmail(setUrl);

    }

    public void validationCreateInvalidEmail() {

        JsonPath jsonPathEvaluator = response.jsonPath();


        String fieldName = jsonPathEvaluator.getString("[0].field");
        String message = jsonPathEvaluator.getString("[0].message");

        assertThat(fieldName).isEqualTo("email");
        assertThat(message).isEqualTo("is invalid");


    }

    public void prepareValidId(int arg0) {
        finalEndpoint = prepareUrlId(setUrl, arg0);
    }

    public void hitAPIGetUsersById() {
        response = hitUserById(finalEndpoint);
    }

    public void validationResponseBodyGetUserById() {

        JsonPath jsonPathEvaluator = response.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }

    public void hitAPICreateNewUserGenderNotFemaleOrMale() {
        response = hitAPICreateNewUserGenderNotFemale(setUrl);
    }

    public void validationCreateUserGenderNotFemaleOrMale() {
        JsonPath jsonPathEvaluator = response.jsonPath();


        String fieldName = jsonPathEvaluator.getString("[0].field");
        String message = jsonPathEvaluator.getString("[0].message");

        assertThat(fieldName).isEqualTo("gender");
        assertThat(message).isEqualTo("can't be blank, can be male of female");


    }

    public void hitGetAPIUpdateUserById() {
        response = hitUpdate(finalEndpoint);
    }

    public void hitGetAPIDeleteUserById() {
        response = deleteUserById(finalEndpoint);
    }

    public void hitAPICreateNewUserOverCharacter() {
        response = createNewUserOver(setUrl);

    }

    public void ResponseBodyCreateOverCharacter() {
        JsonPath jsonPathEvaluator = response.jsonPath();

        String fieldName = jsonPathEvaluator.getString("[0].field");
        String message = jsonPathEvaluator.getString("[0].message");

        assertThat(fieldName).isEqualTo("name");
        assertThat(message).isEqualTo("is too long (maximum is 200 characters)");


    }

    public void validationUpdate() {

        JsonPath jsonPathEvaluator = response.jsonPath();
        String message = jsonPathEvaluator.getString("message");
        assertThat(message).isEqualTo("Resource not found");

    }


}
