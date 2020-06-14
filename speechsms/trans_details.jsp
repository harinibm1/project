<%@page import="com.util.AES_CBC_encryption_Decryption"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dhs.DAO.*"%>



<html>

<head>


	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/user_table.css" type="text/css" />
	
</head>
<%
	ResultSet rs = admindao.getTrans();

	System.out.println(" Trans Details,.....!");
	AES_CBC_encryption_Decryption a=new AES_CBC_encryption_Decryption();
%>
<body>

	<form action="<%=request.getContextPath()%>/GroupManager"	method="post">



		<div style="position: absolute; left: 60px;" >
			<table >
				<caption>Transaction Details</caption>
				<thead>
					<tr>

 						<th>S.NO</th>
						<th>User Code</th>
						<th>User Name</th>
						<th>Domain Name</th>
						<th>User ID</th>
						<th>Password</th>
						




					</tr>
				</thead>
				<%
					if (rs != null)
						while (rs.next()) {
				%>
				<tbody>
					<tr>

						<td><%=rs.getInt(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=admindao.getUserName(rs.getString(2))%></td>
						<td><%=rs.getString(3)%></td>
						<td><%=rs.getString(5)%></td>
						<td><%=a.decrypt(rs.getString(4))%></td>
						


					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	</form>


</body>
</html>