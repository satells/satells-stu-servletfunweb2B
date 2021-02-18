package br.com.alura.gerenciador.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
	UtilListener.print(this.getClass(), "Session Did Activate: ");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
	UtilListener.print(this.getClass(), "Session Will Passivate: ");

    }
}
