<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAssociaCodImp" class="formPanelBlock"><!-- startFragment:p_fpAssociaCodImp -->
		
	
<div class="formPanel" id="fpAssociaCodImp">


	
	

	
	
			
	
	<div id="p_wpAssociaCodImp" class="widgetsPanelBlock"><!-- startFragment:p_wpAssociaCodImp -->
	
	
<h4 class="wpLabel">assegna codice impianto </h4>
<div class="widgetsPanel" id="wpAssociaCodImp">
	
	<customtag:widgetsPanel id="wpAssociaCodImpTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','tfCercaCodiceImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.tfCercaCodiceImpianto.label')}" labelFor="widg_tfCercaCodiceImpianto" errorFor="appDataricercaImpiantoDaAssociareAccertamento.codiceImpianto" labelId="tfCercaCodiceImpiantoLbl"
	position="first"  >


<!-- widget tfCercaCodiceImpianto -->
<s:textfield 
	
	
	name="appDataricercaImpiantoDaAssociareAccertamento.codiceImpianto" id="widg_tfCercaCodiceImpianto"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','tfCercaCodiceImpianto')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btCercaCodiceImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btCercaCodiceImpianto -->
<s:submit name="widg_btCercaCodiceImpianto" id="widg_btCercaCodiceImpianto" method="handleBtCercaCodiceImpianto_CLICKED"
	key="cpDettaglioAccertamentoConf.btCercaCodiceImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btCercaCodiceImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptUbicazioneImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptUbicazioneImpianto.label')}" labelFor="widg_ptUbicazioneImpianto" errorFor="appDataricercaImpiantoDaAssociareAccertamento.ubicazione" labelId="ptUbicazioneImpiantoLbl"  position="first" >


<!-- widget ptUbicazioneImpianto -->
<s:property value="appDataricercaImpiantoDaAssociareAccertamento.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','wpAssociaCodImp_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAssociaCodImp_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDataricercaImpiantoDaAssociareAccertamento.responsabile" labelId="ptResponsabileImpiantoLbl"  position="first" >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDataricercaImpiantoDaAssociareAccertamento.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','wpAssociaCodImp_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAssociaCodImp_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btNuovaRicercaCodiceImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btNuovaRicercaCodiceImpianto -->
<s:submit name="widg_btNuovaRicercaCodiceImpianto" id="widg_btNuovaRicercaCodiceImpianto" method="handleBtNuovaRicercaCodiceImpianto_CLICKED"
	key="cpDettaglioAccertamentoConf.btNuovaRicercaCodiceImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btNuovaRicercaCodiceImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','wpAssociaCodImp_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAssociaCodImp_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAssociaCodImp --></div>

			
	
	<div id="p_cpFunAssociaCodImp" class="commandPanelBlock"><!-- startFragment:p_cpFunAssociaCodImp -->
	
	
<div class="commandPanel functional" id="cpFunAssociaCodImp">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btSalvaAssociaCodImp')" >

	



<!-- widget btSalvaAssociaCodImp -->
<s:submit name="widg_btSalvaAssociaCodImp" id="widg_btSalvaAssociaCodImp" method="handleBtSalvaAssociaCodImp_CLICKED"
	key="cpDettaglioAccertamentoConf.btSalvaAssociaCodImp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btSalvaAssociaCodImp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunAssociaCodImp --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAssociaCodImp --></div>
