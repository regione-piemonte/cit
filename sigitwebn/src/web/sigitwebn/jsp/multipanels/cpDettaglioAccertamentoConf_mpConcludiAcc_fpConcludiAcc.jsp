<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpConcludiAcc" class="formPanelBlock"><!-- startFragment:p_fpConcludiAcc -->
		
	
<div class="formPanel" id="fpConcludiAcc">


	
	

	
	
			
	
	<div id="p_wpConcludiAcc" class="widgetsPanelBlock"><!-- startFragment:p_wpConcludiAcc -->
	
	
<h4 class="wpLabel">concludi accertamento </h4>
<div class="widgetsPanel" id="wpConcludiAcc">
	
	<customtag:widgetsPanel id="wpConcludiAccTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','cbTipoConclusione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.cbTipoConclusione.label')}" labelFor="widg_cbTipoConclusione" errorFor="appDataaccertamento.idTipoConclusione" labelId="cbTipoConclusioneLbl"
	position="first"  >


<!-- widget cbTipoConclusione -->
<s:select name="appDataaccertamento.idTipoConclusione" id="widg_cbTipoConclusione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoConclusione"
	  disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','cbTipoConclusione')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','wpConcludiAcc_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpConcludiAcc_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','cbIsSostIspezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.cbIsSostIspezione.label')}" labelFor="widg_cbIsSostIspezione" errorFor="appDataaccertamento.flgSostIspezione" labelId="cbIsSostIspezioneLbl"
	position="first"  >


<!-- widget cbIsSostIspezione -->
<s:checkbox 
	
	
	name="appDataaccertamento.flgSostIspezione" id="widg_cbIsSostIspezione"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','cbIsSostIspezione')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpDettaglioAccertamentoConf','cbIsSostIspezione')" >
	<s:hidden name="__checkbox_appDataaccertamento.flgSostIspezione" id="__checkbox_widg_cbIsSostIspezione" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','wpConcludiAcc_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpConcludiAcc_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','tfCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioAccertamentoConf.tfCodImp.label')}" labelFor="widg_tfCodImp" errorFor="appDataaccertamento.codiceImpiantoNew" labelId="tfCodImpLbl"
	position="first"  >


<!-- widget tfCodImp -->
<s:textfield 
	
	
	name="appDataaccertamento.codiceImpiantoNew" id="widg_tfCodImp"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','tfCodImp')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btCercaImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btCercaImpianto -->
<s:submit name="widg_btCercaImpianto" id="widg_btCercaImpianto" method="handleBtCercaImpianto_CLICKED"
	key="cpDettaglioAccertamentoConf.btCercaImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btCercaImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','ptRisultatoImpianto')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget ptRisultatoImpianto -->
<s:property value="appDataaccertamento.risultatoImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btNuovaRicercaImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btNuovaRicercaImpianto -->
<s:submit name="widg_btNuovaRicercaImpianto" id="widg_btNuovaRicercaImpianto" method="handleBtNuovaRicercaImpianto_CLICKED"
	key="cpDettaglioAccertamentoConf.btNuovaRicercaImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btNuovaRicercaImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpConcludiAcc --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioAccertamentoConf','btSalvaConcludiAcc')" >

	



<!-- widget btSalvaConcludiAcc -->
<s:submit name="widg_btSalvaConcludiAcc" id="widg_btSalvaConcludiAcc" method="handleBtSalvaConcludiAcc_CLICKED"
	key="cpDettaglioAccertamentoConf.btSalvaConcludiAcc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAccertamentoConf','btSalvaConcludiAcc')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFun --></div>

	

		
	
</div>

	<!-- endFragment:p_fpConcludiAcc --></div>
