package panda.demo.util;

import java.util.ArrayList;
import java.util.List;

import panda.demo.entity.Pet;
import panda.idx.IDocument;
import panda.idx.Indexer;
import panda.idx.IndexerManager;
import panda.ioc.annotation.IocBean;
import panda.ioc.annotation.IocInject;
import panda.lang.Numbers;

@IocBean
public class PetIndexer {
	@IocInject
	private IndexerManager indexes;
	
	public void insertPetIndex(Pet pet) {
		Indexer idxr = indexes.getIndexer();
		IDocument doc = idxr.newDocument();
		document(doc, pet);
		idxr.insert(doc);
	}
	
	public void insertPetIndex(List<Pet> pets) {
		Indexer idxr = indexes.getIndexer();
		List<IDocument> docs = new ArrayList<IDocument>();
		for (Pet pet : pets) {
			IDocument doc = idxr.newDocument();
			document(doc, pet);
			docs.add(doc);
		}
		idxr.inserts(docs);
	}

	public void updatePetIndex(Pet pet) {
		Indexer idxr = indexes.getIndexer();
		IDocument doc = idxr.newDocument();
		document(doc, pet);
		idxr.update(doc);
	}

	public void updatePetIndex(List<Pet> pets) {
		Indexer idxr = indexes.getIndexer();
		List<IDocument> docs = new ArrayList<IDocument>();
		for (Pet pet : pets) {
			IDocument doc = idxr.newDocument();
			document(doc, pet);
			docs.add(doc);
		}
		idxr.updates(docs);
	}

	public void deletePetIndex(Pet pet) {
		Indexer idxr = indexes.getIndexer();
		idxr.remove(pet.getId().toString());
	}

	public void deletePetIndex(Long pid) {
		Indexer idxr = indexes.getIndexer();
		idxr.remove(pid.toString());
	}

	public void deletePetIndex(List<Pet> pets) {
		Indexer idxr = indexes.getIndexer();
		List<String> ids = new ArrayList<String>();
		for (Pet pet : pets) {
			ids.add(pet.getId().toString());
		}
		idxr.removes(ids);
	}

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
