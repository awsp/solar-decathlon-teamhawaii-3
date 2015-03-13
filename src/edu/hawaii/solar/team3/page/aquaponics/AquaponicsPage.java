package edu.hawaii.solar.team3.page.aquaponics;

import edu.hawaii.solar.team3.page.BasePage;
import edu.hawaii.solar.team3.page.ExternalImageUrl;

/**
 * A page displaying the current gas distribution and water level of aquaponics tank.
 * Allows for user control of gas balance and water level.
 *  
 * @author David Lin
 */
public class AquaponicsPage extends BasePage {

  /** Support serialization. */
  private static final long serialVersionUID = 1L;

  /** AquaponicsPage constructor. */
  public AquaponicsPage() {
    // Add Google visualization graph for gas distribution.
    String gasChartURL =
        "http://chart.apis.google.com/chart?chxs=0,000000,11.5&chxt=x&chs=380x300&cht=p3"
            + "&chco=224499|80C65A|FF9900|990066&chd=t:42,35,21,2&chdl=Oxygen|Nitrogen|"
            + "Carbon+Dioxide|Other&chdlp=b&chp=0.6&chl=42%25|35%25|21%25|2%25&chma=30,30&"
            + "chtt=Gas+Distribution&chts=000000,14";
    add(new ExternalImageUrl("gas", gasChartURL, "380", "300"));

    // Add Google visualization graph for water level in the tank.
    String waterChartURL =
        "http://chart.apis.google.com/chart?chxl=0:|12am|6am|12pm|6pm|1:|6|6.25|6.5|6.75|7|"
            + "7.25|7.5|7.75|8&chxr=0,0,4|1,0,8&chxs=0,000000,11.5,0,l,000000|1,000000,11.5,0,l,"
            + "000000&chxt=x,y&chs=385x260&cht=lc&chco=0000FF&chds=6,8&chd=t:7.069,6.85,7.146,7.32"
            + ",7.186,6.813,6.782,6.499&chg=0,25&chls=5&chtt=pH+of+Water+Tank&chts=000000,14";
    add(new ExternalImageUrl("watertank", waterChartURL, "380", "261"));
    
    this.tabId = 4;
  }
}
