Feature: Test World

	Scenario: Hello Karate World
    * print 'Hello World'
    * print 'Hello Abhishek !!'
    
  Scenario: Variable Addition
  * def x = 10
  * def y = 15
  * print 'Addition is ->' + (x+y)
  
  Scenario: Config File Validation
  * print name
  * print email  
  
  @SmokeTest
  Scenario: Smoke Test
  * print 'This is smoke test'
  
  @RegressionTest
  Scenario: Regression Test
  * print 'This is regression test'
  
  @E2ETest @RegressionTest
  Scenario: E2E and Regression Test
  * print 'This is E2E and Regression Test'