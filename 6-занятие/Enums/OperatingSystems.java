package Enums;

public enum OperatingSystems {
	WINDOWS(1, "Windows"),
	MAC(2, "MAC"),
	LINUX(3, "Linux");

	private Integer key;
	private String title;

	OperatingSystems(Integer key, String title) {
		this.key = key;
		this.title = title;
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