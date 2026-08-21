import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Alice McGuire", new Contact("Alice McGuire", "123-456-7890"));
        contacts.put("Eve Adams", new Contact("Eve Adams", "444-444-4444"));
        contacts.put("David Johnson", new Contact("David Johnson", "111-222-3333"));
        contacts.put("Charlie Brown", new Contact("Charlie Brown", "555-555-5555"));
        contacts.put("Bob Smith", new Contact("Bob Smith", "987-654-3210"));
        
        System.out.println("\nContacts added successfully.");
        System.out.println("Total contacts: " + contacts.size());
        System.out.println("Contact list: " + contacts + "\n"); 
 
        // Step 5: look up a contact 
        if (contacts.containsKey("Charlie Brown")) {
            System.out.println("Contact found : " + contacts.get("Charlie Brown"));
        } 
        else {
            System.out.println("Contact not found.");
        }


        if (contacts.containsKey("Isaac Newton")) {
            System.out.println("Contact foound: " + contacts.get("Isaac Newton"));
        } 
        else {
            System.out.println("Contact not found.");
        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a,b) -> a.getName().compareTo(b.getName()));

        System.out.println("\n=== All Contacts ===  ");
        for (Contact c : sorted) {
            System.out.println(c);
        }

    } 
}