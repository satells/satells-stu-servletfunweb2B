package br.com.alura.gerenciador.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
	UtilListener.print(this.getClass(), "Attribute Added: ", se.getName(), se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
	UtilListener.print(this.getClass(), "Attribute Removed: ", se.getName(), se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
	UtilListener.print(this.getClass(), "Attribute Replaced: ", se.getName(), se.getValue());
    }
}
