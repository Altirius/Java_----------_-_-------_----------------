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

	static public UserActions getUserActionByKey(Integer key) {
		if (UserActions.ADD_FILTER.getKey() == key)
			return UserActions.ADD_FILTER;
		if (UserActions.SHOW.getKey() == key)
			return UserActions.SHOW;
		if (UserActions.RESET_FILTER.getKey() == key)
			return UserActions.RESET_FILTER;
		if (UserActions.EXIT.getKey() == key)
			return UserActions.EXIT;

		return UserActions.NOTHING;
	}

	public Integer getKey() {
		return this.key;
	}
}
