package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.controler.Redirect;
import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	try {
	    String paramId = request.getParameter("id");
	    Integer id = Integer.valueOf(paramId);

	    System.out.println(id);

	    Banco banco = new Banco();
	    banco.removeEmpresa(id);

	    return new Redirect("ListaEmpresas");

	} catch (NumberFormatException e) {
	    throw new ServletException(e);
	}
    }
}
