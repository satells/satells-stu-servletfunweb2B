package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.controler.Redirect;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	Usuario usuario = new Banco().existeUsuario(login, senha);

	if (usuario != null) {

	    System.out.println("Usuário existe ");

	    HttpSession sessao = request.getSession();
	    sessao.setAttribute("usuarioLogado", usuario);

	    return new Redirect("Main");
	} else {
	    return new Redirect("FormLogin");
	}
    }
}