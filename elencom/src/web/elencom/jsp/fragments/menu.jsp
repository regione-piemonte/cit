<%@taglib prefix="s" uri="/struts-tags" %>

	
<div id="mainMenu">
	<h3>Menu di navigazione</h3>
	<ul>
		
<s:if test="isMenuVisible('mnuHome')">
	<s:if test="isMenuEnabled('mnuHome')">
		<s:url id="targetUrlMnuHome" action="goToMnuHomeFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuHome')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuHome}" id="menu_items_mnuHome">
				<s:text name="mnuHome.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuHome.label" /></li>
	</s:else>
	

</s:if>

		

	</ul>
</div>


