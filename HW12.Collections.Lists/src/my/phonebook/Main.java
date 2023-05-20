package my.phonebook;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("John Doe", "+380951111122");
        phoneBook.add("Rick Doe", "+380660000022");
        phoneBook.add("John Johnson", "+380970000011");
        phoneBook.add("Rick Johnson", "+380970000033");
        phoneBook.add("Nick Johnson", "+380970000044");
        System.out.println("First first occurance of the last name 'Doe': "+phoneBook.find("Doe"));
        System.out.println("Find all records by last name 'Doe': "+phoneBook.findAll("Doe"));
        System.out.println("Find first record by name Rick:"+phoneBook.find("Rick"));
        System.out.println("Find all records by name Rick: "+ phoneBook.findAll("Rick"));
        System.out.println("Find by all records containing 'John': "+ phoneBook.findAll("John"));

    }
}
