package panda.demo.action.entity.pet;

import panda.dao.query.DataQuery;
import panda.demo.action.WebListAction;
import panda.demo.entity.Pet;
import panda.demo.entity.query.PetQuery;
import panda.mvc.annotation.At;
import panda.mvc.annotation.To;
import panda.mvc.annotation.param.Param;
import panda.mvc.annotation.validate.VisitValidate;
import panda.mvc.bean.Queryer;
import panda.mvc.view.Views;

@At("/pet")
public class PetPopupAction extends WebListAction<Pet> {

	/**
	 * Constructor
	 */
	public PetPopupAction() {
		setType(Pet.class);
		addDisplayFields(Pet.ID, Pet.NAME, Pet.CID, Pet.CNAME, Pet.GENDER, Pet.BIRTHDAY, Pet.ORIGIN, Pet.STATUS);
	}


	/*----------------------------------------------------------------------*
	 * Joins
	 *----------------------------------------------------------------------*/
	/**
	 * add query joins
	 * @param dq data query
	 */
	@Override
	protected void addQueryJoins(DataQuery<Pet> dq) {
		super.addQueryJoins(dq);

		PetQuery eq = new PetQuery(dq);
		eq.autoLeftJoinCN();
		eq.autoLeftJoinUU();
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

