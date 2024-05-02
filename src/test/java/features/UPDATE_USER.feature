Feature: Test Automation Update User GOREST

#  @api
#  Scenario: Test update user by id
#    Given prepare url for "PUT_USERS"
#    And prepare valid id 6880566
#    And hit get API update user by id
#    Then validation status code is equals 200
#    Then validation response json with JSONSchema "get_user_by_id.json"

  @api
  Scenario: Test get data user by id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id 6882096
    And hit API get user by id
    Then validation status code is equals 200
    And hit get API update user by id
    Then validation status code is equals 200
    Then validation response body get user by id
    Then validation response json with JSONSchema "get_user_by_id.json"