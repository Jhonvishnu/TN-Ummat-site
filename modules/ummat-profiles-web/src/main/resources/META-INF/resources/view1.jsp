<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ummat.slayer.model.District"%>
<%@page import="java.io.Serializable"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />
<script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<%
List<District> districtList = (List) request.getAttribute("districtLists");
%>
<div style="flex-direction: column;">
	<portlet:actionURL name="/searchProfiles" var="searchCriteriaURL" />
	<div>
		<form action="${searchCriteriaURL}" name="searchPorfile" method="POST">
			<select name="district" label="District" id="selectedDistrict" required="true">
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
							$('#availableLocality').append("<option value='"+ areaNameList[i].name +"'>"+ areaNameList[i].name+ "</option>");
						}
					});
				}
			</script>
			<select name="area" label="Area" id="availableLocality">
				<option value="">Select Area</option>
			</select>
			<button type="submit" class="">Search</button>
		</form>
	</div>
	<%
	List<User> currentProfiles = (List) request.getAttribute("currentProfilesSearch");
	if (Validator.isNull(currentProfiles)) {
		currentProfiles = (List) request.getAttribute("currentProfiles");
	}
	%>
	<div>
		<table id="usersDatatable">
			<thead>
				<tr>
					<th>Profile ID</th>
					<th>Portrait</th>
					<th>Full Name</th>
					<th>Occupation</th>
					<th>Jamath</th>
					<th>District</th>
					<th>View Full</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (User userItems : currentProfiles) {
				%>
				<tr>
					<td><%=userItems.getUserId()%></td>
					<td><img height="50"
						src="<%=userItems.getPortraitURL(themeDisplay)%>" alt="No image"></td>
					<td><%=userItems.getFullName()%></td>
					<td><%=userItems.getJobTitle()%></td>
					<%
					Serializable currValue = userItems.getExpandoBridge().getAttribute("Jamath");
					for (String curValue : (String[]) currValue) {
					%>
					<td><%=curValue%></td>
					<%
					}
					%>
					<td><%=userItems.getExpandoBridge().getAttribute("District")%></td>
					<td>View</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</div>
<script>
	var myTable = $("#usersDatatable").DataTable({
		paging : true,
		searching : true,
		info : true,
	});
</script>