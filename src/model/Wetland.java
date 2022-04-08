package model;
//To generate javadoc: javadoc src/model/Wetland.java -d doc/API/

/** Class of the wetland
 * @author JuanJoseDiaz
 * 
 * */
public class Wetland {

    // Atributes of the class -------------------------------

    /**The name o the wetland */
    private String name;
    /**The location zone of the wetland */
    private LocationZone locationZone;
    /**The type of the wetland, could be private(True), public(False) */
    private TypeWetland type;
    /**The area of the wetland in km2 */
    private double area;
    /**the url of the picture*/
    private String urlOfThePicture;
    /**If the area is protected, Yes (True), No(False) */
    private boolean protectedArea;
    /**The name of the neighborhood or township  */
    private String locationName;

    // Atributes (objects from another classes )

     /** Object of type EnvironmentalPlan,  contains the environmental plan of the wetland */
    private double environmentalPlan;
    /**Arraylist of object Specie, contains all the species in the wetland */
    private Specie[] species;
    /**Arraylist of object Event, contains all the events of the wetland  */
    private Event[] events;

    /**
	* Constructor method, receives all the atributes of the class, except the objects
	* <b> pre:</b> The variables name, locationZone, type, area, urlOfThePicture, protectedArea, locationName should be declared
	* <b> pos:</b> The variables name, locationZone, type, area, urlOfThePicture, protectedArea, locationName are inicilized
	* @param name String, 
    * @param locationZone boolean
    * @param area  double  
    * @param urlOfThePicture String 
    * @param protectedArea boolean
    * @param locationName String
	*/
    public Wetland(String name, boolean locationZone, boolean type, double area, String urlOfThePicture, boolean protectedArea, String locationName) {

        this.name = name;
        if (locationZone) {
            this.locationZone = LocationZone.RURAL;
        } else {
            this.locationZone = LocationZone.URBAN;
        }

        if (type) {
            this.type = TypeWetland.PRIVATE;
        } else {
            this.type = TypeWetland.PUBLIC;
        }
        this.area = area;
        this.urlOfThePicture = urlOfThePicture;
        this.protectedArea = protectedArea;
        this.locationName = locationName;

        species = new Specie[100000];
        events = new Event[100000];

    }

    //------------------------------ Methods to add Species ---------------------------

    public int indexFirstNullSpecies() {
        int indexFirstNull = -1;
		for (int i = 0; i < species.length && indexFirstNull == -1; i++) {
			if (species[i] == null) {
				indexFirstNull = i;
			}
		}
		return indexFirstNull;
    }

    public boolean isSpecieIn (String name) {
		boolean flag = false;
		for (int i = 0; i < species.length && !flag; i++) {
			if (species[i]!=null && species[i].getName().equals(name) ) {
				flag = true;
			}
		}
		return flag;
	}

    public String addSpecie(Specie specie) {
        String out = "" ;
		int emptyPos = indexFirstNullSpecies();
		
		if (!isSpecieIn(name)) {
			if(emptyPos == -1) {
				out = "\n¡The array is full, you can't add another Specie!";
			} else {
				species[emptyPos] = specie;
				out =  "\n¡The specie was added correctly :) !";
			}
		} else {
			out = "\n¡There's already a Specie with the same name. Please enter other specie with a different name!";
		}
		return out;
    }

    //------------------------------ Methods to add events ---------------------------

    public int indexFirstNullEvents() {
        int indexFirstNull = -1;
		for (int i = 0; i < events.length && indexFirstNull == -1; i++) {
			if (events[i] == null) {
				indexFirstNull = i;
			}
		}
		return indexFirstNull;
    }

    public String addEvent(Event event) {
        String out = "" ;
		int emptyPos = indexFirstNullEvents();
		if(emptyPos == -1) {
			out = "\n¡The array is full, you can't add another event!";
		} else {
			events[emptyPos] = event;
			out =  "\n¡The event was added correctly :) !";
		} 
		return out;
    }

    // ------------------- Method toString ---------------------
    @Override
    public String toString() {
        String out = "";
        out += "\n\n***** Information of wetland "+ name + " *****"+ "\n\nLocation zone: ";
        if (locationZone == LocationZone.RURAL) {
            out += "Rural\nName of the township: " + locationName  ;
        } else {
            out += "Urban\nName of the neighborhood: " + locationName;
        }

        out+= "\nType wetland: ";
        if (type == TypeWetland.PRIVATE) {
            out += "Private";
        } else {
            out += "Public";
        }
        out += "\nArea of the wetland (km2): " + area + "\nUrl of the picture: " + urlOfThePicture +"\n" ; 
        if (protectedArea) {
            out+= "Protected area\n";
        } else {
            out += "Unprotected area\n";
        }
        if (environmentalPlan != 0.0) {
            out += "The compilance percentage of the environmental plan is: \n";
        } else {
            out += "The wetland doesn't have an environmental plan\n ";
        }

        out += "\nTotal species of terrestial flora: " + numberSpeciesTerrestialFlora();
        out += "\nTotal species of aquatic flora: " + numberSpeciesAquaticFlora();
        out += "\nTotal species of birds : " + numberSpeciesBirds();
        out += "\nTotal mammals species : " + numberSpeciesMammals();
        out += "\nTotal aquatic species: " + numberSpeciesAquatic();

        return out;
    }

    //--------------- Methods to calculate the the amount of species in the wetland by type --------------------
    public int numberSpeciesTerrestialFlora() {
        int cont = 0;
        for (int i = 0; i < species.length && i < indexFirstNullSpecies(); i++) {
            if (species[i].getType() == TypeSpecie.TERRESTRIAL_FLORA) {
                cont+=1;
            }
        }
        return cont;
    }
    public int numberSpeciesAquaticFlora() {
        int cont = 0;
        for (int i = 0; i < species.length && i < indexFirstNullSpecies(); i++) {
            if (species[i].getType() == TypeSpecie.AQUATIC_FLORA) {
                cont+=1;
            }
        }
        return cont;
    }
    public int numberSpeciesBirds() {
        int cont = 0;
        for (int i = 0; i < species.length && i < indexFirstNullSpecies(); i++) {
            if (species[i].getType() == TypeSpecie.BIRD) {
                cont+=1;
            }
        }
        return cont;
    }
    public int numberSpeciesMammals() {
        int cont = 0;
        for (int i = 0; i < species.length && i < indexFirstNullSpecies(); i++) {
            if (species[i].getType() == TypeSpecie.MAMMAL) {
                cont+=1;
            }
        }
        return cont;
    }
    public int numberSpeciesAquatic() {
        int cont = 0;
        for (int i = 0; i < species.length && i < indexFirstNullSpecies(); i++) {
            if (species[i].getType() == TypeSpecie.AQUATIC) {
                cont+=1;
            }
        }
        return cont;
    }

    // ------------- Method to consult if a wetland has a certain specie ------------------------

    public boolean hasSpecie(String nameSpecie) {
        boolean flag = false;
        for (int i = 0; i != -1 && i < indexFirstNullSpecies(); i++) {
            if (species[i].getName().equals(nameSpecie)) {
                flag= true;
                break;
            }
        }
        return flag;
    }

    public int numberMaintenanceInYear(int year) {
        int counter  =0;
        for (int i = 0; i < events.length  && i < indexFirstNullEvents(); i++) {
            if (events[i].getType() == TypeEvent.MAINTENANCE && events[i].getYear() == year) {
                counter++;
            }
        }
        return counter;
    }
    // ------------------- Methods getters and setters -------------------------

    public int numberOfAnimals() {
        int num = 0;
        for (int i = 0; i < species.length && i < indexFirstNullEvents() ; i++) {
            if (species[i].getType() == TypeSpecie.AQUATIC || species[i].getType() == TypeSpecie.BIRD || species[i].getType() == TypeSpecie.MAMMAL ) {
                num++;
            }
        }
        return num;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return boolean return the locationZone
     */
    public LocationZone isLocationZone() {
        return locationZone;
    }

    /**
     * @return double return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return String return the urlOfThePIcture
     */
    public String getUrlOfThePicture() {
        return urlOfThePicture;
    }

    /**
     * @param urlOfThePIcture the urlOfThePIcture to set
     */
    public void setUrlOfThePicture(String urlOfThePIcture) {
        this.urlOfThePicture = urlOfThePIcture;
    }

    /**
     * @return boolean return the protectedArea
     */
    public boolean isProtectedArea() {
        return protectedArea;
    }

    /**
     * @param protectedArea the protectedArea to set
     */
    public void setProtectedArea(boolean protectedArea) {
        this.protectedArea = protectedArea;
    }

    /**
     * @return String return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return LocationZone return the locationZone
     */
    public LocationZone getLocationZone() {
        return locationZone;
    }

    /**
     * @param locationZone the locationZone to set
     */
    public void setLocationZone(LocationZone locationZone) {
        this.locationZone = locationZone;
    }

    /**
     * @return TypeWetland return the type
     */
    public TypeWetland getType() {
        return type;
    }

    

   

}
