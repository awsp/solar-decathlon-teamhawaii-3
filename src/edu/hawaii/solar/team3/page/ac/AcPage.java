package edu.hawaii.solar.team3.page.ac;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import edu.hawaii.solar.team3.page.BasePage;
import edu.hawaii.solar.team3.page.ExternalImageUrl;

/**
 * A page displaying the current temperature, humidity, and schedule.
 * Allows for user control of target temperature, humidity, AC on/off, and scheduler.
 * 
 * @author David Lin
 */
public class AcPage extends BasePage {

  /** Support serialization. */
  private static final long serialVersionUID = 1L;

  /** AcPage constructor. */
  public AcPage() {
    // Add Google visualization graph for temperature.
    String chartURL =
        "http://chart.apis.google.com/chart?chxl=0:|12am|4am|8am|12pm|4pm|8pm&chxr=0,0,5|1,50,90"
            + "&chxs=0,000000,11.5,0,l,000000|1,000000,11.5,0,l,000000&chxt=x,y&chbh=a,5,15"
            + "&chs=380x250&cht=bvg&chco=3399CC,AA0033&chds=50,90,50,90&chd=t:76.397,75.214,"
            + "76.934,74.172,78.165,81.84|74.788,71.857,72.667,79.037,84.493,79.947&chdl=Indoor"
            + "|Outdoor&chdlp=b&chg=0,25&chtt=Temperature+(F)&chts=000000,14";
    add(new ExternalImageUrl("chart", chartURL, "380", "250"));

    this.tabId = 3;
    
    // Initialize list of schedule instances.
    List<Schedule> schedules = new ArrayList<Schedule>();
    schedules.add(new Schedule("Monday", "8:00 AM", "Off", "NA", "NA"));
    schedules.add(new Schedule("Monday", "3:00 PM", "On", "75.0 F", "60%"));
    schedules.add(new Schedule("Monday", "11:00 PM", "On", "69.0 F", "50%"));
    schedules.add(new Schedule("Tuesday", "7:30 AM", "Off", "NA", "NA"));
    schedules.add(new Schedule("Tuesday", "5:00 PM", "On", "72.0 F", "60%"));
    schedules.add(new Schedule("Tuesday", "11:00 PM", "On", "69.0 F", "50%"));
    schedules.add(new Schedule("Wednesday", "8:00 AM", "Off", "NA", "NA"));
    schedules.add(new Schedule("Wednesday", "1:00 PM", "On", "71.0 F", "55%"));
    schedules.add(new Schedule("Wednesday", "11:00 PM", "On", "69.0 F", "50%"));

    // Create the dataview to display list of schedule instances.
    DataView<Schedule> dataView =
        new DataView<Schedule>("ScheduleList", new ListDataProvider<Schedule>(schedules)) {
          /** For serialization. */
          private static final long serialVersionUID = 1L;

          /**
           * Display each row in the table.
           * 
           * @param item A Schedule instance to be displayed.
           */
          public void populateItem(Item<Schedule> item) {
            Schedule schedule = item.getModelObject();
            item.add(new Label("Day", schedule.getDay()));
            item.add(new Label("Time", schedule.getTime()));
            item.add(new Label("AC", schedule.getAC()));
            item.add(new Label("Temperature", schedule.getTemperature()));
            item.add(new Label("Humidity", schedule.getHumidity()));
          }
        };

    // Add the dataview to the ACPage.
    add(dataView);
  }
}

/**
 * An inner class implementing a record of data to be displayed as a row in the table.
 * 
 * @author David Lin
 */
class Schedule implements Serializable {
  /** Support serialization. */
  private static final long serialVersionUID = 2L;
  private String day;
  private String time;
  private String AC;
  private String temperature;
  private String humidity;

  /**
   * Create a new schedule, given a day, time, AC, temperature, and humidity setting.
   * 
   * @param day The day.
   * @param time The time.
   * @param ac On or off.
   * @param temperature The temp.
   * @param humidity The humidity.
   */
  public Schedule(String day, String time, String ac, String temperature, String humidity) {
    this.day = day;
    this.time = time;
    this.AC = ac;
    this.temperature = temperature;
    this.humidity = humidity;
  }

  /**
   * Return the day.
   * 
   * @return The day.
   */
  public String getDay() {
    return day;
  }

  /**
   * Return the time.
   * 
   * @return The time.
   */
  public String getTime() {
    return time;
  }

  /**
   * Return whether AC is on or off.
   * 
   * @return The AC status.
   */
  public String getAC() {
    return AC;
  }

  /**
   * Return the temperature.
   * 
   * @return The temperature.
   */
  public String getTemperature() {
    return temperature;
  }

  /**
   * Return the humidity.
   * 
   * @return The humidity.
   */
  public String getHumidity() {
    return humidity;
  }
}