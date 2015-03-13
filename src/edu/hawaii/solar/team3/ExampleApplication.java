package edu.hawaii.solar.team3;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import edu.hawaii.solar.team3.page.home.HomePage;

/**
 * This top-level class is required to specify the Wicket WebApplication. 
 * @author Philip Johnson
 */
public class ExampleApplication extends WebApplication {
  
  /**
   * Return the home page for this application. 
   * @return The home page. 
   */
  @Override
  public Class<? extends Page> getHomePage() {
    return HomePage.class;
  }
  @Override 
  public String getConfigurationType() {
      return Application.DEPLOYMENT;
  }
}
