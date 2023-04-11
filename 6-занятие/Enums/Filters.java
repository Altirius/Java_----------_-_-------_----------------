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

	static public Filters getFilterByKey(Integer key) {
		if (Filters.RAM.getKey() == key)
			return Filters.RAM;
		if (Filters.ROM.getKey() == key)
			return Filters.ROM;
		if (Filters.SYSTEM.getKey() == key)
			return Filters.SYSTEM;
		if (Filters.COLOR.getKey() == key)
			return Filters.COLOR;
		
		return Filters.NOTHING;
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
