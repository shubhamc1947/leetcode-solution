import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;

        // Define valid categories and their sorting priority
        Map<String, Integer> categoryPriority = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        List<String[]> validCoupons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isActive[i] && isValidCode(code[i]) && categoryPriority.containsKey(businessLine[i])) {
                validCoupons.add(new String[]{code[i], businessLine[i]});
            }
        }

        // Sort by category priority, then by code lexicographically
        validCoupons.sort((a, b) -> {
            int cmp = Integer.compare(categoryPriority.get(a[1]), categoryPriority.get(b[1]));
            return cmp != 0 ? cmp : a[0].compareTo(b[0]);
        });

        // Extract sorted codes
        List<String> result = new ArrayList<>();
        for (String[] entry : validCoupons) {
            result.add(entry[0]);
        }

        return result;
    }

    private boolean isValidCode(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') return false;
        }
        return true;
    }
}
