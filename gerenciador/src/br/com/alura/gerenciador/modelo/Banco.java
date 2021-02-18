package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<Empresa> lista = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    private static List<User> listaUsuarios = new ArrayList<>();

    static {
	addEmpresa("Casa das Ferramentas");
	addEmpresa("Mercado Boa Comida Ltda");
	addEmpresa("ATIVOS S.A. Securitizadora de Créditos Financeiros");
	addEmpresa("Banco do Brasil Agência Viena/Áustria");
	addEmpresa("BB Administradora de Cartões de Crédito S.A.");
	addEmpresa("BB Administradora de Consórcios S.A.");
	addEmpresa("BB Banco de Investimento S.A.");
	addEmpresa("BB Corretora de Seguros e Administradora de Bens S.A.");
	addEmpresa("BB ELO CARTÕES Participações S.A.");
	addEmpresa("BB Gestão de Recursos Distribuidora de Títulos e Valores Mobiliários S.A.");
	addEmpresa("BB Leasing Company Limited - Ilhas Cayman");
	addEmpresa("BB Leasing S.A. Arrendamento Mercantil");
	addEmpresa("BB Seguridade Participações S.A.");
	addEmpresa("BB Seguros Participações S.A.");
	addEmpresa("BESC Distribuidora de Títulos e Valores Mobiliários S.A.");
	addEmpresa("Brasilian American Merchant Bank");

	addUsuario("heitor", "123");
	addUsuario("mauro", "123");
    }

    private static void addUsuario(String login, String senha) {
	User u = new User();
	u.setLogin(login);
	u.setSenha(senha);
	listaUsuarios.add(u);
    }

    private static void addEmpresa(String nome) {
	Empresa empresa = new Empresa();
	empresa.setId(chaveSequencial++);
	empresa.setNome(nome);
	lista.add(empresa);
    }

    public void adiciona(Empresa empresa) {
	empresa.setId(Banco.chaveSequencial++);
	Banco.lista.add(empresa);
    }

    public List<Empresa> getEmpresas() {
	return Banco.lista;
    }

    public void removeEmpresa(Integer id) {

	Iterator<Empresa> it = lista.iterator();

	while (it.hasNext()) {
	    Empresa emp = it.next();

	    if (emp.getId() == id) {
		it.remove();
	    }
	}
    }

    public Empresa buscaEmpresaPelaId(Integer id) {
	for (Empresa empresa : lista) {
	    if (empresa.getId() == id) {
		return empresa;
	    }
	}
	return null;
    }

    public User existeUsuario(String login, String senha) {
	for (User usuario : listaUsuarios) {
	    if (usuario.ehIgual(login, senha)) {
		return usuario;
	    }
	}
	return null;
    }

}
