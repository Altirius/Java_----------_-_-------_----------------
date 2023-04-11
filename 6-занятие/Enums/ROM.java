package Enums;

import Interfaces.ISelectebleItem;

public enum ROM implements ISelectebleItem {
	GB_256(1, "256 Гб"),
	GB_512(2, "512 Гб"),
	GB_1024(3, "1 Тб"),
	GB_2048(4, "2 Тб");

	private Integer key;
	private String title;

	ROM(Integer key, String title) {
		this.key = key;
		this.title = title;
	}

	static public ROM getEntityByKey(Integer key) {
		ROM[] options = ROM.values();
		for (int i = 1; i < options.length; i++) {
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
