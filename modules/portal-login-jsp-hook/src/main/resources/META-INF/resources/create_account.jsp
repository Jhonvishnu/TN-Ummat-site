<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.service.CountryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/expando" prefix="liferay-expando"%>
<h3>Register Now!</h3>
<%
String redirect = ParamUtil.getString(request, "redirect");

boolean male = ParamUtil.getBoolean(request, "male", true);

Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);

renderResponse.setTitle(LanguageUtil.get(request, "create-account"));
%>

<portlet:actionURL name="/login/create_account"
	secure="<%=PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure()%>"
	var="createAccountURL"
	windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="/login/create_account" />
</portlet:actionURL>
<style>
    .card-style {
        border: 1px solid #ddd;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        transition: box-shadow 0.3s ease-in-out;
        background-image: url('path/to/your/background-image.jpg');
        background-size: cover;
    }

    .card-style:hover {
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }

    /* Additional styles for text fields */
    .card-style input[type="text"],
    .card-style input[type="file"],
    .card-style select,
    .card-style button {
        border: 1px solid #ccc;
        border-radius: 5px;
        padding: 8px;
        margin-bottom: 10px;
    }

    .card-style input[type="text"]:hover,
    .card-style input[type="file"]:hover,
    .card-style select:hover,
    .card-style button:hover {
        border: 1px solid #555;
    }
</style>

<aui:form action="<%=createAccountURL%>"  method="post" name="fm"
	validateOnBlur="<%=false%>" enctype="multipart/form-data" >
	<aui:input name="saveLastPath" type="hidden" value="<%=false%>" />
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.ADD%>" />
	<aui:input name="redirect" type="hidden" value="<%=redirect%>" />

	<liferay-ui:error exception="<%=AddressCityException.class%>"
		message="please-enter-a-valid-city" />
	<liferay-ui:error exception="<%=AddressStreetException.class%>"
		message="please-enter-a-valid-street" />
	<liferay-ui:error exception="<%=AddressZipException.class%>"
		message="please-enter-a-valid-postal-code" />
	<liferay-ui:error exception="<%=CaptchaConfigurationException.class%>"
		message="a-captcha-error-occurred-please-contact-an-administrator" />
	<liferay-ui:error exception="<%=CaptchaException.class%>"
		message="captcha-verification-failed" />
	<liferay-ui:error exception="<%=CaptchaTextException.class%>"
		message="text-verification-failed" />
	<liferay-ui:error exception="<%=CompanyMaxUsersException.class%>"
		message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
	<liferay-ui:error exception="<%=ContactBirthdayException.class%>"
		message="please-enter-a-valid-birthday" />
	<liferay-ui:error
		exception="<%=ContactNameException.MustHaveFirstName.class%>"
		message="please-enter-a-valid-first-name" />
	<liferay-ui:error
		exception="<%=ContactNameException.MustHaveLastName.class%>"
		message="please-enter-a-valid-last-name" />
	<liferay-ui:error
		exception="<%=ContactNameException.MustHaveValidFullName.class%>"
		message="please-enter-a-valid-first-middle-and-last-name" />
	<liferay-ui:error exception="<%=EmailAddressException.class%>"
		message="please-enter-a-valid-email-address" />

	<liferay-ui:error exception="<%=GroupFriendlyURLException.class%>">

		<%
		GroupFriendlyURLException gfurle = (GroupFriendlyURLException) errorException;
		%>

		<c:if
			test="<%=gfurle.getType() == GroupFriendlyURLException.DUPLICATE%>">
			<liferay-ui:message
				key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%=NoSuchCountryException.class%>"
		message="please-select-a-country" />
	<liferay-ui:error exception="<%=NoSuchListTypeException.class%>"
		message="please-select-a-type" />
	<liferay-ui:error exception="<%=NoSuchRegionException.class%>"
		message="please-select-a-region" />
	<liferay-ui:error exception="<%=PhoneNumberException.class%>"
		message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%=PhoneNumberExtensionException.class%>"
		message="please-enter-a-valid-phone-number-extension" />
	<liferay-ui:error exception="<%=RequiredFieldException.class%>"
		message="please-fill-out-all-required-fields" />
	<liferay-ui:error exception="<%=TermsOfUseException.class%>"
		message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error
		exception="<%=UserEmailAddressException.MustNotBeDuplicate.class%>"
		message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error
		exception="<%=UserEmailAddressException.MustNotBeNull.class%>"
		message="please-enter-an-email-address" />
	<liferay-ui:error
		exception="<%=UserEmailAddressException.MustNotBePOP3User.class%>"
		message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error
		exception="<%=UserEmailAddressException.MustNotBeReserved.class%>"
		message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error
		exception="<%=UserEmailAddressException.MustNotUseCompanyMx.class%>"
		message="the-email-address-you-requested-is-not-valid-because-its-domain-is-reserved" />
	<liferay-ui:error
		exception="<%=UserEmailAddressException.MustValidate.class%>"
		message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%=UserIdException.MustNotBeNull.class%>"
		message="please-enter-a-user-id" />
	<liferay-ui:error
		exception="<%=UserIdException.MustNotBeReserved.class%>"
		message="the-user-id-you-requested-is-reserved" />

	<liferay-ui:error
		exception="<%=UserPasswordException.MustBeLonger.class%>">

		<%
		UserPasswordException.MustBeLonger upe = (UserPasswordException.MustBeLonger) errorException;
		%>

		<liferay-ui:message arguments="<%=String.valueOf(upe.minLength)%>"
			key="that-password-is-too-short" translateArguments="<%=false%>" />
	</liferay-ui:error>

	<liferay-ui:error
		exception="<%=UserPasswordException.MustComplyWithModelListeners.class%>"
		message="that-password-is-invalid-please-enter-a-different-password" />

	<liferay-ui:error
		exception="<%=UserPasswordException.MustComplyWithRegex.class%>">

		<%
		UserPasswordException.MustComplyWithRegex upe = (UserPasswordException.MustComplyWithRegex) errorException;
		%>

		<liferay-ui:message arguments="<%=HtmlUtil.escape(upe.regex)%>"
			key="that-password-does-not-comply-with-the-regular-expression"
			translateArguments="<%=false%>" />
	</liferay-ui:error>

	<liferay-ui:error
		exception="<%=UserPasswordException.MustHaveMoreNumbers.class%>">

		<%
		UserPasswordException.MustHaveMoreNumbers upe = (UserPasswordException.MustHaveMoreNumbers) errorException;
		%>

		<liferay-ui:message arguments="<%=String.valueOf(upe.minNumbers)%>"
			key="that-password-must-contain-at-least-x-numbers"
			translateArguments="<%=false%>" />
	</liferay-ui:error>

	<liferay-ui:error
		exception="<%=UserPasswordException.MustHaveMoreSymbols.class%>">

		<%
		UserPasswordException.MustHaveMoreSymbols upe = (UserPasswordException.MustHaveMoreSymbols) errorException;
		%>

		<liferay-ui:message arguments="<%=String.valueOf(upe.minSymbols)%>"
			key="that-password-must-contain-at-least-x-symbols"
			translateArguments="<%=false%>" />
	</liferay-ui:error>

	<liferay-ui:error
		exception="<%=UserPasswordException.MustHaveMoreUppercase.class%>">

		<%
		UserPasswordException.MustHaveMoreUppercase upe = (UserPasswordException.MustHaveMoreUppercase) errorException;
		%>

		<liferay-ui:message arguments="<%=String.valueOf(upe.minUppercase)%>"
			key="that-password-must-contain-at-least-x-uppercase-characters"
			translateArguments="<%=false%>" />
	</liferay-ui:error>

	<liferay-ui:error
		exception="<%=UserPasswordException.MustMatch.class%>"
		message="the-passwords-you-entered-do-not-match" />
	<liferay-ui:error
		exception="<%=UserPasswordException.MustNotBeNull.class%>"
		message="the-password-cannot-be-blank" />
	<liferay-ui:error
		exception="<%=UserPasswordException.MustNotBeTrivial.class%>"
		message="that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
	<liferay-ui:error
		exception="<%=UserPasswordException.MustNotContainDictionaryWords.class%>"
		message="that-password-uses-common-dictionary-words" />
	<liferay-ui:error
		exception="<%=UserScreenNameException.MustNotBeDuplicate.class%>"
		focusField="screenName"
		message="the-screen-name-you-requested-is-already-taken" />
	<liferay-ui:error
		exception="<%=UserScreenNameException.MustNotBeNull.class%>"
		focusField="screenName" message="the-screen-name-cannot-be-blank" />
	<liferay-ui:error
		exception="<%=UserScreenNameException.MustNotBeNumeric.class%>"
		focusField="screenName"
		message="the-screen-name-cannot-contain-only-numeric-values" />
	<liferay-ui:error
		exception="<%=UserScreenNameException.MustNotBeReserved.class%>"
		message="the-screen-name-you-requested-is-reserved" />
	<liferay-ui:error
		exception="<%=UserScreenNameException.MustNotBeReservedForAnonymous.class%>"
		focusField="screenName"
		message="the-screen-name-you-requested-is-reserved-for-the-anonymous-user" />
	<liferay-ui:error
		exception="<%=UserScreenNameException.MustNotBeUsedByGroup.class%>"
		focusField="screenName"
		message="the-screen-name-you-requested-is-already-taken-by-a-site" />
	<liferay-ui:error
		exception="<%=UserScreenNameException.MustProduceValidFriendlyURL.class%>"
		focusField="screenName"
		message="the-screen-name-you-requested-must-produce-a-valid-friendly-url" />

	<liferay-ui:error
		exception="<%=UserScreenNameException.MustValidate.class%>"
		focusField="screenName">

		<%
		UserScreenNameException.MustValidate usne = (UserScreenNameException.MustValidate) errorException;
		%>

		<liferay-ui:message
			key="<%=usne.screenNameValidator.getDescription(locale)%>" />
	</liferay-ui:error>

	<liferay-ui:error exception="<%=WebsiteURLException.class%>"
		message="please-enter-a-valid-url" />
<style>
    .card-style {
        position: relative;
        border: 1px solid #ddd;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        transition: box-shadow 0.3s ease-in-out;
        background-image: url('https://png.pngtree.com/background/');
        background-color:lightgreen;
        background-size: cover;
        background:attachment;
        overflow: hidden;
    }

    /* Add a light opacity overlay */
    .card-style:before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(255, 255, 255, ); /* Adjust the opacity value (0.8) as needed */
    }

    .card-style:hover {
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }

    /* Additional styles for text fields */
    .card-style input[type="text"],
    .card-style input[type="file"],
    .card-style select,
    .card-style button {
        border: 1px solid #ccc;
        border-radius: 5px;
        padding: 8px;
        margin-bottom: 10px;
    }

    .card-style input[type="text"]:hover,
    .card-style input[type="file"]:hover,
    .card-style select:hover,
    .card-style button:hover {
        border: 1px solid #555;
    }
    .border-color{
   
    }
</style>

	<aui:model-context model="<%=Contact.class%>" />
<div class="card-background">

	<clay:sheet>
	<div class="border-color">
		<clay:sheet-section>
			<div class="card-style">
				<h3 class="sheet-subtitle">
					<liferay-ui:message key="user-display-data" />
				</h3>

				<clay:row>
					<clay:col md="6">

						<%
						Boolean autoGenerateScreenName = PrefsPropsUtil.getBoolean(company.getCompanyId(),
								PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE);
						%>

						<c:if test="<%=!autoGenerateScreenName%>">
							<aui:input model="<%=User.class%>" name="screenName"
								label="Mobile Number">

								<%
								ScreenNameValidator screenNameValidator = ScreenNameValidatorFactory.getInstance();
								%>

								<c:if
									test="<%=Validator.isNotNull(screenNameValidator.getAUIValidatorJS())%>">
									<aui:validator errorMessage="Enter Your Mobile Number"
										name="digits"></aui:validator>
									<aui:validator
										errorMessage="<%=screenNameValidator.getDescription(locale)%>"
										name="custom">
										<%=screenNameValidator.getAUIValidatorJS()%>
									</aui:validator>
								</c:if>
							</aui:input>
						</c:if>

						<aui:input model="<%=User.class%>" name="emailAddress"
							required="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED)%>" />
					</clay:col>
					<clay:col md="6">
						<img
							src="/image/user_male_portrait?img_id=0&img_id_token=ml8ak%2BZFyxdJKXMun4My4PavmL4%3D&t=1704777810332"
							id="img_url" alt="Please choose">
						<aui:script>
									function img_pathUrl(input){
								    $('#img_url')[0].src = (window.URL ? URL : webkitURL).createObjectURL(input.files[0]);
								    }
							</aui:script>
						<style>
#img_url {
	background: #ddd;
	min-width: 8rem;
	min-height: 10rem;
	display: block;
	margin-left: 7rem;
	height: 8rem;
	width: 8rem;
}
</style>
						<br>
						<aui:input name="portraitImage" label="Profile Photo" type="file"
							id="img_file" onChange="img_pathUrl(this);">
							<aui:validator name="required" />
							<aui:validator name="acceptFiles">'jpg,png'</aui:validator>
						</aui:input>
					</clay:col>

				</clay:row>
			</div>

			<div class="card-style">
				<h3 class="sheet-subtitle">
					<liferay-ui:message key="personal-information" />
				</h3>

				<clay:row>
					<clay:col md="6">
						<liferay-ui:user-name-fields />
						<c:choose>
							<c:when
								test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY)%>">
								<aui:input name="birthday" value="<%=birthdayCalendar%>" />
							</c:when>
							<c:otherwise>
								<aui:input name="birthdayMonth" type="hidden"
									value="<%=Calendar.JANUARY%>" />
								<aui:input name="birthdayDay" type="hidden" value="1" />
								<aui:input name="birthdayYear" type="hidden" value="1970" />
							</c:otherwise>
						</c:choose>

						<c:if
							test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE)%>">
							<aui:select label="gender" name="male">
								<aui:option label="male" value="1" />
								<aui:option label="female" selected="<%=!male%>" value="0" />
							</aui:select>
						</c:if>
						<aui:input name="occupation" label="Occupation" type="text">
							<aui:validator name="required" />
						</aui:input>
					</clay:col>

					<clay:col md="5">
						<aui:select name="whyHere" label="Why are you here?"
							id="siteSelection">
							<aui:option value="">Select One</aui:option>
							<aui:option value="matrimony">For Matrimony</aui:option>
							<aui:option value="travel">For travel</aui:option>
						</aui:select>
						<aui:script>
							$("#matrimony").hide();
							$("#<portlet:namespace />siteSelection").on("change",siteSelection);
							function siteSelection() {
								var selectedSite = $("#<portlet:namespace />siteSelection").val();
								if(selectedSite == "matrimony") {
									$("#matrimony").show();
									$("#<portlet:namespace />availableLocality").attr("required","true");
									$("#<portlet:namespace />maritalStatus").attr("required","true");
									$("#<portlet:namespace />education").attr("required","true");
									$("#<portlet:namespace />height").attr("required","true");
									$("#<portlet:namespace />weight").attr("required","true");
									$("#<portlet:namespace />color").attr("required","true");
									$("#<portlet:namespace />jamath").attr("required","true");
								} else {
									$("#matrimony").hide();
									$("#<portlet:namespace />availableLocality").removeAttr("required");
									$("#<portlet:namespace />maritalStatus").removeAttr("required");
									$("#<portlet:namespace />education").removeAttr("required");
									$("#<portlet:namespace />height").removeAttr("required");
									$("#<portlet:namespace />weight").removeAttr("required");
									$("#<portlet:namespace />color").removeAttr("required");
									$("#<portlet:namespace />jamath").removeAttr("required");
								}
							}
					</aui:script>
						<div id="matrimony">
							<%
							List<Country> countries = CountryLocalServiceUtil.getCountries(-1, -1);
							%>
							<aui:select name="country" label="Select country"
								id="selectedCountry">
								<aui:option value="">Select Country</aui:option>
								<%
								for (Country countryItems : countries) {
								%>
								<aui:option value="<%=countryItems.getCountryId()%>"><%=countryItems.getName().toUpperCase()%></aui:option>
								<%
								}
								%>
							</aui:select>
							<aui:script>
							$("#<portlet:namespace />selectedCountry").on("change",selectedCountry);
							    function selectedCountry(){
								 console.log($("#<portlet:namespace />selectedCountry").val());
								         Liferay.Service(
										'/region/get-regions',
										{
						    				countryId: $('#<portlet:namespace />selectedCountry').val()
										},
										function(data) {
						    			console.log(data);
						    			var stateNameList = data;
						    			$('#<portlet:namespace />selectedState').empty();
						    			for(var i in stateNameList) {
						    			$('#<portlet:namespace />selectedState').append("<option value='"+ stateNameList[i].regionId +"'>"+stateNameList[i].title+"</option>");
	    										}
									}
							);
								   	}
						</aui:script>
							<aui:select name="state" label="Select state" id="selectedState">
								<aui:option value="">Select State</aui:option>
								<aui:script>
						$("#<portlet:namespace />selectedState").on("change",selectedState);
						 function selectedState(){
							 var stateId = $("#<portlet:namespace />selectedState").val();
							 Liferay.Service(
										'/district/get-by-region-id',
										{
						    				regionId: stateId
										},
										function(data) {
						    			console.log(data);
									var districtNameList = data;
					    			$('#<portlet:namespace />selectedDistrict').empty();
					    			$('#<portlet:namespace />availableLocality').empty();
					    			for(var i in districtNameList) {
					    			$('#<portlet:namespace />selectedDistrict').append("<option value='"+ districtNameList[i].districtId +"'>"+districtNameList[i].name+"</option>");
					    			}
					    			}
									);
		 }
						</aui:script>
							</aui:select>
							<aui:select name="district" label="District"
								id="selectedDistrict">
								<aui:option value="">Select District</aui:option>
							</aui:select>
							<aui:script>
						$("#<portlet:namespace />selectedDistrict").on("change",selectedDistrict);
						 function selectedDistrict(){
							 var districtId = $("#<portlet:namespace />selectedDistrict").val();
							 Liferay.Service(
										'/locality/get-locality-by-district-id',
										{
						    				districtId: districtId
										},
										function(data) {
						    			console.log(data);
									var areaNameList = data;
					    			$('#<portlet:namespace />availableLocality').empty();
					    			for(var i in areaNameList) {
					    			$('#<portlet:namespace />availableLocality').append("<option value='"+ areaNameList[i].name +"'>"+areaNameList[i].name+"</option>");
					    			}
					    			}
									);
		 }
						</aui:script>
							<aui:select name="area" label="Area" id="availableLocality">
								<aui:option value="">Select Area</aui:option>
							</aui:select>
							<aui:select label="Marital Status" name="maritalStatus"
								id="maritalStatus">
								<aui:option value="">Select Marital Status</aui:option>
								<aui:option label="Single" value="Single" />
								<aui:option label="Divorced" value="Divorced" />
								<aui:option label="Widowed" value="Widowed" />
								<aui:option label="Separated" value="Separated" />
							</aui:select>
							<aui:input name="education" label="Education" type="text"
								id="education">
							</aui:input>
							<aui:input name="height" label="Height (in CM)" type="text"
								id="height">
								<aui:validator errorMessage="Enter Your Height in CM"
									name="digits"></aui:validator>
							</aui:input>
							<aui:input name="weight" label="Weight (in CM)" type="text"
								id="weight">
								<aui:validator errorMessage="Enter Your weight in CM"
									name="digits"></aui:validator>
							</aui:input>
							<aui:input name="color" lable="Choose your skin tone"
								type="color" id="color" value="#964B00"></aui:input>
							<aui:select label="Jamath" name="jamath" id="jamath">
								<aui:option value="">Select Jamath</aui:option>
								<aui:option label="Sunnathwal Jamath" value="Sunnathwal Jamath" />
								<aui:option label="Thowheed Jamath" value="Thowheed Jamath" />
								<aui:option label="TNTJ" value="TNTJ" />
								<aui:option label="Others" value="Others" />
							</aui:select>
							<%-- <liferay-expando:custom-attributes-available
							className="<%=User.class.getName()%>">
							<liferay-expando:custom-attribute-list
								className="<%=User.class.getName()%>"
								classPK="<%=(user != null) ? user.getUserId() : 0%>"
								editable="<%=true%>" label="<%=true%>" />
						</liferay-expando:custom-attributes-available> --%>
						</div>
					</clay:col>
				</clay:row>
			</div>

			<c:if
				test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD,
		PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD)%>">
				<div class="form-group">
					<h3 class="sheet-subtitle">
						<liferay-ui:message key="password" />
					</h3>

					<clay:row>
						<clay:col md="6">
							<aui:input label="password" name="password1" required="<%=true%>"
								size="30" type="password" value="" />

							<aui:input label="reenter-password" name="password2"
								required="<%=true%>" size="30" type="password" value="">
								<aui:validator name="equalTo">
									'#<portlet:namespace />password1'
								</aui:validator>
							</aui:input>
						</clay:col>
					</clay:row>
				</div>
			</c:if>

			<%-- <div class="form-group">
				<h3 class="mb-2 sheet-subtitle"><liferay-ui:message key="verification" /></h3>

				<clay:row>
					<clay:col
						md="6"
					>
						<c:if test="<%= captchaConfiguration.createAccountCaptchaEnabled() %>">
							<liferay-captcha:captcha />
						</c:if>
					</clay:col>
				</clay:row>
			</div> --%>
			<div class="form-group">
				<aui:button-row>
					<aui:button type="submit" />
				</aui:button-row>

				<%@ include file="/navigation.jspf"%>
			</div>
		</clay:sheet-section>
	</clay:sheet>
</aui:form>
</div>
</div>
</div>