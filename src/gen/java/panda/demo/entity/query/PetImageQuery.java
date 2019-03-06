package panda.demo.entity.query;

import panda.app.entity.query.UQuery;
import panda.dao.entity.Entities;
import panda.dao.query.ComparableCondition;
import panda.dao.query.DataQuery;
import panda.dao.query.ObjectCondition;
import panda.dao.query.Query;
import panda.dao.query.StringCondition;
import panda.demo.entity.PetImage;

public class PetImageQuery extends UQuery<PetImage, PetImageQuery> {
	/**
	 * Constructor
	 */
	public PetImageQuery() {
		super(Entities.i().getEntity(PetImage.class));
	}

	/**
	 * Constructor
	 * @param query the query to set
	 */
	public PetImageQuery(DataQuery<PetImage> query) {
		super(query);
	}

	//----------------------------------------------------------------------
	// field conditions
	//----------------------------------------------------------------------
	/**
	 * @return condition of id
	 */
	public ComparableCondition<PetImageQuery, Long> id() {
		return new ComparableCondition<PetImageQuery, Long>(this, PetImage.ID);
	}

	/**
	 * @return condition of pid
	 */
	public ComparableCondition<PetImageQuery, Long> pid() {
		return new ComparableCondition<PetImageQuery, Long>(this, PetImage.PID);
	}

	/**
	 * @return condition of pname
	 */
	public StringCondition<PetImageQuery> pname() {
		return new StringCondition<PetImageQuery>(this, PetImage.PNAME);
	}

	/**
	 * @return condition of imageName
	 */
	public StringCondition<PetImageQuery> imageName() {
		return new StringCondition<PetImageQuery>(this, PetImage.IMAGE_NAME);
	}

	/**
	 * @return condition of imageData
	 */
	public ObjectCondition<PetImageQuery> imageData() {
		return new ObjectCondition<PetImageQuery>(this, PetImage.IMAGE_DATA);
	}

	/**
	 * @return condition of imageSize
	 */
	public ComparableCondition<PetImageQuery, Integer> imageSize() {
		return new ComparableCondition<PetImageQuery, Integer>(this, PetImage.IMAGE_SIZE);
	}


	//----------------------------------------------------------------------
	// auto joins
	//----------------------------------------------------------------------
	/**
	 * auto left join PN
	 * @return this
	 */
	public PetImageQuery autoLeftJoinPN() {
		autoLeftJoin(PetImage._JOIN_PN_);
		return this;
	}

	/**
	 * auto left join PN
	 * @param jq join table query
	 * @return this
	 */
	public PetImageQuery autoLeftJoinPN(Query<?> jq) {
		autoLeftJoin(PetImage._JOIN_PN_, jq);
		return this;
	}

	/**
	 * auto right join PN
	 * @return this
	 */
	public PetImageQuery autoRightJoinPN() {
		autoRightJoin(PetImage._JOIN_PN_);
		return this;
	}

	/**
	 * auto right join PN
	 * @param jq join table query
	 * @return this
	 */
	public PetImageQuery autoRightJoinPN(Query<?> jq) {
		autoRightJoin(PetImage._JOIN_PN_, jq);
		return this;
	}

	/**
	 * auto inner join PN
	 * @return this
	 */
	public PetImageQuery autoInnerJoinPN() {
		autoInnerJoin(PetImage._JOIN_PN_);
		return this;
	}

	/**
	 * auto inner join PN
	 * @param jq join table query
	 * @return this
	 */
	public PetImageQuery autoInnerJoinPN(Query<?> jq) {
		autoInnerJoin(PetImage._JOIN_PN_, jq);
		return this;
	}

	/**
	 * auto join PN
	 * @return this
	 */
	public PetImageQuery autoJoinPN() {
		autoJoin(PetImage._JOIN_PN_);
		return this;
	}

	/**
	 * auto join PN
	 * @param jq join table query
	 * @return this
	 */
	public PetImageQuery autoJoinPN(Query<?> jq) {
		autoJoin(PetImage._JOIN_PN_, jq);
		return this;
	}

}

