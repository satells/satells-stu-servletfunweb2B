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
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Util;
import br.com.alura.gerenciador.controler.HttpFlow;
import br.com.alura.gerenciador.controler.Redirect;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFiltro implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
	System.out.println("Autorizacao  ->>>-  Filtro");

	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;

	String parametro = request.getParameter(Util.ACAO);
	HttpSession session = request.getSession();

	boolean acaoNaoProtegida = acaoNaoProtegida(parametro);

	boolean usuarioNaoEstaLogado = usuarioNaoEstaLogado(session);
	if (usuarioNaoEstaLogado) {
	    if (acaoNaoProtegida) {
		HttpFlow redirect = new Redirect("FormLogin");
		redirect.send(request, response);
		return;
	    }
	} else {
	    if (parametro.equals("FormLogin")) {
		HttpFlow redirect = new Redirect("Main");
		redirect.send(request, response);
		return;
	    }
	}
	chain.doFilter(request, response);
    }

    private boolean acaoNaoProtegida(String parametro) {
	return !(parametro.equals("FormLogin") || parametro.equals("Login"));
    }

    private boolean usuarioNaoEstaLogado(HttpSession session) {
	return session.getAttribute("usuarioLogado") == null;
    }

}
