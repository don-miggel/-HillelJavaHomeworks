package my.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private final List<Record> phones;

    public PhoneBook(){
        phones = new ArrayList<>();
    }

    public void add(String name, String phone){
        phones.add(new Record(name, phone));
    }

    public Record find(String name){
        for (Record record : phones){
            if (record.getName().contains(name))
                return record;
        }
        return null;
    }

    public List<Record> findAll(String name){
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : phones){
            if (record.getName().contains(name))
                foundRecords.add(record);
        }
        return foundRecords;
    }


}
