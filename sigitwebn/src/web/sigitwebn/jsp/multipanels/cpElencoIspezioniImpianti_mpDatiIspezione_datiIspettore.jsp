<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_datiIspettore" class="formPanelBlock"><!-- startFragment:p_datiIspettore -->
		
	
<div class="formPanel floatWrapper" id="datiIspettore">


	
	

	
	
		
	

<div class="leftWrapper">	
	
	<div class="formPanel floatLeft">
		
	
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

	</div>
	
	

	
</div>



	

		
	
</div>

	<!-- endFragment:p_datiIspettore --></div>
