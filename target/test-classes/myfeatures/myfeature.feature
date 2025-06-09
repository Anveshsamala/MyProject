Feature: airnavrador project

  Scenario Outline: airnavrador Registration process
    Given the user open the registration page
    When the user enter the registration details:
      | Field Name      | Label Name            |
      | NAME            | name                  |
      | EMAIL           | email                 |
      | PASSWORD        | password              |
      | CONFIRMPASSWORD | password_confirmation |
      
   Then user completed registration process with valid details