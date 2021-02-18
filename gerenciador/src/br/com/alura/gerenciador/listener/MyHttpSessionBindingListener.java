package br.com.alura.gerenciador.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {

	UtilListener.print(this.getClass(), "Value Bound: ", event.getName(), event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
	UtilListener.print(this.getClass(), "Value Unbound: ", event.getName(), event.getValue());
    }
}
