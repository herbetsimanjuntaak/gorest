Feature: Test Automation Update User GOREST

  @api
  Scenario: Test update user by id
    Given prepare url for "PUT_USERS"
    And prepare valid id 2731682
    And hit API update user by id
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_user_by_id.json"

  @api
  Scenario: Test update user invalid id
    Given prepare url for "PUT_USERS"
    And prepare valid id 6894125
    When hit API update user by id
    Then validation status code is equals 404
    And validation response body message
