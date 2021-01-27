package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet(urlPatterns = "/entrada")
public class Controler extends HttpServlet {

    private static final String PARAMETER = "acao";
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	    String parametro = request.getParameter(PARAMETER);

	    Acao acao = criaInstancia(Acao.class, parametro);

	    acao.executa(request, response);
	} catch (Exception e) {
	    throw new ServletException(e);
	}
    }

    private static ResourceBundle BUNDLE = ResourceBundle.getBundle("dependencies", Locale.getDefault());

    private <T> T criaInstancia(Class<T> classe, String parametro) throws ServletException {
	try {
	    String nomeDaClasse = BUNDLE.getString(parametro);

	    Class<?> clazz = Class.forName(nomeDaClasse);
	    return clazz.asSubclass(classe).newInstance();
	} catch (Exception e) {
	    throw new ServletException(e);
	}
    }
}