Feature:verify program by Name

  
  Scenario Outline: Update program by programName
    Given  A update Service with URL and path
    When "<programId>","<programName>","<programDescription>","<programStatus>",creationTime,lastModTime are updated
    And PUT request is made 
    Then  Save programName
    And  Validate status code
    And validate required fields "<programId>","<programName>","<programDescription>","<programStatus>"

 
  
    Examples: 
      | programId | programName | programDesription | programStatus |
      | 5174 | Jan23-Mighty5 Testers-SDET-005| Learn Postman-APIs |Actives |
      | 6979|  Jan23-NinjaTrainees-Learn Selenium-55 | Actives  |Seleniumjava|
