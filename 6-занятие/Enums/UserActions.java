package Enums;

import Interfaces.ISelectebleItem;

public enum UserActions implements ISelectebleItem {
	NOTHING(0, ""),
	ADD_FILTER(1, "Добавить фильтр"),
	SHOW(2, "Показать результат фильтрации"),
	RESET_FILTER(3, "Сбросить фильтры"),
	EXIT(4, "Выйти");

	private Integer key;
	private String title;

	UserActions(Integer key, String title) {
		this.key = key;
		this.title = title;
	}

	static public UserActions getEntityByKey(Integer key) {
		UserActions[] options = UserActions.values();
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
