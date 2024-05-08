Feature: Test Automation Get User GOREST

  @api
  Scenario: Test get list data user
    Given prepare url for "GET_LIST_USERS"
    And hit API get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users.json"

  @api
  Scenario: Test get list data user invalid endpoint
    Given prepare url for "GET_ENDPOINT_WRONG"
    And hit API get list users
    Then validation status code is equals 404

  @api
  Scenario: Test get data user by id
    Given prepare url for "GET_LIST_USER_BY_ID"
    And prepare valid id 6892470
    And hit API get user by id
    Then validation status code is equals 200
    Then validation response body get user by id
    Then validation response json with JSONSchema "get_user_by_id.json"




