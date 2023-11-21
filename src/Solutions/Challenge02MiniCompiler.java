package Solutions;

public class Challenge02MiniCompiler {
    public static String miniCompiler(String input) {
        int numericValue = 0;
        StringBuilder output = new StringBuilder();

        for (char symbol : input.toCharArray()) {
            switch (symbol) {
                case '#':
                    numericValue++;
                    break;
                case '@':
                    numericValue--;
                    break;
                case '*':
                    numericValue = numericValue * numericValue;
                    break;
                case '&':
                    output.append(numericValue);
                    break;
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String input = "&###@&*&###@@##@##&######@@#####@#@#@#@##@@@@@@@@@@@@@@@*&&@@@@@@@@@####@@@@@@@@@#########&#&##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@&";
        System.out.println(miniCompiler(input));
    }
}
