package panda.demo.util;

import panda.demo.entity.Pet;
import panda.idx.IDocument;
import panda.lang.Numbers;


public class PetIndexer {
	public static void document(IDocument doc, Pet pet) {
		doc.setId(pet.getId().toString());
		doc.addTextField(Pet.NAME, pet.getName());
		doc.addDateField(Pet.BIRTHDAY, pet.getBirthday());
		doc.addAtomField(Pet.GENDER, pet.getGender());
		doc.addNumberField(Pet.PRICE, pet.getPrice());
	}
	
	public static Pet doc2Pet(IDocument doc) {
		Pet pet = new Pet();
		pet.setId(Numbers.toLong(doc.getId()));
		pet.setName(doc.getTextField(Pet.NAME));
		pet.setBirthday(doc.getDateField(Pet.BIRTHDAY));
		pet.setGender(doc.getAtomField(Pet.GENDER));
		pet.setPrice(Numbers.toBigDecimal(doc.getNumberField(Pet.PRICE)));
		return pet;
	}
}
