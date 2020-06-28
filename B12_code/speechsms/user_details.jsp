<%@page import="com.util.AES_CBC_encryption_Decryption"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.database.DAO.*" %>
<%@ page import="com.login.*" %>



<html>

<head>
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/user_table.css" type="text/css" />
</head>
<%
AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();





	ResultSet rs=admindao.getUser();

System.out.println(" User Details,.....!");
%>
<body >

<form action="<%=request.getContextPath() %>" method="post">



<div style="position: absolute;left: 70px;">
	<table>
	<caption>User Details</caption>
	<thead>
	<tr>
		<th colspan="1" align="center">Code</th>
		<th colspan="1" align="center">Id</th>
		<th colspan="1" align="center">Password</th>
		<th colspan="1" align="center">Master Password</th>
		<th colspan="1" align="center">Name</th>
		<th colspan="1" align="center">Mobile</th>
		
		<th colspan="1" align="center">Delete</th>
		
	</tr></thead>
	<%
	if(rs!=null)
		while(rs.next())
		{%>
		 <tbody>
			<tr>
				<td><%=rs.getInt(1) %></td>
						<td><%=rs.getString(2) %></td>
						<td><%=rs.getString(3)  %></td>
						<td><%=a.decrypt(rs.getString(6).trim())  %></td>
						<td><%=rs.getString(4) %></td>
						<td><%=rs.getString(7) %></td>
						
						<td><a href="<%=request.getContextPath()%>/EditUser?submit=Delete&chk=<%=rs.getInt(1) %>"><font style="color: blue;">Delete</font></a></td>
						
			</tr></tbody>
		<%}
	%>
</table></div>
</form>

	<%	
		int no=Utility.parse(request.getParameter("no"));
System.out.println("No :"+no);
		if(no==1)
		{%>
		<div  style="position: absolute;top: -10px;left: 50px;color: #8B4513;font-size: 20px;font-family: monotype corsiva; ">
		<p>User Details Updated Successfully..</p>	
		</div>
		
					
		<%}
		if(no==2)
		{%>
		
			<div  style="position: absolute;top: -10px;left: 50px;color: #8B4513;font-size: 20px; ">	
		
		<p>User Deleted Successfully</p>	
		</div>		
		<%}
		
		
	%>
</body>
</html>