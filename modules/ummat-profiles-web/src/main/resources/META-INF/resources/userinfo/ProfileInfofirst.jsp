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
	// Retrieve the user ID from the request parameter
	String userIdParam = request.getParameter("userId");

	// Check if the user ID is not null and is a valid Long value
	if (userIdParam != null && userIdParam.matches("\\d+")) {
		long userId = Long.parseLong(userIdParam);

		try {
			// Retrieve user details using UserLocalServiceUtil
			User userDetails = UserLocalServiceUtil.getUser(userId);

			// Retrieve and format user details
			long UserId = userDetails.getUserId();
			String fullName = userDetails.getFullName();
			String jobTitle = userDetails.getJobTitle();
			Date createDate = userDetails.getCreateDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = dateFormat.format(createDate);
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
					Serializable jamathValue = userDetails.getExpandoBridge().getAttribute("Jamath");
					String districtValue = (String) userDetails.getExpandoBridge().getAttribute("District");
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
						<span><b>Jamath</b> : <%=jamathValue%> </span>
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
							Gounder-Vanniyar Kulam</span> <span><b>Star</b> : Makam</span> <span><b>Profession</b>
							: Medical Representative </span>

					</div>
				</div>
			</div>


			<div class="personal">
				<div class="card">
					<div class="perinfo">

						<h1 class="underline" style="color: seagreen">Personal
							Information</h1>

						<br>
						<header class="imow">
							<i class="fa-regular fa-pen-to-square"></i>
							<h2>In My Own Words</h2>
						</header>
						<div class="imow">

							<p>I am self-employed with a Master's degree currently living
								in Chennai. I come from an upper middle clas, nuclear fanmily
								background with liberal values.</p>
						</div>
						<br>

						<header class="basic">
							<i class="fa-regular fa-address-card"></i>
							<h2>Basic Details</h2>
						</header>
						<br>
						<div class="basicdetails">

							<div>
								<span>Name : Amrutha</span> <span>Age : <%=userDetails.getBirthday()%></span>
								<span>Height : 4Ft 6In/137 Cms </span> <span>Weight :- </span> <span>Mother
									Tongue : Tamil</span> <span>Martial Status : Never Married </span>
							</div>
							<div>
								<span>Body Type</span> <span>Complexion</span> <span>Physical
									Status : Normal </span> <span>Eating Habits : Non-Vegetarian</span> <span>Drinking
									Habits : Never Drinks</span> <span>Smoking Habits : Never
									Smokes</span>
							</div>
						</div>

						<header class="contact">
							<i class="fa-regular fa-address-book"></i>
							<h2>
								<b>Contact Details</b>
							</h2>
						</header>
						<div class="Contactdetails">

							<span>Contact Number : xxxxxxxxxx</span> <span> Parent
								Contact : Not Available</span> <span> Chat Status : Online</span> <span>Send
								Email : Locked</span>

						</div>

						<header class="Religion">
							<i class="fa-solid fa-book-quran"></i>
							<h2>Religion Information</h2>
						</header>
						<div class="ReligionInformation">
							<span>Religion : Hindu </span> <span>Caste/Sub Caste :
								Gounder</span> <span>Gothram : Not Specified </span> <span>Star/Raasi
								: Simma</span>
						</div>


						<header class="bride">
							<i class="fa-solid fa-location-dot"></i>
							<h2>Bride's Location</h2>
						</header>
						<div class="BridesLocation">
							<span>Country : India </span> <span>State : Tamilnadu</span> <span>City
								: Chennai</span>

						</div>

						<header class="professional">
							<i class="fa-solid fa-user-graduate"></i>
							<h2>Professional Information</h2>
						</header>
						<div class="ProfessionalInformation">
							<span>Education Education in Detail :&nbsp;&nbsp; M.A. </span> <span>Occupation
								Occupation in Detail : Medical Representative</span> <span>Employed
								in : Self Employed</span> <span>Annual Income : Rs.3-4Lakhs</span>
						</div>
					</div>
				</div>


				<div class="heading">
					<h1>
						<b>Her Partner Preferences</b>
					</h1>
				</div>

				<div class="card">
					<h2>Basic Preferences</h2>
					<div class="basicpreferences">
						<span> Groom's Age : 23-25 Years</span> <span> Height : 4
							Ft 6In-5 Ft 6In </span> <span> Martial Status : Never Married</span> <span>
							Physical : Normal</span> <span> Mother Tongue : Tamil</span> <span>
							Eating Habits :Non-Vegetarian,Eggetarian</span> <span> Smoking
							Habits : Smokes Occasionally</span> <span> Drinking Habits :
							Doesn't Matter</span>

					</div>


					<h2>Religious Preferences</h2>
					<div class="ReligiousPreferences">
						<span>Religion : Hindu</span> <span> Caste : Any </span> <span>
							Sub caste : Gothram </span> <span> Star/Rassi : Any </span> <span>
							Manglik : Doesn't Matter</span>
					</div>


					<h2>Professional Preferences</h2>
					<div class="ProfessionalPreferences">
						<span> Education : Any Bachelors in
							Engineering/Computers,Any Master's in Engineering/Computers.<br>
							Any Bachelors in Arts/Science/Commerce.Any Bachelors in Medicine
							in General/ in Dental/Surgeon,Any Masters in
							Medicine-General/Dental/Surgeon/,Any Bachelors in Medicine
							Others.Any Masters in Medicine Others.Any Financial Qualification
							- ICWAI/CA/CS/CFA,Service-IAS/IPS/IRS/IES/IFS.Doctorates,Any
						</span> <span> Occupation : Any </span> <span> Annual Income : Any
						</span>
					</div>

					<h2>Location Preferences</h2>
					<div class="LocationPreferences">

						<span>Citizenship : Any </span> <span> Country :
							Australia,Cannada,India,Malaysia,Singapore,United Arab
							Emirates,United Kingdom, United States of America </span> <span>
							Residing State : Any </span> <span> Residing City : Any </span>

					</div>
					<h2>What I am Looking for</h2>
					<span>Not Specified</span>
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
