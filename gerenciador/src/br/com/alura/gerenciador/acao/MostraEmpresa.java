package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controler.DispatcherRequest;
import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	try {
	    String paramId = request.getParameter("id");
	    Integer id = Integer.valueOf(paramId);

	    Banco banco = new Banco();

	    Empresa empresa = banco.buscaEmpresaPelaId(id);

	    System.out.println(empresa.getNome());
	    System.out.println("Editando empresa: " + empresa.getNome());

	    request.setAttribute("empresa", empresa);

	    return new DispatcherRequest("formAlteraEmpresa.jsp");
	} catch (NumberFormatException e) {
	    throw new ServletException(e);
	}

    }

}
