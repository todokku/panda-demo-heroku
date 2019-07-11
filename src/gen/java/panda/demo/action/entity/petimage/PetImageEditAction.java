package panda.demo.action.entity.petimage;

import panda.app.action.crud.GenericEditAction;
import panda.dao.query.DataQuery;
import panda.demo.entity.PetImage;
import panda.demo.entity.query.PetImageQuery;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.TokenProtect;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.RequiredValidate;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.view.Views;
import panda.net.http.HttpMethod;
import panda.vfs.FileItem;

public abstract class PetImageEditAction extends GenericEditAction<PetImage> {
	/*----------------------------------------------------------------------*
	 * Properties
	 *----------------------------------------------------------------------*/
	protected FileItem file;

	/**
	 * Constructor
	 */
	public PetImageEditAction() {
		setType(PetImage.class);
		setDisplayFields(PetImage.ID, PetImage.PID, PetImage.PNAME, PetImage.IMAGE_NAME, PetImage.IMAGE_SIZE, PetImage.IMAGE_FILE, PetImage.UPDATED_AT, PetImage.UPDATED_BY, PetImage.UPDATED_BY_NAME, PetImage.UPDATED_BY_USER);
	}

	/**
	 * @return the file
	 */
	public FileItem getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(FileItem file) {
		this.file = file;
	}


	/*----------------------------------------------------------------------*
	 * Joins
	 *----------------------------------------------------------------------*/
	/**
	 * add query joins
	 * @param dq data query
	 */
	@Override
	protected void addQueryJoins(DataQuery<PetImage> dq) {
		super.addQueryJoins(dq);

		PetImageQuery eq = new PetImageQuery(dq);
		eq.autoLeftJoinPN();
	}

	/*----------------------------------------------------------------------*
	 * Actions
	 *----------------------------------------------------------------------*/
	/**
	 * view
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object view(@Param PetImage key) {
		return super.view(key);
	}

	/**
	 * view_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~view", error="sftl:~view")
	public Object view_input(@Param PetImage data) {
		return super.view_input(data);
	}

	/**
	 * view_json
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SJSON)
	public Object view_json(@Param PetImage key) {
		return super.view(key);
	}

	/**
	 * view_xml
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SXML)
	public Object view_xml(@Param PetImage key) {
		return super.view(key);
	}

	/**
	 * print
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object print(@Param PetImage key) {
		return super.print(key);
	}

	/**
	 * print_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~print", error="sftl:~print")
	public Object print_input(@Param PetImage data) {
		return super.print_input(data);
	}

	/**
	 * copy
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object copy(@Param PetImage key) {
		return super.copy(key);
	}

	/**
	 * copy_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~copy", error="sftl:~copy")
	public Object copy_input(@Param PetImage data) {
		return super.copy_input(data);
	}

	/**
	 * copy_confirm
	 * @param data the input data
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~copy")
	@TokenProtect
	public Object copy_confirm(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname', 'imageFile': '' }")
			@VisitValidate
			PetImage data) {
		return super.copy_confirm(data);
	}

	/**
	 * copy_execute
	 * @param data the input data
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~copy")
	@TokenProtect
	public Object copy_execute(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname', 'imageFile': '' }")
			@VisitValidate
			PetImage data) {
		return super.copy_execute(data);
	}

	/**
	 * add
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object add() {
		return super.add();
	}

	/**
	 * add_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~add", error="sftl:~add")
	public Object add_input(@Param PetImage data) {
		return super.add_input(data);
	}

	/**
	 * add_confirm
	 * @param data the input data
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~add")
	@TokenProtect
	public Object add_confirm(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname', 'imageFile': '' }")
			@VisitValidate
			PetImage data) {
		return super.add_confirm(data);
	}

	/**
	 * add_execute
	 * @param data the input data
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~add")
	@TokenProtect
	public Object add_execute(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname', 'imageFile': '' }")
			@VisitValidate
			PetImage data) {
		return super.add_execute(data);
	}

	/**
	 * add_json
	 * @param data the input data
	 * @return result
	 */
	@At
	@To(Views.SJSON)
	public Object add_json(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname', 'imageFile': '' }")
			@VisitValidate
			PetImage data) {
		return super.add_execute(data, true);
	}

	/**
	 * add_xml
	 * @param data the input data
	 * @return result
	 */
	@At
	@To(Views.SXML)
	public Object add_xml(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname', 'imageFile': '' }")
			@VisitValidate
			PetImage data) {
		return super.add_execute(data, true);
	}

	/**
	 * edit
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object edit(@Param PetImage key) {
		return super.edit(key);
	}

	/**
	 * edit_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~edit", error="sftl:~edit")
	public Object edit_input(@Param PetImage data) {
		return super.edit_input(data);
	}

	/**
	 * edit_confirm
	 * @param data the input data
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~edit")
	@TokenProtect
	public Object edit_confirm(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname' }")
			@VisitValidate
			PetImage data) {
		return super.edit_confirm(data);
	}

	/**
	 * edit_execute
	 * @param data the input data
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~edit")
	@TokenProtect
	public Object edit_execute(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname' }")
			@VisitValidate
			PetImage data) {
		return super.edit_execute(data);
	}

	/**
	 * edit_json
	 * @param data the input data
	 * @return result
	 */
	@At
	@To(Views.SJSON)
	public Object edit_json(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname' }")
			@VisitValidate
			PetImage data) {
		return super.edit_execute(data, true);
	}

	/**
	 * edit_xml
	 * @param data the input data
	 * @return result
	 */
	@At
	@To(Views.SXML)
	public Object edit_xml(@Param 
			@RequiredValidate(refers="{ 'pid': 'pname' }")
			@VisitValidate
			PetImage data) {
		return super.edit_execute(data, true);
	}

	/**
	 * delete
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object delete(@Param PetImage key) {
		return super.delete(key);
	}

	/**
	 * delete_execute
	 * @param key the input key
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~delete")
	@TokenProtect
	public Object delete_execute(@Param PetImage key) {
		return super.delete_execute(key);
	}

	/**
	 * delete_json
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SJSON)
	public Object delete_json(@Param PetImage key) {
		return super.delete_execute(key, true);
	}

	/**
	 * delete_xml
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SXML)
	public Object delete_xml(@Param PetImage key) {
		return super.delete_execute(key, true);
	}

}

