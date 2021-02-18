package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.controler.Redirect;

public class Logout implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	HttpSession session = request.getSession();

	session.removeAttribute("usuarioLogado");
	session.invalidate();

	return new Redirect("FormLogin");
    }

}
