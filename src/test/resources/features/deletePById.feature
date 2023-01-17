
Feature: To Verify Delete Program API by programId automation with Rest Assured

  
  Scenario Outline: Test Delete program by programId
    Given The delete service with URL and path
    When Delete request by "<programId>" is made
    Then  Validate the status code
    
   

  
    Examples: 
      | programId | 
      | 202|
 