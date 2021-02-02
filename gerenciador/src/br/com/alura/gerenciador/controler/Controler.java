package br.com.alura.gerenciador.controler;

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

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	String parametro = request.getParameter(Util.ACAO);

	Acao acao = Util.createInstance(Acao.class, parametro);

	HttpFlow flow = acao.exec(request, response);

	flow.send(request, response);
    }

}