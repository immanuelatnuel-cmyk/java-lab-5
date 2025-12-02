public class Tree {

    public static void main(String[] args) {

        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("You must provide the tree length as an argument.");
            }

            int length = Integer.parseInt(args[0]);

            if (length < 0) {
                throw new IllegalArgumentException("Length cannot be negative.");
            }

            printTree(length);

        } catch (NumberFormatException e) {
            System.out.println("Error: You must enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void printTree(int length) {
        if (length <= 1) {
            System.out.println("*");
            return;
        }

        // Number of layers before the bottom root
        int layers = (length - 1) / 2;

        int stars = 1;
        int indent = layers;

        // Print top root
        System.out.println(" ".repeat(indent) + "*");

        stars = 3;
        indent--;

        // Each “layer” prints 2 identical rows
        for (int i = 0; i < layers; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(" ".repeat(indent) + "*".repeat(stars));
            }
            stars += 2;
            indent--;
        }

        // Print bottom root
        System.out.println(" ".repeat(indent + 1) + "*");
    }
}
