package panda.demo.action.entity.petcategory;

import java.util.List;

import panda.app.constant.VAL;
import panda.dao.query.DataQuery;
import panda.demo.entity.PetCategory;
import panda.demo.entity.query.PetCategoryQuery;
import panda.mvc.annotation.At;

@At("/petcategory")
public class PetCategoryBulkEnableExAction extends PetCategoryBulkEnableAction {

	@Override
	protected PetCategory getBulkUpdateSample(List<PetCategory> dataList, DataQuery<PetCategory> gq) {
		PetCategory d = new PetCategory();
		d.setStatus(VAL.STATUS_ACTIVE);

		PetCategoryQuery q = new PetCategoryQuery(gq);
		q.excludeAll().include(PetCategory.STATUS);

		return d;
	}

}
