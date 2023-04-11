package Enums;

public enum UserActions {
	NOTHING(0),
	ADD_FILTER(1),
	SHOW(2),
	RESET_FILTER(3),
	EXIT(4);

	private Integer key;

	UserActions(Integer key){
		this.key = key;
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
}
