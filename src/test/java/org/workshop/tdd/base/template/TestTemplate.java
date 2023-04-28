package org.workshop.tdd.base.template;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestTemplate {

  // This test has only one reason to fail
  @Test
  public void oneVariableAddedInTheGivenTemplate() { // Test names should be self explanatory, or like short stories (USE meaningful & intention-revealing names)
    // THINK Phase
    // Programming by Intention (The concept of writing code as if piece of code exists.
    //  -- It Focuses on what we could have instead of working around what we have
    // Test Something that is not exists
    // Use your power of Imagination
    //  -- Think of what the code does and why, instead of how it does it
    //  -- Check the tests description again

    // This is also inner TDD Cycle ACT or GIVEN Phase
    Template template = new Template("Hello, ${name}"); // In Java unit of functionality is Class
    // Template seems good abstraction but we don't have any details on its internal working.

    // ARRANGE or WHEN
    template.setVariable("name", "Reader");

    // ASSERT or THEN
    assertEquals("Hello, Reader", template.evaluate());
  }

  // Adding another variation to clarify the design
  // SUT is verifying same behaviour but with different value
  // Remember, we are not break TDD law to add new test while not pass our first test, we are triangulating to understand the right design of original behavior
  // Also remember we are not testing the class, we are testing a behaviour, this test of behaviour is isolated from other test. (Check "Add Test Cases" -> "Benefits for adding tests than tasks")
  @Test
  public void oneVariableWithDifferentValueParsedInTheGivenTemplate() {
    // This is also inner TDD Cycle ACT or GIVEN Phase
    Template template = new Template("Hello, ${name}");

    // ARRANGE or WHEN
    template.setVariable("name", "someone else");

    // ASSERT or THEN
    assertEquals("Hello, someone else", template.evaluate());
  }

  // Triangulate again but one different dimension. Not on the variable name but on the hard coded template text.
  @Test
  public void oneVariableWithDifferentTemplateTextParsedInTheGivenTemplate() {
    // This is also inner TDD Cycle ACT or GIVEN Phase
    Template template = new Template("Hi, ${name}");

    // ARRANGE or WHEN
    template.setVariable("name", "someone else");

    // ASSERT or THEN
    assertEquals("Hi, someone else", template.evaluate());
  }

  // Now Abstraction getting clear with its intent, and it looks like parsing the template, design rule suggest "Reveals Intention". Proper naming will help here. Changing added with parsed in the test method names
  // Note: Couple one important point here. Although we have added new test for multiple variable ? That should be a separate test in our tests list right ?
  //      -- Reason we are adding here before fully done with first behaviour is (remember triangulate is a step towards design betterment) it naturally reveal design intent.
  //         So we are going with the flow to add the test to make the design clear to remove any further hard coded values.
  //      -- Another point here after GREEN phase in previous test, we dont find any other obvious duplication to remove. So we skipped the REFACTOR phase to carry on progress to remove triangulation with obvious code
  //      -- Another key point here is till so far, all the above tests are testing same behaviour so, technically all test are same a part from different assertions.
  //         that's because of Triangulation. We can easily remove all duplicate code and keep one test with multiple asserts or use JUnit Parametrised tests instead.
  //         Check Mind Map "Triangulate" in "Design"
  @Test
  public void multipleVariablesWithTemplateTextParseInTheGivenTemplate() {
    // This is also inner TDD Cycle ACT or GIVEN Phase
    Template template = new Template("${one}, ${two}, ${three}");

    // ARRANGE or WHEN
    template.setVariable("one", "1");
    template.setVariable("two", "2");
    template.setVariable("three", "3");

    // ASSERT or THEN
    assertEquals("1, 2, 3", template.evaluate());
  }

}
