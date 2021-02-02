package br.com.alura.gerenciador.acao;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.alura.gerenciador.controler.FlowJson;
import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class EmpresasJson implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	List<Empresa> empresas = new Banco().getEmpresas();

	Gson gson = new Gson();

	String json = gson.toJson(empresas);

	return new FlowJson(json);
    }

}
