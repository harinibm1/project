
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML+RDFa 1.0//EN"
  "http://www.w3.org/MarkUp/DTD/xhtml-rdfa-1.dtd">
  <%@page import="com.login.*"  %>
<html >

<head >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	
<link rel="shortcut icon" href="Images/icons.png" type="image/png" />

 <script src="<%=request.getContextPath()%>/jquery.toastmessage.js" type="text/javascript"></script>
  <link href="<%=request.getContextPath()%>/jquery.toastmessage.css" rel="stylesheet" type="text/css" />


<title>SESAME:Secure Your Password</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css" media="all" />


<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style1.css" media="all" />

<style type="text/css">

.site-name{
text-shadow: 0 6px 4px #33F, -3px -5px 4px #F00, 3px -5px 4px #0F0;

}

#burning h1 {
        color: #fff;
        text-shadow: 0px -1px 4px white, 0px -2px 10px yellow, 0px -10px 20px #ff8000, 0px -18px 40px red;
        font: 70px 'BlackJackRegular';
}

#anaglyphic h1 {
	text-align: center;
	margin: 10px auto;
	font-family: Monotype Corsiva;
	font-size: 40px; 
	color: rgba(0,168,255,0.5);
	text-shadow: 1px 1px 0 rgba(255,0,180,0.5);

}

</style>


</head>
<body background="<%=request.getContextPath()%>/Images/22206.jpg">
	
	<div id="page-wrapper">
		

			
				

					<IMG SRC="<%=request.getContextPath()%>/Images/title2.png" width=90% height="5%" BORDER="0" ALT="">
					


				
			
			<!-- /.section, /#header -->
<div style="position: absolute;top: 220px;left: 50px;width: 400px;height: 400px;">
<IMG SRC="<%=request.getContextPath()%>/Images/cloud-service.png" width=100% height="100%" BORDER="0" ALT="">
</div>



			<div id="footer-wrapper" >
				<div class="section" >

					<div id="footer-columns" class="clearfix" >
						<div class="region region-footer-firstcolumn" style="position: absolute; top:200px;left: 600px;">
						

							<div id="block-user-login" class="block block-user" style="position: absolute; top:10px;left: 100px;width: 130px;">

								<h2><font style="color: #FF4500;"><b>Admin login</b></font></h2>

								<div class="content" >
									<form action="<%=request.getContextPath()%>/adminloginaction" method="post" id="user-login-form" ><br>
										<div>
											<div class="form-item form-type-textfield form-item-name" >
												<label for="edit-name--2">Admin Id <span
													class="form-required" title="This field is required.">*</span></label>
												<input type="text" id="edit-name--2" name="name" value=""
													size="15" maxlength="60" class="form-text required" />
											</div>
											<div class="form-item form-type-password form-item-pass">
												<label for="edit-pass">Password <span
													class="form-required" title="This field is required.">*</span></label>
												<input type="password" id="edit-pass" name="pass" size="15"
													maxlength="128" class="form-text required" />
											</div>
											
											
											<div class="form-actions form-wrapper" id="edit-actions--2">
												<input type="submit" id="edit-submit--2" name="op"
													value="Log in" class="form-submit" />
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- /#footer-columns -->

					<div id="footer" class="clearfix">
						<div class="region region-footer">
							<div id="block-system-powered-by" class="block block-system">


							</div>
						</div>
					</div>
					<!-- /#footer -->

				</div>
			</div>
			<!-- /.section, /#footer-wrapper -->

		</div>
	</div>
	<!-- /#page, /#page-wrapper -->
	<script type="text/javascript"
		src="http://www.tylerfrankenstein.com/sites/default/files/js/js_loJJMZ-yLpCFnc5Htc8xgIMfdfNbw5E30CdocHWSiaM.js"></script>
</body>

 
<%	
		int no=Utility.parse(request.getParameter("no"));
System.out.println("No :"+no);
		if(no==1)
		{%>
		<div  style="position: absolute;top: 550px;left: 500px;color: #8B4513;font-size: 20px;font-family: monotype corsiva; ">
		<p>Invalid User</p>	
		</div>
		
					
		<%}
		if(no==2)
		{%>
		
			<div  style="position: absolute;top: 550px;left: 500px;color: #8B4513;font-size: 20px; ">	
		<script type="text/javascript">
		 $().toastmessage('showErrorToast', "Oops,Something went wrong ..!");
		
		</script></div>		
		<%}
		
		
		if(no==3)
		{%>
			
				<div  style="position: absolute;top: 550px;left: 500px;color: #8B4513;font-size: 20px;font-family: monotype corsiva; ">	
		
		<p>You have Logged Out Successfully!</p>
		</div>			
		<%
		}
		
		
	%>
</html>
