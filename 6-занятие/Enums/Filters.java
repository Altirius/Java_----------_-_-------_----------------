package Enums;

public enum Filters {
	NOTHING(0, ""),
	RAM(1, "ОЗУ"),
	ROM(2, "ПЗУ"),
	SYSTEM(3, "ОС"),
	COLOR(4, "Цвет");

	private Integer key;
	private String title;

	Filters(Integer key, String title){
		this.key = key;
	}

	static public Filters getEntityByKey(Integer key) {
		Filters[] options = Filters.values();
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
