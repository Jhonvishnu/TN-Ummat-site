<%@page import="com.ummat.profiles.web.util.UmmatProfileUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.Serializable"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>


<%
Log logger = LogFactoryUtil.getLog("");
	
	String userIdParam = request.getParameter("userId");
%>
<%
	
	if (userIdParam != null && userIdParam.matches("\\d+")) {
		long userId = Long.parseLong(userIdParam);
	
		try { %>

<% 		User userDetails = UserLocalServiceUtil.getUser(userId);
			  logger.info(" variable first try catch block:");
			long UserId = userDetails.getUserId();
			String fullName = userDetails.getFullName();
			String jobTitle = userDetails.getJobTitle();
			Date createDate = userDetails.getCreateDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = dateFormat.format(createDate);
			%>
<%
			
            String jamathValue = null;
					  
			
			    logger.info("Custom Fields:>>>>>1");
			    jamathValue  = UmmatProfileUtil.getData(userDetails);
			    logger.info("Jamath Value: " + jamathValue);
			    logger.info("Custom Fields:>>>>>>2");
			
			
			%> 
			  


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List</title>
<!-- <link rel="stylesheet" href="style.css"> -->

</head>

<body>
	<%
		// Ensure userItems is not null
				if (userDetails != null) {
					
						%>
	<div class="container">
		<div class="card">
			<header class="profnameid">
				<h3 style="color: seagreen">
					<%=fullName%></h3>

				<h4 style="color: seagreen"><%=UserId%>
					<span>| Profile Created By Myself </span>
				</h4>
			</header>
			<div class="profileinfo" style="display: flex;">
				<div class="profile">
					<img src="" style="width: 150px; height: 150px;" alt="" srcset="">
				</div>

				<div class="details">
					<div>
						<%
							Date birthday = userDetails.getBirthday();
										LocalDate birthdate = (birthday != null)
												? birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
												: null;

										// Calculate the age or set to null if there's no birthday information
										Integer age = (birthdate != null) ? Period.between(birthdate, LocalDate.now()).getYears()
												: null;
						%>
						<span><b>Age:</b> <%=(age != null) ? age + " years" : "No birthday information available"%></span>
						
						<span><b>Jamath</b> :<%=jamathValue %> <%-- <%=(jamathValue != null && jamathValue instanceof String[])
							? String.join(", ", (String[]) jamathValue)
							: ""%> --%> </span>
						<% 
                //logger.error("User jamath values : " + jamathValue);
            %>
						<%
							} else {
						%>
						<p>User Not Found</p>
						<%
							}
						%>
						<span><b>Sub-Caste</b> : Not Specified </span> <span><b>Location</b>
							: India,Tamilnadu,Chennai</span> <span><b>Education</b> : M.A. </span> <span><b>AnnualIncome</b>
							: Rs. 3-4 Lakhs</span>
					</div>
					<div>
						<span><b>Height</b> : 4Ft 6In/137 Cms </span> <span><b>Caste</b>:
						</span> <span><b>Star</b> : </span> <span><b>Profession</b> :
							Medical Representative </span>

					</div>
				</div>
			</div>


		</div>
	</div>



</body>
</html>
<%
	} catch (PortalException e) {
			// Handle exception when user details are not found
%>


<head>
<!-- Include your head content here -->
</head>

<body>
	<h1>User Not Found</h1>
	<p>
		The user with ID
		<%=userId%>
		was not found.
	</p>
</body>

</html>
<%
	}
	} else {
		// Handle case when the provided user ID is not valid
%>

<head>
<!-- Include your head content here -->
</head>

<body>
	<h1>Invalid User ID</h1>
	<p>
		The provided user ID (<%=userIdParam%>) is not valid.
	</p>

</body>
<style>
* {
	padding: 0;
	margin: 5px;
}

body {
	padding: 0;
	margin: 30px;
	text-align: left;
	box-sizing: border-box;
	background-color: rgb(225, 229, 233);
}

.card {
	margin: 10px;
	padding: 0px 20px;
	background-color: #ffff;
	width: 80%;
}

.card {
	margin: 10px;
	padding: 0px 20px;
	background-color: #ffff;
	border-radius: 20px;
	background-image: url(form.webp);
	width: 80%;
}

.comment {
	margin-right: auto;
}

button {
	margin-left: 10px;
	border-radius: 3px;
	border-color: black;
}

header.perinfo {
	width: max-content;
}

.details {
	display: contents;
}

div {
	display: grid;
}

.underline {
	border-bottom: 3px solid black;
	width: max-content;
}

header.imow {
	display: flex;
}

header.imow h2 {
	padding-top: 15px;
}

.fa-regular.fa-pen-to-square {
	padding: 10px;
	color: seagreen;
	border: solid;
	border-radius: 50%;
	border-color: grey;
	font-size: 24px;
}

.imow span {
	margin-bottom: 10px;
	margin-left: 100px;
}

header.basic {
	display: flex;
}

header.basic h2 {
	padding-top: 15px;
}

.fa-regular.fa-address-card {
	padding: 10px;
	color: seagreen;
	border: solid;
	border-radius: 50%;
	border-color: grey;
	font-size: 24px;
}

.basicdetails {
	display: flex;
	width: 80%;
	margin: 0 auto;
	justify-content: space-between;
}

.basicdetails>div {
	flex: 1;
	margin-right: 20px;
	margin-left: 70px;
}

.basicdetails>div:last-child {
	margin-right: 0;
}

.basicdetails span {
	display: list-item;
	margin-bottom: 10px;
}

header.contact {
	display: flex;
}

header.contact h2 {
	padding-top: 15px;
}

.fa-regular.fa-address-book {
	padding: 10px;
	color: seagreen;
	border: solid;
	border-radius: 50%;
	border-color: grey;
	font-size: 24px;
}

.Contactdetails {
	display: flex;
	flex-direction: column;
	width: 50%;
	margin: 30px;
}

.Contactdetails span {
	display: list-item;
	margin-bottom: 10px;
	margin-left: 100px;
}

header.Religion {
	display: flex;
}

header.Religion h2 {
	padding-top: 15px;
}

.fa-solid.fa-book-quran {
	padding: 10px;
	color: seagreen;
	border: solid;
	border-radius: 50%;
	border-color: grey;
	font-size: 24px;
}

.ReligionInformation {
	display: flex;
	text-align: left;
	flex-direction: column;
	width: 50%;
	margin: 30px;
}

.ReligionInformation span {
	display: list-item;
	margin-bottom: 10px;
	margin-left: 100px;
}

header.bride {
	display: flex;
}

header.bride h2 {
	padding-top: 15px;
}

.fa-solid.fa-location-dot {
	padding: 10px;
	color: seagreen;
	border: solid;
	border-radius: 50%;
	border-color: grey;
	font-size: 24px;
}

.BridesLocation {
	width: 50%;
	margin: 30px;
}

.BridesLocation span {
	display: list-item;
	margin-left: 100px;
	margin-bottom: 10px;
}

header.professional {
	display: flex;
}

header.professional h2 {
	padding-top: 15px;
}

.fa-solid.fa-user-graduate {
	padding: 10px;
	color: seagreen;
	border: solid;
	border-radius: 50%;
	border-color: grey;
	font-size: 24px;
}

.ProfessionalInformation {
	width: max-content;
	margin: 30px;
}

.ProfessionalInformation span {
	display: list-item;
	margin-bottom: 10px;
	margin-left: 100px;
}

body {
	font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

.container {
	width: 80%;
	margin: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
}

.heading {
	flex: 1;
	text-align: center;
}

.card {
	margin: 10px;
	padding: 0px 20px;
	background-color: #ffff;
	width: 80%;
}

.basicpreferences {
	text-align: left;
	margin-top: 20px;
}

.basicpreferences span {
	display: list-item;
	margin-bottom: 10px;
}

.ReligiousPreferences {
	text-align: left;
	margin-top: 20px;
}

.ReligiousPreferences span {
	display: list-item;
	margin-bottom: 10px;
}

.ProfessionalPreferences {
	text-align: left;
	margin-top: 20px;
}

.ProfessionalPreferences span {
	display: list-item;
	margin-bottom: 10px;
}

.LocationPreferences {
	text-align: left;
	margin-top: 20px;
}

.LocationPreferences span {
	display: list-item;
	margin-bottom: 10px;
}
</style>
</html>
<%
	}
%>


