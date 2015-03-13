package edu.hawaii.solar.team3.page.settings;
import org.junit.Test;
/*
import static org.junit.Assert.assertEquals;

import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;


import edu.hawaii.wicket.ExampleApplication;
import edu.hawaii.wicket.page.home.HomePage;
*/
/**
 * Example test showing a simple way to test a form. 
 * 
 * @author Philip Johnson
 */
public class TestSettingsPage {

  /**
   * Tests the form page. 
   */
  @Test
  public void testFormPage() {
    /*
    // Start up the WicketTester and check that the startpage renders. 
    WicketTester tester = new WicketTester(new ExampleApplication());
    tester.startPage(HomePage.class);
    tester.assertRenderedPage(HomePage.class);
    
    // Click on link to go to Form page, and make sure we got there. 
    tester.clickLink("FormPageLink");
    tester.assertRenderedPage(SettingsPage.class);
    
    // Now check that we can fill out the form and submit it. 
    FormTester formTester = tester.newFormTester("form");
    assertEquals("Checking form default contents", "", formTester.getTextComponentValue("Field1"));
    formTester.setValue("Field1", "foo");
    formTester.setValue("Field2", "bar");
    formTester.submit("Submit");
    tester.assertRenderedPage(SettingsPage.class);
    
    // The following line is useful for seeing what's on the page.
    // tester.debugComponentTrees();
    
    // Now see that submitting the form changed the page. 
    @SuppressWarnings("rawtypes")
    Model fieldModel = (Model) tester.getComponentFromLastRenderedPage("Field1Value")
    .getDefaultModel();
    String field1Value = (String) fieldModel.getObject();
    assertEquals("Testing that submitted form's value showed up", "foo", field1Value);
 */
  }
}
