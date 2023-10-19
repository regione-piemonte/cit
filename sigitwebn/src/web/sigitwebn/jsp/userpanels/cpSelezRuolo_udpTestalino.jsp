<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_udpTestalino" class="panelBlock"><!-- startFragment:p_udpTestalino -->
<div class="userDefinedPanel" id="udpTestalino">
<!--PROTECTED REGION ID(R-224822594) ENABLED START-->
<!-- Inserire il codice del pannello -->
<div id="contUtente">
	<div id="Utente">
		<span id="datiUtente">
			Utente: <b><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></b>
		</span>
	</div>
	<div id="logoutLinkDiv">
		<s:url id="logoutUrl" action="Logout" namespace="/secure" method="ssoLogout" />
		<s:a href="%{logoutUrl}" title="Disconnetti dal servizio">Esci</s:a>
	</div>
</div>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_udpTestalino --></div>
