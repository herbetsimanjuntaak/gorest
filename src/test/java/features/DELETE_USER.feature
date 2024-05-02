Feature: Test Automation Delete User GOREST

  @api
  Scenario: Test get data user by id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id 6882039
    And hit API get user by id
    Then validation status code is equals 200
    And hit get API delete user by id
    Then validation status code is equals 204
