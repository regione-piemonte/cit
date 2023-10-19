<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpRicAvz3Resp" class="formPanelBlock"><!-- startFragment:p_fpRicAvz3Resp -->
		
	
<div class="formPanel" id="fpRicAvz3Resp">


	
	

	
	
			
	
	<div id="p_wpTerzoResp" class="widgetsPanelBlock"><!-- startFragment:p_wpTerzoResp -->
	
	
<h4 class="wpLabel">terzo responsabile </h4>
<div class="widgetsPanel" id="wpTerzoResp">
	
	<customtag:widgetsPanel id="wpTerzoRespTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfRespCodFis')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfRespCodFis.label')}" labelFor="widg_tfRespCodFis" errorFor="appDataricercaAvanzataImpianti.cf3Responsabile" labelId="tfRespCodFisLbl"
	position="first"  >


<!-- widget tfRespCodFis -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.cf3Responsabile" id="widg_tfRespCodFis"
maxlength="16"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfRespCodFis')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','wpTerzoResp_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTerzoResp_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfRespDataInsGG')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfRespDataInsGG.label')}" labelFor="widg_tfRespDataInsGG" errorFor="appDataricercaAvanzataImpianti.ggInserimentoContratto" labelId="tfRespDataInsGGLbl"
	position="first"  >


<!-- widget tfRespDataInsGG -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.ggInserimentoContratto" id="widg_tfRespDataInsGG"
maxlength="16"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfRespDataInsGG')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','ptRespDataInsgg')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRicAvzImpianto.ptRespDataInsgg.label')}" labelFor="widg_ptRespDataInsgg" errorFor="widg_ptRespDataInsgg" labelId="ptRespDataInsggLbl"  position="last" >


<!-- widget ptRespDataInsgg -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','tfRespDataRevGG')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.tfRespDataRevGG.label')}" labelFor="widg_tfRespDataRevGG" errorFor="appDataricercaAvanzataImpianti.ggRevoca" labelId="tfRespDataRevGGLbl"
	position="first"  >


<!-- widget tfRespDataRevGG -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.ggRevoca" id="widg_tfRespDataRevGG"
maxlength="16"	disabled="isWidgetDisabled('cpRicAvzImpianto','tfRespDataRevGG')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','ptRespDataRevgg')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRicAvzImpianto.ptRespDataRevgg.label')}" labelFor="widg_ptRespDataRevgg" errorFor="widg_ptRespDataRevgg" labelId="ptRespDataRevggLbl"  position="last" >


<!-- widget ptRespDataRevgg -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clRespDatInizContrDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clRespDatInizContrDa.label')}" labelFor="widg_clRespDatInizContrDa" errorFor="appDataricercaAvanzataImpianti.dataInizioContrattoDa" labelId="clRespDatInizContrDaLbl"
	position="first"  >


<!-- widget clRespDatInizContrDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataInizioContrattoDa" id="widg_clRespDatInizContrDa"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clRespDatInizContrDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clRespDatInizContrA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clRespDatInizContrA.label')}" labelFor="widg_clRespDatInizContrA" errorFor="appDataricercaAvanzataImpianti.dataInizioContrattoA" labelId="clRespDatInizContrALbl"
	position="last"  >


<!-- widget clRespDatInizContrA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataInizioContrattoA" id="widg_clRespDatInizContrA"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clRespDatInizContrA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clRespDatFineContrDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clRespDatFineContrDa.label')}" labelFor="widg_clRespDatFineContrDa" errorFor="appDataricercaAvanzataImpianti.dataFineContrattoDa" labelId="clRespDatFineContrDaLbl"
	position="first"  >


<!-- widget clRespDatFineContrDa -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataFineContrattoDa" id="widg_clRespDatFineContrDa"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clRespDatFineContrDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicAvzImpianto','clRespDatFineContrA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicAvzImpianto.clRespDatFineContrA.label')}" labelFor="widg_clRespDatFineContrA" errorFor="appDataricercaAvanzataImpianti.dataFineContrattoA" labelId="clRespDatFineContrALbl"
	position="last"  >


<!-- widget clRespDatFineContrA -->
<s:textfield 
	
	
	name="appDataricercaAvanzataImpianti.dataFineContrattoA" id="widg_clRespDatFineContrA"
	disabled="isWidgetDisabled('cpRicAvzImpianto','clRespDatFineContrA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpTerzoResp --></div>

			
	
	<div id="p_cpFunRicAvzImpiantoResp" class="commandPanelBlock"><!-- startFragment:p_cpFunRicAvzImpiantoResp -->
	
	
<div class="commandPanel functional" id="cpFunRicAvzImpiantoResp">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicAvzImpianto','btRicResp')" >

	



<!-- widget btRicResp -->
<s:submit name="widg_btRicResp" id="widg_btRicResp" method="handleBtRicResp_CLICKED"
	key="cpRicAvzImpianto.btRicResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicAvzImpianto','btRicResp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicAvzImpianto','btnAnnullaRicImpiantoResp')" >

	



<!-- widget btnAnnullaRicImpiantoResp -->
<s:submit name="widg_btnAnnullaRicImpiantoResp" id="widg_btnAnnullaRicImpiantoResp" method="handleBtnAnnullaRicImpiantoResp_CLICKED"
	key="cpRicAvzImpianto.btnAnnullaRicImpiantoResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicAvzImpianto','btnAnnullaRicImpiantoResp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicAvzImpiantoResp --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRicAvz3Resp --></div>
