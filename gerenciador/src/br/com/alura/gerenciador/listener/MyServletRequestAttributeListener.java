package br.com.alura.gerenciador.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
	UtilListener.print(this.getClass(), "Attribute Added: ", srae.getName(), srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
	UtilListener.print(this.getClass(), "Attribute Removed: ", srae.getName(), srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
	UtilListener.print(this.getClass(), "Attribute Replaced: ", srae.getName(), srae.getValue());
    }

}
