<%@page
	import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.headless.admin.user.dto.v1_0.UserGroup"%>
<%@page import="com.liferay.portal.kernel.model.Groups_UserGroupsTable"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ummat.slayer.model.District"%>
<%@page import="com.liferay.headless.admin.user.dto.v1_0.UserGroup"%>

<%@page import="java.io.Serializable"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
	
	<portlet:renderURL var="inforenderURL">
	<portlet:param name="jspPage" value="/profile/profileInfo.jsp" />
</portlet:renderURL>

<portlet:renderURL var="followrenderURL">
	<portlet:param name="jspPage" value="/view1.jsp" />
</portlet:renderURL>


<%
	List<District> districtList = (List) request.getAttribute("districtLists");
%>


<div style="flex-direction: column;">
	<portlet:actionURL name="/searchProfiles" var="searchCriteriaURL" />
	<div class = "sel">
		<form action="${searchCriteriaURL}" name="searchPorfile"  method="POST">
			<select name="district" label="District" id="selectedDistrict"
				required="true">
				<option value="">Select District</option>
				<%
					for (District districtListItem : districtList) {
				%>
				<option value="<%=districtListItem.getDistrictId()%>"><%=districtListItem.getName()%></option>
				<%
					}
				%>
			</select>
			<script>
				$("#selectedDistrict").on("change", selectedDistrict);
				function selectedDistrict() {
					var districtId = $("#selectedDistrict").val();
					Liferay.Service('/locality/get-locality-by-district-id', {
						districtId : districtId
					}, function(data) {
						var areaNameList = data;
						$('#availableLocality').empty();
						for ( var i in areaNameList) {
							$('#availableLocality').append(
									"<option value='"+ areaNameList[i].name +"'>"
											+ areaNameList[i].name
											+ "</option>");
						}
					});
				}
			</script>
			<select name="area" label="Area" id="availableLocality">
				<option value="">Select Area</option>
			</select>
			<button type="submit"  class="subm">Search</button>
		</form>
	</div>

	<%
		List<Long> excludedProfileIds = List.of(20129L, 20123L, 20099L, 50022L);
		List<User> currentProfiles = (List) request.getAttribute("currentProfilesSearch");
		if (Validator.isNull(currentProfiles)) {
			currentProfiles = (List) request.getAttribute("currentProfiles");
		}
	%>


	<div class="flow">

		<%
					for (User userItems : currentProfiles) {

						if (!excludedProfileIds.contains(userItems.getUserId())) {
							Serializable jamathValue = userItems.getExpandoBridge().getAttribute("Jamath");
					        String districtValue = (String) userItems.getExpandoBridge().getAttribute("District");
				%>


		<figure class="snip1336">
			<img src="https://th.bing.com/th/id/R.14ab0af50a9f9f3bd334dbc2dc8e4139?rik=PO7fuNYx6l8JLA&riu=http%3a%2f%2fwww.pixelstalk.net%2fwp-content%2fuploads%2f2016%2f08%2fWonderful-Nature-Colorful-Scene-HD.jpg&ehk=0HrJNBc%2bzz5o2AEdayde46yRrDdvVexZ3cYpe67%2bL%2fo%3d&risl=&pid=ImgRaw&r=0"
				alt="Profile Image" />
			<figcaption>
				<img src="<%=userItems.getPortraitURL(themeDisplay)%>"
					alt="Profile Image" class="profile" />
				<h2><%=userItems.getFullName()%><span><%=userItems.getUserId()%></span>
				</h2>
				<p>
					<span class = "var">Jamath :</span>
					<span class = "val"><%= (jamathValue != null && jamathValue instanceof String[]) ? String.join(", ", (String[]) jamathValue) : "" %></span><br>
					<span class = "var">Height :</span>
					<span class = "val"><%=userItems.getExpandoBridge().getAttribute("Height")%>&nbsp;</span><br>
					<span class = "var">Location :</span>
					<span class = "val"><%=districtValue != null ? districtValue : ""%>&nbsp;</span><br> 
					<span class = "var">Education:</span>
					<span class = "val"><%=userItems.getExpandoBridge().getAttribute("Education")%>&nbsp;</span><br>
					<span class = "var">Occupation :</span> 
					 <span class = "val"><%=userItems.getJobTitle()%></span></p>
				<div class = "cart">
				<a href="<%= followrenderURL.toString() %>" class="follow">Interest</a> 
				<a href="<%= inforenderURL.toString() %>" class="info">More Info</a>
				</div>
				</figcaption>
				
		</figure>

		<%
					}
					}
				%>

	</div>
</div>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300,400,600);

.flow {
    width: 1400px;
    display: flex;
    justify-content: start;
    flex-wrap: wrap;
}
.portlet .portlet-content {
    background-color: var(--portlet-bg, transparent);
    width: max-content;
}
.snip1336 {
    font-family: 'Roboto', Arial, sans-serif;
    position: relative;
    overflow: hidden;
    margin: 10px;
    /* min-width: 230px; */
    max-width: 250px;
    width: 100%;
    color: #ffffff;
    text-align: left;
    /* line-height: 1.4em; */
    background-color: #141414;
    border-radius: 15px;
    font-family: auto;
}

.snip1336 * {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	-webkit-transition: all 0.25s ease;
	transition: all 0.25s ease;
}

.snip1336 img {
    height: 100px;
    width: 300px;
    vertical-align: top;
    opacity: 0.85;
}

.snip1336 figcaption {
	width: 100%;
	background-color: #141414;
	padding: 25px;
	position: relative;
}

.snip1336 figcaption:before {
	position: absolute;
	content: '';
	bottom: 100%;
	left: 0;
	width: 0;
	height: 0;
	border-style: solid;
	border-width: 55px 0 0 400px;
	border-color: transparent transparent transparent #141414;
}

.snip1336 figcaption a {
	padding: 5px;
	border: 1px solid #3e80d7;
	color: #418ae9;
	font-size: 0.7em;
	text-transform: uppercase;
	margin: 10px 0;
	display: inline-block;
	opacity: 0.65;
	width: 47%;
	text-align: center;
	text-decoration: none;
	font-weight: 600;
	letter-spacing: 1px;
	border-radius: 15px;
}

.snip1336 figcaption a:hover {
	opacity: 1;
}

.snip1336 .profile {
	border-radius: 50%;
	position: absolute;
	bottom: 91%;
	left: 25px;
	z-index: 1;
	max-width: 90px;
	opacity: 1;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
}

.snip1336 .follow {
	margin-right: 4%;
	border-color: #fd901c;
	color: #e48e2b;
	border-radius: 15px;
}

.snip1336 h2 {
	margin: 0 0 5px;
	font-weight: 300;
}

.snip1336 h2 span {
	display: block;
	font-size: 0.5em;
	color: #2980b9;
}

.snip1336 p {
	margin: 0 0 10px;
	font-size: 0.8em;
	letter-spacing: 1px;
	opacity: 0.8;
}
/*from styles*/
.sel {
    font-family: emoji;
    font-size: 18px;
	width: 900px;
   /* border: solid;*/
    display: flex;
    justify-content: center;
    margin: 30px 20px;
}

select {
    word-wrap: normal;
    margin: 0 0 0 70px;
    letter-spacing: 1.5px;
    width: 250px;
    height: 40px;
    border-radius: 6px;
    text-align: center;
}
/*select#selectedDistrict {
    width: 250px;
    height: 40px;
    border-radius: 6px;
    text-align: center;
}

select#availableLocality {
    width: 250px;
    height: 40px;
    border-radius: 6px;
    text-align: center;
}*/

button.subm {
    margin-left: 70px;
    width: 150px;
    height: 40px;
    border-radius: 6px;
    font-weight: 700;
    background-color: #5589ea;
    color: #ffff;
    letter-spacing: 1.5px;
}

span.val {
    font-family: fangsong;
    font-weight: 700;
    text-transform: uppercase;
}
</style>
<script>
    /* Demo purposes only */
$(".hover").mouseleave(
  function () {
    $(this).removeClass("hover");
  }
);

</script>
<script>
	var myTable = $("#usersDatatable").DataTable({
		paging : true,
		searching : true,
		info : true,
	});
</script>