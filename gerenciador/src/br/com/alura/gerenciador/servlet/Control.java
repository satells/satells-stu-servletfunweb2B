package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.ListaEmpresa;

@WebServlet(urlPatterns = "/entrada")
public class Control extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String acao = request.getParameter("acao");
	if (acao.equals("ListaEmpresas")) {
	    System.out.println("Lista empresas.");

	    ListaEmpresa listaEmpresas = new ListaEmpresa();

	    listaEmpresas.executa(request, response);
	} else if (acao.equals("RemoveEmpresa")) {
	    System.out.println("Remove empresa");
	} else if (acao.equals("MostraEmpresa")) {
	    System.out.println("Mostra empresa");
	}
    }
}