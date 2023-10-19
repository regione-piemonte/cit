<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_cpFunDatiIspezione" class="commandPanelBlock"><!-- startFragment:p_cpFunDatiIspezione -->
	
	
<div class="commandPanel functional" id="cpFunDatiIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnAnnullaDatiIspezione')" >

	



<!-- widget btnAnnullaDatiIspezione -->
<s:submit name="widg_btnAnnullaDatiIspezione" id="widg_btnAnnullaDatiIspezione" method="handleBtnAnnullaDatiIspezione_CLICKED"
	key="cpElencoIspezioniImpianti.btnAnnullaDatiIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnAnnullaDatiIspezione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunDatiIspezione --></div>
