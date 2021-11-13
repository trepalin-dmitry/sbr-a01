import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Class06TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] names = new String[N];
        int[] parents = new int[N];
        Arrays.fill(parents, -1);

        int size = 0;
        for (int i = 1; i < N; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int firstIndex = getOrCreate(size, names, line[0]);
            if (firstIndex == size) {
                size++;
            }

            int secondIndex = getOrCreate(size, names, line[1]);
            if (secondIndex == size) {
                size++;
            }

            parents[firstIndex] = secondIndex;
        }

        List<String> result = new ArrayList<>();
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");
//            System.out.println("line = " + Arrays.toString(line));
            int firstIndex = get(size, names, line[0]);
//            System.out.println("firstIndex = " + firstIndex);
            int secondIndex = get(size, names, line[1]);
//            System.out.println("secondIndex = " + secondIndex);
            Collection<Integer> firstParents = getParents(firstIndex, parents, null);
//            System.out.println("firstParents = " + firstParents);
            int parentIndex = getParents(secondIndex, parents, firstParents::contains)
                    .stream()
                    .findFirst()
                    .orElseThrow();

//            System.out.println("parentIndex = " + parentIndex);

            result.add(names[parentIndex]);
        }

        return result.toArray(String[]::new);
    }

    private static int get(int size, String[] names, String name) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(names[i], name)) {
                return i;
            }
        }

        return -1;
    }

    private static int getOrCreate(int size, String[] names, String name) {
        int result = get(size, names, name);
        if (result != -1) {
            return result;
        }
        names[size] = name;
        return size;
    }

    private static boolean isParent(int[] parents, int childIndex, int parentIndex) {
        while (childIndex != -1) {
            childIndex = parents[childIndex];

            if (childIndex == parentIndex) {
                return true;
            }
        }

        return false;
    }

    private static List<Integer> getParents(int index, int[] parents, Function<Integer, Boolean> findFirstCondition) {
        List<Integer> result = new ArrayList<>();
        while (true) {
            if (index == -1) {
                break;
            }

            if (findFirstCondition != null){
                if (findFirstCondition.apply(index)) {
                    result.add(index);
                    break;
                }
            } else {
                result.add(index);
            }

            index = parents[index];
        }
        return result;
    }
}
