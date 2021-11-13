import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Class06TaskD {
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
            if (firstIndex == size){
                size++;
            }

            int secondIndex = getOrCreate(size, names, line[1]);
            if (secondIndex == size){
                size++;
            }

            parents[firstIndex] = secondIndex;
        }

        List<Integer> result = new ArrayList<>();
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");
            int firstIndex = get(size, names, line[0]);
            int secondIndex = get(size, names, line[1]);
            int value = 0;
            if (firstIndex != -1 || secondIndex != -1) {
                if (isParent(parents, secondIndex, firstIndex)) {
                    value = 1;
                } else if (isParent(parents, firstIndex, secondIndex)) {
                    value = 2;
                }
            }
            result.add(value);
        }

        return new String[]{
                result.stream().map(String::valueOf).collect(Collectors.joining(" "))
        };
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

            if (childIndex == parentIndex){
                return true;
            }
        }

        return false;
    }
}

