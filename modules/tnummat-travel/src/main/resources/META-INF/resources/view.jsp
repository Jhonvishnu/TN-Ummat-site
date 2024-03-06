<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
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

<%
	List<District> districtList = (List) request.getAttribute("districtLists");
%>
<form action="${searchCriteriaURL}" name="searchCar" method="POST">
<section class="loc-sec">
        <div class="main-sec">
            <div class="pick">
                <label for="pickup-location">Pick Up Location</label>
               <select name="district" class="form-control" label="District"
								id="selectedDistrict" required="true">
								<option value="">Select District</option>
								<%
									for (District districtListItem : districtList) {
								%>
								<option value="<%=districtListItem.getDistrictId()%>"><%=districtListItem.getName()%></option>
								<%
									}
								%>
							</select>
							<select name="area" class="form-control" label="Area"
								id="availableLocality">
								<option value="">Select Area</option>
							</select>
							<script>
								$("#selectedDistrict").on("change",
										selectedDistrict);
								function selectedDistrict() {
									var districtId = $("#selectedDistrict")
											.val();
									Liferay
											.Service(
													'/locality/get-locality-by-district-id',
													{
														districtId : districtId
													},
													function(data) {
														var areaNameList = data;
														$('#availableLocality')
																.empty();
														for ( var i in areaNameList) {
															$(
																	'#availableLocality')
																	.append(
																			"<option value='"+ areaNameList[i].name +"'>"
																					+ areaNameList[i].name
																					+ "</option>");
														}
													});
								}
							</script>

            </div>
    
            <div class="pick">
                <label for="destination-location">Destination Location</label>
               <select name="district" class="form-control" label="District"
								id="selectedDistricts" required="true">
								<option value="">Select District</option>
								<%
									for (District districtListItem : districtList) {
								%>
								<option value="<%=districtListItem.getDistrictId()%>"><%=districtListItem.getName()%></option>
								<%
									}
								%>
							</select>
							<select name="area" class="form-control" label="Area"
								id="availableLocalitys">
								<option value="">Select Area</option>
							</select>
							<script>
								$("#selectedDistricts").on("change",
										selectedDistrict);
								function selectedDistrict() {
									var districtId = $("#selectedDistricts")
											.val();
									Liferay
											.Service(
													'/locality/get-locality-by-district-id',
													{
														districtId : districtId
													},
													function(data) {
														var areaNameList = data;
														$('#availableLocality')
																.empty();
														for ( var i in areaNameList) {
															$(
																	'#availableLocalitys')
																	.append(
																			"<option value='"+ areaNameList[i].name +"'>"
																					+ areaNameList[i].name
																					+ "</option>");
														}
													});
								}
							</script>

            </div>
    
            <div class="pick">
                <label for="pickup-date">Pick Up Date</label>
                <input type="date" id="pickup-date" required>
            </div>
    
            <div class="pick">
                <label for="return-date">Return Date</label>
                <input type="date" id="return-date" required>
            </div>
    
            <div class="pick">
                <input type="button" value="Search Car" onclick="searchCar()">
            </div>
        </div>
    </section>
    </form>
    