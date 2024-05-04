import com.sun.jdi.IntegerValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public static List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        //TODO
        Collections.sort(sortedByName, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
//        for (int i=0;i<countries.size();i++){
//            System.out.print(i+": "+"Country Name: " + sortedByName.get(i).getName());
//            System.out.print(" Country Capital: " + sortedByName.get(i).getCapital());
//            System.out.print(" Country Population: " + sortedByName.get(i).getPopulation());
//            System.out.println(" Country Area: " + sortedByName.get(i).getArea());
//        }

        return  sortedByName;
    }

    public static List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        //TODO
        Collections.sort(sortedByPopulation, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return Integer.valueOf(o2.getPopulation()).compareTo(o1.getPopulation());
            }
        });
//        for (int i=0;i<countries.size();i++){
//            System.out.print(i+": "+"Country Name: " + sortedByPopulation.get(i).getName());
//            System.out.print(" Country Capital: " + sortedByPopulation.get(i).getCapital());
//            System.out.print(" Country Population: " + sortedByPopulation.get(i).getPopulation());
//            System.out.println(" Country Area: " + sortedByPopulation.get(i).getArea());
//        }

        return sortedByPopulation;
    }

    public static List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        //TODO
        Collections.sort(sortedByArea, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return Double.valueOf(o2.getArea()).compareTo(o1.getArea());
            }
        });
//        for (int i=0;i<countries.size();i++){
//                System.out.print(i+": "+"Country Name: " + sortedByArea.get(i).getName());
//                System.out.print(" Country Capital: " + sortedByArea.get(i).getCapital());
//                System.out.print(" Country Population: " + sortedByArea.get(i).getPopulation());
//                System.out.println(" Country Area: " + sortedByArea.get(i).getArea());
//        }

        return sortedByArea;
    }

    public static void setUp() throws IOException {
        String url = "D:\\Maria\\term4\\computer science\\java_programing\\HW\\Fourth-Assignment-HTML-Parser\\src\\Resources\\country-list.html";

        try {
            // Extract data from the HTML
            //TODO
            File input = new File(url);
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements Countries = doc.select(".country");

            // Iterate through each country div to extract country data
            //TODO
            for (Element country : Countries) {
                String countryName = country.select(".country-name").text();
                String countryCapital = country.select(".country-capital").text();
                String countryPopulation = country.select(".country-population").text();
                String countryArea = country.select(".country-area").text();
                Country countryobject =new Country(countryName,countryCapital,Integer.parseInt(countryPopulation),Double.parseDouble(countryArea));
                countries.add(countryobject);

            }
        } catch (IOException var11) {
            var11.printStackTrace();
        }





    }

    public static void main(String[] args) throws IOException {
        //you can test your code here before you run the unit tests ;)
        setUp();
        sortByArea();
//        sortByName();
//        sortByPopulation();

    }
}
