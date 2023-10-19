<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpInserimentoIspezioniMassive" class="formPanelBlock"><!-- startFragment:p_fpInserimentoIspezioniMassive -->
		
	
<div class="formPanel" id="fpInserimentoIspezioniMassive">


	
	

	
	
			
	
	<div id="p_wpInserimentoIspezioniMassive" class="widgetsPanelBlock"><!-- startFragment:p_wpInserimentoIspezioniMassive -->
	
	
<h4 class="wpLabel">Inserimento Ispezioni Massive </h4>
<div class="widgetsPanel" id="wpInserimentoIspezioniMassive">
	
	<customtag:widgetsPanel id="wpInserimentoIspezioniMassiveTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cbTipoVerificaInserimentoIspezioniMassive')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cbTipoVerificaInserimentoIspezioniMassive.label')}" labelFor="widg_cbTipoVerificaInserimentoIspezioniMassive" errorFor="appDatainserimentoIspezioniMassive.idTipoVerifica" labelId="cbTipoVerificaInserimentoIspezioniMassiveLbl"
	  >


<!-- widget cbTipoVerificaInserimentoIspezioniMassive -->
<s:select name="appDatainserimentoIspezioniMassive.idTipoVerifica" id="widg_cbTipoVerificaInserimentoIspezioniMassive"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiVerificaInserimentoIspezioniMassive"
	  disabled="isWidgetDisabled('cpRicercaVerifiche','cbTipoVerificaInserimentoIspezioniMassive')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','taElencoValori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.taElencoValori.label')}" labelFor="widg_taElencoValori" errorFor="appDatainserimentoIspezioniMassive.elencoValori" labelId="taElencoValoriLbl"
	  >


<!-- widget taElencoValori -->
<s:textarea 
	
	
	name="appDatainserimentoIspezioniMassive.elencoValori" id="widg_taElencoValori"
	disabled="isWidgetDisabled('cpRicercaVerifiche','taElencoValori')"
	rows="4"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cbIspezionePagamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cbIspezionePagamento.label')}" labelFor="widg_cbIspezionePagamento" errorFor="appDatainserimentoIspezioniMassive.isIspezionePagamento" labelId="cbIspezionePagamentoLbl"
	  >


<!-- widget cbIspezionePagamento -->
<s:checkbox 
	
	
	name="appDatainserimentoIspezioniMassive.isIspezionePagamento" id="widg_cbIspezionePagamento"
	disabled="isWidgetDisabled('cpRicercaVerifiche','cbIspezionePagamento')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaVerifiche','cbIspezionePagamento')" >
	<s:hidden name="__checkbox_appDatainserimentoIspezioniMassive.isIspezionePagamento" id="__checkbox_widg_cbIspezionePagamento" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInserimentoIspezioniMassive --></div>

			
	
	<div id="p_cpNavInserimentoIspezioniMassive" class="commandPanelBlock"><!-- startFragment:p_cpNavInserimentoIspezioniMassive -->
	
	
<div class="commandPanel functional" id="cpNavInserimentoIspezioniMassive">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaVerifiche','btChiudiInserimentoIspezioniMassive')" >

	



<!-- widget btChiudiInserimentoIspezioniMassive -->
<s:submit name="widg_btChiudiInserimentoIspezioniMassive" id="widg_btChiudiInserimentoIspezioniMassive" method="handleBtChiudiInserimentoIspezioniMassive_CLICKED"
	key="cpRicercaVerifiche.btChiudiInserimentoIspezioniMassive.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaVerifiche','btChiudiInserimentoIspezioniMassive')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaVerifiche','btAvviaInserimentoIspezioniMassive')" >

	



<!-- widget btAvviaInserimentoIspezioniMassive -->
<s:submit name="widg_btAvviaInserimentoIspezioniMassive" id="widg_btAvviaInserimentoIspezioniMassive" method="handleBtAvviaInserimentoIspezioniMassive_CLICKED"
	key="cpRicercaVerifiche.btAvviaInserimentoIspezioniMassive.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaVerifiche','btAvviaInserimentoIspezioniMassive')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavInserimentoIspezioniMassive --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInserimentoIspezioniMassive --></div>
