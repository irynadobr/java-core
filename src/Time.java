import java.util.Objects;

public class Time {
    private int hour;
    private int min;


    public Time() {
    }

    public Time(int hour, int min) {
        this.limitHour(hour);
        this.limitMin(min);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.limitMin(min);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.limitHour(hour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return min == time.min && hour == time.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, hour);
    }

    @Override
    public String toString() {
        if (hour < 10 && min < 10) {
            return "Time:" + "0" + this.hour + ":0" + this.min;
        } else if (hour < 10 && min > 10) {
            return "Time:" + "0" + this.hour + ":" + this.min;
        } else if (hour > 10 && min < 10) {
            return "Time:" + this.hour + ":0" + this.min;
        }
        return "Time:" + this.hour + ":" + this.min;
    }

    public void limitHour(int hour) {
        if (hour < 0 || hour > 23) {
            System.out.println("Ви ввели не вірне значення: hour = " + hour + ", година повинна бути в межах від 0 до 23");
            return;
        }
        this.hour = hour;
    }

    public void limitMin(int min) {
        if (min < 0 || min > 59) {
            System.out.println("Ви ввели не вірне значення: min = " + min + ", хвилина повинна бути в межах від 0 до 59");
            return;
        }
        this.min = min;
    }
}
