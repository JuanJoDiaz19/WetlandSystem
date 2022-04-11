package model;
//To generate javadoc: javadoc src/model/Event.java -d doc/API/

/** Class of the event
 * @author JuanJoseDiaz
 * 
 * */
public class Event {

    // Atributes 
    /**The name of the person that makes the event */
    private String eventClient;
    /**The price that it cost */
    private double price;
    /**The description of the event */
    private String description;

    private TypeEvent type;

    // Atributes that are objects
    /**The date where the event was made */
    private Date eventDate;

    //Constructor method:

    /**
	* Constructor of the method Event
	* <b> pre:</b> the variables eventclient, price, description and eventDate should be declared
	* <b> pos:</b> the variables eventclient, price, description and eventDate are initialized
	* @param eventClient String
    * @param price double
    * @param description String
    * @param eventDate Date
    * @param typeEvent int 
	*/
    
    public Event(String eventClient, double price, String description, Date eventDate, int optionTypeEvent) {
        this.eventClient = eventClient;
        this.price = price;
        this.description = description;
        this.eventDate = eventDate;
        switch (optionTypeEvent) {
            case 1:
                type = TypeEvent.MAINTENANCE;    
                break;
            case 2:
                type = TypeEvent.SCHOOL_VISITS;
                break;
            case 3:   
                type = TypeEvent.IMPROVEMENT_ACTIVITIES; 
                break;
            case 4:    
                type = TypeEvent.CELEBREATIONS;
                break;
        }
    }

    // ------------ Method to String -------------

    @Override
    /**
     * Method toString that returns a Strings with all the information of a event
     * @return out String
     */
    public String toString() {
        String out = "";
        out += "\n--- Informacion of event ---\n\nName of the client: " + eventClient +"\nPrice of the event: " + price +
                "\nDescription of the event: " + description + "\nType: ";
        if (type == TypeEvent.MAINTENANCE) {
            out += "Maintenance";
        } else if (type == TypeEvent.SCHOOL_VISITS) {
            out += "School visits";
        } else if (type == TypeEvent.IMPROVEMENT_ACTIVITIES) {
            out += "Improvement activities";
        } else if (type == TypeEvent.CELEBREATIONS) {
            out += "Celebrations";
        } 
        out += "\nDate: " + eventDate.toString() + "\n";
        return out;
    }

    public int getYear() {
        return eventDate.getYear();
    }

    // Methods getters and setters

    /**
     * @return String return the eventClient
     */
    public String getEventClient() {
        return eventClient;
    }

    /**
     * @param eventClient the eventClient to set
     */
    public void setEventClient(String eventClient) {
        this.eventClient = eventClient;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return Date return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }


    /**
     * @return TypeEvent return the type
     */
    public TypeEvent getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeEvent type) {
        this.type = type;
    }

}
