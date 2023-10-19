<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

			
			
<s:set name="mddPortalCode" value="getPortalCode()" />
<s:set name="mddChannelCode" value="getChannelCode()" />
<s:set name="applicationCssUrl" value="getStaticResource('/ris/utheme/{areaCode}/sigitweba/css/sigitweba.css')" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml" lang="it" xml:lang="it">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>CIT Registrazione</title>
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/globalPortal.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/xhtmlStructureUniversal.css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/<s:property value="mddChannelCode" />/theme.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="<s:property value="applicationCssUrl" />" media="screen" />		
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/corner/corner.css" media="screen" />
		<!--[if lte IE 6]>
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/ie6.css" media="screen" />
		<![endif]-->
		<!--[if IE 7]>
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/ie7.css" media="screen" />
		<![endif]-->
		<!-- funzioni e definizioni javascript -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/ris/js/jsFunctions.js"></script>
			
		


	<csiuicore:header areaCode='${sessionScope["MDD_CHANNEL_CODE"]}' />

	</head>
	<body>
		
		<noscript>
			<meta http-equiv="refresh" content="0;url=<%=request.getContextPath()%>/base/javascriptError.do"  />
		</noscript>

		<!-- PAGE (OBBLIGATORIO) -->
		<div id="page">

			<!-- HEADER di PORTALE (con remincl) (facoltativo) -->
			
<r:include url="/ris/utheme/global/themes/xstructureV1/include/portal_header.html" resourceProvider="${mddPortalCode}" />

			<!-- fine HEADER di PORTALE (con remincl) (facoltativo) -->

			<!-- APPICATION AREA (OBBLIGATORIO) -->
			<div id="applicationArea">

				<!-- HEADER di APPLICATIVO (con remincl) (facoltativo) -->
				
<s:set name="applicationHeaderUrl" value="getStaticResource('/ris/utheme/{areaCode}/sigitweba/include/application_header.html')" />
<r:include url="${applicationHeaderUrl}" resourceProvider="${mddPortalCode}" />

				<!-- fine HEADER di APPLICATIVO (con remincl) (facoltativo) -->

<!-- FINE HEADER -->


