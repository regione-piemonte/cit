<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_cpNavDatiRapporto" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiRapporto -->
	
	
<div class="commandPanel navigation" id="cpNavDatiRapporto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnChiudiDatiAllegato')" >

	



<!-- widget btnChiudiDatiAllegato -->
<s:submit name="widg_btnChiudiDatiAllegato" id="widg_btnChiudiDatiAllegato" method="handleBtnChiudiDatiAllegato_CLICKED"
	key="cpElencoIspezioniImpianti.btnChiudiDatiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnChiudiDatiAllegato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnCreaAllegato')" >

	



<!-- widget btnCreaAllegato -->
<s:submit name="widg_btnCreaAllegato" id="widg_btnCreaAllegato" method="handleBtnCreaAllegato_CLICKED"
	key="cpElencoIspezioniImpianti.btnCreaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnCreaAllegato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiRapporto --></div>
