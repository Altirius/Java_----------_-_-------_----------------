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

	public Integer getKey() {
		return this.key;
	}
}
