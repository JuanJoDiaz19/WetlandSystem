package model;
//To generate javadoc: javadoc src/model/Control.java -d doc/API/

/** Container class of the program
 * @author JuanJoseDiaz
 * 
 * */

public class Control {

    // Atributes: -----------------------

    /**ArrayList of objects wetland that contains all the wetlands of the system */
    private Wetland[] wetlands;

    private static final int MAX_NUMBER_WETLANDS = 80;
    
    //Method to add Wetlands to the array
    /**
	* adds an object Wetland to the ArrayList wetlands
	* <b> pre:</b> the Arraylist should be inicialized
	* <b> pos:</b> adds an object wetland to the arraylist
	* @param wetland Wetland
	*/

    public Control() {
        wetlands = new Wetland[MAX_NUMBER_WETLANDS];
    }

	//-------------------  Methods to manage the adition of wetlands ------------------------------ 

    public int indexFirstNull() {
        int indexFirstNull = -1;
		for (int i = 0; i < MAX_NUMBER_WETLANDS && indexFirstNull == -1; i++) {
			if (wetlands[i] == null) {
				indexFirstNull = i;
			}
		}
		return indexFirstNull;
    }

	public boolean isWetlandIn (String name) {
		boolean flag = false;
		for (int i = 0; i < MAX_NUMBER_WETLANDS && !flag; i++) {
			if (wetlands[i]!=null && wetlands[i].getName().equals(name) ) {
				flag = true;
			}
		}
		return flag;
	}
    public String addWetland(String name, boolean locationZone, boolean type, double area, String urlOfThePicture, boolean protectedArea, String locationName) {
        String out = "" ;
		int emptyPos = indexFirstNull();
		
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

	public int findIndexWetland (String id) {
		boolean flag = false;
		int foundCircle = -1;
		for (int i = 0; i < wetlands.length && !flag; i++) {
			if (wetlands[i]!=null && wetlands[i].getName().equals(id) ) {
				flag = true;
				foundCircle = i;
			}
		}
		return foundCircle;
	}

	//-------------------  Methods to manage the adition of species ------------------------------ 

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
	
	public String toString() {
		String out = "";
		for (int i = 0; i < wetlands.length && i != indexFirstNull(); i++) {
			out += wetlands[i].toString();
		}
		return out;
	}

	//------------------ Method to show the wetlands that have the same specie -----------
	public String wetlandsWithSameSpecie(String nameSpecie) {
		String out = "\n*** Wetlands that have that specie: ***";
		String names = " ";
		for (int i = 0; i != -1 && i != indexFirstNull(); i++) {
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

	public String nameWetlandWithLessFlora() {
		String out = "";
		int counterMin = wetlands[0].numberSpeciesAquaticFlora() + wetlands[0].numberSpeciesTerrestialFlora();
		for (int i = 0; i != -1 && i != indexFirstNull(); i++) {
			int tempVar = wetlands[i].numberSpeciesTerrestialFlora() + wetlands[i].numberSpeciesAquaticFlora(); 
			if (tempVar <= counterMin) {
				counterMin = tempVar;
				out = wetlands[i].getName(); 
			}
			
		}
		return out;
	}

	public String amountMaintenanceWetlandsInYear(int year) {
		String out = "";
		for (int i = 0; i < wetlands.length && i < indexFirstNull(); i++) {
			out += "* " + wetlands[i].getName() + ": " + wetlands[i].numberMaintenanceInYear(year) + "\n";	
		}
		return out; 
	}

	public String ammountAnimalsInWetlands() {
		String out = "";
		int maxCounter = wetlands[0].numberOfAnimals();
		for (int i = 0; i < wetlands.length && i < indexFirstNull(); i++) {
			int varTemp = wetlands[i].numberOfAnimals();
			if (maxCounter <= varTemp) {
				maxCounter = varTemp;
				out = "" + wetlands[i].getName();
			}	
		}
		return out;
	}

}
