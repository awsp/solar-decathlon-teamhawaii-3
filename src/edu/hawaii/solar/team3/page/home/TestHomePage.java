package edu.hawaii.solar.team3.page.home;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;

import edu.hawaii.solar.team3.ExampleApplication;

/**
 * Example test showing how to retrieve the Hello World page.
 * 
 * @author Philip Johnson
 */
public class TestHomePage {

  /**
   * Tests for external and internal links.  
   */
  @Test
  public void testHelloWorld() {
    // Start up the WicketTester and check that the startpage renders. 
    WicketTester tester = new WicketTester(new ExampleApplication());
    tester.startPage(HomePage.class);
    tester.assertRenderedPage(HomePage.class);

    // Now check that the links all exist. 
    tester.assertComponent("HomePageLink", Link.class);
    tester.assertComponent("AcPageLink", Link.class);
    tester.assertComponent("WaterPageLink", Link.class);
    tester.assertComponent("LogPageLink", Link.class);
    
    // Click on the home page link to make sure it works and that we're back at this page.  
    tester.clickLink("HomePageLink");
    tester.assertRenderedPage(HomePage.class);
  }
}
