<%
if(request.getAttribute("tuote")==null){
	response.sendRedirect("EtsiTuotteet_servlet");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.Tuote"%>
<%@	page import="java.text.DecimalFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/Leipomo/Style.css" type="text/css">
<title>Poista tuote</title>
</head>

<body>

	<div class = "header">
			<h1>LEIPOMO</h1>
	</div>

	<div class = "section1">
			<h2>Haluatko poistaa seuraavan tuotteen?</h2>
	
	<form action="PoistaTuote_servlet" method="post">
		<table class="table3">
		<%
		DecimalFormat des = new DecimalFormat("0.00");
		Tuote tuote = (Tuote)request.getAttribute("tuote");
				out.print("<tr>");
					out.print("<th>");
					out.print("Tuotenro");
					out.print("</th>");
					out.print("<th>");
					out.print("Tuote");
					out.print("</th>");
					out.print("<th>");
					out.print("Hinta  &#8364");
					out.print("</th>");
					out.print("<th>");
					out.print("Tyyppi");
					out.print("</th>");
					out.print("<th>");
					out.print("Kuvaus");
					out.print("</th>");
				out.print("</tr>");
				out.print("<tr>");
					out.print("<td>");
					out.print(tuote.getTuotenro());
					out.print("</td>");
					out.print("<td>");
					out.print(tuote.getNimi());
					out.print("</td>");
					out.print("<td>");
					out.print(des.format(tuote.getHinta()));
					out.print("</td>");
					out.print("<td>");
					out.print(tuote.getTyyppi());
					out.print("</td>");
					out.print("<td>");
					out.print(tuote.getKuvaus());
					out.print("</td>");
					out.print("<td>");
					out.print("<input type='submit' value='Kyllä'>");
					out.print("</td>");	
				out.println("</tr>");
		%>
		</table>
			<input type="hidden" name="poistaTuotenro" value="<%=tuote.getTuotenro()%>">
	</form>
</div>

<div class = "divspace">
	<form action="Paavalikko.jsp">
    	<input type="submit" value="Palaa päävalikkoon">
	</form>
</div>

</body>
</html>