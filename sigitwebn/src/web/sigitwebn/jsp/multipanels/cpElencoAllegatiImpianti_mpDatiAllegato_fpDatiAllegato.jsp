<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiAllegato" class="formPanelBlock"><!-- startFragment:p_fpDatiAllegato -->
		
	
<div class="formPanel" id="fpDatiAllegato">


	
	

	
	
			
	
	<div id="p_wpDatiAllegatoImpianti" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiAllegatoImpianti -->
	
	
<h4 class="wpLabel">dati REE </h4>
<div class="widgetsPanel" id="wpDatiAllegatoImpianti">
	
	<customtag:widgetsPanel id="wpDatiAllegatoImpiantiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','calDataControllo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.calDataControllo.label')}" labelFor="widg_calDataControllo" errorFor="appDataallegato.dataControllo" labelId="calDataControlloLbl"
	  >


<!-- widget calDataControllo -->
<s:textfield 
	
	
	name="appDataallegato.dataControllo" id="widg_calDataControllo"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','calDataControllo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','cbTipoAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.cbTipoAllegato.label')}" labelFor="widg_cbTipoAllegato" errorFor="appDataallegato.idTipoAllegato" labelId="cbTipoAllegatoLbl"
	  >


<!-- widget cbTipoAllegato -->
<s:select name="appDataallegato.idTipoAllegato" id="widg_cbTipoAllegato"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumentoProfilati"
	  disabled="isWidgetDisabled('cpElencoAllegatiImpianti','cbTipoAllegato')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnCercaApparecchiature')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaApparecchiature -->
	<csiuicore:ajaxify id="p_fpCenter" 
		widgetType="button"
		 
		requestUri="/sigitwebn/base/elenco_allegati_impianti/cpElencoAllegatiImpianti!handleBtnCercaApparecchiature_CLICKED.do" 
		
		pageId="cpElencoAllegatiImpianti" 
		formName="cpElencoAllegatiImpianti"
		javascriptDetection="false">
<s:submit name="widg_btnCercaApparecchiature" id="widg_btnCercaApparecchiature" method="handleBtnCercaApparecchiature_CLICKED"
	key="cpElencoAllegatiImpianti.btnCercaApparecchiature.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnCercaApparecchiature')" />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnNuovaRicercaApparecchiature')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnNuovaRicercaApparecchiature -->
	<csiuicore:ajaxify id="p_fpCenter" 
		widgetType="button"
		 
		requestUri="/sigitwebn/base/elenco_allegati_impianti/cpElencoAllegatiImpianti!handleBtnNuovaRicercaApparecchiature_CLICKED.do" 
		
		pageId="cpElencoAllegatiImpianti" 
		formName="cpElencoAllegatiImpianti"
		javascriptDetection="false">
<s:submit name="widg_btnNuovaRicercaApparecchiature" id="widg_btnNuovaRicercaApparecchiature" method="handleBtnNuovaRicercaApparecchiature_CLICKED"
	key="cpElencoAllegatiImpianti.btnNuovaRicercaApparecchiature.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnNuovaRicercaApparecchiature')" />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','cbCombustibile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.cbCombustibile.label')}" labelFor="widg_cbCombustibile" errorFor="appDataallegato.idTipiCombustibile" labelId="cbCombustibileLbl"
	  >


<!-- widget cbCombustibile -->
<s:select name="appDataallegato.idTipiCombustibile" id="widg_cbCombustibile"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiCombustibile"
	  disabled="isWidgetDisabled('cpElencoAllegatiImpianti','cbCombustibile')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','ptCombustibili')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.ptCombustibili.label')}" labelFor="widg_ptCombustibili" errorFor="appDataallegato.elencoCombustibili" labelId="ptCombustibiliLbl"   >


<!-- widget ptCombustibili -->
<s:property value="appDataallegato.elencoCombustibili" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnFiltraComp')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnFiltraComp -->
<s:submit name="widg_btnFiltraComp" id="widg_btnFiltraComp" method="handleBtnFiltraComp_CLICKED"
	key="cpElencoAllegatiImpianti.btnFiltraComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnFiltraComp')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','cbApparecchiature')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.cbApparecchiature.label')}" labelFor="widg_cbApparecchiature" errorFor="appDataallegato.idApparecchiature" labelId="cbApparecchiatureLbl"
	  >


<!-- widget cbApparecchiature -->
<s:select name="appDataallegato.idApparecchiature" id="widg_cbApparecchiature"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiature"
	  disabled="isWidgetDisabled('cpElencoAllegatiImpianti','cbApparecchiature')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','ptApparecchiature')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.ptApparecchiature.label')}" labelFor="widg_ptApparecchiature" errorFor="appDataallegato.elencoApparecchiature" labelId="ptApparecchiatureLbl"   >


<!-- widget ptApparecchiature -->
<s:property value="appDataallegato.elencoApparecchiature" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnVerificaApparecchiature')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnVerificaApparecchiature -->
	<csiuicore:ajaxify id="p_fpCenter" 
		widgetType="button"
		 
		requestUri="/sigitwebn/base/elenco_allegati_impianti/cpElencoAllegatiImpianti!handleBtnVerificaApparecchiature_CLICKED.do" 
		
		pageId="cpElencoAllegatiImpianti" 
		formName="cpElencoAllegatiImpianti"
		javascriptDetection="false">
<s:submit name="widg_btnVerificaApparecchiature" id="widg_btnVerificaApparecchiature" method="handleBtnVerificaApparecchiature_CLICKED"
	key="cpElencoAllegatiImpianti.btnVerificaApparecchiature.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnVerificaApparecchiature')" />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiAllegatoImpianti --></div>

			
	
	<div id="p_cpNavDatiAllegato" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiAllegato -->
	
	
<div class="commandPanel navigation" id="cpNavDatiAllegato">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnChiudiDatiAlleagto')" >

	



<!-- widget btnChiudiDatiAlleagto -->
<s:submit name="widg_btnChiudiDatiAlleagto" id="widg_btnChiudiDatiAlleagto" method="handleBtnChiudiDatiAlleagto_CLICKED"
	key="cpElencoAllegatiImpianti.btnChiudiDatiAlleagto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnChiudiDatiAlleagto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnReeWeb')" >

	



<!-- widget btnReeWeb -->
<s:submit name="widg_btnReeWeb" id="widg_btnReeWeb" method="handleBtnReeWeb_CLICKED"
	key="cpElencoAllegatiImpianti.btnReeWeb.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnReeWeb')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiAllegato --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiAllegato --></div>
