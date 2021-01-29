package br.com.alura.gerenciador.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Forward extends HttpFlow {

    public Forward(String location) {
	super(location);
    }

    @Override
    public void send(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	try {
	    System.out.println("forward");
	    RequestDispatcher rd = request.getRequestDispatcher(this.location);
	    rd.forward(request, response);
	} catch (IOException e) {
	    throw new ServletException(e);
	}
    }
}