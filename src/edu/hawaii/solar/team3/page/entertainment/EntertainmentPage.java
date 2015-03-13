package edu.hawaii.solar.team3.page.entertainment;

import org.apache.wicket.markup.html.link.Link;
import edu.hawaii.solar.team3.page.BasePage;
import edu.hawaii.solar.team3.page.help.HelpPage;


/**
 * A page illustrating the construction of a form. 
 * @author Philip Johnson
 */
public class EntertainmentPage extends BasePage {
  
  /** Support serialization. */
  private static final long serialVersionUID = 1L;
  
  /** Page. */
  public EntertainmentPage() {
    
    //Tab ID
    this.tabId = 5;
    
    add(new Link<String>("hplink2_ent") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to HelpPage. */
      @Override
      public void onClick() {
        setResponsePage(new HelpPage());
      }
      }
    );
    
  }
}
