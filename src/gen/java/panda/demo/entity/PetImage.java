package panda.demo.entity;

import java.io.Serializable;
import panda.app.entity.UBean;
import panda.dao.DaoTypes;
import panda.dao.entity.annotation.Column;
import panda.dao.entity.annotation.FK;
import panda.dao.entity.annotation.ForeignKeys;
import panda.dao.entity.annotation.Id;
import panda.dao.entity.annotation.Join;
import panda.dao.entity.annotation.JoinColumn;
import panda.dao.entity.annotation.Joins;
import panda.lang.Objects;
import panda.mvc.annotation.validate.CastErrorValidate;
import panda.mvc.annotation.validate.FileValidate;
import panda.mvc.annotation.validate.StringValidate;
import panda.mvc.validator.Validators;
import panda.vfs.FileItem;

@ForeignKeys({
	@FK(target=Pet.class, fields={ "pid" }, onUpdate=FK.CASCADE, onDelete=FK.CASCADE)
})
@Joins({
	@Join(name="PN", target=Pet.class, keys="pid", refs="id")
})
public class PetImage extends UBean implements Serializable {

	private static final long serialVersionUID = 251449373L;

	/**
	 * Constructor
	 */
	public PetImage() {
		super();
	}

	/*----------------------------------------------------------------------*
	 * Constants
	 *----------------------------------------------------------------------*/
	public static final String ID = "id";
	public static final String PID = "pid";
	public static final String PNAME = "pname";
	public static final String IMAGE_NAME = "imageName";
	public static final String IMAGE_DATA = "imageData";
	public static final String IMAGE_SIZE = "imageSize";
	public static final String IMAGE_FILE = "imageFile";

	public static final String[] _COLUMNS_ = new String[] {
			ID,
			PID,
			IMAGE_NAME,
			IMAGE_DATA,
			IMAGE_SIZE
		};

	public static final String[] _JOINS_ = new String[] {
			PNAME
		};

	public static final String _JOIN_PN_ = "PN";

	/*----------------------------------------------------------------------*
	 * Properties
	 *----------------------------------------------------------------------*/
	@Id(start=1001)
	protected Long id;

	@Column(notNull=true)
	protected Long pid;

	@JoinColumn(name="PN", field="name")
	protected String pname;

	@Column(size=255)
	protected String imageName;

	@Column(type=DaoTypes.BLOB, notNull=true)
	protected byte[] imageData;

	@Column(notNull=true)
	protected Integer imageSize;

	protected FileItem imageFile;


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
	 * @return the pid
	 */
	@CastErrorValidate(msgId=Validators.MSGID_INTEGER)
	public Long getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = panda.lang.Strings.stripToNull(pname);
	}

	/**
	 * @return the imageName
	 */
	@StringValidate(maxLength=255)
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = panda.lang.Strings.stripToNull(imageName);
	}

	/**
	 * @return the imageData
	 */
	@CastErrorValidate(msgId=Validators.MSGID_INTEGER)
	public byte[] getImageData() {
		return imageData;
	}

	/**
	 * @param imageData the imageData to set
	 */
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	/**
	 * @return the imageSize
	 */
	@CastErrorValidate(msgId=Validators.MSGID_INTEGER)
	public Integer getImageSize() {
		return imageSize;
	}

	/**
	 * @param imageSize the imageSize to set
	 */
	public void setImageSize(Integer imageSize) {
		this.imageSize = imageSize;
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
	public void copy(PetImage src) {
		this.id = src.id;
		this.pid = src.pid;
		this.pname = src.pname;
		this.imageName = src.imageName;
		this.imageData = src.imageData;
		this.imageSize = src.imageSize;
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
	public PetImage clone() {
		PetImage copy = new PetImage();
		
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

		PetImage rhs = (PetImage)obj;
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
				.append(PID, pid)
				.append(PNAME, pname)
				.append(IMAGE_NAME, imageName)
				.append(IMAGE_DATA, imageData)
				.append(IMAGE_SIZE, imageSize)
				.append(IMAGE_FILE, imageFile)
				.appendSuper(super.toString())
				.toString();
	}
}

