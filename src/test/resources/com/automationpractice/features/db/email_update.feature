

Feature: Update user email
  

  #@db @ui
  Scenario: Verify the user email update from the DB
    Given I am on logged in using "duotech" as username and "duotech2020" as password
    When  I update the email in the database with "duotech@gmail.com"
   	Then The correct email should be diplayed in the user details page
   

  