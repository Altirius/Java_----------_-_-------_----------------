package Devices;

import Enums.Colors;
import Enums.OperatingSystems;
import Enums.RAM;
import Enums.ROM;

public class Notebook {
	private final String manufacturer;
	private final String model;
	private final RAM RAM;
	private final ROM ROM;
	private final OperatingSystems system;
	private final Colors color;


	public Notebook(
		String manufacturer,
		String model,
		RAM RAM,
		ROM ROM,
		OperatingSystems system,
		Colors color		
	) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.RAM = RAM;
		this.ROM = ROM;
		this.system = system;
		this.color = color;
	}

	public void print() {
		String[] characteristics = {
			"Производитель: ", this.manufacturer,
			", Модель: ", this.model,
			", ОЗУ: ", this.RAM.getTitle(),
			", ПЗУ: ", this.ROM.getTitle(),
			", ОС: ", this.system.getTitle(),
			", Цвет: ", this.color.getTitle()
		};

		System.out.println(String.join("", characteristics));
	}

	public boolean filterByRAM(Integer minKey) {
		return this.RAM.getKey() >= minKey;
	}

	public boolean filterByROM(Integer minKey) {
		return this.ROM.getKey() >= minKey;
	}

	public boolean filterBySystem(Integer key) {
		return this.system.getKey() == key;
	}

	public boolean filterByColor(Integer key) {
		return this.color.getKey() == key;
	} 
}
