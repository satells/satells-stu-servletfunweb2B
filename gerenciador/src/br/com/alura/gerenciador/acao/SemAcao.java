package br.com.alura.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SemAcao extends Acao {

    @Override
    public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	return "";
    }
}