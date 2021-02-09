package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet(urlPatterns = "/empresas")
public class EmpresasServlet extends HttpServlet {

    private static final long serialVersionUID = 7452838788717546565L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	List<Empresa> empresasList = new Banco().getEmpresas();
	String acceptValue = request.getHeader("Accept");
	System.out.println(acceptValue);
	String resultado = null;
	if (acceptValue.endsWith("/json")) {
	    Gson gson = new Gson();
	    resultado = gson.toJson(empresasList);
	} else if (acceptValue.endsWith("/xml")) {
	    XStream xStream = new XStream();
	    xStream.alias("empresa", Empresa.class);
	    xStream.alias("empresas", List.class);
	    resultado = xStream.toXML(empresasList);
	} else {
	    acceptValue = "application/json";
	    resultado = "{'message': 'no content'}";
	}

	response.setContentType(acceptValue);
	response.getWriter().print(resultado);
    }

}
