<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDati" class="formPanelBlock"><!-- startFragment:p_fpDati -->
		
	
<div class="formPanel" id="fpDati">


	
	

	
	
			
	
	<div id="p_wDettWMS" class="widgetsPanelBlock"><!-- startFragment:p_wDettWMS -->
	
	

<div class="widgetsPanel" id="wDettWMS">
	
	<customtag:widgetsPanel id="wDettWMSTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettWMS','tfImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfImpianto.label')}" labelFor="widg_tfImpianto" errorFor="appDatacurrentDettaglioGeografico.impianto" labelId="tfImpiantoLbl"
	position="first"  >


<!-- widget tfImpianto -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.impianto" id="widg_tfImpianto"
	disabled="isWidgetDisabled('cpDettWMS','tfImpianto')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfUbicazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfUbicazione.label')}" labelFor="widg_tfUbicazione" errorFor="appDatacurrentDettaglioGeografico.ubicazione" labelId="tfUbicazioneLbl"
	position="first"  >


<!-- widget tfUbicazione -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.ubicazione" id="widg_tfUbicazione"
	disabled="isWidgetDisabled('cpDettWMS','tfUbicazione')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfVolRiscM3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfVolRiscM3.label')}" labelFor="widg_tfVolRiscM3" errorFor="appDatacurrentDettaglioGeografico.volRiscM3" labelId="tfVolRiscM3Lbl"
	position="first"  >


<!-- widget tfVolRiscM3 -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.volRiscM3" id="widg_tfVolRiscM3"
	disabled="isWidgetDisabled('cpDettWMS','tfVolRiscM3')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfvolRaffM3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfvolRaffM3.label')}" labelFor="widg_tfvolRaffM3" errorFor="appDatacurrentDettaglioGeografico.volRaffM3" labelId="tfvolRaffM3Lbl"
	position="first"  >


<!-- widget tfvolRaffM3 -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.volRaffM3" id="widg_tfvolRaffM3"
	disabled="isWidgetDisabled('cpDettWMS','tfvolRaffM3')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','potClimaInv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.potClimaInv.label')}" labelFor="widg_potClimaInv" errorFor="appDatacurrentDettaglioGeografico.potClimaInv" labelId="potClimaInvLbl"
	position="first"  >


<!-- widget potClimaInv -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.potClimaInv" id="widg_potClimaInv"
	disabled="isWidgetDisabled('cpDettWMS','potClimaInv')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfPotClimaEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfPotClimaEst.label')}" labelFor="widg_tfPotClimaEst" errorFor="appDatacurrentDettaglioGeografico.potClimaEst" labelId="tfPotClimaEstLbl"
	position="first"  >


<!-- widget tfPotClimaEst -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.potClimaEst" id="widg_tfPotClimaEst"
	disabled="isWidgetDisabled('cpDettWMS','tfPotClimaEst')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','componente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.componente.label')}" labelFor="widg_componente" errorFor="appDatacurrentDettaglioGeografico.componente" labelId="componenteLbl"
	position="first"  >


<!-- widget componente -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.componente" id="widg_componente"
	disabled="isWidgetDisabled('cpDettWMS','componente')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wDettWMS --></div>

			
	
	<div id="p_pDettaglioFun" class="commandPanelBlock"><!-- startFragment:p_pDettaglioFun -->
	
	
<div class="commandPanel functional" id="pDettaglioFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettWMS','btPrecedente')" >

	



<!-- widget btPrecedente -->
<s:submit name="widg_btPrecedente" id="widg_btPrecedente" method="handleBtPrecedente_CLICKED"
	key="cpDettWMS.btPrecedente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettWMS','btPrecedente')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettWMS','btSuccessivo')" >

	



<!-- widget btSuccessivo -->
<s:submit name="widg_btSuccessivo" id="widg_btSuccessivo" method="handleBtSuccessivo_CLICKED"
	key="cpDettWMS.btSuccessivo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettWMS','btSuccessivo')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDettaglioFun --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDati --></div>
