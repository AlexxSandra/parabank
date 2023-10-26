Feature: Manage - ParaBank

  Scenario: Verify that Login was successful
    Given user is accessing the login page
    When user enters correct credentials
  #  Then the error message is displayed
    Then user is successful logged in

#  Scenario: Verify that user is able to contact Parasoft team
#    Given user is accessing the Contact Us page
#    When user enters correct credentials for Contact Us page
#    And user clicks on Contact Us button
#    Then the message should be successful send
