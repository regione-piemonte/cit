<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_cpNavDatiIspezione" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiIspezione -->
	
	
<div class="commandPanel navigation" id="cpNavDatiIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnChiudiDatiIspezione')" >

	



<!-- widget btnChiudiDatiIspezione -->
<s:submit name="widg_btnChiudiDatiIspezione" id="widg_btnChiudiDatiIspezione" method="handleBtnChiudiDatiIspezione_CLICKED"
	key="cpElencoIspezioniImpianti.btnChiudiDatiIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnChiudiDatiIspezione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnCreaIspezione')" >

	



<!-- widget btnCreaIspezione -->
<s:submit name="widg_btnCreaIspezione" id="widg_btnCreaIspezione" method="handleBtnCreaIspezione_CLICKED"
	key="cpElencoIspezioniImpianti.btnCreaIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnCreaIspezione')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiIspezione --></div>
