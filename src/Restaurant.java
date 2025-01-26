import java.io.*;
import java.util.*;

public class Restaurant {
    static public List<Meal> menu;
    public List<Order> orders;

    public Restaurant() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public static Meal addMeal(Meal meal) {
        menu.add(meal);
        return meal;
    }

    public static boolean HashSet() {
        HashSet<String> namesSet = new HashSet<>();
        boolean repetition = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Save Customer Name.txt"));
            String name;
            while ((name = br.readLine()) != null) {
                if (!namesSet.add(name)) {
                    repetition = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return repetition;
    }

    public static String hashMap(String[] names) {
        HashMap<String, Integer> nameCount = new HashMap<>();
        for (String name : names) {
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }
        String mostFrequentName = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentName = entry.getKey();
            }
        }
        return mostFrequentName;
    }

    public static Meal hashMap(List<Meal> names) {
        HashMap<Meal, Integer> nameCount = new HashMap<>();
        for (Meal name : names) {
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }
        Meal meal1 = null;
        int maxCount = 0;
        for (Map.Entry<Meal, Integer> entry : nameCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                meal1 = entry.getKey();
            }
        }
        return meal1;
    }
}
