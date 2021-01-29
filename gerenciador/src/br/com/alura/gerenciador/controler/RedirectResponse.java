package br.com.alura.gerenciador.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectResponse extends HttpFlow {

    public RedirectResponse(String location) {
	super(location);
    }

    @Override
    public void send(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	try {
	    response.sendRedirect(location);
	} catch (IOException e) {
	    throw new ServletException(e);
	}
    }
}
