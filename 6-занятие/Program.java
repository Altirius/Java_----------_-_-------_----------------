import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Devices.Notebook;
import Enums.Colors;
import Enums.Filters;
import Enums.OperatingSystems;
import Enums.RAM;
import Enums.ROM;
import Enums.UserActions;

public class Program {
	private Scanner input = new Scanner(System.in);

	private HashMap<Filters, Integer> filters = new HashMap<>();
	private UserActions action = UserActions.NOTHING;
	private ArrayList<Notebook> notebooks = new ArrayList<>();

	static public void main(String[] args) {
		Program prog = new Program();
		prog.start();
	}

	public void start() {
		this.prepareNotebooks();
		this.messageLoop();
	}

	private void prepareNotebooks() {
		this.notebooks.add(new Notebook("DELL", "G15", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", RAM.GB_8, ROM.GB_256, OperatingSystems.MAC, Colors.GRAY));
		this.notebooks.add(new Notebook("Samsung", "r530", RAM.GB_16, ROM.GB_512, OperatingSystems.LINUX, Colors.WHITE));
		this.notebooks.add(new Notebook("DELL", "G15", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", RAM.GB_8, ROM.GB_256, OperatingSystems.MAC, Colors.BLACK));
		this.notebooks.add(new Notebook("Samsung", "r530", RAM.GB_16, ROM.GB_512, OperatingSystems.LINUX, Colors.WHITE));
		this.notebooks.add(new Notebook("DELL", "G15", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("DELL", "G8", RAM.GB_16, ROM.GB_512, OperatingSystems.WINDOWS, Colors.GRAPHITE));
		this.notebooks.add(new Notebook("Macbook", "Air", RAM.GB_8, ROM.GB_256, OperatingSystems.MAC, Colors.GRAY));
		this.notebooks.add(new Notebook("Samsung", "r530", RAM.GB_16, ROM.GB_1024, OperatingSystems.WINDOWS, Colors.PINK));
	}

	private void messageLoop() {
		while (!isTimeToLeave()) {
			this.action = this.askAndGetUserAction();
			this.handleAction(action);
		}
	}

	private boolean isTimeToLeave() {
		return this.action == UserActions.EXIT;
	}

	private UserActions askAndGetUserAction() {
		this.askUserAction();
		return UserActions.getEntityByKey(this.input.nextInt());
	}

	private void askUserAction() {
		System.out.println("Введите команду:");
	}

	private void handleAction(UserActions action) {
		switch (action) {
			case ADD_FILTER:
				this.handleAddFilter();
				break;
			case SHOW:
				this.handleShowFiltered();
			case RESET_FILTER:
				this.handleResetFilter();
			default:
				break;
		}
	}

	private void handleAddFilter() {
		Filters filter = this.askAndGetFilter();
		if (this.isFilterNothing(filter))
			return;

		Integer filterValue = this.askAndGetFilterValue(filter);
		this.filters.put(filter, filterValue);
	}

	private Filters askAndGetFilter() {
		this.askFilter();
		return Filters.getEntityByKey(this.input.nextInt());
	}

	private void askFilter() {
		ArrayList<Filters> filters = new ArrayList<>();
		filters.add(Filters.RAM);
		filters.add(Filters.ROM);
		filters.add(Filters.SYSTEM);
		filters.add(Filters.COLOR);

		filters.forEach(filter -> System.out.println(filter.getMenuItemString()));
	}

	private boolean isFilterNothing(Filters filter) {
		return Filters.NOTHING == filter;
	}

	private Integer askAndGetFilterValue(Filters filter) {
		this.askFilterValue(filter);
		return this.getFilterValue(filter);
	}

	private void askFilterValue(Filters filter) {
		switch (filter) {
			case RAM:
				this.askRAMFilterValue();
				break;
			case ROM:
				this.askROMFilterValue();
				break;
			case SYSTEM:
				this.askOSFilterValue();
				break;
			case COLOR:
				this.askColorFilterValue();
				break;
			default:
				break;
		}
	}

	private void askRAMFilterValue() {
		ArrayList<RAM> options = new ArrayList<>();
		options.add(RAM.GB_2);
		options.add(RAM.GB_4);
		options.add(RAM.GB_8);
		options.add(RAM.GB_16);

		options.forEach(option -> System.out.println(option.getMenuItemString()));
	}

	private void askROMFilterValue() {
		ArrayList<ROM> options = new ArrayList<>();
		options.add(ROM.GB_256);
		options.add(ROM.GB_512);
		options.add(ROM.GB_1024);
		options.add(ROM.GB_2048);

		options.forEach(option -> System.out.println(option.getMenuItemString()));
	}

	private void askOSFilterValue() {
		ArrayList<OperatingSystems> options = new ArrayList<>();
		options.add(OperatingSystems.WINDOWS);
		options.add(OperatingSystems.MAC);
		options.add(OperatingSystems.LINUX);

		options.forEach(option -> System.out.println(option.getMenuItemString()));
	}

	private void askColorFilterValue() {
		ArrayList<Colors> options = new ArrayList<>();
		options.add(Colors.WHITE);
		options.add(Colors.BLACK);
		options.add(Colors.GRAY);
		options.add(Colors.GRAPHITE);
		options.add(Colors.PINK);

		options.forEach(option -> System.out.println(option.getMenuItemString()));
	}

	private Integer getFilterValue(Filters filter) {
		return this.input.nextInt();
	}

	private void handleShowFiltered() {
		ArrayList<Notebook> notebooks = this.notebooks;
		System.out.println(this.filters);
	}

	private ArrayList<Notebook> filterNotebooks() {
		return new ArrayList<>();
	}

	private void handleResetFilter() {
		this.filters.clear();
	}

	private void printNotebooks(ArrayList<Notebook> notebooks) {
		notebooks.forEach(notebook -> notebook.print());
	}

}
