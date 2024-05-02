Feature: Test Automation Create User GOREST

  @api
  Scenario: Test new user normal
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new users
    Then validation status code is equals 201
    Then validation response body get create new user
    Then validation response json with JSONSchema "post_create_new_user_normal.json"

  @api
  Scenario: Test create new user blank name
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new user name blank
    Then validation status code is equals 422
    Then validation response body create blank name

  @api
  Scenario: Test create new user blank gender
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new user gender blank
    Then validation status code is equals 422
    Then validation response body create blank gender

  @api
  Scenario: Test create new user gender not female or male
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new user gender not female or male
    Then validation status code is equals 422
    Then validation response body create user gender not female or male

  @api
  Scenario: Test create new user blank status
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new user status blank
    Then validation status code is equals 422
    Then validation response body create blank status

  @api
  Scenario: Test create new user blank email
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new user email blank
    Then validation status code is equals 422
    Then validation response body create email status

  @api
  Scenario: Test create new user invalid email
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new user invalid email
    Then validation status code is equals 422
    Then validation response body create invalid email

  @api
  Scenario: Test create new user over 200 character
    Given prepare url for "CREATE_NEW_USERS"
    And hit API create new user over character
    Then validation status code is equals 422
    Then validation response body create over character