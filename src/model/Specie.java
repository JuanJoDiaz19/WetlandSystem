package model;
//To generate javadoc: javadoc src/model/Specie.java -d doc/API/

/** class of the specie
 * @author JuanJoseDiaz
 * 
 * */
public class Specie {

    // Atributes 
    /**name of the specie */
    private String name;
    /**scientific name of the specie  */
    private String scientificName; 
    /**The specie comes from another place migratory(True), not migratory(False) */
    private boolean migratorySpecie;
    /**type of the specie */
    private TypeSpecie type;

    //Constructor method:
    
    /**
	* Constrcutor method of the class Specie
	* <b> pre:</b> The variables name, scientificName, migratorySpecie and type should be declared
	* <b> pos:</b> The variables name, scientificName, migratorySpecie and type are initialized
	* @param name String
    * @param scientificName String
    * @param migratorySpecie boolean
    * @param type String
	*/
    public Specie(String name, String scientificName, boolean migratorySpecie, int optionType) {
        this.name = name;
        this.scientificName = scientificName;
        this.migratorySpecie = migratorySpecie;
        switch (optionType) {
            case 1:
                type = TypeSpecie.TERRESTRIAL_FLORA;  
                break;
            case 2: 
                type = TypeSpecie.AQUATIC_FLORA;     
                break;
            case 3:    
                type = TypeSpecie.BIRD;  
                break;
            case 4:    
                type = TypeSpecie.MAMMAL;  
                break;
            case 5:    
                type = TypeSpecie.AQUATIC;  
                break;
        }
    }    

    //--------------- Method toString ---------------

    public String toString() {
        String out = "";
        out += "\n--- Information of the specie: " + name + " ---\n"+
                "\nScientific name: " + scientificName ;
        if (migratorySpecie) {
            out += "\nThe specie es migratory";
        } else {
            out += "\nThe specie isn't migratory";
        }
        out += "\nType: ";
        if (type == TypeSpecie.TERRESTRIAL_FLORA) {
            out += "Terrestrial flora\n";
        } else if(type == TypeSpecie.AQUATIC_FLORA){
            out += "Aquatic flora\n";
        } else if(type == TypeSpecie.BIRD){
            out += "Bird\n";
        } else if(type == TypeSpecie.MAMMAL){
            out += "Mammal\n";
        } else if(type == TypeSpecie.AQUATIC){
            out += "Aquatic\n";
        }
        return out; 
    }

    //Methods getters and setters 

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
     * @return String return the scienticName
     */
    public String getScientificName() {
        return scientificName;
    }

    /**
     * @param scientificName the scienticName to set
     */
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    /**
     * @return boolean return the migratorySpecie
     */
    public boolean isMigratorySpecie() {
        return migratorySpecie;
    }

    /**
     * @param migratorySpecie the migratorySpecie to set
     */
    public void setMigratorySpecie(boolean migratorySpecie) {
        this.migratorySpecie = migratorySpecie;
    }

    /**
     * @return TypeSpecie return the type
     */
    public TypeSpecie getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeSpecie type) {
        this.type = type;
    }

}
