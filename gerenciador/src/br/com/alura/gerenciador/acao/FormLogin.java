package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.controler.DispatcherRequest;
import br.com.alura.gerenciador.controler.HttpFlow;

public class FormLogin implements Acao {

    @Override
    public HttpFlow exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	return new DispatcherRequest("formLogin.jsp");
    }

}
