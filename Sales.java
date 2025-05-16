import java.util.*;

public class Sales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> report = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            if (tokens.length != 3) continue;

            String customer = tokens[0];
            String product = tokens[1];
            int amount = Integer.parseInt(tokens[2]);

            report.computeIfAbsent(customer, name -> new TreeMap<>())
                    .merge(product, amount, Integer::sum);
        }
        scanner.close();

        for (Map.Entry<String, Map<String, Integer>> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> product : entry.getValue().entrySet()) {
                System.out.println(product.getKey() + " " + product.getValue());
            }
        }
    }
}
