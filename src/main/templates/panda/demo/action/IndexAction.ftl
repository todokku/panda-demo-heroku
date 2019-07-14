<html>
<head>
	<title><@p.text name="site-desc"/></title>
</head>

<body>
	<div class="p-well p-tcenter" style="margin: 0 10px 20px 10px">
		<@p.text name="site-desc"/>
	</div>

<#macro mitem ac ic tx>
	<#if a.canAccess(ac)>
		<@p.a cssClass="p-menu-item" action=ac>
			<i class="fa-4x ${a.getText(ic)}"></i>
			<div><@p.text name=tx/></div>
		</@p.a>
	</#if>
</#macro>

	<div class="p-menu">
		<@mitem ac="/pet/list"          ic="icon-pets-pet"          tx="navi-pets-pet"/>
		<@mitem ac="/petsearch/"        ic="icon-pets-petsearch"    tx="navi-pets-petsearch"/>
		<@mitem ac="/petcategory/list"  ic="icon-pets-petcategory"  tx="navi-pets-petcategory"/>
		<@mitem ac="/petimage/list"     ic="icon-pets-petimage"     tx="navi-pets-petimage"/>
		<div class="clearfix"></div>

		<hr/>
		<@mitem ac="/pages"       ic="icon-pages"                  tx="navi-pages"/>
		<@mitem ac="/media"       ic="icon-media"                  tx="navi-media"/>
		<@mitem ac="/mfupd"       ic="icon-sample-multifileupload" tx="navi-sample-multifileupload"/>
		<@mitem ac="/alert"       ic="icon-sample-alert"           tx="navi-sample-alert"/>
		<@mitem ac="/ftltags"     ic="icon-sample-ftltags"         tx="navi-sample-ftltags"/>
		<@mitem ac="/jsptags"     ic="icon-sample-jsptags"         tx="navi-sample-jsptags"/>
		<@mitem ac="/debug"       ic="icon-sample-debug"           tx="navi-sample-debug"/>
		<@mitem ac="/memtest"     ic="icon-sample-memtest"         tx="navi-sample-memtest"/>
		<@mitem ac="/task/reset"  ic="icon-reset"                  tx="navi-task-reset"/>
		<div class="clearfix"></div>

<#if assist.loginUser??>
		<hr/>
		<@mitem ac="/user/profile/input"    ic="icon-user-profile"         tx="navi-user-profile"/>
		<@mitem ac="/user/password/change/" ic="icon-user-password-change" tx="navi-user-password-change"/>
		<@mitem ac="/admin/users/list"      ic="icon-admin-users"          tx="navi-admin-users"/>
		<@mitem ac="/admin/pages/list"      ic="icon-admin-pages"          tx="navi-admin-pages"/>
		<@mitem ac="/admin/media/list"      ic="icon-admin-media"          tx="navi-admin-media"/>
		<@mitem ac="/admin/files/list"      ic="icon-admin-files"          tx="navi-admin-files"/>
		<div class="clearfix"></div>
</#if>

<#if assist.hasAdminRole()>
		<hr/>
		<@mitem ac="/admin/users/list"      ic="icon-admin-users"          tx="navi-admin-users"/>
		<@mitem ac="/admin/pages/list"      ic="icon-admin-pages"          tx="navi-admin-pages"/>
		<@mitem ac="/admin/media/list"      ic="icon-admin-media"          tx="navi-admin-media"/>
		<@mitem ac="/admin/files/list"      ic="icon-admin-files"          tx="navi-admin-files"/>
		<div class="clearfix"></div>
</#if>

<#if assist.hasSuperRole()>
		<hr/>
		<#include "/panda/gems/admin/super-menunav.ftl" />
		<div class="clearfix"></div>
</#if>

		<br/>
		<br/>
	</div>
</body>
</html>

