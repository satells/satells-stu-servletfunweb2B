<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
<li><a href="/gerenciador/entrada?acao=ListaEmpresas">Lista Empresas</a></li>
<li><a href="/gerenciador/entrada?acao=NovaEmpresaForm">Nova Empresa Formulário</a></li>
<li><c:import url="logout-parcial.jsp"/></li>
</ul>
</body>
</html>