package br.com.alura.gerenciador.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.controler.FlowXml;
import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class EmpresasXml implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	XStream xStream = new XStream();
	Banco banco = new Banco();
	List<Empresa> empresas = banco.getEmpresas();

	xStream.alias("empresa", Empresa.class);
	xStream.alias("empresas", List.class);

	String xml = xStream.toXML(empresas);

	return new FlowXml(xml);
    }

}
