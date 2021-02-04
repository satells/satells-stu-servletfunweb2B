package br.com.alura.gerenciador.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Util;
import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.controler.HttpFlow;

//@WebServlet(urlPatterns = "/entrada")
public class ControllerFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
	System.out.println("Controler  ->>>-  Filter");
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;

	String parametro = request.getParameter(Util.ACAO);

	Acao acao = Util.createInstance(Acao.class, parametro);

	HttpFlow flow = acao.exec(request, response);

	flow.send(request, response);
	System.out.println("--------------------------------------------------------------------------------------");

    }

}