package version4;

import java.util.Objects;

public class Name implements Cloneable {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        Name other = (Name) obj;
        return safeEquals(firstname, other.firstname) && safeEquals(middleInitial, other.middleInitial) && safeEquals(lastName, other.lastName);
    }

    private boolean safeEquals(String a, String b) {
        if (a == null || b == null) return a == b;
        return a.equalsIgnoreCase(b);
    }

    private String suffix = "";

    public Name(String firstname, String middleInitial, String lastName, String suffix) {
        this.firstname = firstname;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, middleInitial, lastName);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Name should be cloneable", e);
        }
    }
}

