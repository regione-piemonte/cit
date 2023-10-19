<%@taglib prefix="s" uri="/struts-tags" %>

	
<div id="mainMenu">
	<h3>Menu di navigazione</h3>
	<ul>
		
<s:if test="isMenuVisible('menuHome')">
	<s:if test="isMenuEnabled('menuHome')">
		<s:url id="targetUrlMenuHome" action="goToMenuHomeFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuHome')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuHome}" id="menu_items_menuHome">
				<s:text name="menuHome.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuHome.label" /></li>
	</s:else>
	

</s:if>

		
		
<s:if test="isMenuVisible('menuRuolo')">
	<s:if test="isMenuEnabled('menuRuolo')">
		<s:url id="targetUrlMenuRuolo" action="goToMenuRuoloFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuRuolo')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuRuolo}" id="menu_items_menuRuolo">
				<s:text name="menuRuolo.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuRuolo.label" /></li>
	</s:else>
	

</s:if>

		
		
			
<s:if test="isMenuVisible('menuAcquisisci')">
	<s:if test="isAtLeastOneSubMenuVisible('menuAcquisisci')">
	
		<li class="parent<s:property value="%{(isMenuActive('menuAcquisisci') || isSubMenuActive('menuAcquisisci')) ? ' active' : ''}" />"<s:if test="isMenuActive('menuAcquisisci')"> id="current"</s:if>><span><s:text name="menuAcquisisci.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('menuCodImp')">
	<s:if test="isMenuEnabled('menuCodImp')">
		<s:url id="targetUrlMenuCodImp" action="goToMenuCodImpFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuCodImp')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuCodImp}" id="menu_items_menuCodImp">
				<s:text name="menuCodImp.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuCodImp.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuAcquistaBollini')">
	<s:if test="isMenuEnabled('menuAcquistaBollini')">
		<s:url id="targetUrlMenuAcquistaBollini" action="goToMenuAcquistaBolliniFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuAcquistaBollini')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuAcquistaBollini}" id="menu_items_menuAcquistaBollini">
				<s:text name="menuAcquistaBollini.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuAcquistaBollini.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="menuAcquisisci.label" /></li>
	
	</s:else>
</s:if>

		
		
			
<s:if test="isMenuVisible('menuAbilitazioni')">
	<s:if test="isAtLeastOneSubMenuVisible('menuAbilitazioni')">
	
		<li class="parent<s:property value="%{(isMenuActive('menuAbilitazioni') || isSubMenuActive('menuAbilitazioni')) ? ' active' : ''}" />"<s:if test="isMenuActive('menuAbilitazioni')"> id="current"</s:if>><span><s:text name="menuAbilitazioni.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('menuSubentro')">
	<s:if test="isMenuEnabled('menuSubentro')">
		<s:url id="targetUrlMenuSubentro" action="goToMenuSubentroFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuSubentro')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuSubentro}" id="menu_items_menuSubentro">
				<s:text name="menuSubentro.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuSubentro.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuDelega')">
	<s:if test="isMenuEnabled('menuDelega')">
		<s:url id="targetUrlMenuDelega" action="goToMenuDelegaFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuDelega')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuDelega}" id="menu_items_menuDelega">
				<s:text name="menuDelega.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuDelega.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuIncaricoCat')">
	<s:if test="isMenuEnabled('menuIncaricoCat')">
		<s:url id="targetUrlMenuIncaricoCat" action="goToMenuIncaricoCatFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuIncaricoCat')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuIncaricoCat}" id="menu_items_menuIncaricoCat">
				<s:text name="menuIncaricoCat.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuIncaricoCat.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuTerzoResp')">
	<s:if test="isMenuEnabled('menuTerzoResp')">
		<s:url id="targetUrlMenuTerzoResp" action="goToMenuTerzoRespFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuTerzoResp')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuTerzoResp}" id="menu_items_menuTerzoResp">
				<s:text name="menuTerzoResp.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuTerzoResp.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="menuAbilitazioni.label" /></li>
	
	</s:else>
</s:if>

		
		
			
<s:if test="isMenuVisible('menuGestione')">
	<s:if test="isAtLeastOneSubMenuVisible('menuGestione')">
	
		<li class="parent<s:property value="%{(isMenuActive('menuGestione') || isSubMenuActive('menuGestione')) ? ' active' : ''}" />"<s:if test="isMenuActive('menuGestione')"> id="current"</s:if>><span><s:text name="menuGestione.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('menuImpianto')">
	<s:if test="isMenuEnabled('menuImpianto')">
		<s:url id="targetUrlMenuImpianto" action="goToMenuImpiantoFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuImpianto')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuImpianto}" id="menu_items_menuImpianto">
				<s:text name="menuImpianto.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuImpianto.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuAllegati')">
	<s:if test="isMenuEnabled('menuAllegati')">
		<s:url id="targetUrlMenuAllegati" action="goToMenuAllegatiFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuAllegati')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuAllegati}" id="menu_items_menuAllegati">
				<s:text name="menuAllegati.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuAllegati.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuImportMassivo')">
	<s:if test="isMenuEnabled('menuImportMassivo')">
		<s:url id="targetUrlMenuImportMassivo" action="goToMenuImportMassivoFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuImportMassivo')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuImportMassivo}" id="menu_items_menuImportMassivo">
				<s:text name="menuImportMassivo.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuImportMassivo.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="menuGestione.label" /></li>
	
	</s:else>
</s:if>

		
		
			
<s:if test="isMenuVisible('menuPA')">
	<s:if test="isAtLeastOneSubMenuVisible('menuPA')">
	
		<li class="parent<s:property value="%{(isMenuActive('menuPA') || isSubMenuActive('menuPA')) ? ' active' : ''}" />"<s:if test="isMenuActive('menuPA')"> id="current"</s:if>><span><s:text name="menuPA.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('menuRicercaAvanzataImp')">
	<s:if test="isMenuEnabled('menuRicercaAvanzataImp')">
		<s:url id="targetUrlMenuRicercaAvanzataImp" action="goToMenuRicercaAvanzataImpFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuRicercaAvanzataImp')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuRicercaAvanzataImp}" id="menu_items_menuRicercaAvanzataImp">
				<s:text name="menuRicercaAvanzataImp.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuRicercaAvanzataImp.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuDatiImpresa')">
	<s:if test="isMenuEnabled('menuDatiImpresa')">
		<s:url id="targetUrlMenuDatiImpresa" action="goToMenuDatiImpresaFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuDatiImpresa')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuDatiImpresa}" id="menu_items_menuDatiImpresa">
				<s:text name="menuDatiImpresa.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuDatiImpresa.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuExportMassivo')">
	<s:if test="isMenuEnabled('menuExportMassivo')">
		<s:url id="targetUrlMenuExportMassivo" action="goToMenuExportMassivoFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuExportMassivo')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuExportMassivo}" id="menu_items_menuExportMassivo">
				<s:text name="menuExportMassivo.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuExportMassivo.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuBackOffice')">
	<s:if test="isMenuEnabled('menuBackOffice')">
		<s:url id="targetUrlMenuBackOffice" action="goToMenuBackOfficeFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuBackOffice')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuBackOffice}" id="menu_items_menuBackOffice">
				<s:text name="menuBackOffice.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuBackOffice.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuRicercaVerifiche')">
	<s:if test="isMenuEnabled('menuRicercaVerifiche')">
		<s:url id="targetUrlMenuRicercaVerifiche" action="goToMenuRicercaVerificheFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuRicercaVerifiche')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuRicercaVerifiche}" id="menu_items_menuRicercaVerifiche">
				<s:text name="menuRicercaVerifiche.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuRicercaVerifiche.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuRicercaAccertamenti')">
	<s:if test="isMenuEnabled('menuRicercaAccertamenti')">
		<s:url id="targetUrlMenuRicercaAccertamenti" action="goToMenuRicercaAccertamentiFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuRicercaAccertamenti')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuRicercaAccertamenti}" id="menu_items_menuRicercaAccertamenti">
				<s:text name="menuRicercaAccertamenti.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuRicercaAccertamenti.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuRicercaIspezioni')">
	<s:if test="isMenuEnabled('menuRicercaIspezioni')">
		<s:url id="targetUrlMenuRicercaIspezioni" action="goToMenuRicercaIspezioniFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuRicercaIspezioni')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuRicercaIspezioni}" id="menu_items_menuRicercaIspezioni">
				<s:text name="menuRicercaIspezioni.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuRicercaIspezioni.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuRicercaSanzioni')">
	<s:if test="isMenuEnabled('menuRicercaSanzioni')">
		<s:url id="targetUrlMenuRicercaSanzioni" action="goToMenuRicercaSanzioniFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuRicercaSanzioni')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuRicercaSanzioni}" id="menu_items_menuRicercaSanzioni">
				<s:text name="menuRicercaSanzioni.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuRicercaSanzioni.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('menuRicercaSveglie')">
	<s:if test="isMenuEnabled('menuRicercaSveglie')">
		<s:url id="targetUrlMenuRicercaSveglie" action="goToMenuRicercaSveglieFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuRicercaSveglie')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuRicercaSveglie}" id="menu_items_menuRicercaSveglie">
				<s:text name="menuRicercaSveglie.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuRicercaSveglie.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="menuPA.label" /></li>
	
	</s:else>
</s:if>

		
		
<s:if test="isMenuVisible('menuDatiDistributore')">
	<s:if test="isMenuEnabled('menuDatiDistributore')">
		<s:url id="targetUrlMenuDatiDistributore" action="goToMenuDatiDistributoreFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuDatiDistributore')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuDatiDistributore}" id="menu_items_menuDatiDistributore">
				<s:text name="menuDatiDistributore.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuDatiDistributore.label" /></li>
	</s:else>
	

</s:if>

		
		
<s:if test="isMenuVisible('menuToken')">
	<s:if test="isMenuEnabled('menuToken')">
		<s:url id="targetUrlMenuToken" action="goToMenuTokenFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuToken')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuToken}" id="menu_items_menuToken">
				<s:text name="menuToken.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuToken.label" /></li>
	</s:else>
	

</s:if>

		

		
<!-- STATIC LINKS -->

<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<s:set name="mddPortalCode" value="getPortalCode()" />	
<s:set name="staticLinksUrl" value="getStaticResource('/ris/utheme/{areaCode}/sigitwebn/include/static_links.html')" />
<c:catch var="ex">
	<r:include url='${staticLinksUrl}' resourceProvider='${mddPortalCode}' />
</c:catch>
	</ul>
</div>


