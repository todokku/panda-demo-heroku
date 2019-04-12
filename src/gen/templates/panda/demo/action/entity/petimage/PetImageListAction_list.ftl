<html>
<head>
	<title><@p.text name="title-list"><@p.param name="title" value="#(title)"/></@p.text></title>
</head>
<body>

<div class="p-section">
	<div class="p-header">
		<ol class="breadcrumb">
			<li><@p.i icon="icon"/> <@p.text name="title"/></li>
			<li class="active"><@p.text name="step-list"/></li>
		</ol>
	</div>
<#assign _well = a.getText("well-list", "")/>
<#if _well?has_content>
	<div class="p-well">${_well}</div>
</#if>


	<div class="p-toolbar-wrap"><ul class="p-toolbar">
<#if a.canAccess("./add")><li><@p.a action="./add" icon="icon-new" label="#(btn-new)"/>
</li></#if><#if a.canAccess("./import")><li><@p.a action="./import" icon="icon-import" label="#(btn-import)"/>
</li></#if><#if a.canAccess("./expo.xlsx")><li><@p.a action="./expo.xlsx" includeParams="all" icon="icon-xlsx" label="#(btn-xlsx)" target="_blank"/>
</li></#if><#if a.canAccess("./expo.csv")><li><@p.a action="./expo.csv" includeParams="all" icon="icon-csv" label="#(btn-csv)" target="_blank"/>
</li></#if><#if a.canAccess("./list.json")><li><@p.a action="./list.json" includeParams="all" icon="icon-json" label="#(btn-json)" target="_blank"/>
</li></#if><#if a.canAccess("./list.xml")><li><@p.a action="./list.xml" includeParams="all" icon="icon-xml" label="#(btn-xml)" target="_blank"/>
</li></#if><#if a.canAccess("./list.pdf")><li><@p.a action="./list.pdf?__redir=/pdf&__query=url" includeParams="all" icon="icon-pdf" label="#(btn-pdf)" target="_blank"/>
</li></#if><#if a.canAccess("./list.print")><li><@p.a action="./list.print" includeParams="all" icon="icon-print" label="#(btn-print)" target="_blank"/>
</li></#if>	</ul><div class="clearfix"></div></div>

	<#include "/action-alert.ftl"/>

	<#assign _columns_ = [{
		"name": "_number_",
		"type": "number",
		"fixed": true,
		"header": a.getText("listview-th-number", "")
	}] />

	<#assign _actions_ = [] />
	<#assign _ash_ = "" />
	<#if a.canAccess("./add")>
		<@p.url var='_u_' action='./add' escapeAmp='true'/>
		<#assign _ash_ = '<a class="p-lv-ia" href="' + vars._u_ + '" title="' + a.getText('tip-new', '')?html + '"><i class="' + a.getText('icon-new', '') + '"></i>' + a.getText('lbl-new', '') + '</a>'/>
	</#if>
	<#if a.canAccess("./copy")>
		<#assign _actions_ = _actions_ + [{
			"action": "./copy",
			"params": { "id": "%{top.id}" },
			"icon": a.getText("icon-copy"),
			"label": a.getText("lbl-copy", ""),
			"tooltip": a.getText("tip-copy", "")
		}] />
	</#if>
	<#if a.canAccess("./edit")>
		<#assign _actions_ = _actions_ + [{
			"action": "./edit",
			"params": { "id": "%{top.id}" },
			"icon": a.getText("icon-edit"),
			"label": a.getText("lbl-edit", ""),
			"tooltip": a.getText("tip-edit", "")
		}] />
	</#if>
	<#if a.canAccess("./delete")>
		<#assign _actions_ = _actions_ + [{
			"action": "./delete",
			"params": { "id": "%{top.id}" },
			"icon": a.getText("icon-delete"),
			"label": a.getText("lbl-delete", ""),
			"tooltip": a.getText("tip-delete", "")
		}] />
	</#if>
	<#if _actions_?has_content || _ash_?has_content>
		<#if !(_ash_?has_content)>
			<#assign _ash_ = a.getText("listview-th-actions", "")/>
		</#if>
		<#assign _actionc_ = [{
			"name": "_actions_",
			"type": "actions",
			"fixed": true,
			"header": _ash_,
			"actions": _actions_
		}] />
	</#if>
	<#if a.actionsAlignLeft>
		<#assign _columns_ = _columns_ + _actionc_![]/>
	</#if>

	<#if action.canAccess("./bdelete") || action.canAccess("./benable") || action.canAccess("./bdisable")>
		<#assign _columns_ = _columns_ + [{
			"name": "_check_",
			"type": "check",
			"fixed": true
		}] />
	</#if>

	<#assign _columns_ = _columns_ + [{
			"name" : "id",
			"pkey" : true,
			"value": true,
			"header": a.getFieldLabel("id"),
			"display": a.displayField("id"),
			"filterable": a.filterField("id"),
			"filter": {
				"type": "number"
			},
			"hidden": false,
			"link": true,
			"sortable": true,
			"tooltip": a.getFieldTooltip("id")
		}, {
			"name" : "pid",
			"header": a.getFieldLabel("pid"),
			"display": a.displayField("pid"),
			"filterable": a.filterField("pid"),
			"filter": {
				"type": "number"
			},
			"hidden": false,
			"link": { 'action': '../pet/view', 'params': { 'id': '%{top.pid}' } },
			"sortable": true,
			"tooltip": a.getFieldTooltip("pid")
		}, {
			"name" : "pname",
			"header": a.getFieldLabel("pname"),
			"display": a.displayField("pname"),
			"filterable": a.filterField("pname"),
			"filter": {
				"type": "string"
			},
			"hidden": false,
			"link": { 'action': '../pet/view', 'params': { 'id': '%{top.pid}' } },
			"sortable": true,
			"tooltip": a.getFieldTooltip("pname")
		}, {
			"name" : "imageName",
			"header": a.getFieldLabel("imageName"),
			"display": a.displayField("imageName"),
			"filterable": a.filterField("imageName"),
			"filter": {
				"type": "string"
			},
			"hidden": false,
			"link": true,
			"sortable": true,
			"tooltip": a.getFieldTooltip("imageName")
		}, {
			"name" : "imageSize",
			"header": a.getFieldLabel("imageSize"),
			"display": a.displayField("imageSize"),
			"format": {
				"type": "size"
			},
			"hidden": false,
			"link": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("imageSize")
		}, {
			"name" : "imageFile",
			"header": a.getFieldLabel("imageFile"),
			"display": a.displayField("imageFile"),
			"format": {
				"expr": "assist.getPetImageLink(top)",
				"escape": "none",
				"type": "expr"
			},
			"hidden": false,
			"link": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("imageFile")
		}, {
			"name" : "updatedAt",
			"header": a.getFieldLabel("updatedAt"),
			"display": a.displayField("updatedAt"),
			"format": {
				"type": "datetime"
			},
			"filterable": a.filterField("updatedAt"),
			"filter": {
				"type": "datetime"
			},
			"hidden": false,
			"link": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("updatedAt")
		}, {
			"name" : "updatedBy",
			"header": a.getFieldLabel("updatedBy"),
			"display": a.displayField("updatedBy"),
			"format": {
				"expr": "top.updatedByUser",
				"type": "expr"
			},
			"filterable": a.filterField("updatedBy"),
			"filter": {
				"type": "number"
			},
			"hidden": false,
			"link": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("updatedBy")
		}] />


	<#if a.actionsAlignRight>
		<#assign _columns_ = _columns_ + _actionc_![]/>
	</#if>
	<@p.set var="lvtools">
		<#if a.canAccess("./bdelete")>
			<@p.b onclick="return petimage_list_bdelete();" icon="icon-bdelete" label="#(btn-bdelete)"/>
		</#if>
		<#if a.canAccess("./benable")>
			<@p.b onclick="return petimage_list_benable();" icon="icon-benable" label="#(btn-benable)"/>
		</#if>
		<#if a.canAccess("./bdisable")>
			<@p.b onclick="return petimage_list_bdisable();" icon="icon-bdisable" label="#(btn-bdisable)"/>
		</#if>
	</@p.set>

	<@p.queryer id="petimage_list_qr" action="./list"
		columns=_columns_
	/>

	<@p.listview id="petimage_list" action="./list"
		list=result columns=_columns_
		cssTable="table-hover table-striped"
		link={ "action": "./view", "params": { "id": "%{top.id}" } }
		tools="%{vars.lvtools}"
	/>

	<script type="text/javascript"><!--
		function petimage_list_bdelete() {
			return plv_submitCheckedKeys('petimage_list', '<@p.url action="./bdelete"/>', null, "");
		}
		function petimage_list_benable() {
			return plv_submitCheckedKeys('petimage_list', '<@p.url action="./benable"/>', null, "");
		}
		function petimage_list_bdisable() {
			return plv_submitCheckedKeys('petimage_list', '<@p.url action="./bdisable"/>', null, "");
		}
	--></script>
</div>

</body>
</html>
