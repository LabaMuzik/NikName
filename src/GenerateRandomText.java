import java.util.Random;

public class GenerateRandomText {
    private static int randomValue = 3;
    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static String [] generateNames(int arrayLength,String letters){
        Random random = new Random();
        String[] texts = new String[arrayLength];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText(letters, randomValue + random.nextInt(randomValue));
        }
        return texts;

    }
}
