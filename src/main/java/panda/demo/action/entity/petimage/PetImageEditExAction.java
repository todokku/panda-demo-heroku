package panda.demo.action.entity.petimage;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import panda.demo.entity.PetImage;
import panda.io.FileNames;
import panda.lang.Exceptions;
import panda.lang.Strings;
import panda.mvc.annotation.At;

@At("/petimage")
public class PetImageEditExAction extends PetImageEditAction {
	private void setFileData(PetImage data) {
		try {
			if (data.getImageFile() != null && data.getImageFile().isExists()) {
				data.setImageData(data.getImageFile().data());
				data.setImageSize(data.getImageData().length);
				if (Strings.isEmpty(data.getImageName())) {
					data.setImageName(Strings.right(data.getImageFile().getName(), FileNames.MAX_FILENAME_LENGTH));
				}
			}
		}
		catch (IOException e) {
			throw Exceptions.wrapThrow(e);
		}
	}

/*	@Override
	protected boolean checkOnInsert(PetImage data) {
		boolean r = super.checkOnInsert(data);
		if (!r && isCheckAbortOnError()) {
			return false;
		}
		if (data.getImageItem() == null || !data.getImageItem().isExists()) {
			addFieldError(PetImage.IMAGE_ITEM, getMessage(RES.ERROR_ITEM_REQUIRED));
			return false;
		}
		return true;
	}*/

	@Override
	protected PetImage startInsert(PetImage data) {
		data =  super.startInsert(data);
		data.setImageSize(0);
		setFileData(data);
		return data;
	}

	@Override
	protected void afterInsert(PetImage data) {
		super.afterInsert(data);
		
		data.setImageFile(null);
	}

	@Override
	protected PetImage startUpdate(PetImage data, PetImage sd) {
		data = super.startUpdate(data, sd);
		data.setImageSize(sd.getImageSize());
		setFileData(data);
		return data;
	}

	@Override
	protected Set<String> getUpdateFields(PetImage data, PetImage sd) {
		Set<String> ufs = new HashSet<String>(super.getUpdateFields(data, sd));
		if (data.getImageData() != null) {
			ufs.add(PetImage.IMAGE_DATA);
		}
		return ufs;
	}

	@Override
	protected void afterUpdate(PetImage data, PetImage sd) {
		super.afterUpdate(data, sd);
		
		data.setImageFile(null);
	}
}
