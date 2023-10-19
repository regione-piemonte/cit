<%@taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{appDataallegatoIsp != null && appDataallegatoIsp.idStatoRapporto == 0 && (appDatautenteLoggato.ruolo.descRuolo == 'SUPERUSER'  || appDatautenteLoggato.ruolo.descRuolo == 'ISPETTORE')}">
	<a id="id_linkable_cell" href="/sigitwebn/base/main/generaRappProvaNOW.do"><span class="pdf">PDF rap prova</span></a>
</s:if>
<s:if test="%{appDataallegatoIsp != null && appDataallegatoIsp.idStatoRapporto == 0 && (appDatautenteLoggato.ruolo.descRuolo == 'SUPERUSER' || appDatautenteLoggato.ruolo.descRuolo == 'ISPETTORE')}">
	<a id="id_linkable_cell" href="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaConfirm!handleHvVerificaInvioRapProva_CLICKED.do">invia/consolida RapProva</a>
</s:if>