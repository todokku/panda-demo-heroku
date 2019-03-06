package panda.demo.entity.query;

import java.math.BigDecimal;
import java.util.Date;
import panda.app.entity.query.SUQuery;
import panda.dao.entity.Entities;
import panda.dao.query.ComparableCondition;
import panda.dao.query.DataQuery;
import panda.dao.query.ObjectCondition;
import panda.dao.query.Query;
import panda.dao.query.StringCondition;
import panda.demo.entity.Pet;

public class PetQuery extends SUQuery<Pet, PetQuery> {
	/**
	 * Constructor
	 */
	public PetQuery() {
		super(Entities.i().getEntity(Pet.class));
	}

	/**
	 * Constructor
	 * @param query the query to set
	 */
	public PetQuery(DataQuery<Pet> query) {
		super(query);
	}

	//----------------------------------------------------------------------
	// field conditions
	//----------------------------------------------------------------------
	/**
	 * @return condition of id
	 */
	public ComparableCondition<PetQuery, Long> id() {
		return new ComparableCondition<PetQuery, Long>(this, Pet.ID);
	}

	/**
	 * @return condition of name
	 */
	public StringCondition<PetQuery> name() {
		return new StringCondition<PetQuery>(this, Pet.NAME);
	}

	/**
	 * @return condition of cid
	 */
	public ComparableCondition<PetQuery, Long> cid() {
		return new ComparableCondition<PetQuery, Long>(this, Pet.CID);
	}

	/**
	 * @return condition of cname
	 */
	public StringCondition<PetQuery> cname() {
		return new StringCondition<PetQuery>(this, Pet.CNAME);
	}

	/**
	 * @return condition of gender
	 */
	public StringCondition<PetQuery> gender() {
		return new StringCondition<PetQuery>(this, Pet.GENDER);
	}

	/**
	 * @return condition of birthday
	 */
	public ComparableCondition<PetQuery, Date> birthday() {
		return new ComparableCondition<PetQuery, Date>(this, Pet.BIRTHDAY);
	}

	/**
	 * @return condition of origin
	 */
	public StringCondition<PetQuery> origin() {
		return new StringCondition<PetQuery>(this, Pet.ORIGIN);
	}

	/**
	 * @return condition of temper
	 */
	public StringCondition<PetQuery> temper() {
		return new StringCondition<PetQuery>(this, Pet.TEMPER);
	}

	/**
	 * @return condition of habits
	 */
	public ObjectCondition<PetQuery> habits() {
		return new ObjectCondition<PetQuery>(this, Pet.HABITS);
	}

	/**
	 * @return condition of amount
	 */
	public ComparableCondition<PetQuery, Integer> amount() {
		return new ComparableCondition<PetQuery, Integer>(this, Pet.AMOUNT);
	}

	/**
	 * @return condition of price
	 */
	public ComparableCondition<PetQuery, BigDecimal> price() {
		return new ComparableCondition<PetQuery, BigDecimal>(this, Pet.PRICE);
	}

	/**
	 * @return condition of shopName
	 */
	public StringCondition<PetQuery> shopName() {
		return new StringCondition<PetQuery>(this, Pet.SHOP_NAME);
	}

	/**
	 * @return condition of shopAddress
	 */
	public StringCondition<PetQuery> shopAddress() {
		return new StringCondition<PetQuery>(this, Pet.SHOP_ADDRESS);
	}

	/**
	 * @return condition of shopTelephone
	 */
	public StringCondition<PetQuery> shopTelephone() {
		return new StringCondition<PetQuery>(this, Pet.SHOP_TELEPHONE);
	}

	/**
	 * @return condition of shopCloseTime
	 */
	public ComparableCondition<PetQuery, Date> shopCloseTime() {
		return new ComparableCondition<PetQuery, Date>(this, Pet.SHOP_CLOSE_TIME);
	}

	/**
	 * @return condition of shopLink
	 */
	public StringCondition<PetQuery> shopLink() {
		return new StringCondition<PetQuery>(this, Pet.SHOP_LINK);
	}

	/**
	 * @return condition of description
	 */
	public StringCondition<PetQuery> description() {
		return new StringCondition<PetQuery>(this, Pet.DESCRIPTION);
	}


	//----------------------------------------------------------------------
	// auto joins
	//----------------------------------------------------------------------
	/**
	 * auto left join CN
	 * @return this
	 */
	public PetQuery autoLeftJoinCN() {
		autoLeftJoin(Pet._JOIN_CN_);
		return this;
	}

	/**
	 * auto left join CN
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoLeftJoinCN(Query<?> jq) {
		autoLeftJoin(Pet._JOIN_CN_, jq);
		return this;
	}

	/**
	 * auto right join CN
	 * @return this
	 */
	public PetQuery autoRightJoinCN() {
		autoRightJoin(Pet._JOIN_CN_);
		return this;
	}

	/**
	 * auto right join CN
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoRightJoinCN(Query<?> jq) {
		autoRightJoin(Pet._JOIN_CN_, jq);
		return this;
	}

	/**
	 * auto inner join CN
	 * @return this
	 */
	public PetQuery autoInnerJoinCN() {
		autoInnerJoin(Pet._JOIN_CN_);
		return this;
	}

	/**
	 * auto inner join CN
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoInnerJoinCN(Query<?> jq) {
		autoInnerJoin(Pet._JOIN_CN_, jq);
		return this;
	}

	/**
	 * auto join CN
	 * @return this
	 */
	public PetQuery autoJoinCN() {
		autoJoin(Pet._JOIN_CN_);
		return this;
	}

	/**
	 * auto join CN
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoJoinCN(Query<?> jq) {
		autoJoin(Pet._JOIN_CN_, jq);
		return this;
	}

	/**
	 * auto left join UU
	 * @return this
	 */
	public PetQuery autoLeftJoinUU() {
		autoLeftJoin(Pet._JOIN_UU_);
		return this;
	}

	/**
	 * auto left join UU
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoLeftJoinUU(Query<?> jq) {
		autoLeftJoin(Pet._JOIN_UU_, jq);
		return this;
	}

	/**
	 * auto right join UU
	 * @return this
	 */
	public PetQuery autoRightJoinUU() {
		autoRightJoin(Pet._JOIN_UU_);
		return this;
	}

	/**
	 * auto right join UU
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoRightJoinUU(Query<?> jq) {
		autoRightJoin(Pet._JOIN_UU_, jq);
		return this;
	}

	/**
	 * auto inner join UU
	 * @return this
	 */
	public PetQuery autoInnerJoinUU() {
		autoInnerJoin(Pet._JOIN_UU_);
		return this;
	}

	/**
	 * auto inner join UU
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoInnerJoinUU(Query<?> jq) {
		autoInnerJoin(Pet._JOIN_UU_, jq);
		return this;
	}

	/**
	 * auto join UU
	 * @return this
	 */
	public PetQuery autoJoinUU() {
		autoJoin(Pet._JOIN_UU_);
		return this;
	}

	/**
	 * auto join UU
	 * @param jq join table query
	 * @return this
	 */
	public PetQuery autoJoinUU(Query<?> jq) {
		autoJoin(Pet._JOIN_UU_, jq);
		return this;
	}

}

