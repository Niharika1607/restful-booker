@Create @CreateBooking
Feature: To Create new bookings

  Background:
    * header Authorization = 'Bearer '+ tokenId


  Scenario Outline: Clone a Issue when value of with_notes is <withNoteValue>
    Given url baseUrl+'/projects/<oldProjectId>/issues/<issueId>/clone/?with_notes=<withNoteValue>&to_project_id=<newProjectId>'
    When method POST
    Then status 201
    And match $.project_id == <newProjectId>
    Examples:
      | oldProjectId | newProjectId | issueId | withNoteValue |
      | 39946432     | 39952225     | 40      | true          |
      | 39946432     | 39952225     | 40      | false         |
      | 39946432     | 39952225     | 40      |               |


