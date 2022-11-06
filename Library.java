import java.util.Hashtable;

/**
 * Created Library Class
 */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;
 
    /**
     * class constructor specifying name, address, numbers of floors, location of the person, if has elevators of the library
     * @param name String name
     * @param address String address
     * @param nFloors int nFloors
     * @param activeFloor int activeFloor 
     * @param elevator Boolean elevator 
     */
    public Library(String name, String address, int nFloors, int activeFloor, Boolean elevator) {
      super(name, address, nFloors, activeFloor);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = elevator;
      System.out.println("You have built a library: 📖");
    }
    /**
     * Overloaded constructor with no elevator and no location of the person
     * @param name String name
     * @param address String address
     * @param nFloors int nFloors
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
    /**
     * Overloaded constructor with no elevator
     * @param name String name
     * @param address String address
     * @param nFloors int nFloors
     * @param activeFloor int activeFloor 
     */
    public Library(String name, String address, int nFloors, int activeFloor) {
      super(name, address, nFloors, activeFloor);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    /**
     * method that add new book title to library 
     * @param title String title
     */
    public void addTitle(String title){
      this.collection.put(title,true);
    }
    /**
     * method that removes a book from the library 
     * @param title String title
     * @return title of the book that removed 
     */
    public String removeTitle(String title){// return the title that we removed
      this.collection.remove(title);
      return title;
    } 
    /**
     * method that check out a book from the library 
     * @param title String title
     */
    public void checkOut(String title){
      this.collection.replace(title,false);
    }
    /**
     * method that returns a book to the library 
     * @param title String title
     */
    public void returnBooks(String title){
      this.collection.replace(title,true);
    }
    /*
     * method that checks if a book is in the library 
     * @param title String title
     * @return true if the book is in the library and false if it's not in the library 
     */
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }
    /**
     * method that checks if a book is available for rent in the library 
     * @param title String title
     * @return true if the book is available in the library and false if it's not available in the library 
     */
    public boolean isAvailable(String title){
      return this.collection.get(title);
    }

    /**
     * check and return if the library has elevator 
     * @return true if the library has elevator or false if it doesn't have elevator 
     */
    public boolean hasElevator(){
      return this.hasElevator;
    }
    
    /**
     * Check if can go to the floor entered and go to the floor or throw out an exception message 
     */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      if (this.hasElevator){
          System.out.println("You are now on floor #" + floorNum + " of " + this.name);
          this.activeFloor = floorNum;
      }
      else {
        if (Math.abs(floorNum - activeFloor) == 1) {
            this.activeFloor = floorNum;
        }
        else{
            System.out.println("This library doesn't have an elevator. Cannot move between non-adjacent floors. Try again.");
        }
      }
    }
    /**
     * method that prints the collection of the library
     */
    public void printCollection(){
      System.out.println("this library's collection is"+this.collection.toString());
    }

    /**
     * Shows options the subclass has 
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBooks()\n + containsTitle()\n + isAvailable\n + printCollection\n");
    }

    /**
     * main merthod for testing 
     * @param args empty list of arguments 
     */
     public static void main(String[] args) {
      Library neilson = new Library("Neilson"," 7 Neilson Drive",4, 1, true);
      System.out.println(neilson);
      neilson.showOptions();
      neilson.addTitle("The Old Man And the Sea");
      neilson.addTitle("1Q84");
      neilson.printCollection();
      neilson.enter();
      neilson.goToFloor(3);
      //neilson.goUp();

    }
  }