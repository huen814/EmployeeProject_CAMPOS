package version6;

import java.util.Objects;

public final class Name implements Cloneable {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String suffix;

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        if (isBlank(firstName) || isBlank(lastName)) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
        this.firstName = firstName.trim();
        this.middleName = isBlank(middleName) ? "" : middleName.trim();
        this.lastName = lastName.trim();
        this.suffix = isBlank(suffix) ? "" : suffix.trim();
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getSuffix() { return suffix; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(lastName).append(", ").append(firstName);
        if (!middleName.isEmpty()) {
            sb.append(' ').append(middleName.charAt(0)).append('.');
        }
        if (!suffix.isEmpty()) {
            sb.append(' ').append(suffix);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), middleName.toLowerCase(),
                lastName.toLowerCase(), suffix.toLowerCase());
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
