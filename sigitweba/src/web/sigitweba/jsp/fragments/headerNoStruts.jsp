<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="globalMessages" />



			
			
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="it" xml:lang="it">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>CIT Registrazione</title>
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/globalPortal.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/xhtmlStructureUniversal.css" media="screen" />
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/<c:out value='${sessionScope["MDD_CHANNEL_CODE"]}' />/theme.css" media="screen" />
		<link rel="stylesheet" type="text/css" href="/ris/utheme/<c:out value='${sessionScope["MDD_CHANNEL_CODE"]}' />/sigitweba/css/sigitweba.css" media="screen" />		
		
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/corner/corner.css" media="screen" />
		<!--[if lte IE 6]>
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/ie6.css" media="screen" />
		<![endif]-->
		<!--[if IE 7]>
		<link rel="stylesheet" type="text/css" href="/ris/utheme/global/themes/xstructureV1/css/ie7.css" media="screen" />
		<![endif]-->
		<!-- funzioni e definizioni javascript -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/ris/js/jsFunctions.js"></script>
			
		


	</head>
	<body>

		<!-- PAGE (OBBLIGATORIO) -->
		<div id="page">

			<!-- HEADER di PORTALE (con remincl) (facoltativo) -->
			
<r:include url='/ris/utheme/global/themes/xstructureV1/include/portal_header.html' resourceProvider='${sessionScope["MDD_PORTAL_CODE"]}' />

			<!-- fine HEADER di PORTALE (con remincl) (facoltativo) -->

			<!-- APPICATION AREA (OBBLIGATORIO) -->
			<div id="applicationArea">

				<!-- HEADER di APPLICATIVO (con remincl) (facoltativo) -->
				
<r:include url='<%="/ris/utheme/"+(String)session.getAttribute("MDD_CHANNEL_CODE")+"/sigitweba/include/application_header.html" %>' resourceProvider='${sessionScope["MDD_PORTAL_CODE"]}' />

				<!-- fine HEADER di APPLICATIVO (con remincl) (facoltativo) -->

<!-- FINE HEADER -->


