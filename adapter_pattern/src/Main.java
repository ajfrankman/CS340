import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Main {

    public static void main(String args[]) {
        System.out.println("hello world");
        ContactManager contactManager = new ContactManager();

        Contact contact = new Contact("first", "last", "phone", "email");
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        contactManager.addContact(contact);
        AdapterThing adapterThing = new AdapterThing(contactManager);

        Writer output = new PrintWriter(System.out);
        Table table = new Table(output, adapterThing);
        try {
            table.display();
            System.out.println("hello!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
