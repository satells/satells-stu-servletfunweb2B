package br.com.alura.gerenciador.acao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.controler.RedirectResponse;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	System.out.println("Cadastrando nova empresa");

	String nomeEmpresa = request.getParameter("nome");
	String paramDataEmpresa = request.getParameter("data");

	Date dataAbertura = null;
	try {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    dataAbertura = sdf.parse(paramDataEmpresa);
	} catch (ParseException e) {
	    throw new ServletException(e);
	}

	Empresa empresa = new Empresa();
	empresa.setNome(nomeEmpresa);
	empresa.setDataAbertura(dataAbertura);

	Banco banco = new Banco();
	banco.adiciona(empresa);

	request.setAttribute("empresa", empresa.getNome());

	return new RedirectResponse("ListaEmpresas");
    }
}
