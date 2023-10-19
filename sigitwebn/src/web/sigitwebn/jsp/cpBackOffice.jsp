<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/back_office -->
<!-- pageId:cpBackOffice -->

<s:form id="cpBackOffice" action="cpBackOffice" namespace="/base/back_office" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpBackOffice_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpBackOffice','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpBackOffice_udpBackOffice.jsp"></s:include>

	



			
	
	<div id="p_fpBackOffice" class="formPanelBlock"><!-- startFragment:p_fpBackOffice -->
		
	
<h4 class="fpLabel"><s:text name="cpBackOffice.fpBackOffice.label" /></h4>
<div class="formPanel" id="fpBackOffice">


	
	

	
	
			
	
	<div id="p_stdMsgPHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPHome -->
	
	
<div class="stdMessagePanel" id="stdMsgPHome">
	<customtag:stdMessagePanel id="stdMsgPHome" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPHome --></div>

			
	
	<div id="p_wpBackOffice" class="widgetsPanelBlock"><!-- startFragment:p_wpBackOffice -->
	
	

<div class="widgetsPanel" id="wpBackOffice">
	
	<customtag:widgetsPanel id="wpBackOfficeTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzPul')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzPul.label')}" labelFor="widg_ptFunzPul" errorFor="widg_ptFunzPul" labelId="ptFunzPulLbl" colSpan="3" position="first" >


<!-- widget ptFunzPul -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzPulLogStor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzPulLogStor.label')}" labelFor="widg_ptFunzPulLogStor" errorFor="appDatariepilogoStoricizzazione.logStor" labelId="ptFunzPulLogStorLbl"  position="first" tdStyleClass="numbers">


<!-- widget ptFunzPulLogStor -->
<s:property value="appDatariepilogoStoricizzazione.logStor" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzPulLogCanc')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzPulLogCanc.label')}" labelFor="widg_ptFunzPulLogCanc" errorFor="appDatariepilogoStoricizzazione.logCanc" labelId="ptFunzPulLogCancLbl"  position="first" tdStyleClass="numbers">


<!-- widget ptFunzPulLogCanc -->
<s:property value="appDatariepilogoStoricizzazione.logCanc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_4_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpBackOffice_4_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','btPulisciLog')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btPulisciLog -->
<s:submit name="widg_btPulisciLog" id="widg_btPulisciLog" method="handleBtPulisciLog_CLICKED"
	key="cpBackOffice.btPulisciLog.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpBackOffice','btPulisciLog')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzStor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzStor.label')}" labelFor="widg_ptFunzStor" errorFor="widg_ptFunzStor" labelId="ptFunzStorLbl" colSpan="3" position="first" >


<!-- widget ptFunzStor -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzLibStor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzLibStor.label')}" labelFor="widg_ptFunzLibStor" errorFor="appDatariepilogoStoricizzazione.librettiStor" labelId="ptFunzLibStorLbl"  position="first" tdStyleClass="numbers">


<!-- widget ptFunzLibStor -->
<s:property value="appDatariepilogoStoricizzazione.librettiStor" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzLibCanc')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzLibCanc.label')}" labelFor="widg_ptFunzLibCanc" errorFor="appDatariepilogoStoricizzazione.librettiCanc" labelId="ptFunzLibCancLbl"  position="first" tdStyleClass="numbers">


<!-- widget ptFunzLibCanc -->
<s:property value="appDatariepilogoStoricizzazione.librettiCanc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_8_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpBackOffice_8_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','btStoricizza')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btStoricizza -->
<s:submit name="widg_btStoricizza" id="widg_btStoricizza" method="handleBtStoricizza_CLICKED"
	key="cpBackOffice.btStoricizza.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpBackOffice','btStoricizza')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzStorLogAccesso')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzStorLogAccesso.label')}" labelFor="widg_ptFunzStorLogAccesso" errorFor="widg_ptFunzStorLogAccesso" labelId="ptFunzStorLogAccessoLbl" colSpan="3" position="first" >


<!-- widget ptFunzStorLogAccesso -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzLogAccessoStor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzLogAccessoStor.label')}" labelFor="widg_ptFunzLogAccessoStor" errorFor="appDatariepilogoStoricizzazione.logAccessoStor" labelId="ptFunzLogAccessoStorLbl"  position="first" tdStyleClass="numbers">


<!-- widget ptFunzLogAccessoStor -->
<s:property value="appDatariepilogoStoricizzazione.logAccessoStor" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzLogAccessoCanc')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzLogAccessoCanc.label')}" labelFor="widg_ptFunzLogAccessoCanc" errorFor="appDatariepilogoStoricizzazione.logAccessoCanc" labelId="ptFunzLogAccessoCancLbl"  position="first" tdStyleClass="numbers">


<!-- widget ptFunzLogAccessoCanc -->
<s:property value="appDatariepilogoStoricizzazione.logAccessoCanc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_11_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_11_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_12_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpBackOffice_12_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','btStoricizzaLogAccesso')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btStoricizzaLogAccesso -->
<s:submit name="widg_btStoricizzaLogAccesso" id="widg_btStoricizzaLogAccesso" method="handleBtStoricizzaLogAccesso_CLICKED"
	key="cpBackOffice.btStoricizzaLogAccesso.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpBackOffice','btStoricizzaLogAccesso')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzAbil')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzAbil.label')}" labelFor="widg_ptFunzAbil" errorFor="widg_ptFunzAbil" labelId="ptFunzAbilLbl" colSpan="3" position="first" >


<!-- widget ptFunzAbil -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpBackOffice','ptAbilitaFitt')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget ptAbilitaFitt -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_14_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_14_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_15_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpBackOffice_15_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','btAbilita')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btAbilita -->
<s:submit name="widg_btAbilita" id="widg_btAbilita" method="handleBtAbilita_CLICKED"
	key="cpBackOffice.btAbilita.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpBackOffice','btAbilita')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzSub')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzSub.label')}" labelFor="widg_ptFunzSub" errorFor="widg_ptFunzSub" labelId="ptFunzSubLbl" colSpan="3" position="first" >


<!-- widget ptFunzSub -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpBackOffice','ptSubentroFitt')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget ptSubentroFitt -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_17_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_17_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_18_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpBackOffice_18_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','btSubentro')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btSubentro -->
<s:submit name="widg_btSubentro" id="widg_btSubentro" method="handleBtSubentro_CLICKED"
	key="cpBackOffice.btSubentro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpBackOffice','btSubentro')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptFunzAggiornaCoordinate')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptFunzAggiornaCoordinate.label')}" labelFor="widg_ptFunzAggiornaCoordinate" errorFor="widg_ptFunzAggiornaCoordinate" labelId="ptFunzAggiornaCoordinateLbl" colSpan="3" position="first" >


<!-- widget ptFunzAggiornaCoordinate -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpBackOffice','ptCountImpiantiSenzaCoordinate')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptCountImpiantiSenzaCoordinate.label')}" labelFor="widg_ptCountImpiantiSenzaCoordinate" errorFor="appDatacountImpiantiSenzaCoordinate" labelId="ptCountImpiantiSenzaCoordinateLbl"  position="first" >


<!-- widget ptCountImpiantiSenzaCoordinate -->
<s:property value="appDatacountImpiantiSenzaCoordinate" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_20_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_20_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','ptCountImpiantiAggiornatiPrimaDiDataAggiornaCoordinate')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpBackOffice.ptCountImpiantiAggiornatiPrimaDiDataAggiornaCoordinate.label')}" labelFor="widg_ptCountImpiantiAggiornatiPrimaDiDataAggiornaCoordinate" errorFor="appDatacountImpiantiAggiornatiADataAggiornaCoord" labelId="ptCountImpiantiAggiornatiPrimaDiDataAggiornaCoordinateLbl"  position="first" >


<!-- widget ptCountImpiantiAggiornatiPrimaDiDataAggiornaCoordinate -->
<s:property value="appDatacountImpiantiAggiornatiADataAggiornaCoord" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_21_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpBackOffice_21_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','wpBackOffice_22_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpBackOffice_22_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpBackOffice','btAggiornaCoordinate')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btAggiornaCoordinate -->
<s:submit name="widg_btAggiornaCoordinate" id="widg_btAggiornaCoordinate" method="handleBtAggiornaCoordinate_CLICKED"
	key="cpBackOffice.btAggiornaCoordinate.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpBackOffice','btAggiornaCoordinate')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpBackOffice --></div>

	

		
	
</div>

	<!-- endFragment:p_fpBackOffice --></div>

			
	
	<div id="p_cpBackOfficeBack" class="commandPanelBlock"><!-- startFragment:p_cpBackOfficeBack -->
	
	
<div class="commandPanel navigation" id="cpBackOfficeBack">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpBackOffice','cbIndietro')" >

	



<!-- widget cbIndietro -->
<s:submit name="widg_cbIndietro" id="widg_cbIndietro" method="handleCbIndietro_CLICKED"
	key="cpBackOffice.cbIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpBackOffice','cbIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpBackOfficeBack --></div>

	

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
