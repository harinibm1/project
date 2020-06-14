
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML+RDFa 1.0//EN"
  "http://www.w3.org/MarkUp/DTD/xhtml-rdfa-1.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en"
	version="XHTML+RDFa 1.0" dir="ltr"
	>

<head profile="http://www.w3.org/1999/xhtml/vocab">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta about="/create-android-emulator-sd-card-and-write-data-to-it"
	property="sioc:num_replies" content="1" datatype="xsd:integer" />
	
<link rel="shortcut icon" href="<%=request.getContextPath()%>/Images/icons.png" type="image/png" />

<meta content="Create an Android Emulator SD Card and Write Data To It"
	about="/create-android-emulator-sd-card-and-write-data-to-it"
	property="dc:title" />
<link rel="shortlink" href="/node/3" />
<meta name="Generator" content="Drupal 7 (http://drupal.org)" />
<link rel="canonical" href="/create-android-emulator-sd-card-and-write-data-to-it" />
	
<title>Mobile Offload</title>

<link type="text/css" rel="stylesheet" href="CSS/style.css" 	media="all" />

<link type="text/css" rel="stylesheet" 	href="CSS/style1.css" 	media="all" />

<style type="text/css">

#anaglyphic h1 {
	text-align: center;
	margin: 10px auto;
	font-family: Tahoma;
	font-size: 30px; 
	color: #000;
	text-shadow: 3px 3px 0 #fff;

}
</style>

</head>

<%
String name =session.getAttribute("admin_name").toString();
String adminid = session.getAttribute("admin_id").toString();
%>
<body>
	
	<div id="page-wrapper">
		<div id="page">

			<div id="header" class="without-secondary-menu">
				<div class="section clearfix">

					<a  title="Home" rel="home" id="logo">
					 <img src="Images/icons.png" alt="Home" />
					</a>

					<div id="name-and-slogan">

						<IMG SRC="<%=request.getContextPath()%>/Images/title2.png" width=90% height="5%" BORDER="0" ALT="">




					</div>
					
					<!-- /#name-and-slogan -->

					<div class="region region-header">
						<div id="block-block-2" class="block block-block">


							<div  style="position: absolute;top: 120px;left: 720px">
								
									Welcome, <font style="color:#5E2612;font-family: monotype corsiva;font-size: 20px;"><%=name %></font>&nbsp;<a href="<%=request.getContextPath()%>/Signout.jsp" 	title="logout"><font style="font-size: 15px;"> LogOut</font></a>
								
							</div>
						</div>
					</div>

			<div id="main-menu" class="navigation">
						
			<ul id="main-menu-links" class="links clearfix">
				<li class="menu-533 first"><a href="<%=request.getContextPath()%>/adminhome.jsp" title="Home">Home</a></li>
				<li class="menu-412"><a href="<%=request.getContextPath()%>/user_details.jsp" title="User Details" target="home">User Details</a></li>
				
				<li class="menu-534"><a href="<%=request.getContextPath()%>/trans_details.jsp" title="Transaction Details" target="home">User Password Details</a></li>
				<li class="menu-480 last"><a href="<%=request.getContextPath()%>/adminchangepwdaction?name=<%=adminid%>&no=1&id=<%=adminid %>" title="Change Password" target="home">Change Password</a></li>
			</ul>
			</div>

				</div>
			</div>
			<div style="position: absolute;top: 200px;background-color: #8B8989;width: 800px;height: 450px;left: 100px;" >
			<iframe style="position: absolute;top: 20px;width: 700px;height: 400px;left: 50px;" name="home">
			
			</iframe>
			</div>
			
</body>
</html>
