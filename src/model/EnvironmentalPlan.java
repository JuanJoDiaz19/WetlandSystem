package model;
//To generate javadoc: javadoc src/model/EnvironmentalPlan.java -d doc/API/

/** Class of the enviromental plan
 * @author JuanJoseDiaz
 * 
 * */
public class EnvironmentalPlan {

    // Atributes: -----------------------------------------------------------

    //**Contains the compilance percentage of the environmental plan */
    private double compliancePercentage;

    //Constructor method: 
    /**
	* The constructor method of the class EnvironmentalPlan
	* <b> pre:</b> the variable compilancePercentage should be declared
	* <b> pos:</b> the variable compilancePercentage is initialized
	* @param compliancePercentage double
	*/
    public EnvironmentalPlan(double compliancePercentage){
        this.compliancePercentage = compliancePercentage;   
    }

    @Override
    public String toString() {
        return "Environmental plan compilance percentage: " + compliancePercentage;
    }

    //Methods getters and setters: -------------------------------------

    /**
     * @return double return the compliancePercentage
     */
    public double getCompliancePercentage() {
        return compliancePercentage;
    }

    /**
     * @param compliancePercentage the compliancePercentage to set
     */
    public void setCompliancePercentage(double compliancePercentage) {
        this.compliancePercentage = compliancePercentage;
    }

}
