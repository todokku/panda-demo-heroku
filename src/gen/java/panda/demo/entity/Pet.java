package panda.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import panda.app.entity.SUBean;
import panda.dao.DaoTypes;
import panda.dao.entity.annotation.Column;
import panda.dao.entity.annotation.Comment;
import panda.dao.entity.annotation.FK;
import panda.dao.entity.annotation.ForeignKeys;
import panda.dao.entity.annotation.Id;
import panda.dao.entity.annotation.Index;
import panda.dao.entity.annotation.Indexes;
import panda.dao.entity.annotation.Join;
import panda.dao.entity.annotation.JoinColumn;
import panda.dao.entity.annotation.Joins;
import panda.lang.Objects;
import panda.mvc.annotation.validate.CastErrorValidate;
import panda.mvc.annotation.validate.ConstantValidate;
import panda.mvc.annotation.validate.DecimalValidate;
import panda.mvc.annotation.validate.FileValidate;
import panda.mvc.annotation.validate.NumberValidate;
import panda.mvc.annotation.validate.RegexValidate;
import panda.mvc.annotation.validate.StringValidate;
import panda.mvc.annotation.validate.URLValidate;
import panda.mvc.validator.Validators;
import panda.vfs.FileItem;

@ForeignKeys({
	@FK(target=PetCategory.class, fields={ "cid" })
})
@Indexes({
	@Index(name="NG", fields={ "name", "gender" }, unique=true)
})
@Joins({
	@Join(name="CN", target=PetCategory.class, keys="cid", refs="id"),
	@Join(name="UU", target=User.class, keys="updatedBy", refs="id")
})
public class Pet extends SUBean implements Serializable {

	private static final long serialVersionUID = 1788250496L;

	/**
	 * Constructor
	 */
	public Pet() {
		super();
	}

	/*----------------------------------------------------------------------*
	 * Constants
	 *----------------------------------------------------------------------*/
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String CID = "cid";
	public static final String CNAME = "cname";
	public static final String GENDER = "gender";
	public static final String BIRTHDAY = "birthday";
	public static final String ORIGIN = "origin";
	public static final String TEMPER = "temper";
	public static final String HABITS = "habits";
	public static final String AMOUNT = "amount";
	public static final String PRICE = "price";
	public static final String SHOP_NAME = "shopName";
	public static final String SHOP_ADDRESS = "shopAddress";
	public static final String SHOP_TELEPHONE = "shopTelephone";
	public static final String SHOP_CLOSE_TIME = "shopCloseTime";
	public static final String SHOP_LINK = "shopLink";
	public static final String DESCRIPTION = "description";
	public static final String IMAGE_FILE = "imageFile";

	public static final String[] _COLUMNS_ = new String[] {
			ID,
			NAME,
			CID,
			GENDER,
			BIRTHDAY,
			ORIGIN,
			TEMPER,
			HABITS,
			AMOUNT,
			PRICE,
			SHOP_NAME,
			SHOP_ADDRESS,
			SHOP_TELEPHONE,
			SHOP_CLOSE_TIME,
			SHOP_LINK,
			DESCRIPTION
		};

	public static final String[] _JOINS_ = new String[] {
			UPDATED_BY_NAME,
			CNAME
		};

	public static final String _JOIN_CN_ = "CN";
	public static final String _JOIN_UU_ = "UU";

	/*----------------------------------------------------------------------*
	 * Properties
	 *----------------------------------------------------------------------*/
	@Id(start=1001)
	@Comment("pet id")
	protected Long id;

	@Column(size=100, notNull=true)
	@Comment("pet name")
	protected String name;

	@Column(notNull=true)
	@Comment("category id")
	protected Long cid;

	@JoinColumn(name="CN", field="name")
	protected String cname;

	@Column(size=1)
	protected String gender;

	@Column
	protected Date birthday;

	@Column(size=10)
	protected String origin;

	@Column
	protected String temper;

	@Column
	protected Set<String> habits;

	@Column(notNull=true, defaults="0")
	protected Integer amount;

	@Column(size=10, scale=2)
	protected BigDecimal price;

	@Column(size=100)
	protected String shopName;

	@Column(size=100)
	protected String shopAddress;

	@Column(size=20)
	protected String shopTelephone;

	@Column
	protected Date shopCloseTime;

	@Column(size=1000)
	protected String shopLink;

	@Column(type=DaoTypes.CLOB, size=5000)
	protected String description;

	protected FileItem imageFile;


	/*----------------------------------------------------------------------*
	 * Getter & Setter
	 *----------------------------------------------------------------------*/
	/**
	 * @return the updatedByName
	 */
	@Override
	@JoinColumn(name="UU", field="name")
	public String getUpdatedByName() {
		return super.getUpdatedByName();
	}

	/**
	 * @return the id
	 */
	@CastErrorValidate(msgId=Validators.MSGID_INTEGER)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@StringValidate(maxLength=100)
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = panda.lang.Strings.stripToNull(name);
	}

	/**
	 * @return the cid
	 */
	@CastErrorValidate(msgId=Validators.MSGID_INTEGER)
	public Long getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = panda.lang.Strings.stripToNull(cname);
	}

	/**
	 * @return the gender
	 */
	@ConstantValidate(list="%{consts.petGenderMap}")
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = panda.lang.Strings.stripToNull(gender);
	}

	/**
	 * @return the birthday
	 */
	@CastErrorValidate(msgId=Validators.MSGID_DATE)
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the origin
	 */
	@ConstantValidate(list="%{consts.petOriginMap}")
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = panda.lang.Strings.stripToNull(origin);
	}

	/**
	 * @return the temper
	 */
	@ConstantValidate(list="%{consts.petTemperMap}")
	public String getTemper() {
		return temper;
	}

	/**
	 * @param temper the temper to set
	 */
	public void setTemper(String temper) {
		this.temper = panda.lang.Strings.stripToNull(temper);
	}

	/**
	 * @return the habits
	 */
	@ConstantValidate(list="%{consts.petHabitMap}")
	public Set<String> getHabits() {
		return habits;
	}

	/**
	 * @param habits the habits to set
	 */
	public void setHabits(Set<String> habits) {
		this.habits = panda.lang.Collections.stripToNull(habits);
	}

	/**
	 * @return the amount
	 */
	@CastErrorValidate(msgId=Validators.MSGID_INTEGER)
	@NumberValidate(min="0")
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the price
	 */
	@CastErrorValidate(msgId=Validators.MSGID_DECIMAL)
	@NumberValidate(min="0", max="9999999999")
	@DecimalValidate(precision=10, scale=2)
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the shopName
	 */
	@StringValidate(maxLength=100)
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = panda.lang.Strings.stripToNull(shopName);
	}

	/**
	 * @return the shopAddress
	 */
	@StringValidate(maxLength=100)
	public String getShopAddress() {
		return shopAddress;
	}

	/**
	 * @param shopAddress the shopAddress to set
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = panda.lang.Strings.stripToNull(shopAddress);
	}

	/**
	 * @return the shopTelephone
	 */
	@StringValidate(maxLength=20)
	@RegexValidate(regex="#(regex-telno)", msgId="validation-telno")
	public String getShopTelephone() {
		return shopTelephone;
	}

	/**
	 * @param shopTelephone the shopTelephone to set
	 */
	public void setShopTelephone(String shopTelephone) {
		this.shopTelephone = panda.lang.Strings.stripToNull(shopTelephone);
	}

	/**
	 * @return the shopCloseTime
	 */
	@CastErrorValidate(msgId=Validators.MSGID_DATE)
	public Date getShopCloseTime() {
		return shopCloseTime;
	}

	/**
	 * @param shopCloseTime the shopCloseTime to set
	 */
	public void setShopCloseTime(Date shopCloseTime) {
		this.shopCloseTime = shopCloseTime;
	}

	/**
	 * @return the shopLink
	 */
	@URLValidate
	public String getShopLink() {
		return shopLink;
	}

	/**
	 * @param shopLink the shopLink to set
	 */
	public void setShopLink(String shopLink) {
		this.shopLink = panda.lang.Strings.stripToNull(shopLink);
	}

	/**
	 * @return the description
	 */
	@StringValidate(maxLength=5000)
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the imageFile
	 */
	@FileValidate(maxLength=1048576, minLength=1)
	public FileItem getImageFile() {
		return imageFile;
	}

	/**
	 * @param imageFile the imageFile to set
	 */
	public void setImageFile(FileItem imageFile) {
		this.imageFile = imageFile;
	}


	/**
	 * copy properties from the specified object.
	 * @param src the source object to copy
	 */
	public void copy(Pet src) {
		this.id = src.id;
		this.name = src.name;
		this.cid = src.cid;
		this.cname = src.cname;
		this.gender = src.gender;
		this.birthday = src.birthday;
		this.origin = src.origin;
		this.temper = src.temper;
		this.habits = src.habits;
		this.amount = src.amount;
		this.price = src.price;
		this.shopName = src.shopName;
		this.shopAddress = src.shopAddress;
		this.shopTelephone = src.shopTelephone;
		this.shopCloseTime = src.shopCloseTime;
		this.shopLink = src.shopLink;
		this.description = src.description;
		this.imageFile = src.imageFile;
		super.copy(src);
	}

	/*----------------------------------------------------------------------*
	 * Overrides
	 *----------------------------------------------------------------------*/
	/**
	 * Creates and returns a copy of this object.
	 * @return the copy object
	 */
	@Override
	public Pet clone() {
		Pet copy = new Pet();
		
		copy.copy(this);

		return copy;
	}

	/**
	 * @return  a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		return Objects.hashCodes(id);
	}

	/**
	 * @return  <code>true</code> if this object is the same as the obj argument; 
	 * 			<code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Pet rhs = (Pet)obj;
		return Objects.equalsBuilder()
				.append(id, rhs.id)
				.isEquals();
	}

	/**
	 * @return  a string representation of the object.
	 */
	@Override
	public String toString() {
		return Objects.toStringBuilder()
				.append(ID, id)
				.append(NAME, name)
				.append(CID, cid)
				.append(CNAME, cname)
				.append(GENDER, gender)
				.append(BIRTHDAY, birthday)
				.append(ORIGIN, origin)
				.append(TEMPER, temper)
				.append(HABITS, habits)
				.append(AMOUNT, amount)
				.append(PRICE, price)
				.append(SHOP_NAME, shopName)
				.append(SHOP_ADDRESS, shopAddress)
				.append(SHOP_TELEPHONE, shopTelephone)
				.append(SHOP_CLOSE_TIME, shopCloseTime)
				.append(SHOP_LINK, shopLink)
				.append(DESCRIPTION, description)
				.append(IMAGE_FILE, imageFile)
				.appendSuper(super.toString())
				.toString();
	}
}

