import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Class03TaskD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        Set<String> allLanguages = new HashSet<>();
        Set<String> commonLanguages = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(bufferedReader.readLine());
            Set<String> currentLanguages = new HashSet<>();
            for (int i1 = 0; i1 < M; i1++) {
                String language = bufferedReader.readLine();
                allLanguages.add(language);
                currentLanguages.add(language);
            }

            if (i == 0) {
                commonLanguages.addAll(currentLanguages);
            } else {
                commonLanguages.retainAll(currentLanguages);
            }
        }

        List<String> result = new ArrayList<>();
        addSetToResult(result, commonLanguages);
        addSetToResult(result, allLanguages);
        return result.toArray(String[]::new);
    }

    private static void addSetToResult(List<String> result, Set<String> setToAdd) {
        result.add(String.valueOf(setToAdd.size()));
        result.addAll(setToAdd.stream().sorted().collect(Collectors.toList()));
    }
}

