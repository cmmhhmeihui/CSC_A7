/** 
 * Created Cafe Class through inheritance of Builidng Class 
 */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    
    /**
     * class constructor of Cafe 
     * @param name String name
     * @param address String address
     * @param nFloors int nFloors
     * @param nCoffeeOunces int nCoffeeOunces
     * @param nSugarPackets int nSugarPackets
     * @param nCreams int nCreams
     * @param nCups int nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    /**
     * method that check and updates the inventory when selling coffee
     * @param size int size
     * @param nSugarPackets int nSugarPackets
     * @param nCreams int nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets){
            System.out.println("Restocking");
            this.restock(20, 20);
        }
        else if (this.nCreams < nCreams){
            System.out.println("Restocking");
            this.restock(20);
        }
        else if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets ||this.nCups < 1){
            System.out.println("Restocking");
            this.restock(20, 20, 20);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("sold 1 cup of "+nCoffeeOunces+" ounces coffee containing "+nSugarPackets+" sugarpackets and "+nCreams+" creams.");

    }

    /**
     * method that updates the coffee inventory 
     * @param nCoffeeOunces int nCoffeeOunces
     * @param nSugarPackets int nSugarPackets
     * @param nCups int nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCups += nCups;
        System.out.println("Restocked "+nCoffeeOunces+" CoffeeOunces, "+nSugarPackets+" Sugarpackets, and "+nCups+" Cups.");
    }
    /**
     * overloaded method that updates the coffee inventory 
     * @param nCoffeeOunces int nCoffeeOunces
     * @param nSugarPackets int nSugarPackets
     */
    private void restock(int nCoffeeOunces, int nSugarPackets){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        System.out.println("Restocked "+nCoffeeOunces+" CoffeeOunces, "+nSugarPackets+" SugarPackets.");
    }
    /**
     * overloaded method that updates the coffee inventory 
     * @param nCreams int nCreams
     */
    private void restock(int nCreams){
        this.nCreams += nCreams;
        System.out.println("Restocked "+nCreams+" Creams.");
    }
    /*
     * method that shows cafe subclass-specific options
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock() \n");
    }

    /*
     * main method for testing 
     * @param args empty list of arguments 
     */
    public static void main(String[] args) {
       Cafe compass_c = new Cafe("Compass Cafe","7 Neilson Drive",1, 5, 5, 5,5);
       compass_c.showOptions();
       System.out.println(compass_c);
       compass_c.sellCoffee(10, 3, 2);
    }
    
}
