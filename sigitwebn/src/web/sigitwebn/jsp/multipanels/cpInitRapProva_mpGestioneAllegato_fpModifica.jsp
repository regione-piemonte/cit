<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpModifica" class="formPanelBlock"><!-- startFragment:p_fpModifica -->
		
	
<div class="formPanel" id="fpModifica">


	
	

	
	
			
	
	<div id="p_wpDatiRapportoIspeImpiantiModifica" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiRapportoIspeImpiantiModifica -->
	
	
<h4 class="wpLabel">dati rapporto di prova </h4>
<div class="widgetsPanel" id="wpDatiRapportoIspeImpiantiModifica">
	
	<customtag:widgetsPanel id="wpDatiRapportoIspeImpiantiModificaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInitRapProva','calDataControlloMod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.calDataControlloMod.label')}" labelFor="widg_calDataControlloMod" errorFor="appDataallegatoIsp.dataControllo" labelId="calDataControlloModLbl"
	  >


<!-- widget calDataControlloMod -->
<s:textfield 
	
	
	name="appDataallegatoIsp.dataControllo" id="widg_calDataControlloMod"
	disabled="isWidgetDisabled('cpInitRapProva','calDataControlloMod')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbTipoAllegatoMod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbTipoAllegatoMod.label')}" labelFor="widg_cbTipoAllegatoMod" errorFor="appDataallegatoIsp.idTipoAllegato" labelId="cbTipoAllegatoModLbl"
	  >


<!-- widget cbTipoAllegatoMod -->
<s:select name="appDataallegatoIsp.idTipoAllegato" id="widg_cbTipoAllegatoMod"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentoProfilatiIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbTipoAllegatoMod')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbCombustibileMod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbCombustibileMod.label')}" labelFor="widg_cbCombustibileMod" errorFor="appDataallegatoIsp.idTipiCombustibile" labelId="cbCombustibileModLbl"
	  >


<!-- widget cbCombustibileMod -->
<s:select name="appDataallegatoIsp.idTipiCombustibile" id="widg_cbCombustibileMod"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiCombustibileIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbCombustibileMod')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpInitRapProva','cbApparecchiatureMod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.cbApparecchiatureMod.label')}" labelFor="widg_cbApparecchiatureMod" errorFor="appDataallegatoIsp.idApparecchiature" labelId="cbApparecchiatureModLbl"
	  >


<!-- widget cbApparecchiatureMod -->
<s:select name="appDataallegatoIsp.idApparecchiature" id="widg_cbApparecchiatureMod"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiatureIsp"
	  disabled="isWidgetDisabled('cpInitRapProva','cbApparecchiatureMod')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiRapportoIspeImpiantiModifica --></div>

	

		
	
</div>

	<!-- endFragment:p_fpModifica --></div>
