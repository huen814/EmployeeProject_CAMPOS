package version2;

public class MyDate {
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
        return  + date + " " + monthNames[month - 1] + " " + year;
    }
}
