package br.com.alura.gerenciador.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
	UtilListener.print(this.getClass(), "Context Destroyed: ");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	UtilListener.print(this.getClass(), "Context Initialized: ");
    }

}
