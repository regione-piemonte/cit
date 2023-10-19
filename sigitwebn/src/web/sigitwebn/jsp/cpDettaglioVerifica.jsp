<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_verifica/CpDettaglioVerificaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_verifica -->
<!-- pageId:cpDettaglioVerifica -->

<s:form id="cpDettaglioVerifica" action="cpDettaglioVerifica" namespace="/base/gestisci_verifica" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioVerifica_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpDettaglioVerifica','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpDettaglioVerifica2" class="formPanelBlock"><!-- startFragment:p_fpDettaglioVerifica2 -->
		
	
<h4 class="fpLabel"><s:text name="cpDettaglioVerifica.fpDettaglioVerifica2.label" /></h4>
<div class="formPanel" id="fpDettaglioVerifica2">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpDettaglioVerifica2 --></div>

			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpVerifica" class="widgetsPanelBlock"><!-- startFragment:p_wpVerifica -->
	
	
<h4 class="wpLabel">dettaglio verifica </h4>
<div class="widgetsPanel" id="wpVerifica">
	
	<customtag:widgetsPanel id="wpVerificaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptVerificaNumero')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptVerificaNumero.label')}" labelFor="widg_ptVerificaNumero" errorFor="appDataverifica.identificativo" labelId="ptVerificaNumeroLbl"   >


<!-- widget ptVerificaNumero -->
<s:property value="appDataverifica.identificativo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptEseguitoDa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptEseguitoDa.label')}" labelFor="widg_ptEseguitoDa" errorFor="appDataverifica.eseguitoDa" labelId="ptEseguitoDaLbl"   >


<!-- widget ptEseguitoDa -->
<s:property value="appDataverifica.eseguitoDa" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptDataCaricamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptDataCaricamento.label')}" labelFor="widg_ptDataCaricamento" errorFor="appDataverifica.dataCaricamento" labelId="ptDataCaricamentoLbl"   >


<!-- widget ptDataCaricamento -->
<s:property value="appDataverifica.dataCaricamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptTipoVerifica')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptTipoVerifica.label')}" labelFor="widg_ptTipoVerifica" errorFor="appDataverifica.descrizioneTipoVerifica" labelId="ptTipoVerificaLbl"   >


<!-- widget ptTipoVerifica -->
<s:property value="appDataverifica.descrizioneTipoVerifica" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataverifica.codiceImpianto" labelId="ptCodiceImpiantoLbl"   >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataverifica.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptDescrizioneImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptDescrizioneImpianto" errorFor="appDataverifica.risultatoImpianto" labelId="ptDescrizioneImpiantoLbl"   >


<!-- widget ptDescrizioneImpianto -->
<s:property value="appDataverifica.risultatoImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataverifica.risultatoBollino" labelId="ptBollinoLbl"   >


<!-- widget ptBollino -->
<s:property value="appDataverifica.risultatoBollino" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptBollinoExteded')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptBollinoExteded" errorFor="appDataverifica.risultatoBollinoExtended" labelId="ptBollinoExtededLbl"   >


<!-- widget ptBollinoExteded -->
<s:property value="appDataverifica.risultatoBollinoExtended" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptDistributore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptDistributore.label')}" labelFor="widg_ptDistributore" errorFor="appDataverifica.idDatoDistributore" labelId="ptDistributoreLbl"   >


<!-- widget ptDistributore -->
<s:property value="appDataverifica.idDatoDistributore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptDistributoreExtended')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptDistributoreExtended" errorFor="appDataverifica.risultatoDatoDistributore" labelId="ptDistributoreExtendedLbl"   >


<!-- widget ptDistributoreExtended -->
<s:property value="appDataverifica.risultatoDatoDistributore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','ptSveglia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioVerifica.ptSveglia.label')}" labelFor="widg_ptSveglia" errorFor="appDataverifica.descrizioneSveglia" labelId="ptSvegliaLbl"   >


<!-- widget ptSveglia -->
<s:property value="appDataverifica.descrizioneSveglia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioVerifica','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioVerifica.taNote.label')}" labelFor="widg_taNote" errorFor="appDataverifica.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDataverifica.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpDettaglioVerifica','taNote')"
	rows="2"
	cols="100"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpVerifica --></div>

			
	
	<div id="p_cpSalva" class="commandPanelBlock"><!-- startFragment:p_cpSalva -->
	
	
<div class="commandPanel functional" id="cpSalva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpDettaglioVerifica.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpSalva --></div>

			
	
	<div id="p_wpAzioni" class="widgetsPanelBlock"><!-- startFragment:p_wpAzioni -->
	
	
<h4 class="wpLabel">azioni svolte </h4>
<div class="widgetsPanel" id="wpAzioni">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioVerifica','tbAzioni')" >

	
<div class="tableWidget">


<!-- widget tbAzioni -->
<s:set name="cpDettaglioVerifica_tbAzioni_clearStatus" value="isTableClearStatus('cpDettaglioVerifica_tbAzioni')" />
<s:url id="cpDettaglioVerificaViewUrl"						   
					   action="cpDettaglioVerifica"
					   namespace="/base/gestisci_verifica"/>
<display:table name="appDataelencoAzioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAzioni"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpDettaglioVerificaViewUrl}"  
               clearStatus="${cpDettaglioVerifica_tbAzioni_clearStatus}"
               uid="row_tbAzioni"
               summary="" 
decorator="it.csi.sigit.sigitwebn.presentation.decorator.gestisci_verifica.CpDettaglioVerificaTbAzioniCustomDecorator"               class="dataTable">
	
		<display:column property="dataAzione" titleKey="cpDettaglioVerifica.tbAzioni.dataAzione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrizioneUtente" titleKey="cpDettaglioVerifica.tbAzioni.descrizioneUtente.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrizione" titleKey="cpDettaglioVerifica.tbAzioni.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nomeDoc" titleKey="cpDettaglioVerifica.tbAzioni.nomeDoc.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAzioni --></div>

			
	
	<div id="p_cpFunzioni" class="commandPanelBlock"><!-- startFragment:p_cpFunzioni -->
	
	
<div class="commandPanel functional" id="cpFunzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btInserisciAzione')" >

	



<!-- widget btInserisciAzione -->
<s:submit name="widg_btInserisciAzione" id="widg_btInserisciAzione" method="handleBtInserisciAzione_CLICKED"
	key="cpDettaglioVerifica.btInserisciAzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btInserisciAzione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btIGestisciSveglia')" >

	



<!-- widget btIGestisciSveglia -->
<s:submit name="widg_btIGestisciSveglia" id="widg_btIGestisciSveglia" method="handleBtIGestisciSveglia_CLICKED"
	key="cpDettaglioVerifica.btIGestisciSveglia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btIGestisciSveglia')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btAvviaAccertamento')" >

	



<!-- widget btAvviaAccertamento -->
<s:submit name="widg_btAvviaAccertamento" id="widg_btAvviaAccertamento" method="handleBtAvviaAccertamento_CLICKED"
	key="cpDettaglioVerifica.btAvviaAccertamento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btAvviaAccertamento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btVisAccertamento')" >

	



<!-- widget btVisAccertamento -->
<s:submit name="widg_btVisAccertamento" id="widg_btVisAccertamento" method="handleBtVisAccertamento_CLICKED"
	key="cpDettaglioVerifica.btVisAccertamento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btVisAccertamento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btAvviaIspezione')" >

	



<!-- widget btAvviaIspezione -->
<s:submit name="widg_btAvviaIspezione" id="widg_btAvviaIspezione" method="handleBtAvviaIspezione_CLICKED"
	key="cpDettaglioVerifica.btAvviaIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btAvviaIspezione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btVisIspezione')" >

	



<!-- widget btVisIspezione -->
<s:submit name="widg_btVisIspezione" id="widg_btVisIspezione" method="handleBtVisIspezione_CLICKED"
	key="cpDettaglioVerifica.btVisIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btVisIspezione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunzioni --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglioVerifica','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpDettaglioVerifica.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioVerifica','btIndietro')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNav --></div>

			
	
	
	<div id="p_mpGestioneSveglia" class="panelBlock"><!-- startFragment:p_mpGestioneSveglia -->
		

		
<s:if test="#session.cpDettaglioVerifica_mpGestioneSveglia_selectedMultiPanel == 'cpDettaglioVerifica_mpGestioneSveglia_fpGestioneSveglia'">
	<s:include value="/jsp/multipanels/cpDettaglioVerifica_mpGestioneSveglia_fpGestioneSveglia.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpGestioneSveglia --></div>

	

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
