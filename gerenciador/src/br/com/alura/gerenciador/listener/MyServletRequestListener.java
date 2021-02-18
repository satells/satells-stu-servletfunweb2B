package br.com.alura.gerenciador.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    private long start = 0;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
	UtilListener.print(this.getClass(), "Request Destroyed: ", sre.getServletRequest().getParameter("acao"), "Execution Time: " + (System.currentTimeMillis() - start));

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
	start = System.currentTimeMillis();
	UtilListener.print(this.getClass(), "Request Initialized: ", sre.getServletRequest().getParameter("acao"));
    }
}
