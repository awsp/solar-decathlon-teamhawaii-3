package edu.hawaii.solar.team3;

import org.apache.wicket.protocol.http.WicketServlet;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 * Enables this web application to run inside the Jetty container. 
 * 
 * @author Philip Johnson
 */
public class Jetty {
  
  /** The port used by this webapp. */
  private static int port = 7070;
  /** The context root. */
  private static String contextPath = "solar-decathlon-teamhawaii-3"; 
  /** The class corresponding to this web application. */
  private static String applicationClass = "edu.hawaii.solar.team3.ExampleApplication";

  /**
   * Starts up Jetty and points it at Wicket.
   * This method does not return until Jetty is shut down. 
   * Jetty will check every five seconds for keyboard input from the console, and if it gets some,
   * it will shutdown.
   * @param args Ignored.
   * @throws Exception If things go wrong. 
   */
  public static void main(String[] args) throws Exception {
    Server server = new Server(port);
    Context context = new Context(server, "/" + contextPath, Context.SESSIONS);

    ServletHolder servletHolder = new ServletHolder(new WicketServlet());
    servletHolder.setInitParameter("applicationClassName", applicationClass);
    servletHolder.setInitOrder(1);
    context.addServlet(servletHolder, "/*");
    try {
      server.start();
      System.out.printf("%nApplication at http://localhost:%s/%s.%n",
          port, contextPath);
      System.out.printf("%nWe recommend Safari or Chrome web browsers for the best experience.%n");

      System.out.printf("%nPress return to exit.%n");
      while (System.in.available() == 0) {
        Thread.sleep(5000);
      }
      server.stop();
      server.join();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
