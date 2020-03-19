import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static String movementList = "data/movementList.csv";

    public static void main(String[] args) throws IOException {
        int income = 0;
        double cost = 0;
        System.out.println("Cost Breakdown: ");
        try {
            List<String> lines = Files.readAllLines(Paths.get(movementList));
            lines.remove(0);
            HashMap<String, Double> costBreakdown = new HashMap<>();
            for (String line : lines) {

                List<String> fragments = new ArrayList<>(Arrays.asList(line.split(",")));
                for (int i = 0; i < fragments.size(); i++) {
                    if ((fragments.get(i).trim().contains("\"")) && (fragments.get(i + 1).trim().contains("\""))) {
                        fragments.set(i, (fragments.get(i).trim().replace("\"", "") + "." + fragments.get(i + 1).trim().replace("\"", "")));
                        fragments.remove(i + 1);
                    }
                }

                if (fragments.size() != 8) {
                    System.out.println(fragments.size() + " Wrong line: " + line);
                    continue;
                }

                income += Integer.parseInt(fragments.get(6));
                cost += Double.parseDouble(fragments.get(7));

                if (Double.parseDouble(fragments.get(7)) != 0) {
                    String[] s = fragments.get(5).split("/|\\\\");
                    String key = s[s.length - 1].substring(0, s[s.length - 1].indexOf("  "));
                    Double value = Double.parseDouble(fragments.get(7));

                    if (!costBreakdown.containsKey(key)) {
                        costBreakdown.put(key, value);
                    } else {
                        costBreakdown.put(key, costBreakdown.get(key) + value);
                    }
                }

            }
            for (Map.Entry<String, Double> entry : costBreakdown.entrySet()) {
                System.out.print(entry.getKey() + "      ");
                System.out.printf("%.2f ", entry.getValue());
                System.out.println("");
            }

            System.out.println("---------------------------------\n Total INCOME: " + income + "rub  COST: " + cost + "rub");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
