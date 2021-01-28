package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa extends Acao {

    private static final String LOCATION = "entrada?acao=ListaEmpresas";

    @Override
    public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	try {
	    String paramId = request.getParameter("id");
	    Integer id = Integer.valueOf(paramId);

	    System.out.println(id);

	    Banco banco = new Banco();
	    banco.removeEmpresa(id);

	    redirectTrue();
	    return LOCATION;
	} catch (NumberFormatException e) {
	    throw new ServletException(e);
	}
    }
}
