package br.com.alura.gerenciador.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
	System.out.println("attributeAdded: " + se.getName() + " - " + se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
	System.out.println("attributeRemoved: " + se.getName() + " - " + se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
	System.out.println("attributeReplaced: " + se.getName() + " - " + se.getValue());
    }
}
