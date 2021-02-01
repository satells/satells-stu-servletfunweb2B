package br.com.alura.gerenciador.acao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.controler.Redirect;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	try {
	    System.out.println("Alterando empresa");

	    String nomeEmpresa = request.getParameter("nome");
	    String paramDataEmpresa = request.getParameter("data");
	    String paramId = request.getParameter("id");
	    Integer id = Integer.valueOf(paramId);

	    Date dataAbertura = null;
	    try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataAbertura = sdf.parse(paramDataEmpresa);
	    } catch (ParseException e) {
		throw new ServletException(e);
	    }

	    System.out.println(id);

	    Banco banco = new Banco();
	    Empresa empresa = banco.buscaEmpresaPelaId(id);
	    empresa.setNome(nomeEmpresa);
	    empresa.setDataAbertura(dataAbertura);

	    return new Redirect("ListaEmpresas");
	} catch (NumberFormatException e) {
	    throw new ServletException(e);
	}
    }
}