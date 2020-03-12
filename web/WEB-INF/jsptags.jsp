<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/panda-tags" prefix="p" %>
<html>
<head>
	<title>Panda JSP TagLib</title>
</head>

<body>
<div class="p-section">
	<div class="p-header">
		<h3><i class="fa fa-code"></i> Panda JSP TagLib</h3>
	</div>

	<p:form cssClass="p-eform" id="tags" focusme="true" method="post" theme="bs3h">
		<p:hidden name="hidden"/>
		<p:viewfield key="viewfield"/>
		<p:textfield key="textfield"/>
		<p:triggerfield key="triggerfield"/>
		<p:datepicker key="datepicker"/>
		<p:datetimepicker key="datetimepicker"/>
		<p:timepicker key="timepicker"/>
		<p:select key="select" emptyOption="true" list="!{'a': 'aaa', 'b': 'bbb'}"/>
		<p:select key="combobox" editable="true" emptyOption="true" list="!{'a': 'aaa', 'b': 'bbb'}"/>
		<p:radio key="radio" list="!{'a': 'aaa', 'b': 'bbb'}"/>
		<p:checkboxlist key="checkboxlist" list="!{'a': 'aaa', 'b': 'bbb'}"/>
		<p:checkbox key="checkbox" fieldValue="true" fieldLabel="label"/>
		<p:file key="file"/>
		<p:uploader
			key="uploader"
			accept="image/*,video/*,audio/*"
			size="30"
			multiple="true"
			uploadAction="%{b['files_path'] + '/uploads'}"
			uploadName="files"
			dnloadAction="%{b['files_path'] + '/download'}"
			dnloadName="id"
		/>
		<p:textarea key="textarea" maxlength="100" autosize="true"/>
		<p:viewfield key="htmlviewer" format="html"/>
		<p:htmleditor key="summernote" height="200" mediaAction="%{b.media_path + '/browse.popup'}"/>
		<p:htmleditor key="cleditor" editor="cleditor" rows="25"/>
		<p:div>
			<p:submit btype="primary" icon="submit" label="Submit"/>
			<p:reset btype="info" icon="reset" label="Reset"/>
		</p:div>
	</p:form>

</div>
</body>
</html>
