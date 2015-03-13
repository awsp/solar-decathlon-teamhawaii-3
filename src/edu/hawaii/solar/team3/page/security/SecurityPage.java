package edu.hawaii.solar.team3.page.security;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.image.Image;

import edu.hawaii.solar.team3.page.BasePage;

/**
 * A page illustrating the construction of a form. 
 * @author Philip Johnson
 */
public class SecurityPage extends BasePage {
  
  /** Support serialization. */
  private static final long serialVersionUID = 1L;
  
  /** Page. */
  public SecurityPage() {
    add(new Image("image", new ResourceReference(SecurityPage.class, 
    "kitchen.jpeg"))); 
    this.tabId = 8;
  }
}
