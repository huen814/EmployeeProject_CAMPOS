package version4;

import java.util.Objects;

public class MyDate implements Cloneable {
    public int date;
    public int month;
    public int year;

    public MyDate(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        String[] monthNames = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };
        return +date + " " + monthNames[month - 1] + " " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyDate)) return false;
        MyDate other = (MyDate) obj;
        return date == other.date && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("MyDate should be cloneable", e);
        }
    }
}

