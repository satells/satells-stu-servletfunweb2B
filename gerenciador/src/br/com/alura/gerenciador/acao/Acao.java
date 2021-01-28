package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Acao {

    public abstract String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException;

    private boolean isForward = false;

    private boolean isRedirect = false;

    protected void forwardTrue() {
	this.isForward = true;
	this.isRedirect = !this.isForward;
    }

    protected void redirectTrue() {
	this.isRedirect = true;
	this.isForward = !this.isRedirect;
    }

    public boolean isRedirect() {
	return isRedirect;
    }

    public boolean isForward() {
	return isForward;
    }

}
