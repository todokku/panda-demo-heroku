package panda.demo.action.entity.petcategory;

import java.util.Map;
import panda.demo.action.WebBulkAction;
import panda.demo.entity.PetCategory;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.TokenProtect;
import panda.mvc.annotation.param.Param;
import panda.mvc.view.Views;
import panda.net.http.HttpMethod;

public abstract class PetCategoryBulkEnableAction extends WebBulkAction<PetCategory> {

	/**
	 * Constructor
	 */
	public PetCategoryBulkEnableAction() {
		setType(PetCategory.class);
		addDisplayFields(PetCategory.ID, PetCategory.NAME, PetCategory.STATUS, PetCategory.UPDATED_AT, PetCategory.UPDATED_BY, PetCategory.UPDATED_BY_USER);
	}


	/*----------------------------------------------------------------------*
	 * Actions
	 *----------------------------------------------------------------------*/
	/**
	 * benable
	 * @param args arguments
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object benable(@Param Map<String, String[]> args) {
		return super.bupdate(args);
	}

	/**
	 * benable_execute
	 * @param args arguments
	 * @return result or view
	 */
	@At(method=HttpMethod.POST)
	@To(value=Views.SFTL, error="sftl:~benable")
	@TokenProtect
	public Object benable_execute(@Param Map<String, String[]> args) {
		return super.bupdate_execute(args);
	}
	
}

