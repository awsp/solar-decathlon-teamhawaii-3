package edu.hawaii.solar.team3.page;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import edu.hawaii.solar.team3.page.ac.AcPage;
import edu.hawaii.solar.team3.page.aquaponics.AquaponicsPage;
import edu.hawaii.solar.team3.page.energy.EnergyPage;
import edu.hawaii.solar.team3.page.entertainment.EntertainmentPage;
import edu.hawaii.solar.team3.page.help.HelpPage;
import edu.hawaii.solar.team3.page.home.HomePage;
import edu.hawaii.solar.team3.page.lighting.LightingPage;
import edu.hawaii.solar.team3.page.log.LogPage;
import edu.hawaii.solar.team3.page.security.SecurityPage;
import edu.hawaii.solar.team3.page.settings.SettingsPage;
import edu.hawaii.solar.team3.page.water.WaterPage;

/**
 * A Base page that serves as the superclass for all pages in this application.
 * The four pages (HomePage, ListPage, FormPage, and TablePage) all inherit from this class.
 * This class also adds the CSS stylesheets that will be used by all pages. 
 *  
 * @author Philip Johnson
 *
 */
public abstract class BasePage extends WebPage {
  
  /** Support serialization. */
  private static final long serialVersionUID = 1L;
  
  /** Tab id. */
  public int tabId = 0;
  
  /** Tab selected class.*/
  public String tabClass = "tab-selected";
  
  /** CSS type.*/
  public String tabType = "class";
  
  /**
   * The base page layout used by all pages. 
   * This includes a title and the links that appear in the tabbed menu. 
   */
  public BasePage() {
    // Add CSS definitions for use in all pages
    add(CSSPackageResource.getHeaderContribution(
    edu.hawaii.solar.team3.page.BasePage.class, "style/customtheme/jquery-ui-1.8.7.custom.css"));
    add(CSSPackageResource.getHeaderContribution(
        edu.hawaii.solar.team3.page.BasePage.class, "style/boilerplate/screen.css", "screen"));
    add(JavascriptPackageResource.getHeaderContribution(
        edu.hawaii.solar.team3.page.BasePage.class, "style/jquery-1.4.4.min.js"));
    add(JavascriptPackageResource.getHeaderContribution(
        edu.hawaii.solar.team3.page.BasePage.class, "style/jquery-ui-1.8.7.custom.min.js"));
    add(CSSPackageResource.getHeaderContribution(
    edu.hawaii.solar.team3.page.BasePage.class, "style/jquery.jgrowl.css", "screen"));
    add(JavascriptPackageResource.getHeaderContribution(
        edu.hawaii.solar.team3.page.BasePage.class, "style/jquery.jgrowl.min.js"));
    add(JavascriptPackageResource.getHeaderContribution(
        edu.hawaii.solar.team3.page.BasePage.class, "style/jquery.scale.js"));
    add(new Label("title", "Solar Decathlon Teamhawaii 3"));
    
    
    // Now add the links that go in the tabs. 
    add(new Link<String>("HomePageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new HomePage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag);
         if (tabId == 1) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("WaterPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new WaterPage());
      } 
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 2) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("AcPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new AcPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 3) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("AquaponicsPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new AquaponicsPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 4) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("EntertainmentPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new EntertainmentPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 5) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("EnergyPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new EnergyPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 6) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("SettingsPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new SettingsPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 7) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("SecurityPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new SecurityPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 8) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("LogPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new LogPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 9) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("LightingPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new LightingPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 10) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
    
    add(new Link<String>("HelpPageLink") {
      private static final long serialVersionUID = 1L;
      /** Upon clicking this link, go to FormPage. */
      @Override
      public void onClick() {
        setResponsePage(new HelpPage());
      }
      @Override 
      protected void onComponentTag(final ComponentTag tag) { 
         super.onComponentTag(tag); 
         if (tabId == 11) {
           tag.put(tabType, tabClass);
         }
      } 
      }
    );
  }
}
