import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class06TaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        Tree tree = new Tree();
        for (int i : Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray()) {
            if (i == 0) {
                break;
            }

            tree.add(i);
        }

        List<String> result = new ArrayList<>();
        if (isAbs(tree.root)) {
            result.add("YES");
        } else {
            result.add("NO");
        }

        return result.toArray(String[]::new);
    }

    private static class Tree {
        private Node root;

        public boolean add(Integer value) {
            if (root == null) {
                root = new Node();
                root.value = value;
                return true;
            } else {
                return root.add(value);
            }
        }

        public boolean contains(Integer value) {
            if (root == null) {
                return false;
            }

            return root.contains(value);
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "root=" + root +
                    '}';
        }
    }

    private static class Node {
        private Integer value;
        private Node left;
        private Node right;

        private boolean add(Integer value) {
            if (Objects.equals(this.value, value)) {
                return false;
            } else if (value < this.value) {
                if (left == null) {
                    left = new Node();
                    left.value = value;
                    return true;
                } else {
                    return left.add(value);
                }
            } else {
                if (right == null) {
                    right = new Node();
                    right.value = value;
                    return true;
                } else {
                    return right.add(value);
                }
            }
        }

        private boolean contains(Integer value) {
            if (Objects.equals(this.value, value)) {
                return true;
            } else if (this.value > value) {
                if (left != null) {
                    return left.contains(value);
                }
                return false;
            } else {
                if (right != null) {
                    return right.contains(value);
                }
                return false;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private static Collection<String> nodeToStrings(Tree tree) {
        if (tree.root == null) {
            return new ArrayList<>();
        }
        return nodeToStrings(tree.root, 0);
    }

    private static Collection<String> nodeToStrings(Node node, int level) {
        List<String> result = new ArrayList<>();
        if (node.left != null) {
            result.addAll(nodeToStrings(node.left, level + 1));
        }
        result.add(".".repeat(level) + node.value);
        if (node.right != null) {
            result.addAll(nodeToStrings(node.right, level + 1));
        }
        return result;
    }

    public static int getMaxLevel(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getMaxLevel(node.left), getMaxLevel(node.right)) + 1;
    }

    public static boolean isAbs(Node node) {
        if (node == null) {
            return true;
        }

        if (!isAbs(node.left) || !isAbs(node.right)) {
            return false;
        }

        return Math.abs(getMaxLevel(node.left) - getMaxLevel(node.right)) <= 1;
    }
}

