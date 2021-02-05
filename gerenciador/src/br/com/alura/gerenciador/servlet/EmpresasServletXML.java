package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet(urlPatterns = "/empresasxml")
public class EmpresasServletXML extends HttpServlet {

    private static final long serialVersionUID = 7452838788717546565L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Banco banco = new Banco();
	List<Empresa> empresas = banco.getEmpresas();

	XStream xStream = new XStream();
	xStream.alias("empresa", Empresa.class);
	xStream.alias("empresas", List.class);

	String xml = xStream.toXML(empresas);

	try {
	    response.setContentType("application/json");
	    response.getWriter().print(xml);

	} catch (IOException e) {
	    throw new ServletException(e);
	}

    }
}
