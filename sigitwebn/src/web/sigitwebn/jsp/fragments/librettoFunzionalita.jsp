<%@taglib prefix="s" uri="/struts-tags" %>

<a id="id_linkable_cell" href="/sigitwebn/base/main/recuperaLibretto.do"><span class="pdf">PDF libretto consolidato</span></a>
<a id="id_linkable_cell" href="/sigitwebn/base/main/recuperaLibrettoXML.do"><span class="pdf">XML libretto consolidato</span></a>
<a id="id_linkable_cell" href="/sigitwebn/base/main/generaLibrettoNOW.do"><span class="pdf">Visualizza bozza libretto</span></a>
<a id="id_linkable_cell" href="/sigitwebn/base/gestisci_libretto_aggiornamenti/cpGestLibAggiornamenti.do">Verifica libretto</a>
<s:if test="%{appDatautenteLoggato.ruolo.descRuolo == 'IMPRESA' ||
				appDatautenteLoggato.ruolo.descRuolo == 'SUPERUSER' || 
				appDatautenteLoggato.ruolo.descRuolo == 'VALIDATORE' || 
				appDatautenteLoggato.ruolo.descRuolo == 'ISPETTORE'}">
	<a id="id_linkable_cell" href="/sigitwebn/base/main/consolidaLibretto.do">Consolida libretto</a>
</s:if>
