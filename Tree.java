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

        // Compute the maximum width of the tree
        int maxStars = 1; // start with top root width
        for (int i = 3; i <= length; i += 2) {
            maxStars += 2; // each body section adds 2 stars
        }

        // top root, centered
        System.out.println(" ".repeat(maxStars / 2) + "*");

        int stars = 3;   // initial width for first body section

        // print body sections
        for (int i = 3; i <= length; i += 2) {
            for (int j = 0; j < 2; j++) { // print each section twice
                int indent = (maxStars - stars) / 2; // center each line
                
                // Print all stars except the last one
                if (stars > 1) {
                    System.out.print(" ".repeat(indent));
                    System.out.print("*".repeat(stars - 1));
                    // Print the last star in the middle
                    System.out.println("*");
                } else {
                    System.out.println(" ".repeat(indent) + "*");
                }
            }
            stars += 2;
        }

        // bottom root, centered
        System.out.println(" ".repeat(maxStars / 2) + "*");
    }
}
