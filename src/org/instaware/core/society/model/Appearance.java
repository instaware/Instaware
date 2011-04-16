package org.instaware.core.society.model;

/**
 * The physical appearance attributes of a {@link Player}.
 * @author Thomas Nappo
 */
public class Appearance {
	
	private int[] looks;
	
	public int[] getLooks() {
		return looks;
	}
	
	public void setLooks(int index, int value) {
		looks[index] = value;
	}
	
	private int[] colours;
	
	public int[] getColours() {
		return colours;
	}
	
	public void setColour(int index, int value) {
		colours[index] = value;
	}
	
	private Gender gender = Gender.MALE;
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public static enum Gender {
		MALE,
		FEMALE;
	}
	
	private int npcId = -1;
	
	public int getNpcId() {
		return npcId;
	}
	
	public void setNpcId(int id) {
		this.npcId = id;
	}
	
	public boolean isNpc() {
		return npcId != -1;
	}

}