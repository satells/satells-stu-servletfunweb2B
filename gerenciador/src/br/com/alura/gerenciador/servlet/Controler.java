package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Util;
import br.com.alura.gerenciador.acao.Acao;

@WebServlet(urlPatterns = "/entrada")
public class Controler extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static ResourceBundle BUNDLE = ResourceBundle.getBundle("dependencies", Locale.getDefault());

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	try {
	    String parametro = request.getParameter(Util.PARAMETER);

	    Acao acao = criaInstancia(Acao.class, parametro);

	    String result = acao.exec(request, response);

	    if (acao.isForward()) {
		RequestDispatcher rd = request.getRequestDispatcher(result);
		rd.forward(request, response);
	    } else if (acao.isRedirect()) {
		response.sendRedirect(result);
	    }

	} catch (IOException e) {
	    throw new ServletException(e);
	}
    }

    private <T> T criaInstancia(Class<T> classe, String parametro) throws ServletException {
	try {
	    String nomeDaClasse = BUNDLE.getString("SemAcao");
	    if (parametro != null) {
		nomeDaClasse = BUNDLE.getString(parametro);
	    }
	    Class<?> clazz = Class.forName(nomeDaClasse);
	    return clazz.asSubclass(classe).newInstance();
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    throw new ServletException(e);
	}

    }
}
