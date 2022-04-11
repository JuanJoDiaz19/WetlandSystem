package model;
//To generate javadoc: javadoc src/model/Date.java -d doc/API/

/** Class of date
 * @author JuanJoseDiaz
 * 
 * */
public class Date {

    // Atributes 

    /**Number of days in the date */
    private int day;
    /**Number of months in the date */
    private int month;
    /**Number of years in the date */
    private int year;

    /**
	* Constructor method of the class Date
	* <b> pre:</b> the variables day, month and year should be declared
	* <b> pos:</b> the variables day, month and year are inicilized
	* @param day int
    * @param month int
    * @param year int 
	*/
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override
    /**
     * Method toString that returns a Strings with all the information of a date
     * @returns out String
     */
    public String toString() {
        return ""+ day + "/" + month + "/" + year;
    }

    // Methods getters and setters 

    /** 
     * @return int return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return int return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return int return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

}
