public class TreeDrawer {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.err.println("Usage: java TreeDrawer <length>");
                return;
            }

            int length;
            try {
                length = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Error: Must be an integer.");
                return;
            }

            if (length < 0) {
                System.err.println("Error: No negetivity bro.");
                return;
            }

            if (length <= 1) {
                System.out.println("*");
                return;
            }

            int bodyLines = length - 2;
            int[] widths = new int[bodyLines];

            int currentWidth = 3;
            int repeat = 0;
            int maxWidth = 1;

            for (int i = 0; i < bodyLines; i++) {
                widths[i] = currentWidth;

                if (currentWidth > maxWidth)
                    maxWidth = currentWidth;

                repeat++;
                if (repeat == 2) {
                    currentWidth += 2;
                    repeat = 0;
                }
            }

            System.out.println(center("*", maxWidth));

            for (int w : widths) {
                System.out.println(center(repeatChar('*', w), maxWidth));
            }

            System.out.println(center("*", maxWidth));

        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private static String repeatChar(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(c);
        return sb.toString();
    }

    private static String center(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text;
    }
}
