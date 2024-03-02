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

<!-- <portlet:renderURL var="InformationRenderURL">
	<portlet:param name="jspPage" value="/userinfo/ProfileInfo.jsp" />
	<portlet:param name="jspPage" value="/userinfo/ProfileInfo.jsp" />
</portlet:renderURL> -->

<%
	PortletURL informationRenderURL = renderResponse.createRenderURL();
    informationRenderURL.setParameter("jspPage","/userinfo/ProfileInfo.jsp" );
	List<District> districtList = (List) request.getAttribute("districtLists");
%>
<portlet:actionURL name="/searchProfiles" var="searchCriteriaURL" />
<div class ="proflist">
<div class="row" style="margin-left: 10px;">
	<div class="col">
		<form action="${searchCriteriaURL}" name="searchPorfile" method="POST">
			<div class="card@1">
				<div class="card-body@1">
					<div class="row g-3" id="selcopt">
						<div class="col-xxl- col-lg-">
							<div class="search-box">
								<input type="text" class="form-control"
									placeholder="Search profile"> <i
									class="ri-search-line search-icon"></i>
							</div>
						</div>

						<div class="col-xxl- col-lg-">
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
						<div class="col-xxl- col-lg-">
							<select name="area" class="form-control" label="Area"
								id="availableLocality">
								<option value="">Select Area</option>
							</select>
						</div>

						<div class="col-xxl- col-lg-" id="btsearch">
							<button class="btn btn-secondary w-100">Search</button>
						</div>
					</div>

				</div>
			</div>
		</form>
	</div>
</div>

<style>
.portlet-decorate .portlet-content {
	background: #efefef;
	border-color: transparent;
	border-style: solid;
	border-width: 1px 1px 1px 1px;
	padding: 1rem;
	word-wrap: break-word;
}

.d-flex.align-items-center {
  margin: 10px 3px;
}
#selcopt {
  padding: 20px;
  display: flex;
  justify-content: space-around;
  width: 70%;
}
div#btsearch > button {
    background: #5959ab;
    color: #ffff;
    box-shadow: 2px 3px 2px blue;
}
</style>
<div class="col-xxl-3 col-md-6">
	<!-- <div class="cont"> -->

	<%
		/* String contextPath = request.getContextPath(); */
		/* String informationRenderURL = contextPath + "/userinfo/ProfileInfo.jsp"; */

		List<Long> excludedProfileIds = List.of(20129L, 20123L, 20099L, 50022L);
		List<User> currentProfiles = (List) request.getAttribute("currentProfilesSearch");
		if (Validator.isNull(currentProfiles)) {
			currentProfiles = (List) request.getAttribute("currentProfiles");
		}
	%>
	<div class="card" id="cardlist" style="width: 1700px; background: transparent;">
		<div class="card-body" style="display: flex;
  flex-wrap: wrap;">
			<%
				for (User userItems : currentProfiles) {

					if (!excludedProfileIds.contains(userItems.getUserId())) {
						Serializable jamathValue = userItems.getExpandoBridge().getAttribute("Jamath");
						String districtValue = (String) userItems.getExpandoBridge().getAttribute("District");
			%>
			<div class="d-flex align-items-center" style="width: 23%; background: #c0d0d88c; margin: 1rem 1rem; padding: 0.5rem;">
				<div class="flex-shrink-0">
					<div class="avatar-lg rounded">
						<img src="<%=userItems.getPortraitURL(themeDisplay)%>" alt=""
							class="member-img img-fluid d-block rounded" style="width: 100px; height:100px">
					</div>
				</div>
				<div class="flex-grow-1 ms-3" style="width: 150px; font-size: 12px; margin-left: 0.5rem;">
					<a href="#">
						<h5 class="fs-16 mb-1"><%=userItems.getFullName()%></h5>
					</a>
					<p class="text-info mb-2"><%=userItems.getJobTitle()%></p>
					<div class="d-flex flex-wrap gap-2 align-items-center">
						<!-- <div class="badge text-bg-success">
                                                   Line Manager
                                                </div> -->
						<div class="text-info"><%=(jamathValue != null && jamathValue instanceof String[])
							? String.join(", ", (String[]) jamathValue)
							: ""%></div>
					</div>
					<div class="d-flex gap-4 mt-2 text-info">
						<div>
							<%
								// Assuming userItems.getCreateDate() returns a Date object
										Date createDate = userItems.getCreateDate();

										// Format the date as "yyyy-MM-dd" to display only the date without time
										SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
										String formattedDate = dateFormat.format(createDate);
							%>
							<i class="ri-calendar-2-line text-primary me-1 align-bottom"></i>
							<p class="text-info mb-2" >
								join profile data
								<%=formattedDate%></p>
						</div>
					</div>
					<div style=" margin: .2rem; background: #23da23; width: fit-content; float: right;">
						<%
						 informationRenderURL.setParameter("userId",String.valueOf(userItems.getUserId()));
						%>
							<!--<div class="badge text-bg-success">Intrested</div>-->
							 <a href="<%=informationRenderURL%>"
                    class="badge text-bg-warning" role="button">My Details</a>
							
						</div>
				</div>
			</div>
			<%
				}
				}
			%>
		</div>
	</div>
</div>
</div>