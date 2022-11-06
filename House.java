import java.util.ArrayList;
import java.lang.Math;
/**
 * Created House Class through inheritance of Builidng Class 
 */
public class House extends Building {
  private boolean hasDiningRoom;
  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasElevator;

  /**
   * class constructor specifying name, address, numbers of floors, if has dinning halls, location of the person, if has elevators of the house
   * @param name String name 
   * @param address String address
   * @param nFloors int nFloors
   * @param activeFloor
   * @param DR Boolean DR
   * @param elevator Boolean elevator 
   */
  public House(String name, String address, int nFloors,  int activeFloor, Boolean DR, Boolean elevator) {
    super(name, address, nFloors, activeFloor);
    this.hasDiningRoom = DR;
    this.hasElevator = elevator;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }
  
  /**
   * Overloaded constructor with no elevator
   * @param name String name
   * @param address String address 
   * @param nFloors int nFloors
   * @param activeFloor int activeFloor
   * @param DR Boolean DR
   */
  public House(String name, String address, int nFloors,  int activeFloor, Boolean DR) {
    super(name, address, nFloors);
    //ArrayList<String> residents = new ArrayList<String>();
    this.hasDiningRoom = DR;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }
  /**
   * Overloaded constructor with no elevator and no location of the person
   * @param name String name
   * @param address String address
   * @param nFloors int nFloors
   * @param DR Boolean DR
   */
  public House(String name, String address, int nFloors, Boolean DR) {
    super(name, address, nFloors);
    //ArrayList<String> residents = new ArrayList<String>();
    this.hasDiningRoom = DR;
    this.residents = new ArrayList<String>();
    System.out.println("You have built a house: 🏠");
  }

/**
 * check and return if the house has dinning room 
 * @return true if the house has dinning hall or false if it doesn't have dinning hall 
 */
public boolean hasDiningRoom(){
  return this.hasDiningRoom;
  }

/**
 * check and return if the house has elevator 
 * @return true if the house has elevator or false if it doesn't have elevator 
 */
public boolean hasElevator(){
  return this.hasElevator;
  }

/**
 * method that returns the number of residents 
 * @return size of the arraylist residents 
 */
public int nResidents(){
  return this.residents.size();
  }

/**
 * method that add new strings to residents arraylist 
 */
public void moveIn(String name){
  this.residents.add(name);
  }

/**
 * method that return the name of the person who moved out
 * @param name String name 
 * @return prints the person who moved out 
 */
public String moveOut(String name){ 
  this.residents.remove(name);
  return (name+"moved out");
  } 

/**
 * method that returns if the residents lives in the house 
 * @param person String person
 * @return true if the person lives in the house or false if they are not 
 */
public boolean isResident(String person){
  return this.residents.contains(person);
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
    if (this.hasElevator == true){
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }
    else {
      if (Math.abs(floorNum - activeFloor) != 1) {
        System.out.println("This house doesn't have an elevator. Cannot move between non-adjacent floors. Try again.");
      }
      else {
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
    }
  }

  /**
   * method thart shows all the options Building subclass has 
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut()\n + isResident()\n");
  }

  /**
   * main method of house, created and printed out a new object of House
   * @param args empty list of arguments 
   */
  public static void main(String[] args) {
    House chasehouse = new House("Chase House", "45 Elm Street", 5, 2, true, false);
    System.out.println(chasehouse);
    chasehouse.showOptions();
    chasehouse.goToFloor(5);
  
  }

}