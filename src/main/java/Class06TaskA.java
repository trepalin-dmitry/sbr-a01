import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class06TaskA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (String s : calc(bufferedReader)) {
            System.out.println(s);
        }
    }

    public static String[] calc(BufferedReader bufferedReader) throws IOException {
        List<String> result = new ArrayList<>();

        Tree tree = new Tree();
        while (bufferedReader.ready()) {
            String[] line = bufferedReader.readLine().split(" ");
            String type = line[0];
            switch (type) {
                case ("ADD"):
                    if (tree.add(Integer.valueOf(line[1]))) {
                        result.add("DONE");
                    } else {
                        result.add("ALREADY");
                    }
                    break;
                case ("SEARCH"):
                    if (tree.contains(Integer.valueOf(line[1]))) {
                        result.add("YES");
                    } else {
                        result.add("NO");
                    }
                    break;
                case ("PRINTTREE"):
                    result.addAll(nodeToStrings(tree.root, 0));
                    break;
            }
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
}