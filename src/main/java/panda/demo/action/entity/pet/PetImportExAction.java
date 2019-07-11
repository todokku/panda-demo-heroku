package panda.demo.action.entity.pet;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import panda.dao.entity.EntityField;
import panda.demo.entity.Pet;
import panda.lang.Collections;
import panda.lang.Strings;
import panda.mvc.annotation.At;


@At("/pet")
public class PetImportExAction extends PetImportAction {
	private Map<String, String> genders;
	private Map<String, String> origins;
	private Map<String, String> tempers;
	private Map<String, String> habits;

	public PetImportExAction() {
		// set update key { 'name', 'gender' }
		setUpdateKey(new String[] { Pet.NAME, Pet.GENDER });
	}

	@SuppressWarnings("unchecked")
	private String getGender(String p) {
		if (genders == null) {
			genders = Collections.swapMap(consts().getMap("petGenderMap"));
		}
		return genders.get(p);
	}

	@SuppressWarnings("unchecked")
	private String getHabit(String p) {
		if (habits == null) {
			habits = Collections.swapMap(consts().getMap("petHabitMap"));
		}
		return habits.get(p);
	}

	@SuppressWarnings("unchecked")
	private String getOrigin(String p) {
		if (origins == null) {
			origins = Collections.swapMap(consts().getMap("petOriginMap"));
		}
		return origins.get(p);
	}

	@SuppressWarnings("unchecked")
	private String getTemper(String p) {
		if (tempers == null) {
			tempers = Collections.swapMap(consts().getMap("petTemperMap"));
		}
		return tempers.get(p);
	}

	@Override
	protected void trimData(Pet data) {
		List<EntityField> efs = new ArrayList<EntityField>();
		
		if (Strings.isNotEmpty(data.getGender())) {
			String g = getGender(data.getGender());
			if (Strings.isEmpty(g)) {
				efs.add(getEntity().getField(Pet.GENDER));
			}
			else {
				data.setGender(g);
			}
		}
		
		if (Strings.isNotEmpty(data.getOrigin())) {
			String g = getOrigin(data.getOrigin());
			if (Strings.isEmpty(g)) {
				efs.add(getEntity().getField(Pet.ORIGIN));
			}
			else {
				data.setOrigin(g);
			}
		}
		
		if (Strings.isNotEmpty(data.getTemper())) {
			String g = getTemper(data.getTemper());
			if (Strings.isEmpty(g)) {
				efs.add(getEntity().getField(Pet.TEMPER));
			}
			else {
				data.setTemper(g);
			}
		}
		
		if (Collections.isNotEmpty(data.getHabits())) {
			Set<String> hs = new LinkedHashSet<String>();
			for (String ss : data.getHabits()) {
				for (String s : Strings.split(ss)) {
					String g =  getHabit(s);
					if (Strings.isEmpty(g)) {
						hs = null;
						efs.add(getEntity().getField(Pet.HABITS));
						break;
					}
					else {
						hs.add(g);
					}
				}
				if (hs == null) {
					break;
				}
			}
			if (Collections.isNotEmpty(hs)) {
				data.setHabits(hs);
			}
		}
		
		if (Collections.isNotEmpty(efs)) {
			throw new IllegalArgumentException(dataIncorrectError(data, efs));
		}
		super.trimData(data);
	}
}
