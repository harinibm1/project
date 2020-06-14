<%@ page import="com.login.*" %>
<html>
<head>
	<%

		int no=Utility.parse(request.getParameter("no"));
	
		String adminid = session.getAttribute("admin_id").toString();
	%>

</head>
<body onload="startTimer()">
	<form id="login" action="<%=request.getContextPath() %>/adminchangepwdaction">
		<input type="hidden" name="admin" value="<%=adminid %>"></input>
		<input type="hidden" name="id" value="<%=adminid %>"></input>
		<input type="hidden" name="no" value="2"></input>

		<br></br>
	<div id="a1" style="position: absolute;top: 30px;left: 200px;">

	 <table id="login" align="center">
			     	<tr>
			     			<td colspan="3" align="center"><font style="font-family:cursive;font-size: 20px;color: black;"><b>Change Password</b></font></td>
			     	</tr>

			     	<tr>
			     			<td>&nbsp;</td>
			     	</tr>

			     	<tr>
			     		<td>Admin Id</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="text" name="user_id" value="<%=adminid %>" readonly="readonly">
			     		</td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>

			     	<tr>
			     		<td>Current Password</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="password" name="pass" required="yes"></input>
			     		</td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>

			     	<tr>
			     		<td>New Password </td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="password" name="npass"  required="yes"></input>
			     		</td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>

			     	<tr>
			     		<td>Confirm new password</td>
			     		<td>:</td>
			     		<td><input class="field" type="password" name="cpass"  required="yes"></input></td>
			     	</tr>
			     	<tr><td>&nbsp;</td></tr>
			     	<tr>
			     	<td colspan="3" align="center">
			     	<input type="submit" value="Change Pass" />

			     	</td>
			     	</tr>


	</table></div></form>
<%
if(no==1)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color:red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;">
			<p>Opp's,your current password is wrong ..!</p>
		</div>
	<%
}
if(no==2)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color: red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;">
			<p>Opp's,your new password do not match with confirm password ..!</p>
		</div>
	<%
}
if(no==3)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color: red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;">
			<p>Opp's,Seems something went wrong....!</p>
		</div>
	<%
}
if(no==4)
{
	%>
		<div class="error" id="message" style="position: absolute;top: -10px;color: red;font-size: 20px;color: #8B4513;font-family: monotype corsiva;">
			<p>Your Password Updated Successfully....!</p>
		</div>
	<%
}
%>

</body>
</html>
