<html>
<head>
	<title><@p.text name="title-list_pdf"><@p.param name="title" value="#(title)"/></@p.text></title>
</head>
<body>

<div class="p-section">
	<div class="p-header">
		<ol class="breadcrumb">
			<li><@p.i icon="icon"/> <@p.text name="title"/></li>
			<li class="active"><@p.text name="step-list_pdf"/></li>
		</ol>
	</div>
<#assign _well = a.getText("well-list_pdf", "")/>
<#if _well?has_content>
	<div class="p-well">${_well}</div>
</#if>

	<#include "/action-alert.ftl"/>

	<#assign _columns_ = [{
			"name": "_number_",
			"type": "number",
			"fixed": true,
			"header": a.getText("listview-th-number", "")
		}, {
			"name": "id",
			"value": false,
			"header": a.getFieldLabel("id"),
			"display": a.displayField("id"),
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("id")
		}, {
			"name": "name",
			"value": false,
			"header": a.getFieldLabel("name"),
			"display": a.displayField("name"),
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("name")
		}, {
			"name": "status",
			"value": false,
			"header": a.getFieldLabel("status"),
			"display": a.displayField("status"),
			"format": {
				"codemap": consts.dataStatusMap,
				"type": "code"
			},
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("status")
		}, {
			"name": "updatedAt",
			"value": false,
			"header": a.getFieldLabel("updatedAt"),
			"display": a.displayField("updatedAt"),
			"format": {
				"type": "datetime"
			},
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("updatedAt")
		}, {
			"name": "updatedBy",
			"value": false,
			"header": a.getFieldLabel("updatedBy"),
			"display": a.displayField("updatedBy"),
			"format": {
				"expr": "top.updatedByUser",
				"type": "expr"
			},
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("updatedBy")
		}] />

	<@p.listview id="petcategory_list_pdf" action="./list.pdf" 
		list=result columns=_columns_ cssColumn="status"
		cssTable="table-striped" header=" " footer=" "
	/>
</div>

</body>
</html>
