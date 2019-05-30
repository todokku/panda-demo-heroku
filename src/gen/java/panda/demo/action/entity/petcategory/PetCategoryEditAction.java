package panda.demo.action.entity.petcategory;

import panda.demo.action.WebEditAction;
import panda.demo.entity.PetCategory;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.TokenProtect;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.RequiredValidate;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.view.Views;
import panda.net.http.HttpMethod;

@At("/petcategory")
public class PetCategoryEditAction extends WebEditAction<PetCategory> {

	/**
	 * Constructor
	 */
	public PetCategoryEditAction() {
		setType(PetCategory.class);
		setDisplayFields(PetCategory.ID, PetCategory.NAME, PetCategory.MEMO, PetCategory.STATUS, PetCategory.UPDATED_AT, PetCategory.UPDATED_BY, PetCategory.UPDATED_BY_NAME, PetCategory.UPDATED_BY_USER);
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
	public Object view(@Param PetCategory key) {
		return super.view(key);
	}

	/**
	 * view_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~view", error="sftl:~view")
	public Object view_input(@Param PetCategory data) {
		return super.view_input(data);
	}

	/**
	 * view_json
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SJSON)
	public Object view_json(@Param PetCategory key) {
		return super.view(key);
	}

	/**
	 * view_xml
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SXML)
	public Object view_xml(@Param PetCategory key) {
		return super.view(key);
	}

	/**
	 * print
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object print(@Param PetCategory key) {
		return super.print(key);
	}

	/**
	 * print_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~print", error="sftl:~print")
	public Object print_input(@Param PetCategory data) {
		return super.print_input(data);
	}

	/**
	 * copy
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object copy(@Param PetCategory key) {
		return super.copy(key);
	}

	/**
	 * copy_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~copy", error="sftl:~copy")
	public Object copy_input(@Param PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
	public Object add_input(@Param PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
		return super.add_execute(data, true);
	}

	/**
	 * edit
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object edit(@Param PetCategory key) {
		return super.edit(key);
	}

	/**
	 * edit_input
	 * @param data the input data
	 * @return result or view
	 */
	@At
	@To(value="sftl:~edit", error="sftl:~edit")
	public Object edit_input(@Param PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
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
			@RequiredValidate(fields={ "name" })
			@VisitValidate
			PetCategory data) {
		return super.edit_execute(data, true);
	}

	/**
	 * delete
	 * @param key the input key
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object delete(@Param PetCategory key) {
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
	public Object delete_execute(@Param PetCategory key) {
		return super.delete_execute(key);
	}

	/**
	 * delete_json
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SJSON)
	public Object delete_json(@Param PetCategory key) {
		return super.delete_execute(key, true);
	}

	/**
	 * delete_xml
	 * @param key the input key
	 * @return result
	 */
	@At
	@To(Views.SXML)
	public Object delete_xml(@Param PetCategory key) {
		return super.delete_execute(key, true);
	}

}

