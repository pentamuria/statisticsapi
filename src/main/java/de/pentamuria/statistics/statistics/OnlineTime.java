package de.pentamuria.statistics.statistics;

public class OnlineTime {

    int minutes;
    int hours;
    int days;

    public OnlineTime(int minutes, int hours, int days) {
        this.minutes = minutes;
        this.hours = hours;
        this.days = days;
    }

    public OnlineTime() {
        this.minutes = 0;
        this.hours = 0;
        this.days = 0;
    }


    public OnlineTime(long minutes) {
        this.days = (int) (minutes/60/24);
        this.hours = (int) ((minutes-days*60*24)/60);
        this.minutes = (int) (minutes-(days*60*24)-(hours*60));
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getDays() {
        return days;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void addMinute() {
        this.minutes+=1;
        if(minutes==60) {
            addHour();
            setMinutes(0);
        }
    }

    private void addHour() {
        this.hours+=1;
        if(hours==24) {
            addDay();
            setHours(0);
        }
    }

    private void addDay() {
        this.days+=1;
    }


    /**
     * Format: (Online seit) 2 Tagen, 5 Stunden und 3 Minuten
     * @return
     */
    public String format() {
        String dayStr = "";
        String hoursStr = "";
        String minutesStr = "";
        if(days>0) {
            dayStr = days + (days>1 || days==0 ? " Tagen, " : " Tag, ");
        }
        if(hours>0 || days>0) {
            hoursStr = hours + (hours>1 || hours==0 ? " Stunden und " : " Stunde und ");
        }

        minutesStr = minutes + (minutes>1 || minutes==0 ? " Minuten" : " Minute");

        return dayStr + hoursStr + minutesStr;

    }

    public long getAllTimeInMinutes() {
        long dayMin = days*1440;
        long hoursMin = (hours*60);
        return dayMin+hoursMin+minutes;
    }


    @Override
    public String toString() {
        return "OnlineTime{" +
                "minutes=" + minutes +
                ", hours=" + hours +
                ", days=" + days +
                '}';
    }
}
