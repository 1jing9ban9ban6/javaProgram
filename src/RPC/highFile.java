package RPC;

import file.person;

import java.util.ArrayList;

public interface highFile {
    public void addPerson(person p) throws Exception;
    public ArrayList<person> getPersonByName(String name) throws Exception;
    public file.person getPersonById(int i) throws Exception;
}
