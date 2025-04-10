class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1; // We want to add 1

        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;

            if (sum < 10) {
                digits[i] = sum;
                carry = 0;
                break; // no need to continue
            } else {
                digits[i] = 0; // carry over to next digit
                carry = 1;
            }
        }

        // If carry is still 1, we need an extra digit at the front
        if (carry == 1) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1; // first digit is 1, rest are 0 by default
            return newDigits;
        }

        return digits;
    }
}