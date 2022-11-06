import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sage Hall", "near Josten", 4));
        myMap.addBuilding(new Building("Wright Hall", "across from Campus Center", 3));
        myMap.addBuilding(new Library("Josten Library", "across from Tyler House", 2, 1, true));
        myMap.addBuilding(new Library("Young Library", "besides McConell", 1));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "first floor of Campus Center", 1, 10, 10, 10, 10));
        myMap.addBuilding(new Cafe("Compass Cafe", "ground and first floor of Neilson", 2, 10, 10, 10, 10));
        myMap.addBuilding(new House("Park House", "near Paradise Pond", 4, false));
        myMap.addBuilding(new House("Chase House", "across from Smith Art Meseum", 3, 2,true, true));
        System.out.println(myMap);
    }
    
}