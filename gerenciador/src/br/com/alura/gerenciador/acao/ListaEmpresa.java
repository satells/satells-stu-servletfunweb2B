package br.com.alura.gerenciador.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresa extends Acao {

    private static final String LOCATION = "/listaEmpresas.jsp";

    @Override
    public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	List<Empresa> lista = new Banco().getEmpresas();

	request.setAttribute("empresas", lista);

	forwardTrue();
	return LOCATION;

    }
}