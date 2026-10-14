package version6;

import java.util.Objects;

public final class MyDate implements Cloneable {

    private static final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        validate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private static int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static void validate(int day, int month, int year) {
        if (month < 1 || month > 12 || year <= 1900) {
            throw new IllegalArgumentException("Invalid calendar date");
        }
        if (day < 1 || day > daysInMonth(month, year)) {
            throw new IllegalArgumentException("Invalid day for the specified month.");
        }
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    public String getMonthName() { return MONTH_NAMES[month - 1]; }

    public void setDay(int day) {
        validate(day, this.month, this.year);
        this.day = day;
    }

    public void setMonth(int month) {
        validate(this.day, month, this.year);
        this.month = month;
    }

    public void setYear(int year) {
        validate(this.day, this.month, year);
        this.year = year;
    }

    @Override
    public String toString() {
        return day + " " + getMonthName() + " " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyDate)) return false;
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
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
