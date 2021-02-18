package br.com.alura.gerenciador.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

public class MyHttpSessionIdListener implements HttpSessionIdListener {

    @Override
    public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
	UtilListener.print(this.getClass(), "Session Id Changed: ", oldSessionId);
    }
}
