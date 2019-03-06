package panda.demo.action.entity.pet;

import java.io.IOException;

import panda.demo.entity.Pet;
import panda.demo.entity.PetImage;
import panda.demo.entity.query.PetImageQuery;
import panda.lang.Exceptions;
import panda.lang.Systems;
import panda.mvc.annotation.At;

@At("/pet")
public class PetEditExAction extends PetEditAction {

	@Override
	protected void insertData(Pet pet) {
		super.insertData(pet);
		try {
			if (pet.getImageFile() != null && pet.getImageFile().isExists()) {
				PetImage pi = new PetImage();
				pi.setPid(pet.getId());
				pi.setImageData(pet.getImageFile().data());
				pi.setImageSize(pi.getImageData().length);
				pi.setImageName(pet.getImageFile().getName());
				assist().setCreatedByFields(pi);
				getDao().insert(pi);
			}
		}
		catch (IOException e) {
			throw Exceptions.wrapThrow(e);
		}
	}

	@Override
	protected void afterInsert(Pet data) {
		super.afterInsert(data);

		data.setImageFile(null);
	}

	@Override
	protected int updateData(Pet pet, Pet oPet) {
		int r = super.updateData(pet, oPet);
		try {
			if (pet.getImageFile() != null && pet.getImageFile().isExists()) {
				PetImageQuery piq = new PetImageQuery();
				piq.pid().eq(pet.getId());
				
				PetImage pi = new PetImage();
				pi.setPid(pet.getId());
				pi.setImageData(pet.getImageFile().data());
				pi.setImageSize(pi.getImageData().length);
				pi.setImageName(pet.getImageFile().getName());
				assist().setUpdatedByFields(pi);

				getDao().updatesIgnoreNull(pi, piq);
			}
		}
		catch (IOException e) {
			throw Exceptions.wrapThrow(e);
		}
		return r;
	}

	@Override
	protected void afterUpdate(Pet pet, Pet oPet) {
		super.afterUpdate(pet, oPet);

		pet.setImageFile(null);
	}

	@Override
	protected void deleteData(Pet data) {
		if (Systems.IS_OS_APPENGINE) {
			// GAE does not support foreign key CASCADE action
			// we need delete PetImage manually
			PetImageQuery piq = new PetImageQuery();
			piq.pid().eq(data.getId());
			getDao().deletes(piq);
		}
		super.deleteData(data);
	}
}
