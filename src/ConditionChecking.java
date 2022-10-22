import java.util.Arrays;

public class ConditionChecking {
    public boolean palindrome(String name) {
        StringBuilder sb = new StringBuilder(name);
        sb.reverse();
        return name.equals(sb.toString());
    }

    public boolean single(String name) {
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != name.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public boolean sortedName(String name) {
        char[] array = name.toCharArray();
        Arrays.sort(array);
        String sorted = String.valueOf(array);
        return name.equals(sorted);
    }
}
