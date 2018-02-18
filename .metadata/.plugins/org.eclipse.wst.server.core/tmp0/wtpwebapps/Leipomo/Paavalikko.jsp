<%
if(request.getAttribute("tuotteet")==null){
	response.sendRedirect("EtsiTuotteet_servlet");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.Tuote"%>
<%@	page import="java.text.DecimalFormat" %>

<jsp:useBean id="tuotteet" type="java.util.ArrayList<Tuote>" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/Leipomo/Style.css" type="text/css" >
	<title>Kulman Leipomo</title>
</head>


<body>

<div class = "header">
			<h1>KULMAN LEIPOMO</h1>
</div>

<div class = "section1">

	<form action="EtsiTuotteet_servlet" method="post">
			<h2>HAE TUOTE</h2>
				<p>Nimi:</p>
				<input type="text" name="hakusana" value="" >
				<input type="submit" value="Etsi" >
	</form>
	
	
	<form action="EtsiTyyppi_servlet" method="post">
				<p>Tyyppi:</p>
				<input type="text" name="hakusana" value="" >
				<input type="submit" value="Etsi" >
	</form>
	
	
			<h2>LISÄÄ TUOTE</h2>
			
	<form action="Lisaa_servlet" method="post">
		<table class="table1">
			<tr>
				<th>Tuote</th>
				<th>Hinta</th>
				<th>Tyyppi</th>
				<th>Kuvaus</th>
			</tr>

			<tr>
				<td><input type="text" name="nimi" ></td>
				<td><input type="text" size="4" name="hinta" ></td>
				<td><input type="text" name="tyyppi" ></td>
				<td><input type="text" name="kuvaus" ></td>
			</tr>

			<tr>
				<td colspan="3"></td>
				<td><input type="submit" value="Lisää" ></td>
			</tr>
		</table>
	</form>
</div>
	
<div class = "section2">

			<h3>TUOTELISTA</h3>


	<table class = "table2">
	<%
	DecimalFormat des = new DecimalFormat("0.00");
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
					out.print("<th>");
					out.print("Muuta");
					out.print("</th>");
					out.print("<th>");
					out.print("Poista");
					out.print("</th>");
			out.print("</tr>");
		for(int i=0;i<tuotteet.size();i++){
			out.print("<tr>");
				out.print("<td>");
				out.print(tuotteet.get(i).getTuotenro());
				out.print("</td>");
				out.print("<td>");
				out.print(tuotteet.get(i).getNimi());
				out.print("</td>");
				out.print("<td>");
				out.print(des.format(tuotteet.get(i).getHinta()));
				out.print("</td>");
				out.print("<td>");
				out.print(tuotteet.get(i).getTyyppi());
				out.print("</td>");
				out.print("<td>");
				out.print(tuotteet.get(i).getKuvaus());
				out.print("</td>");
				out.print("<td>");
				out.print("<a href='MuutaTuote_servlet?tuotenro=" + tuotteet.get(i).getTuotenro() + "'>Muuta</a>");
				out.print("</td>");	
				out.print("<td>");
				out.print("<a href='PoistaTuote_servlet?tuotenro=" + tuotteet.get(i).getTuotenro() + "'>Poista</a>");
				out.print("</td>");	
			out.println("</tr>");
		}
	%>
	</table>
</div>

</body>
</html>