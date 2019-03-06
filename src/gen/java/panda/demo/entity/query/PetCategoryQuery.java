package panda.demo.entity.query;

import panda.app.entity.query.SUQuery;
import panda.dao.entity.Entities;
import panda.dao.query.ComparableCondition;
import panda.dao.query.DataQuery;
import panda.dao.query.StringCondition;
import panda.demo.entity.PetCategory;

public class PetCategoryQuery extends SUQuery<PetCategory, PetCategoryQuery> {
	/**
	 * Constructor
	 */
	public PetCategoryQuery() {
		super(Entities.i().getEntity(PetCategory.class));
	}

	/**
	 * Constructor
	 * @param query the query to set
	 */
	public PetCategoryQuery(DataQuery<PetCategory> query) {
		super(query);
	}

	//----------------------------------------------------------------------
	// field conditions
	//----------------------------------------------------------------------
	/**
	 * @return condition of id
	 */
	public ComparableCondition<PetCategoryQuery, Long> id() {
		return new ComparableCondition<PetCategoryQuery, Long>(this, PetCategory.ID);
	}

	/**
	 * @return condition of name
	 */
	public StringCondition<PetCategoryQuery> name() {
		return new StringCondition<PetCategoryQuery>(this, PetCategory.NAME);
	}

	/**
	 * @return condition of memo
	 */
	public StringCondition<PetCategoryQuery> memo() {
		return new StringCondition<PetCategoryQuery>(this, PetCategory.MEMO);
	}


}

