package com.freeroom.projectci;

import com.freeroom.web.Apollo;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

//mvn exec:java -Dexec.mainClass="com.freeroom.projectci.Server"
public class Server {
    public static void main(final String[] args) throws Exception
    {
        final org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
        final ServletContextHandler context = new ServletContextHandler(SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new Apollo("com.freeroom.projectci.beans")), "/*");

        server.start();
        server.join();
    }
}
