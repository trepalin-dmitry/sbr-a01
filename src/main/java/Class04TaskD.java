import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Class04TaskD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        Map<String, Long> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");
            String operation = line[0];
            switch (operation) {
                case Operations.DEPOSIT -> add(map, line[1], Integer.parseInt(line[2]));
                case Operations.WITHDRAW -> add(map, line[1], -Integer.parseInt(line[2]));
                case Operations.BALANCE -> {
                    Long balance = map.get(line[1]);
                    String balanceLine;
                    if (balance == null) {
                        balanceLine = "ERROR";
                    } else {
                        balanceLine = String.valueOf(balance);
                    }
                    result.add(balanceLine);
                }
                case Operations.TRANSFER -> {
                    int sum = Integer.parseInt(line[3]);
                    add(map, line[1], -sum);
                    add(map, line[2], sum);
                }
                case Operations.INCOME -> {
                    int p = Integer.parseInt(line[1]);
                    for (Map.Entry<String, Long> entry : map.entrySet()) {
                        long value = entry.getValue();
                        if (value > 0) {
                            entry.setValue(value * (100 + p) / 100);
                        }
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
        return result.toArray(String[]::new);
    }

    private static void add(Map<String, Long> map, String name, long sum) {
        map.compute(name, (key, value) -> (value == null ? 0 : value) + sum);
    }

    private static final class Operations {
        public final static String DEPOSIT = "DEPOSIT";
        public final static String WITHDRAW = "WITHDRAW";
        public final static String BALANCE = "BALANCE";
        public final static String TRANSFER = "TRANSFER";
        public final static String INCOME = "INCOME";
    }
}