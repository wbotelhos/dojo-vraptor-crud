<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Crudão [novo]</title>
	</head>
	<body>
		<form action="<c:url value='/usuario'/>" method="post">
			<input type="hidden" name="usuario.id" value="${usuario.id}" />

			<label for="nome">Nome:</label>
			<input id="nome" type="text" name="usuario.nome" value="${usuario.nome}" />

			<label for="email">Email:</label>
			<input id="email" type="text" name="usuario.email" value="${usuario.email}"  />

			<input type="submit" value="salvar"/>
		</form>
	</body>
</html>