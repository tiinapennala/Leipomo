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
<title>Muuta tietoja</title>
</head>
<body>

<div class = "header">
		<h1>KULMAN LEIPOMO</h1>
</div>


<div class = "section1">
	<form action="MuutaTuote_servlet" method="post">

		<table class = "table1">
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
				out.print("<input type='text' name='nimi' value='"+tuote.getNimi()+"'>");
				out.print("</td>");
				out.print("<td>");
				out.print("<input type='text' name='hinta' value='"+tuote.getHinta()+"'>");
				out.print("</td>");
				out.print("<td>");
				out.print("<input type='text' name='tyyppi' value='"+ tuote.getTyyppi()+"'>");
				out.print("</td>");
				out.print("<td>");
				out.print("<input type='text' name='kuvaus' value='"+ tuote.getKuvaus()+"'>");
				out.print("</td>");
				out.print("<td>");
				out.print("<input type='submit' value='Hyväksy muutos'>");
				out.print("</td>");	
			out.println("</tr>");
		%>
		</table>
		
		<input type="hidden" name="vanhaTuotenro" value="<%=tuote.getTuotenro()%>">
	</form>
</div>


<div class = "divspace">
	<form action="Paavalikko.jsp">
   	 <input type="submit" value="Palaa päävalikkoon">
	</form>
</div>


</body>
</html>