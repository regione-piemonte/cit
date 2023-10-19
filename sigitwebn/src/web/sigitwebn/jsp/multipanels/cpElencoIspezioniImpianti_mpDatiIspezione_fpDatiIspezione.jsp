<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiIspezione" class="formPanelBlock"><!-- startFragment:p_fpDatiIspezione -->
		
	
<div class="formPanel" id="fpDatiIspezione">


	
	

	
	
			
	
	<div id="p_wpDatiIspettore" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiIspettore -->
	
	
<h4 class="wpLabel">dati ispettore </h4>
<div class="widgetsPanel" id="wpDatiIspettore">
	
	<customtag:widgetsPanel id="wpDatiIspettoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','tfCodFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.tfCodFiscale.label')}" labelFor="widg_tfCodFiscale" errorFor="appDataispezione.ispettoreCF" labelId="tfCodFiscaleLbl"
	  >


<!-- widget tfCodFiscale -->
<s:textfield 
	
	
	name="appDataispezione.ispettoreCF" id="widg_tfCodFiscale"
maxlength="16"	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','tfCodFiscale')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnCercaIspe')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaIspe -->
<s:submit name="widg_btnCercaIspe" id="widg_btnCercaIspe" method="handleBtnCercaIspe_CLICKED"
	key="cpElencoIspezioniImpianti.btnCercaIspe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnCercaIspe')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnNuovaRicercaIspe')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnNuovaRicercaIspe -->
<s:submit name="widg_btnNuovaRicercaIspe" id="widg_btnNuovaRicercaIspe" method="handleBtnNuovaRicercaIspe_CLICKED"
	key="cpElencoIspezioniImpianti.btnNuovaRicercaIspe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnNuovaRicercaIspe')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','tfNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.tfNome.label')}" labelFor="widg_tfNome" errorFor="appDataispezione.ispettoreNome" labelId="tfNomeLbl"
	  >


<!-- widget tfNome -->
<s:textfield 
	
	
	name="appDataispezione.ispettoreNome" id="widg_tfNome"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','tfNome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','tfCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.tfCognome.label')}" labelFor="widg_tfCognome" errorFor="appDataispezione.ispettoreCognome" labelId="tfCognomeLbl"
	  >


<!-- widget tfCognome -->
<s:textfield 
	
	
	name="appDataispezione.ispettoreCognome" id="widg_tfCognome"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','tfCognome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiIspettore --></div>

			
	
	<div id="p_wpDatiIspezioneImpianti" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiIspezioneImpianti -->
	
	
<h4 class="wpLabel">dati ispezione </h4>
<div class="widgetsPanel" id="wpDatiIspezioneImpianti">
	
	<customtag:widgetsPanel id="wpDatiIspezioneImpiantiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','calDataIspezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.calDataIspezione.label')}" labelFor="widg_calDataIspezione" errorFor="appDataispezione.dataIspezione" labelId="calDataIspezioneLbl"
	  >


<!-- widget calDataIspezione -->
<s:textfield 
	
	
	name="appDataispezione.dataIspezione" id="widg_calDataIspezione"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','calDataIspezione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','tfEnteIsp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.tfEnteIsp.label')}" labelFor="widg_tfEnteIsp" errorFor="appDataispezione.enteCompetente" labelId="tfEnteIspLbl"
	  >


<!-- widget tfEnteIsp -->
<s:textfield 
	
	
	name="appDataispezione.enteCompetente" id="widg_tfEnteIsp"
maxlength="100"	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','tfEnteIsp')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','rbEsito')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.rbEsito.label')}" labelFor="widg_rbEsito" errorFor="appDataispezione.esitoIspezione" labelId="rbEsitoLbl"
	  >


<!-- widget rbEsito -->

	
<div id="appDataispezione.esitoIspezione" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbPositivo" name="appDataispezione.esitoIspezione"
	list="#{'1':'positivo'}"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','rbEsito')"
	cssClass="radio"
	
	/> <label  for="widg_rbPositivo1"><s:text name="cpElencoIspezioniImpianti.rbEsito.rbPositivo.label" /></label>








<s:radio
	
	
	id="widg_rbNegativo" name="appDataispezione.esitoIspezione"
	list="#{'0':'negativo'}"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','rbEsito')"
	cssClass="radio"
	
	/> <label  for="widg_rbNegativo0"><s:text name="cpElencoIspezioniImpianti.rbEsito.rbNegativo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','tfNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.tfNote.label')}" labelFor="widg_tfNote" errorFor="appDataispezione.note" labelId="tfNoteLbl"
	  >


<!-- widget tfNote -->
<s:textfield 
	
	
	name="appDataispezione.note" id="widg_tfNote"
maxlength="1000"	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','tfNote')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiIspezioneImpianti --></div>

			
	
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

	

		
	
</div>

	<!-- endFragment:p_fpDatiIspezione --></div>
