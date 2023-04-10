package Devices;

import Enums.Colors;
import Enums.OperatingSystems;

public class Notebook {
	private final String manufacturer;
	private final String model;
	private final OperatingSystems system;
	private final Colors color;

	private final Integer RAM;
	private final Integer ROM;

	public Notebook(
		String manufacturer,
		String model,
		Integer RAM,
		Integer ROM,
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
			", ОЗУ: ", String.valueOf(this.RAM),
			", ПЗУ: ", String.valueOf(this.ROM),
			", ОС: ", String.valueOf(this.system),
			", Цвет: ", String.valueOf(this.color)
		};

		System.out.println(String.join("", characteristics));
	}

	public boolean filterByRAM(Integer min) {
		return this.RAM >= min;
	}

	public boolean filterByROM(Integer min) {
		return this.ROM >= min;
	}

	public boolean filterBySystem(OperatingSystems targetSystem) {
		return this.system == targetSystem;
	}

	public boolean filterByColor(Colors targetColor) {
		return this.color == targetColor;
	} 
}
