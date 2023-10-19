<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAssociaCodiceImpianto" class="formPanelBlock"><!-- startFragment:p_fpAssociaCodiceImpianto -->
		
	
<div class="formPanel" id="fpAssociaCodiceImpianto">


	
	

	
	
			
	
	<div id="p_wpAssociaCodiceImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpAssociaCodiceImpianto -->
	
	
<h4 class="wpLabel">associa codice impianto </h4>
<div class="widgetsPanel" id="wpAssociaCodiceImpianto">
	
	<customtag:widgetsPanel id="wpAssociaCodiceImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','tfCercaCodiceImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.tfCercaCodiceImpianto.label')}" labelFor="widg_tfCercaCodiceImpianto" errorFor="appDataRicercaImpiantoDaAssociare.codiceImpianto" labelId="tfCercaCodiceImpiantoLbl"
	position="first"  >


<!-- widget tfCercaCodiceImpianto -->
<s:textfield 
	
	
	name="appDataRicercaImpiantoDaAssociare.codiceImpianto" id="widg_tfCercaCodiceImpianto"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','tfCercaCodiceImpianto')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btCercaCodiceImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btCercaCodiceImpianto -->
<s:submit name="widg_btCercaCodiceImpianto" id="widg_btCercaCodiceImpianto" method="handleBtCercaCodiceImpianto_CLICKED"
	key="cpDettaglioIspezione2018.btCercaCodiceImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btCercaCodiceImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptUbicazioneImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptUbicazioneImpianto.label')}" labelFor="widg_ptUbicazioneImpianto" errorFor="appDataRicercaImpiantoDaAssociare.ubicazione" labelId="ptUbicazioneImpiantoLbl"  position="first" >


<!-- widget ptUbicazioneImpianto -->
<s:property value="appDataRicercaImpiantoDaAssociare.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','wpAssociaCodiceImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAssociaCodiceImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDataRicercaImpiantoDaAssociare.responsabile" labelId="ptResponsabileImpiantoLbl"  position="first" >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDataRicercaImpiantoDaAssociare.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','wpAssociaCodiceImpianto_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAssociaCodiceImpianto_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btNuovaRicercaCodiceImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btNuovaRicercaCodiceImpianto -->
<s:submit name="widg_btNuovaRicercaCodiceImpianto" id="widg_btNuovaRicercaCodiceImpianto" method="handleBtNuovaRicercaCodiceImpianto_CLICKED"
	key="cpDettaglioIspezione2018.btNuovaRicercaCodiceImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btNuovaRicercaCodiceImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','wpAssociaCodiceImpianto_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAssociaCodiceImpianto_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAssociaCodiceImpianto --></div>

			
	
	<div id="p_cpAssociaCodiceImpianto" class="commandPanelBlock"><!-- startFragment:p_cpAssociaCodiceImpianto -->
	
	
<div class="commandPanel functional" id="cpAssociaCodiceImpianto">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConfermaCodiceImpianto')" >

	



<!-- widget btConfermaCodiceImpianto -->
<s:submit name="widg_btConfermaCodiceImpianto" id="widg_btConfermaCodiceImpianto" method="handleBtConfermaCodiceImpianto_CLICKED"
	key="cpDettaglioIspezione2018.btConfermaCodiceImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConfermaCodiceImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaAssociazioneImpianto')" >

	



<!-- widget btAnnullaAssociazioneImpianto -->
<s:submit name="widg_btAnnullaAssociazioneImpianto" id="widg_btAnnullaAssociazioneImpianto" method="handleBtAnnullaAssociazioneImpianto_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaAssociazioneImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaAssociazioneImpianto')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpAssociaCodiceImpianto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAssociaCodiceImpianto --></div>
