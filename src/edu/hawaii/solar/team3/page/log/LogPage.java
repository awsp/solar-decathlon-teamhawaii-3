package edu.hawaii.solar.team3.page.log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.PropertyModel;
import edu.hawaii.solar.team3.page.BasePage;

/**
 * Keeps a log of system events, user messages, and historical usage of the system.
 * 
 * @author Nathan Dorman
 */
public class LogPage extends BasePage {

  /** Support serialization. */
  private static final long serialVersionUID = 1L;

  private String message = "[type your time period]";

  /** Page. */
  public LogPage() {

    this.tabId = 9;
    Form<String> form2 = new Form<String>("form2");

    form2.add(new Button("Submit2") {
      private static final long serialVersionUID = 1L;

      /** Display the page again, now with the updated values of field1 and field2. */
      @Override
      public void onSubmit() {
        setResponsePage(LogPage.class);
      }
    });
    form2.add(new Button("Cancel2") {
      private static final long serialVersionUID = 1L;

      /** Display the page again, now with the updated values of field1 and field2. */
      @Override
      public void onSubmit() {
        setResponsePage(LogPage.class);
      }
    });

    Form<String> form3 = new Form<String>("form3");

    // Initialize our list of Event instances.
    List<Event> Events = new ArrayList<Event>();
    Events.add(new Event("20101110@1155", "System", "Unplanned system shutdown"));
    Events.add(new Event("20101105@1412", "User", "Don't forget to water the lawn"));
    Events.add(new Event("20101104@1013", "User", "Buy some eggs."));
    Events.add(new Event("20101030@0930", "User", "Do something"));
    Events.add(new Event("20101028@2230", "System", "System update"));

    // Create the dataview to display our list of Event instances.
    DataView<Event> dataView =
        new DataView<Event>("EventList", new ListDataProvider<Event>(Events)) {
          /** For serialization. */
          private static final long serialVersionUID = 1L;

          /**
           * Display each row in the table.
           * 
           * @param item A Event instance to be displayed.
           */
          public void populateItem(Item<Event> item) {
            Event Event = item.getModelObject();
            item.add(new Label("time", Event.getTime()));
            item.add(new Label("user", Event.getUser()));
            item.add(new Label("message", Event.getMessage()));
          }
        };

    PropertyModel<String> messageModel = new PropertyModel<String>(this, "message");
    Form<String> form4 = new Form<String>("form4");
    form4.add(new TextField<String>("msg", messageModel));
    form3.add(form4);

    // Add the dataview to the TablePage.
    // add(dataView);
    form2.add(dataView);
    add(form2);
    add(form3);

  }

  /**
   * Returns the message.
   * 
   * @return The message.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message.
   * 
   * @param message the message.
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * An inner class implementing a record of data to be displayed as a row in the table. Package
   * private so that TestTablePage can access it.
   * 
   * @author Nathan Dorman
   * 
   */
  static class Event implements Serializable {
    /** Support serialization. */
    private static final long serialVersionUID = 2L;

    private String time;
    private String user;
    private String message;

    /**
     * Create a new Event, given a name and an address.
     * 
     * @param time the event time.
     * @param user the reporting user.
     * @param message the message.
     */
    public Event(String time, String user, String message) {
      this.time = time;
      this.user = user;
      this.message = message;
    }

    /**
     * Return the time.
     * 
     * @return The time of this message.
     */
    public String getTime() {
      return time;
    }

    /**
     * Return the user of this message.
     * 
     * @return The user.
     */
    public String getUser() {
      return user;
    }

    /**
     * Return the message.
     * 
     * @return The message.
     */
    public String getMessage() {
      return message;
    }
  }

}
