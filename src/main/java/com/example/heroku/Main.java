package com.example.heroku;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Jetty - Это аппликейшн сервер, как томкат
 * Тут он подгружается как либа, и стартуется вручную
 * Прям в мейн классе
 */
public class Main {

    public static void main(String[] args) throws Exception{
        // The port that we should run on can be set into an environment variable
        // Look for that variable and default to 8080 if it isn't there.
        // тут написано выше
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        final Server server = new Server(Integer.valueOf(webPort));
        // Тут создали сервер как объект
        final WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        // Parent loader priority is a class loader setting that Jetty accepts.
        // By default Jetty will behave like most web containers in that it will
        // allow your application to replace non-server libraries that are part of the
        // container. Setting parent loader priority to true changes this behavior.
        // Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
        root.setParentLoaderPriority(true);

        final String webappDirLocation = "src/main/webapp/";
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        // После запуска он полезет сюда
        root.setResourceBase(webappDirLocation);

        server.setHandler(root);
        // Настроили его

        server.start();
        server.join();
        // И запустили
    }
}
