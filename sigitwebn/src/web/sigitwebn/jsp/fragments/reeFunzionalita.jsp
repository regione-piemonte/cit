<%@taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{appDataallegato != null && appDataallegato.idStatoRapporto == 0 && (appDatautenteLoggato.ruolo.descRuolo == 'SUPERUSER' || appDatautenteLoggato.ruolo.descRuolo == 'IMPRESA' || appDatautenteLoggato.ruolo.descRuolo == 'VALIDATORE')}">
	<a id="id_linkable_cell" href="/sigitwebn/base/main/generaAllegatoNOW.do"><span class="pdf">Visualizza bozza REE</span></a>
</s:if>
<a id="id_linkable_cell" href="/sigitwebn/base/gestisci_ree_documenti/cpGestisciReeDocumenti.do">Carica file</a>
<s:if test="%{appDataallegato != null && appDataallegato.idStatoRapporto == 0 && (appDatautenteLoggato.ruolo.descRuolo == 'SUPERUSER' || appDatautenteLoggato.ruolo.descRuolo == 'IMPRESA' || appDatautenteLoggato.ruolo.descRuolo == 'VALIDATORE')}">
	<!-- a id="id_linkable_cell" href="/sigitwebn/base/main/inviaAllegato.do">Invia REE</a-->
	<a id="id_linkable_cell" href="/sigitwebn/base/gestisci_ree_confirm/cpGestReeConfirm!handleHvVerificaInvioREE_CLICKED.do">Invia REE</a>
</s:if>