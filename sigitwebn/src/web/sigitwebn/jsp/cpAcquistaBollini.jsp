<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/acquista_bollini/CpAcquistaBolliniAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/acquista_bollini -->
<!-- pageId:cpAcquistaBollini -->

<s:form id="cpAcquistaBollini" action="cpAcquistaBollini" namespace="/base/acquista_bollini" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpAcquistaBollini_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpAcquistaBollini','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpAcquisisciBolliniTitolo" class="formPanelBlock"><!-- startFragment:p_fpAcquisisciBolliniTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpAcquistaBollini.fpAcquisisciBolliniTitolo.label" /></h4>
<div class="formPanel" id="fpAcquisisciBolliniTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpAcquisisciBolliniTitolo --></div>

			
	
	<div id="p_fpAcqBollini" class="formPanelBlock"><!-- startFragment:p_fpAcqBollini -->
		
	
<div class="formPanel" id="fpAcqBollini">


	
	

	
	
			
	
	<div id="p_stdMsgPAcqBol" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPAcqBol -->
	
	
<div class="stdMessagePanel" id="stdMsgPAcqBol">
	<customtag:stdMessagePanel id="stdMsgPAcqBol" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPAcqBol --></div>

			
	
	<div id="p_wpAcqBolManut" class="widgetsPanelBlock"><!-- startFragment:p_wpAcqBolManut -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpAcqBolManut">
	
	<customtag:widgetsPanel id="wpAcqBolManutTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAcquistaBollini','cbSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquistaBollini.cbSiglaRea.label')}" labelFor="widg_cbSiglaRea" errorFor="appDataacquistaBollini.idSiglaRea" labelId="cbSiglaReaLbl"
	  >


<!-- widget cbSiglaRea -->
<s:select name="appDataacquistaBollini.idSiglaRea" id="widg_cbSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpAcquistaBollini','cbSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquistaBollini','tfNumeroRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquistaBollini.tfNumeroRea.label')}" labelFor="widg_tfNumeroRea" errorFor="appDataacquistaBollini.numeroRea" labelId="tfNumeroReaLbl"
	  >


<!-- widget tfNumeroRea -->
<s:textfield 
	
	
	name="appDataacquistaBollini.numeroRea" id="widg_tfNumeroRea"
maxlength="9"	disabled="isWidgetDisabled('cpAcquistaBollini','tfNumeroRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquistaBollini','tfCF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquistaBollini.tfCF.label')}" labelFor="widg_tfCF" errorFor="appDataacquistaBollini.codiceFiscaleImpresa" labelId="tfCFLbl"
	  >


<!-- widget tfCF -->
<s:textfield 
	
title=""	
	name="appDataacquistaBollini.codiceFiscaleImpresa" id="widg_tfCF"
maxlength="16"	disabled="isWidgetDisabled('cpAcquistaBollini','tfCF')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquistaBollini','btnCercaImpresa')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaImpresa -->
<s:submit name="widg_btnCercaImpresa" id="widg_btnCercaImpresa" method="handleBtnCercaImpresa_CLICKED"
	key="cpAcquistaBollini.btnCercaImpresa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquistaBollini','btnCercaImpresa')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquistaBollini','btnNuovaRicercaImpresa')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnNuovaRicercaImpresa -->
<s:submit name="widg_btnNuovaRicercaImpresa" id="widg_btnNuovaRicercaImpresa" method="handleBtnNuovaRicercaImpresa_CLICKED"
	key="cpAcquistaBollini.btnNuovaRicercaImpresa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquistaBollini','btnNuovaRicercaImpresa')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquistaBollini','tfDitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquistaBollini.tfDitta.label')}" labelFor="widg_tfDitta" errorFor="appDataacquistaBollini.denominazioneImpresa" labelId="tfDittaLbl"
	  >


<!-- widget tfDitta -->
<s:textfield 
	
	
	name="appDataacquistaBollini.denominazioneImpresa" id="widg_tfDitta"
	disabled="isWidgetDisabled('cpAcquistaBollini','tfDitta')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAcqBolManut --></div>

			
	
	<div id="p_wpAcqBollini" class="widgetsPanelBlock"><!-- startFragment:p_wpAcqBollini -->
	
	
<h4 class="wpLabel">acquisisci codice REE </h4>
<div class="widgetsPanel" id="wpAcqBollini">
	
	<customtag:widgetsPanel id="wpAcqBolliniTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAcquistaBollini','tfCFOperatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquistaBollini.tfCFOperatore.label')}" labelFor="widg_tfCFOperatore" errorFor="appDataacquistaBollini.codiceFiscaleOp" labelId="tfCFOperatoreLbl"
	  >


<!-- widget tfCFOperatore -->
<s:textfield 
	
	
	name="appDataacquistaBollini.codiceFiscaleOp" id="widg_tfCFOperatore"
	disabled="isWidgetDisabled('cpAcquistaBollini','tfCFOperatore')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquistaBollini','tfDataAcquisto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquistaBollini.tfDataAcquisto.label')}" labelFor="widg_tfDataAcquisto" errorFor="appDataacquistaBollini.dataAcquisto" labelId="tfDataAcquistoLbl"
	  >


<!-- widget tfDataAcquisto -->
<s:textfield 
	
title=""	
	name="appDataacquistaBollini.dataAcquisto" id="widg_tfDataAcquisto"
	disabled="isWidgetDisabled('cpAcquistaBollini','tfDataAcquisto')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAcquistaBollini','siglaBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAcquistaBollini.siglaBollino.label')}" labelFor="widg_siglaBollino" errorFor="appDataacquistaBollini.siglaBollino" labelId="siglaBollinoLbl"
	  >


<!-- widget siglaBollino -->
<s:textfield 
	
	
	name="appDataacquistaBollini.siglaBollino" id="widg_siglaBollino"
	disabled="isWidgetDisabled('cpAcquistaBollini','siglaBollino')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAcqBollini --></div>

			
	
	<div id="p_wpAcqBolliniQta" class="widgetsPanelBlock"><!-- startFragment:p_wpAcqBolliniQta -->
	
	

<div class="widgetsPanel" id="wpAcqBolliniQta">
	

	
	
<s:if test="isWidgetVisible('cpAcquistaBollini','tQuantita')" >

	
<div class="tableWidget">


<!-- widget tQuantita -->
<s:set name="cpAcquistaBollini_tQuantita_clearStatus" value="isTableClearStatus('cpAcquistaBollini_tQuantita')" />
<s:url id="cpAcquistaBolliniViewUrl"						   
					   action="cpAcquistaBollini"
					   namespace="/base/acquista_bollini"/>
<display:table name="appDataelencoAcquistaBolliniQuantita"  				
			   excludedParams="*"			   export="false"
               id="widg_tQuantita"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpAcquistaBolliniViewUrl}"  
               clearStatus="${cpAcquistaBollini_tQuantita_clearStatus}"
               uid="row_tQuantita"
               summary="" 
               class="dataTable">
	
		<display:column property="descrizione" titleKey="cpAcquistaBollini.tQuantita.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpAcquistaBollini.tQuantita.quantita.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDataelencoAcquistaBolliniQuantita['+(#attr.row_tQuantita_rowNum - 1)+'].quantita'}"   theme="csi-tableinput-rem" />
		</display:column>
		
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAcqBolliniQta --></div>

			
	
	<div id="p_cpFunAcqBol" class="commandPanelBlock"><!-- startFragment:p_cpFunAcqBol -->
	
	
<div class="commandPanel functional" id="cpFunAcqBol">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAcquistaBollini','btnAnnullaAcqBol')" >

	



<!-- widget btnAnnullaAcqBol -->
<s:submit name="widg_btnAnnullaAcqBol" id="widg_btnAnnullaAcqBol" method="handleBtnAnnullaAcqBol_CLICKED"
	key="cpAcquistaBollini.btnAnnullaAcqBol.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquistaBollini','btnAnnullaAcqBol')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunAcqBol --></div>

			
	
	<div id="p_cpNavAcqBol" class="commandPanelBlock"><!-- startFragment:p_cpNavAcqBol -->
	
	
<div class="commandPanel navigation" id="cpNavAcqBol">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAcquistaBollini','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpAcquistaBollini.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquistaBollini','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAcquistaBollini','btnConferma')" >

	



<!-- widget btnConferma -->
<s:submit name="widg_btnConferma" id="widg_btnConferma" method="handleBtnConferma_CLICKED"
	key="cpAcquistaBollini.btnConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAcquistaBollini','btnConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavAcqBol --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAcqBollini --></div>

	

	<!-- endFragment:p_fpCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
