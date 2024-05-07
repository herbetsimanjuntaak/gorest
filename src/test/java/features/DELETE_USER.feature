Feature: Test Automation Delete User GOREST

  @api
  Scenario: Test Deleted user
    Given prepare url for "DELETE_USERS"
    And prepare valid id 6894125
    And hit get API delete user by id
    Then validation status code is equals 204

  @api
  Scenario: Test Deleted user invalid id
    Given prepare url for "DELETE_USERS"
    And prepare valid id 6894125
    And hit get API delete user by id
    Then validation status code is equals 404
    And validation response body message