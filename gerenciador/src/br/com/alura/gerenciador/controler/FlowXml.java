package br.com.alura.gerenciador.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlowXml extends HttpFlow {

    public FlowXml(String location) {
	super(location);
    }

    @Override
    public void send(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	try {
	    response.setContentType("application/xml");
	    response.getWriter().print(location);

	} catch (IOException e) {
	    throw new ServletException(e);
	}
    }

}
