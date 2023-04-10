package Enums;

public enum FilterIds {
	NOTHING(0),
	RAM(1),
	ROM(2),
	SYSTEM(3),
	COLOR(4);

	private Integer key;

	FilterIds(Integer key){
		this.key = key;
	}

	static public FilterIds getFilterByKey(Integer key) {
		if (FilterIds.RAM.getKey() == key)
			return FilterIds.RAM;
		if (FilterIds.ROM.getKey() == key)
			return FilterIds.ROM;
		if (FilterIds.SYSTEM.getKey() == key)
			return FilterIds.SYSTEM;
		if (FilterIds.COLOR.getKey() == key)
			return FilterIds.COLOR;
		
		return FilterIds.NOTHING;
	}

	public Integer getKey() {
		return this.key;
	}

	
}
