package br.com.alura.gerenciador.controler;

import java.util.Locale;
import java.util.ResourceBundle;

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
	String parametro = request.getParameter(Util.PARAMETER);

	Acao acao = criaInstancia(Acao.class, parametro);

	HttpFlow flow = acao.exec(request, response);

	flow.send(request, response);

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
