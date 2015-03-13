package edu.hawaii.solar.team3.page.help;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import edu.hawaii.solar.team3.page.BasePage;

/**
 * Helps the user perform tasks on the system.
 * 
 * @author Nathan Dorman
 */
public class HelpPage extends BasePage {

  /** Support serialization. */
  private static final long serialVersionUID = 1L;

  /**
   * HelpPage constructor.
   */
  public HelpPage() {

    add(new MultiLineLabel("usage", "" 
        + "Energy management\n" 
        + "Water management\n"
        + "Security management\n" 
        + "Aquaponics management\n" 
        + "Lighting controls\n"
        + "Climate controls\n" 
        + "Entertainment controls\n" 
        + "Electrical\n"));

    add(new MultiLineLabel("issues", "" 
        + "How do I change the volume on the speakers?\n"
        + "How do I adjust the AC?\n" 
        + "Who do I contact if something breaks?\n"
        + "How do I adjust the water levels?\n" 
        + "How do I turn off the lights\n" 
        + " \n \n "));

    add(new MultiLineLabel("other", "Issues\nForum\nDocumentation"));
    this.tabId = 11;

    // Initialize our list of Contact instances.
    List<Contact> contacts = new ArrayList<Contact>();
    contacts.add(new Contact("Joe Smith", "Electricial", "965-2345"));
    contacts.add(new Contact("Sally Forth", "Plumber", "932-1234"));

    // Create the dataview to display our list of contact instances.
    DataView<Contact> dataView =
        new DataView<Contact>("ContactList", new ListDataProvider<Contact>(contacts)) {
          /** For serialization. */
          private static final long serialVersionUID = 1L;

          /**
           * Display each row in the table.
           * 
           * @param item A Contact instance to be displayed.
           */
          public void populateItem(Item<Contact> item) {
            Contact contact = item.getModelObject();
            item.add(new Label("Name", contact.getName()));
            item.add(new Label("Job", contact.getJob()));
            item.add(new Label("Phone", contact.getPhone()));
          }
        };

    // Add the dataview to the TablePage.
    add(dataView);
  }

  /**
   * An inner class implementing a record of emergency contacts.
   * 
   * @author Nathan Dorman
   */
  static class Contact implements Serializable {
    /** Support serialization. */
    private static final long serialVersionUID = 2L;
    private String name;
    private String job;
    private String phone;

    /**
     * Create a new contact, given a name and an address.
     * 
     * @param name The name.
     * @param phone The phone.
     * @param job The job title.
     */
    public Contact(String name, String job, String phone) {
      this.name = name;
      this.phone = phone;
      this.job = job;
    }

    /**
     * Return the name.
     * 
     * @return The name of this contact.
     */
    public String getName() {
      return name;
    }

    /**
     * Return the phone of this contact.
     * 
     * @return The address.
     */
    public String getPhone() {
      return phone;
    }

    /**
     * Return the job of this contact.
     * 
     * @return The address.
     */
    public String getJob() {
      return job;
    }
  }
}
