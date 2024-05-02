package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage = new ApiPage();

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareTheUrlFor(url);
    }

    @And("hit API get list users")
    public void hitAPIGetListUsers() {
        apiPage.hitAPIGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        apiPage.validationStatusCodeIsEquals(statusCode);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String json) {
        apiPage.validationResponseJsonWithJSONSchema(json);
    }


    @And("hit API create new users")
    public void hitAPICreateNewUsers() {
        apiPage.hitAPICreateNewUsers();
    }

    @Then("validation response body get create new user")
    public void validationResponseBodyGetCreateNewUser() {
        apiPage.validationResponseBodyGetCreateNewUser();
    }

    @And("hit API create new user name blank")
    public void hitAPICreateNewUserNameBlank() {
        apiPage.hitAPICreateNewUserBlank();
    }

    @Then("validation response body create blank name")
    public void validationResponseBodyCreateBlankName() {
        apiPage.validationCreateBlankName();
    }


    @And("hit API create new user gender blank")
    public void hitAPICreateNewUserGenderBlank() {
        apiPage.hitAPICreateNewUserGenderBlank();

    }

    @Then("validation response body create blank gender")
    public void validationResponseBodyCreateBlankGender() {
        apiPage.validationCreateBlankGender();
    }

    @And("hit API create new user status blank")
    public void hitAPICreateNewUserStatusBlank() {
        apiPage.hitAPICreateNewUserStatusBlank();


    }

    @Then("validation response body create blank status")
    public void validationCreateBlankStatus() {
        apiPage.validationCreateBlankStatus();
    }

    @And("hit API create new user email blank")
    public void hitAPICreateNewUserEmailBlank() {
        apiPage.hitAPICreateNewUserEmailBlank();

    }

    @Then("validation response body create email status")
    public void validationCreateEmailStatus() {
        apiPage.validationCreateEmailStatus();
    }

    @And("prepare valid id {int}")
    public void prepareValidId(int arg0) {
        apiPage.prepareValidId(arg0);
    }

    @And("hit API get user by id")
    public void hitAPIGetUsersById() {
        apiPage.hitAPIGetUsersById();
    }

    @Then("validation response body get user by id")
    public void validationResponseBodyGetUserById() {
        apiPage.validationResponseBodyGetUserById();

    }

    @And("hit API create new user gender not female or male")
    public void hitAPICreateNewUserGenderNotFemaleOrMale() {
        apiPage.hitAPICreateNewUserGenderNotFemaleOrMale();

    }

    @Then("validation response body create user gender not female or male")
    public void validationResponseBodyCreateUserGenderNotFemaleOrMale() {
        apiPage.validationCreateUserGenderNotFemaleOrMale();
    }

    @And("hit API create new user invalid email")
    public void hitAPICreateNewUserInvalidEmail() {
        apiPage.hitAPICreateNewUserInvalidEmail();
        
    }

    @Then("validation response body create invalid email")
    public void validationCreateInvalidEmail() {
        apiPage.validationCreateInvalidEmail();
    }


    @And("hit get API update user by id")
    public void hitGetAPIUpdateUserById() {
        apiPage.hitGetAPIUpdateUserById();
    }

    @And("hit get API delete user by id")
    public void hitGetAPIDeleteUserById() {
        apiPage.hitGetAPIDeleteUserById();
    }




    @And("hit API create new user over character")
    public void hitAPICreateNewUserOverCharacter() {
        apiPage.hitAPICreateNewUserOverCharacter();
    }

    @Then("validation response body create over character")
    public void validationResponseBodyCreateOverCharacter() {
        apiPage.ResponseBodyCreateOverCharacter();
    }
}
