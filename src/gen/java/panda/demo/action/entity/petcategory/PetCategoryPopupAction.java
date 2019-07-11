package panda.demo.action.entity.petcategory;

import panda.app.action.crud.GenericListAction;
import panda.demo.entity.PetCategory;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.bean.Queryer;
import panda.mvc.view.Views;

@At("/petcategory")
public class PetCategoryPopupAction extends GenericListAction<PetCategory> {

	/**
	 * Constructor
	 */
	public PetCategoryPopupAction() {
		setType(PetCategory.class);
		setDisplayFields(PetCategory.ID, PetCategory.NAME, PetCategory.STATUS);
	}


	/*----------------------------------------------------------------------*
	 * Actions
	 *----------------------------------------------------------------------*/
	/**
	 * list_popup
	 * @param qr queryer
	 * @return result or view
	 */
	@At
	@To(value=Views.SFTL, error=Views.SFTL)
	public Object list_popup(@Param @VisitValidate Queryer qr) {
		return super.list_popup(qr);
	}
	
}

