
@tag
Feature: verify program by id

 @tag1
  Scenario Outline: Update program by ID
    Given A update Service with URL and path
    When "<programName>","<programDescription>","<programStatus>",creationTime,lastModTime are updated
    And PUT request is made
    Then Save programId
    And Validate status code
    And Validate required fields "<programId>","<programName>","<programDescription>","<programStatus>"

    Examples: 
      | programId | programName| programDescription       | programStatus |
      |      264| minal | Learn SQL                       | Active        |
     