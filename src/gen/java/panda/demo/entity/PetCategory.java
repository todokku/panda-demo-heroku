package panda.demo.entity;

import java.io.Serializable;
import panda.app.entity.SUBean;
import panda.dao.entity.annotation.Column;
import panda.dao.entity.annotation.Id;
import panda.dao.entity.annotation.Index;
import panda.dao.entity.annotation.Indexes;
import panda.lang.Objects;
import panda.mvc.annotation.validate.CastErrorValidate;
import panda.mvc.annotation.validate.StringValidate;
import panda.mvc.validator.Validators;

@Indexes({
	@Index(name="N", fields={ "name" }, unique=true)
})
public class PetCategory extends SUBean implements Serializable {

	private static final long serialVersionUID = 1377369589L;

	/**
	 * Constructor
	 */
	public PetCategory() {
		super();
	}

	/*----------------------------------------------------------------------*
	 * Constants
	 *----------------------------------------------------------------------*/
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String MEMO = "memo";

	public static final String[] _COLUMNS_ = new String[] {
			ID,
			NAME,
			MEMO
		};



	/*----------------------------------------------------------------------*
	 * Properties
	 *----------------------------------------------------------------------*/
	@Id(start=1001)
	protected Long id;

	@Column(size=50, notNull=true)
	protected String name;

	@Column(size=1000)
	protected String memo;


	/*----------------------------------------------------------------------*
	 * Getter & Setter
	 *----------------------------------------------------------------------*/
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
	@StringValidate(maxLength=50)
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
	 * @return the memo
	 */
	@StringValidate(maxLength=1000)
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = panda.lang.Strings.stripToNull(memo);
	}


	/**
	 * copy properties from the specified object.
	 * @param src the source object to copy
	 */
	public void copy(PetCategory src) {
		this.id = src.id;
		this.name = src.name;
		this.memo = src.memo;
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
	public PetCategory clone() {
		PetCategory copy = new PetCategory();
		
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

		PetCategory rhs = (PetCategory)obj;
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
				.append(MEMO, memo)
				.appendSuper(super.toString())
				.toString();
	}
}

