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
			"link": true,
			"sortable": true,
			"tooltip": a.getFieldTooltip("id")
		}, {
			"name" : "name",
			"header": a.getFieldLabel("name"),
			"display": a.displayField("name"),
			"filterable": a.filterField("name"),
			"filter": {
				"fixed": true,
				"type": "string"
			},
			"link": true,
			"sortable": true,
			"tooltip": a.getFieldTooltip("name")
		}, {
			"name" : "cid",
			"header": a.getFieldLabel("cid"),
			"display": a.displayField("cid"),
			"filterable": a.filterField("cid"),
			"filter": {
				"type": "number"
			},
			"hidden": true,
			"tooltip": a.getFieldTooltip("cid")
		}, {
			"name" : "-icon",
			"header": a.getFieldLabel("-icon"),
			"display": a.displayField("-icon"),
			"format": {
				"expr": "<img class='pi-icon' src='%{base}/petimage/pimage?pid=%{top.id}'>",
				"escape": "none",
				"type": "tran"
			},
			"tooltip": a.getFieldTooltip("-icon")
		}, {
			"name" : "cname",
			"header": a.getFieldLabel("cname"),
			"display": a.displayField("cname"),
			"filterable": a.filterField("cname"),
			"filter": {
				"type": "string"
			},
			"link": { 'action': '../petcategory/view', 'params': { 'id': '%{top.cid}' } },
			"sortable": true,
			"tooltip": a.getFieldTooltip("cname")
		}, {
			"name" : "gender",
			"header": a.getFieldLabel("gender"),
			"display": a.displayField("gender"),
			"format": {
				"codemap": consts.petGenderMap,
				"type": "code"
			},
			"filterable": a.filterField("gender"),
			"filter": {
				"list": consts.petGenderMap,
				"type": "checklist"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("gender")
		}, {
			"name" : "birthday",
			"header": a.getFieldLabel("birthday"),
			"display": a.displayField("birthday"),
			"format": {
				"type": "date"
			},
			"filterable": a.filterField("birthday"),
			"filter": {
				"type": "date"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("birthday")
		}, {
			"name" : "origin",
			"header": a.getFieldLabel("origin"),
			"display": a.displayField("origin"),
			"format": {
				"codemap": consts.petOriginMap,
				"type": "code"
			},
			"filterable": a.filterField("origin"),
			"filter": {
				"list": consts.petOriginMap,
				"type": "select"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("origin")
		}, {
			"name" : "temper",
			"header": a.getFieldLabel("temper"),
			"display": a.displayField("temper"),
			"format": {
				"codemap": consts.petTemperMap,
				"type": "code"
			},
			"filterable": a.filterField("temper"),
			"filter": {
				"list": consts.petTemperMap,
				"type": "checklist"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("temper")
		}, {
			"name" : "habits",
			"header": a.getFieldLabel("habits"),
			"display": a.displayField("habits"),
			"format": {
				"codemap": consts.petHabitMap,
				"type": "code"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("habits")
		}, {
			"name" : "amount",
			"header": a.getFieldLabel("amount"),
			"display": a.displayField("amount"),
			"filterable": a.filterField("amount"),
			"filter": {
				"type": "number"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("amount")
		}, {
			"name" : "price",
			"header": a.getFieldLabel("price"),
			"display": a.displayField("price"),
			"filterable": a.filterField("price"),
			"filter": {
				"type": "number"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("price")
		}, {
			"name" : "shopName",
			"header": a.getFieldLabel("shopName"),
			"display": a.displayField("shopName"),
			"filterable": a.filterField("shopName"),
			"filter": {
				"type": "string"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("shopName")
		}, {
			"name" : "status",
			"header": a.getFieldLabel("status"),
			"display": a.displayField("status"),
			"format": {
				"codemap": consts.dataStatusMap,
				"type": "code"
			},
			"filterable": a.filterField("status"),
			"filter": {
				"list": consts.dataStatusMap,
				"type": "checklist"
			},
			"hidden": false,
			"link": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("status")
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
			"filterable": a.filterField("updatedBy"),
			"filter": {
				"type": "number"
			},
			"hidden": true,
			"link": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("updatedBy")
		}, {
			"name" : "updatedByUser",
			"header": a.getFieldLabel("updatedByUser"),
			"display": a.displayField("updatedByUser"),
			"hidden": false,
			"link": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("updatedByUser")
		}] />


	<#if a.actionsAlignRight>
		<#assign _columns_ = _columns_ + _actionc_![]/>
	</#if>
	<@p.set var="lvtools">
		<#if a.canAccess("./bdelete")>
			<@p.b onclick="return pet_list_bdelete();" icon="icon-bdelete" label="#(btn-bdelete)"/>
		</#if>
		<#if a.canAccess("./benable")>
			<@p.b onclick="return pet_list_benable();" icon="icon-benable" label="#(btn-benable)"/>
		</#if>
		<#if a.canAccess("./bdisable")>
			<@p.b onclick="return pet_list_bdisable();" icon="icon-bdisable" label="#(btn-bdisable)"/>
		</#if>
	</@p.set>

	<@p.queryer id="pet_list_qr" action="./list"
		columns=_columns_
	/>

	<@p.listview id="pet_list" action="./list"
		list=result columns=_columns_ cssColumn="status"
		cssTable="table-hover table-striped"
		link={ "action": "./view", "params": { "id": "%{top.id}" } }
		tools="%{vars.lvtools}"
	/>

	<script type="text/javascript"><!--
		function pet_list_bdelete() {
			return plv_submitCheckedKeys('pet_list', '<@p.url action="./bdelete"/>', null, "");
		}
		function pet_list_benable() {
			return plv_submitCheckedKeys('pet_list', '<@p.url action="./benable"/>', null, "");
		}
		function pet_list_bdisable() {
			return plv_submitCheckedKeys('pet_list', '<@p.url action="./bdisable"/>', null, "");
		}
	--></script>
</div>

</body>
</html>
