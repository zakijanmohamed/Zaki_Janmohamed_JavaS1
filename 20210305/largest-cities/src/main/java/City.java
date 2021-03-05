import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class City {
    String name;
    int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public static Map<String,City> filterByPopulation(Map<String,City> x, int population){
        Map<String,City> updated = new HashMap<String,City>();

        for(String i: x.keySet()){
            if(x.get(i).getPopulation() > population){
                updated.put(i,x.get(i));
            }
        }

        return updated;
    }

    static City newYork = new City("New York", 8654321);
    static City losAngeles = new City("Los Angeles", 4563218);
    static City chicago = new City("Chicago", 2716520);
    static City denver = new City("Denver", 704621);
    static City desMoines = new City("Des Moines", 217521);
    static City atlanta = new City("Atlanta", 486213);



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String,City> city = new HashMap<String,City>();
        city.put("New York",newYork);
        city.put("California",losAngeles);
        city.put("Illinois",chicago);
        city.put("Colorado",denver);
        city.put("Iowa",desMoines);
        city.put("Georgia",atlanta);

        for(String i: city.keySet()){
            System.out.println(i + " " + city.get(i).getName() + " " + city.get(i).getPopulation());
        }

        System.out.println("Enter a population filter: ");
        int input = Integer.parseInt(scanner.nextLine());

        Map<String,City> x = filterByPopulation(city,input);

        for(String i:x.keySet()){
            System.out.println(i + " " + x.get(i).getName());
        }
    }

}