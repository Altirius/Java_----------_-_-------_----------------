import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    class Contact {
        String name = "";
        String phoneNumber = "";

        Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    };

    static final int NOTHING = 0;
    static final int ADD_NEW = 1;
    static final int SHOW_ALL = 2;
    static final int EXIT = 3;

    private Scanner input = new Scanner(System.in);

    private HashMap<String, ArrayList<String>> contacts = new HashMap<>();

    public static void main(String[] args) {
        Program prog = new Program();
        prog.start();
    }

    public void start() {
        int action = NOTHING;

        while (action != EXIT) {
            action = this.askAndGetUserAction();
            this.handleAction(action);
        }
    }

    private int askAndGetUserAction() {
        this.askUserAction();
        return this.getUserAction();
    }

    private void askUserAction() {
        String[] actions = {
                "Введите номер команды: ",
                "1) Добавить номер",
                "2) Показать всё",
                "3) Выйти"
        };

        System.out.println(String.join(" ", actions));
    }

    private int getUserAction() {
        return this.input.nextInt();
    }

    private void handleAction(int action) {
        switch (action) {
            case ADD_NEW:
                this.handleAddContact();
                break;
            case SHOW_ALL:
                this.handleShowAll();
                break;
        }
    }

    private void handleAddContact() {
        Contact contact = this.askAndGetContact();
        ArrayList<String> phoneNumbers = this.contacts.containsKey(contact.name)
                ? this.contacts.get(contact.name)
                : new ArrayList<>();

        phoneNumbers.add(contact.phoneNumber);
        this.contacts.put(contact.name, phoneNumbers);
    }

    private Contact askAndGetContact() {
        this.askName();
        String name = this.input.next();
        this.askPhoneNumber();
        String phoneNumber = this.input.next();

        return new Contact(name, phoneNumber);
    }

    private void askName() {
        System.out.println("Введите имя");
    }

    private void askPhoneNumber() {
        System.out.println("Введите номер телефона");
    }

    private void handleShowAll() {
        if (!this.contacts.isEmpty()) {
            System.out.println(this.contacts);
        } else {
            System.out.println("Список пуст");
        }
    }
}
