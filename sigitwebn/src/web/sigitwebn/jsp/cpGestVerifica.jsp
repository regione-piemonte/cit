<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_verifica -->
<!-- pageId:cpGestVerifica -->

<s:form id="cpGestVerifica" action="cpGestVerifica" namespace="/base/gestisci_verifica" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestVerifica_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestVerifica','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpInserisciVerifica" class="formPanelBlock"><!-- startFragment:p_fpInserisciVerifica -->
		
	
<div class="formPanel" id="fpInserisciVerifica">


	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpGestVerifica.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpHidden" class="widgetsPanelBlock"><!-- startFragment:p_wpHidden -->
	
	

<div class="widgetsPanel" id="wpHidden">
	
	<customtag:widgetsPanel id="wpHiddenTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestVerifica','hvGestInsVerificaAuto')" >

	
<div class="hidden">


<!-- widget hvGestInsVerificaAuto -->
<s:hidden name="widg_hvGestInsVerificaAuto" id="widg_hvGestInsVerificaAuto" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpHidden --></div>

			
	
	<div id="p_wpVerifica" class="widgetsPanelBlock"><!-- startFragment:p_wpVerifica -->
	
	
<h4 class="wpLabel">inserisci verifica </h4>
<div class="widgetsPanel" id="wpVerifica">
	
	<customtag:widgetsPanel id="wpVerificaTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestVerifica','ptVerificaNumero')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestVerifica.ptVerificaNumero.label')}" labelFor="widg_ptVerificaNumero" errorFor="appDataverifica.identificativo" labelId="ptVerificaNumeroLbl"  position="first" >


<!-- widget ptVerificaNumero -->
<s:property value="appDataverifica.identificativo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpVerifica_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','ptEseguitoDa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestVerifica.ptEseguitoDa.label')}" labelFor="widg_ptEseguitoDa" errorFor="appDataverifica.eseguitoDa" labelId="ptEseguitoDaLbl"  position="first" >


<!-- widget ptEseguitoDa -->
<s:property value="appDataverifica.eseguitoDa" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpVerifica_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','ptDataCaricamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestVerifica.ptDataCaricamento.label')}" labelFor="widg_ptDataCaricamento" errorFor="appDataverifica.dataCaricamento" labelId="ptDataCaricamentoLbl"  position="first" >


<!-- widget ptDataCaricamento -->
<s:property value="appDataverifica.dataCaricamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpVerifica_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','cbTipoVerifica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestVerifica.cbTipoVerifica.label')}" labelFor="widg_cbTipoVerifica" errorFor="appDataverifica.tipoVerifica" labelId="cbTipoVerificaLbl"
	position="first"  fieldRequired="true">


<!-- widget cbTipoVerifica -->
	<csiuicore:ajaxify id="p_wpVerifica" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_verifica/cpGestVerifica!handleCbTipoVerifica_VALUE_CHANGED.do"
		pageId="cpGestVerifica"
		formName="cpGestVerifica"
		javascriptDetection="false"
		nameSpace="/base/gestisci_verifica">

<s:url id="widg_cbTipoVerificaurlComboBoxValueChange"
   action="/sigitwebn/cpGestVerifica!handleCbTipoVerifica_VALUE_CHANGED" namespace="/base/gestisci_verifica"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataverifica.tipoVerifica" id="widg_cbTipoVerifica"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiVerifica"
	  disabled="isWidgetDisabled('cpGestVerifica','cbTipoVerifica')"
	  listKey="id"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoVerifica','conferma','%{widg_cbTipoVerificaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoVerifica','conferma','%{widg_cbTipoVerificaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpVerifica_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','tfCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestVerifica.tfCodImp.label')}" labelFor="widg_tfCodImp" errorFor="appDataverifica.codiceImpianto" labelId="tfCodImpLbl"
	position="first"  >


<!-- widget tfCodImp -->
<s:textfield 
	
	
	name="appDataverifica.codiceImpianto" id="widg_tfCodImp"
	disabled="isWidgetDisabled('cpGestVerifica','tfCodImp')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','btCercaImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btCercaImpianto -->
<s:submit name="widg_btCercaImpianto" id="widg_btCercaImpianto" method="handleBtCercaImpianto_CLICKED"
	key="cpGestVerifica.btCercaImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btCercaImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_5_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_5_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','ptRisultatoImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptRisultatoImpianto" errorFor="appDataverifica.risultatoImpianto" labelId="ptRisultatoImpiantoLbl"  position="first" >


<!-- widget ptRisultatoImpianto -->
<s:property value="appDataverifica.risultatoImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','btNuovaRicercaImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btNuovaRicercaImpianto -->
<s:submit name="widg_btNuovaRicercaImpianto" id="widg_btNuovaRicercaImpianto" method="handleBtNuovaRicercaImpianto_CLICKED"
	key="cpGestVerifica.btNuovaRicercaImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btNuovaRicercaImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_6_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_6_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','cbSiglaBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestVerifica.cbSiglaBollino.label')}" labelFor="widg_cbSiglaBollino" errorFor="appDataverifica.siglaBollino" labelId="cbSiglaBollinoLbl"
	position="first"  >


<!-- widget cbSiglaBollino -->
<s:select name="appDataverifica.siglaBollino" id="widg_cbSiglaBollino"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaBollini"
	  disabled="isWidgetDisabled('cpGestVerifica','cbSiglaBollino')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','tfNumeroBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestVerifica.tfNumeroBollino.label')}" labelFor="widg_tfNumeroBollino" errorFor="appDataverifica.numeroBollino" labelId="tfNumeroBollinoLbl"
	  >


<!-- widget tfNumeroBollino -->
<s:textfield 
	
	
	name="appDataverifica.numeroBollino" id="widg_tfNumeroBollino"
	disabled="isWidgetDisabled('cpGestVerifica','tfNumeroBollino')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','btCercaBollino')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btCercaBollino -->
<s:submit name="widg_btCercaBollino" id="widg_btCercaBollino" method="handleBtCercaBollino_CLICKED"
	key="cpGestVerifica.btCercaBollino.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btCercaBollino')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','ptRisultatoBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptRisultatoBollino" errorFor="appDataverifica.risultatoBollinoExtended" labelId="ptRisultatoBollinoLbl"  position="first" >


<!-- widget ptRisultatoBollino -->
<s:property value="appDataverifica.risultatoBollinoExtended" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','btNuovaRicercaBollino')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btNuovaRicercaBollino -->
<s:submit name="widg_btNuovaRicercaBollino" id="widg_btNuovaRicercaBollino" method="handleBtNuovaRicercaBollino_CLICKED"
	key="cpGestVerifica.btNuovaRicercaBollino.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btNuovaRicercaBollino')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_8_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_8_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','tfDatoDistributore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestVerifica.tfDatoDistributore.label')}" labelFor="widg_tfDatoDistributore" errorFor="appDataverifica.idDatoDistributore" labelId="tfDatoDistributoreLbl"
	position="first"  >


<!-- widget tfDatoDistributore -->
<s:textfield 
	
	
	name="appDataverifica.idDatoDistributore" id="widg_tfDatoDistributore"
	disabled="isWidgetDisabled('cpGestVerifica','tfDatoDistributore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','btCercaDatoDistributore')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btCercaDatoDistributore -->
<s:submit name="widg_btCercaDatoDistributore" id="widg_btCercaDatoDistributore" method="handleBtCercaDatoDistributore_CLICKED"
	key="cpGestVerifica.btCercaDatoDistributore.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btCercaDatoDistributore')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_9_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_9_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','ptRisultatoDatoDistributore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptRisultatoDatoDistributore" errorFor="appDataverifica.risultatoDatoDistributore" labelId="ptRisultatoDatoDistributoreLbl"  position="first" >


<!-- widget ptRisultatoDatoDistributore -->
<s:property value="appDataverifica.risultatoDatoDistributore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','btNuovaRicercaDatoDistributore')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btNuovaRicercaDatoDistributore -->
<s:submit name="widg_btNuovaRicercaDatoDistributore" id="widg_btNuovaRicercaDatoDistributore" method="handleBtNuovaRicercaDatoDistributore_CLICKED"
	key="cpGestVerifica.btNuovaRicercaDatoDistributore.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btNuovaRicercaDatoDistributore')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestVerifica','wpVerifica_10_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpVerifica_10_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpVerifica --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestVerifica','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpGestVerifica.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFun --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestVerifica','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpGestVerifica.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInserisciVerifica --></div>

	

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
