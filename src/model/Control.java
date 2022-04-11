package model;
//To generate javadoc: javadoc src/model/Control.java -d doc/API/

/** Container class of the program
 * @author JuanJoseDiaz
 * 
 * */

public class Control {

    // Atributes: -----------------------

    /**Array of objects wetlands that contains all the wetlands of the system */
    private Wetland[] wetlands;

	/**Constant of the size of the array of wetland */
    private static final int MAX_NUMBER_WETLANDS = 80;
    
    //Method to add Wetlands to the array
    /**
	* Adds an object Wetland to the ArrayList wetlands
	* <b> pre:</b> the Arraylist should be inicialized
	* <b> pos:</b> adds an object wetland to the arraylist
	* @param wetland Wetland
	*/
    public Control() {
        wetlands = new Wetland[MAX_NUMBER_WETLANDS];
    }

	//-------------------  Methods to manage the adition of wetlands ------------------------------ 

	/**
	 * Method that returns the number of the index of the first null space in the array of wetlands
	 * <b> pre:</b> The array wetlands should be initialized
	 * @return indexFirstNull int, index of the first null, -1 if it is full
	 */
    public int indexFirstNullWetlands() {
        int indexFirstNull = -1;
		for (int i = 0; i < MAX_NUMBER_WETLANDS && indexFirstNull == -1; i++) {
			if (wetlands[i] == null) {
				indexFirstNull = i;
			}
		}
		return indexFirstNull;
    }
	/**
	 * Method that indicates wether if the class control has a wetland with the name entered in the parameter
	 * @param name String with the name of the wetland to search
	 * @return flag boolean, True is there is another wetland with the same name, False if not
	 */
	public boolean isWetlandIn (String name) {
		boolean flag = false;
		for (int i = 0; i < MAX_NUMBER_WETLANDS && !flag; i++) {
			if (wetlands[i]!=null && wetlands[i].getName().equals(name) ) {
				flag = true;
			}
		}
		return flag;
	}
	/**
	 * Method that adds an object wetland to the array wetlands
	 * <b> pre:</b> The array wetlands should be initialized
	 * @param name String, != null
	 * @param locationZone boolean != null
	 * @param type boolean != null
	 * @param area double != null
	 * @param urlOfThePicture String != null
	 * @param protectedArea boolean != null
	 * @param locationName String != null
	 * @return out String with the state of the process
	 */
    public String addWetland(String name, boolean locationZone, boolean type, double area, String urlOfThePicture, boolean protectedArea, String locationName) {
        String out = "" ;
		int emptyPos = indexFirstNullWetlands();
		
		if (!isWetlandIn(name)) {
			if(emptyPos == -1) {
				out = "\n¡The array is full, you can't add another wetland!";
			} else {
				wetlands[emptyPos] = new Wetland(name, locationZone, type, area, urlOfThePicture, protectedArea, locationName);
				out =  "\n¡The wetland was added correctly!";
			}
		} else {
			out = "\n¡There's already a wetland with the same name. Please enter other wetland with a different name!";
		}
		return out;
    }
	/**
	 * Method that finds the index of a wetland according to the id 
	 * @param id String, != null
	 * @return foundWetland int, index of the wetland, -1 if the array is full
	 */
	public int findIndexWetland (String id) {
		boolean flag = false;
		int foundWetland = -1;
		for (int i = 0; i < wetlands.length && !flag; i++) {
			if (wetlands[i]!=null && wetlands[i].getName().equals(id) ) {
				flag = true;
				foundWetland = i;
			}
		}
		return foundWetland;
	}

	//-------------------  Methods to manage the adition of species ------------------------------ 
	/**
	 * Method to add an specie to the array species of a wetland
	 * <b> pre:</b> The array wetlands and species should be initialized
	 * @param nameWetland String != null
	 * @param name String != null
	 * @param scientificName String != null
	 * @param migratorySpecie boolean != null
	 * @param optionType int != null
	 * @return out String with the message of the process
	 */
	public String addSpecie(String nameWetland, String name, String scientificName, boolean migratorySpecie, int optionType ) {
		String out = "";
		if (!isWetlandIn(nameWetland)) {
			out = "\nThe wetland you are trying to register the specie isn't registered yet :(";
		} else {
			Specie specie = new Specie(name, scientificName, migratorySpecie, optionType);
			out = wetlands[findIndexWetland(nameWetland)].addSpecie(specie);
		}
		return out;
	}

	//-------------------  Methods to manage the adition of events ------------------------------
	/**
	 * Method to add an event to the array events of a wetland
	 * <b> pre:</b> The array wetlands and events should be initialized
	 * @param nameWetland String
	 * @param eventClient String
	 * @param price double
	 * @param description String
	 * @param day int
	 * @param month int
	 * @param year int
	 * @param optionTypeEvent int
	 * @return out String with the message of the process
	 */
	public String addEvent(String nameWetland, String eventClient, double price, String description, int day, int month, int year, int optionTypeEvent) {
		String out = "";
		Date date = new Date(day, month, year);
		if (!isWetlandIn(nameWetland)) {
			out = "\nThe wetland you are trying to register the event isn't registered yet :(";
		} else {
			Event event = new Event(eventClient, price,description, date, optionTypeEvent);
			out = wetlands[findIndexWetland(nameWetland)].addEvent(event);
		}
		return out;
	}
	/**
	 * Method toString that shows all the information of the class Control
	 * <b> pre:</b> The class Control should be initialized
	 */
	public String toString() {
		String out = "";
		for (int i = 0; i < wetlands.length && i != indexFirstNullWetlands(); i++) {
			out += wetlands[i].toString();
		}
		return out;
	}

	//------------------ Method to show the wetlands that have the same specie -----------

	/**
	 * Method that detects if there's an specie with the same name in the array of species in the class wetland
	 * <b> pre:</b> The array species in the class wetland should be initialized 
	 * @param nameSpecie String, != null
	 * @return out String message with the result of the search
	 */
	public String wetlandsWithSameSpecie(String nameSpecie) {
		String out = "\n*** Wetlands that have that specie: ***";
		String names = " ";
		for (int i = 0; i != -1 && i != indexFirstNullWetlands(); i++) {
			if (wetlands[i].hasSpecie(nameSpecie)) {
				names +="\n* " + wetlands[i].getName();
			}
		}
		if (names.equals(" ")) {
			out = "\nThat specie wasn't found in any wetland :(";
		} else {
			out += names;
		}
		return out;
	}

	/**
	 * Method that returns the name of the wetland with less flora
	 * <b> pre:</b> The array wetlands should be initialized
	 * @return out String name of the wetland with less flora
	 */
	public String nameWetlandWithLessFlora() {
		String out = "";
		int counterMin = wetlands[0].numberSpeciesAquaticFlora() + wetlands[0].numberSpeciesTerrestialFlora();
		for (int i = 0; i != -1 && i != indexFirstNullWetlands(); i++) {
			int tempVar = wetlands[i].numberSpeciesTerrestialFlora() + wetlands[i].numberSpeciesAquaticFlora(); 
			if (tempVar <= counterMin) {
				counterMin = tempVar;
				out = wetlands[i].getName(); 
			}
		}
		return out;
	}

	/**
	 * Method that returns a string with the name of each wetland and the ammount of events of type maintenance in a year entered as parameter
	 * <b> pre:</b> The array wetlands should be initialized
	 * @param year int, != null
	 * @return out String, with the message
	 */
	public String amountMaintenanceWetlandsInYear(int year) {
		String out = "";
		for (int i = 0; i < wetlands.length && i < indexFirstNullWetlands(); i++) {
			out += "* " + wetlands[i].getName() + ": " + wetlands[i].numberMaintenanceInYear(year) + "\n";	
		}
		return out; 
	}
	/**
	 * Method that returns the name of the wetland with more species of type bird, mammal and aquatic
	 * <b> pre:</b> The array wetlands should be initialized
	 * @return out String name of the wetland
	 */
	public String nameWetlandWithMoreAnimals() {
		String out = "";
		int maxCounter = wetlands[0].numberOfAnimals();
		for (int i = 0; i < wetlands.length && i < indexFirstNullWetlands(); i++) {
			int varTemp = wetlands[i].numberOfAnimals();
			if (maxCounter <= varTemp) {
				maxCounter = varTemp;
				out = "" + wetlands[i].getName();
			}	
		}
		return out;
	}

}
