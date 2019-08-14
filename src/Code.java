public class Code {
    public static void main(String[] args) {
        char[] array = {'A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę',
                'F', 'G', 'H', 'I', 'J', 'K', 'L', 'Ł',
                'M', 'N', 'Ń', 'O', 'Ó', 'P', 'R', 'S',
                'Ś', 'T', 'U', 'W', 'Y', 'Z', 'Ź', 'Ż'};
        String message = "MĘŻNY BĄDŹ, CHROŃ PUŁK TWÓJ I SZEŚĆ FLAG";
        int shift = 3;
        String codedMessage = codeMessage(message, array, shift);
        System.out.println(codedMessage);
        System.out.println(decodedMessage(codedMessage, array, -shift));
    }

    private static String codeMessage(String message, char[] array, int shift) {
        String messageToUpperCase = message.toUpperCase();
        char[] messageArray = messageToUpperCase.toCharArray();
        char[] codedMessage = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            if (ifContainsNumberInAlphabet(messageArray[i], array) != -1) {
                int number = ifContainsNumberInAlphabet(messageArray[i], array);
                codedMessage[i] = array[properNumber(number, shift)];
            } else {
                codedMessage[i] = messageArray[i];
            }
        }
        return new String(codedMessage);
    }

    private static int ifContainsNumberInAlphabet(char letter, char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (letter == array[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int properNumber(int number, int shift) {
        if((number + shift) <= 31 && (number + shift) >= 0) {
            return number + shift;
        } else if ((number + shift) > 31) {
            return (number + shift) % 31 - 1;
        } else {
            return 31 - Math.abs(shift) + (number + 1);
        }
    }

    private static String decodedMessage(String codedMessage, char[] array, int shift) {
        return codeMessage(codedMessage, array, shift);
    }
}
