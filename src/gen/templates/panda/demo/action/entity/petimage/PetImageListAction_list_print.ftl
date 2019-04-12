<html>
<head>
	<title><@p.text name="title-list_print"><@p.param name="title" value="#(title)"/></@p.text></title>
</head>
<body>

<div class="p-section">
	<div class="p-header">
		<ol class="breadcrumb">
			<li><@p.i icon="icon"/> <@p.text name="title"/></li>
			<li class="active"><@p.text name="step-list_print"/></li>
		</ol>
	</div>
<#assign _well = a.getText("well-list_print", "")/>
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
			"name": "pid",
			"value": false,
			"header": a.getFieldLabel("pid"),
			"display": a.displayField("pid"),
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("pid")
		}, {
			"name": "pname",
			"value": false,
			"header": a.getFieldLabel("pname"),
			"display": a.displayField("pname"),
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("pname")
		}, {
			"name": "imageName",
			"value": false,
			"header": a.getFieldLabel("imageName"),
			"display": a.displayField("imageName"),
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("imageName")
		}, {
			"name": "imageSize",
			"value": false,
			"header": a.getFieldLabel("imageSize"),
			"display": a.displayField("imageSize"),
			"format": {
				"type": "size"
			},
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("imageSize")
		}, {
			"name": "imageFile",
			"value": false,
			"header": a.getFieldLabel("imageFile"),
			"display": a.displayField("imageFile"),
			"format": {
				"expr": "assist.getPetImageLink(top)",
				"escape": "none",
				"type": "expr"
			},
			"hidden": false,
			"sortable": false,
			"tooltip": a.getFieldTooltip("imageFile")
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


	<@p.listview id="petimage_list_print" action="./list.print" 
		list=result columns=_columns_
		cssTable="table-striped"
	/>
</div>

</body>
</html>
