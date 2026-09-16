package version2;

public class Name {
    public String firstname;
    public String middleInitial;
    public String lastName;

    public Name(String firstname, String middleInitial, String lastName) {
        this.firstname = firstname;
        this.middleInitial = middleInitial;
        this.lastName = lastName;


    }

    @Override
    public String toString() {
        return lastName + ", " + firstname + " " + middleInitial + ".";
    }
}


