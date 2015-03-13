package edu.hawaii.solar.team3.page.settings;

import edu.hawaii.solar.team3.page.BasePage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;

/**
 * A page allowing user change of name, address, phone, password, and alert notification.
 * 
 * @author David Lin
 */
public class SettingsPage extends BasePage {

  /** Support serialization. */
  private static final long serialVersionUID = 1L;

  /** SettingsPage constructor. */
  public SettingsPage() {
    // Add the form to change contact information.
    Form<String> form1 = new Form<String>("form1");
    form1.add(new TextField<String>("firstname"));
    form1.add(new TextField<String>("lastname"));
    form1.add(new TextField<String>("homephone"));
    form1.add(new TextField<String>("cellphone"));
    form1.add(new TextField<String>("address"));
    form1.add(new Button("Submit") {
      private static final long serialVersionUID = 1L;

      /** Display the page again. */
      @Override
      public void onSubmit() {
        setResponsePage(SettingsPage.class);
      }
    });
    form1.add(new Button("Cancel") {
      private static final long serialVersionUID = 1L;

      /** Display the page again. */
      @Override
      public void onSubmit() {
        setResponsePage(SettingsPage.class);
      }
    });
    add(form1);
    this.tabId = 7;
    
    // Add the form to change login information.
    Form<String> form2 = new Form<String>("form2");
    form2.add(new TextField<String>("newusername"));
    form2.add(new TextField<String>("currentpw"));
    form2.add(new TextField<String>("newpw"));
    form2.add(new Button("Submit2") {
      private static final long serialVersionUID = 1L;

      /** Display the page again. */
      @Override
      public void onSubmit() {
        setResponsePage(SettingsPage.class);
      }
    });
    form2.add(new Button("Cancel2") {
      private static final long serialVersionUID = 1L;

      /** Display the page again. */
      @Override
      public void onSubmit() {
        setResponsePage(SettingsPage.class);
      }
    });
    add(form2);

    // Add the form to change alert notifications.
    Form<String> form3 = new Form<String>("form3");
    form3.add(new TextField<String>("cellphone2"));
    form3.add(new TextField<String>("email"));
    form3.add(new Button("Submit3") {
      private static final long serialVersionUID = 1L;

      /** Display the page again. */
      @Override
      public void onSubmit() {
        setResponsePage(SettingsPage.class);
      }
    });
    form3.add(new Button("Cancel3") {
      private static final long serialVersionUID = 1L;

      /** Display the page again. */
      @Override
      public void onSubmit() {
        setResponsePage(SettingsPage.class);
      }
    });
    add(form3);
  }
}
