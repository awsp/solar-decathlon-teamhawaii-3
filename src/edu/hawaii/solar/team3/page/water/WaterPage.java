package edu.hawaii.solar.team3.page.water;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import edu.hawaii.solar.team3.page.ExternalImageUrl;
import edu.hawaii.solar.team3.page.BasePage;

/**
 * A page illustrating the construction of a form.
 * 
 * @author Philip Johnson
 */
public class WaterPage extends BasePage {

  /** Support serialization. */
  private static final long serialVersionUID = 1L;

  /** Page. */
  public WaterPage() {
    //
    add(new MultiLineLabel("sprinkler", "Sprinkler System Status: ON\n " + "Timer: 0 - 60 min."));

    add(new Label("gas", "Switch to gas"));

    add(new MultiLineLabel("temperature", "Hot water temperature: 110F\n "
        + "available gallons: 30"));

    String chartURL =
        "http://chart.apis.google.com/chart?chxl=1:"
            + "|11%2F02%2F09|01%2F07%2F10|03%2F06%2F10|05%2F07%2F10|"
            + "07%2F07%2F10|09%2F08%2F10|11%2F05%2F10|to+date" + "&chxr=0,0,400" + "&chxt=y,x"
            + "&chbh=r,8" + "&chs=500x300" + "&cht=bvg" + "&chco=3072F3" + "&chds=5,400"
            + "&chd=t:144.171,248.445,310.392,314.92,283.363,254.983,239.443,220.841"
            + "&chtt=Average+Daily+Usage";

    add(new ExternalImageUrl("googleChart", chartURL, "500", "300"));

    this.tabId = 2;

    // Initialize our list of Contact instances.
    List<Bill> contacts = new ArrayList<Bill>();
    contacts.add(new Bill("to date", 96.65, 8, 32, 250));
    contacts.add(new Bill("11/05/2010", 193.09, 16, 61, 262));
    contacts.add(new Bill("09/08/2010", 201.03, 18, 63, 286));
    contacts.add(new Bill("07/07/2010", 206.26, 19, 58, 328));
    contacts.add(new Bill("05/07/2010", 216.72, 21, 62, 339));
    contacts.add(new Bill("03/06/2010", 199.48, 22, 62, 355));
    contacts.add(new Bill("01/07/2010", 189.26, 21, 62, 339));
    contacts.add(new Bill("11/02/2009", 175.24, 18, 59, 305));

    // Create the dataview to display our list of contact instances.
    DataView<Bill> dataView = new DataView<Bill>("bill", new ListDataProvider<Bill>(contacts)) {
      /** For serialization. */
      private static final long serialVersionUID = 1L;

      /**
       * Display each row in the table.
       * 
       * @param item A Contact instance to be displayed.
       */
      public void populateItem(Item<Bill> item) {
        Bill contact = item.getModelObject();
        item.add(new Label("date", contact.getDate()));
        item.add(new Label("amount", "$" + contact.getAmount()));
        item.add(new Label("gallons", "" + contact.getGallons()));
        item.add(new Label("days", "" + contact.getDays()));
        item.add(new Label("perDay", "" + contact.getGallonsPerDay()));
      }
    };

    // Add the dataview to the TablePage.
    add(dataView);
  }

  /**
   * An inner class implementing a record of data to be displayed as a row in the table. Package
   * private so that TestTablePage can access it.
   * 
   * @author Nathan Dorman.
   */
  static class Bill implements Serializable {
    /** Support serialization. */
    private static final long serialVersionUID = 2L;
    private String date;
    private double amount;
    private int gallons;
    private int days;
    private int gallonsPerDay;

    /**
     * Create a new contact, given a name and an address.
     * 
     * @param date The date.
     * @param amount The amount.
     * @param gallons The gallons.
     * @param days The days.
     * @param gallonsPerDay The gallons used per day.
     */
    public Bill(String date, double amount, int gallons, int days, int gallonsPerDay) {
      this.date = date;
      this.amount = amount;
      this.gallons = gallons;
      this.days = days;
      this.gallonsPerDay = gallonsPerDay;

    }

    /**
     * Return the gallons spent per day.
     * 
     * @return The gallons spent per day.
     */
    public int getGallonsPerDay() {
      return this.gallonsPerDay;
    }

    /**
     * Return the days in the period.
     * 
     * @return The number of days in selected period.
     */
    public int getDays() {
      return this.days;
    }

    /**
     * Return the gallons in the thousands.
     * 
     * @return The gallons used for selected period.
     */
    public int getGallons() {
      return this.gallons;
    }

    /**
     * Return the amount.
     * 
     * @return The amount paid for selected period.
     */
    public double getAmount() {
      return this.amount;
    }

    /**
     * Return the date.
     * 
     * @return The date of selected period.
     */
    public String getDate() {
      return this.date;
    }
  }
}
