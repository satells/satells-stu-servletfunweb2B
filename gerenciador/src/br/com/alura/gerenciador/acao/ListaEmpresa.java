package br.com.alura.gerenciador.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controler.Forward;
import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresa implements Acao {

    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	List<Empresa> lista = new Banco().getEmpresas();

	request.setAttribute("empresas", lista);

	return new Forward("listaEmpresas.jsp");

    }
}