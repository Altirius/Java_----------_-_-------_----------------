package Enums;

import Interfaces.ISelectebleItem;

public enum OperatingSystems implements ISelectebleItem {
	ANY(0, "Любая система"),
	WINDOWS(1, "Windows"),
	MAC(2, "MAC"),
	LINUX(3, "Linux");

	private Integer key;
	private String title;

	OperatingSystems(Integer key, String title) {
		this.key = key;
		this.title = title;
	}

	static public OperatingSystems getEntityByKey(Integer key) {
		OperatingSystems[] options = OperatingSystems.values();
		for(int i = 1; i < options.length; i ++) {
			if (options[i].getKey() == key) {
				return options[i];
			}
		}

		return options[0];
	}

	public Integer getKey() {
		return this.key;
	}

	public String getTitle() {
		return this.title;
	}

	public String getMenuItemString() {
		return String.valueOf(this.getKey()) + ") " + this.getTitle();
	}
}