<%@taglib prefix="s" uri="/struts-tags" %>

<div id="contUtente">
	<div id="Utente">
		<span id="datiUtente">
			Utente: <b><s:property value="appDatautenteLoggato.denominazione" /></b>
			Ruolo: <b><s:property value="appDatautenteLoggato.ruolo.descRuoloCompleto" /></b>
		</span>
	</div>
	<div id="logoutLinkDiv">
		<s:url id="logoutUrl" action="Logout" namespace="/secure" method="ssoLogout" />
		<s:a href="%{logoutUrl}" title="Disconnetti dal servizio">Esci</s:a>
	</div>
</div>