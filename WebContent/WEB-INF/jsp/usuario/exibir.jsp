<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
		<title>Crudão | ${usuario.nome}</title>
	</head>
	<body>
		<label>Nome:</label> ${usuario.nome}<br/>
		<label>Email:</label> ${usuario.email}<br/><br/>

		<form action="<c:url value='/usuario'/>" method="post">
			<input type="hidden" name="usuario.id" value="${usuario.id}" />
			<input type="hidden" name="_method" value="put" />

			<input type="submit" value="editar" />
		</form>
	</body>
</html>