package org.example;

public class RuleChecker {
    public static void main(String[] args) {
        String[] items = {"C0900A", "C0900B", "C0900C", "C0900D", "C0900Z"};

        // Example test case
        String c0900ZValue = "[0]";
        String[] c0900AtoDValues = {"[0]", "[0]", "[0]", "[0]"};
        boolean isValid = checkRules(c0900AtoDValues, c0900ZValue);
        System.out.println("Is valid: " + isValid);
    }

    public static boolean checkRules(String[] c0900AtoDValues, String c0900ZValue) {
        boolean isRuleValid = false;

        if (c0900AtoDValues.length == 4 && c0900ZValue.equals("[0]")) {
            // Rule a) If C0900Z = [0], then at least one item from C0900A through C0900D must equal [1]
            for (String item : c0900AtoDValues) {
                if (item.equals("[1]")) {
                    isRuleValid = true;
                    break;
                }
            }
        } else if (c0900AtoDValues.length == 4 && c0900ZValue.equals("[1]")) {
            // Rule b) If C0900Z = [1], then all items from C0900A through C0900D must equal [0]
            boolean allItemsEqualZero = true;
            for (String item : c0900AtoDValues) {
                if (!item.equals("[0]")) {
                    allItemsEqualZero = false;
                    break;
                }
            }
            isRuleValid = allItemsEqualZero;
        } else if (c0900AtoDValues.length == 4 && c0900ZValue.equals("[-]")) {
            // Rule c) If C0900Z = [-], then at least one item from C0900A through C0900D must equal [-]
            // and all remaining items must equal [0,-]
            boolean isAtLeastOneItemEqualDash = false;
            boolean areRemainingItemsValid = true;

            for (int i = 0; i < c0900AtoDValues.length; i++) {
                String item = c0900AtoDValues[i];
                if (item.equals("[-]")) {
                    isAtLeastOneItemEqualDash = true;
                } else if (i > 0 && !(item.equals("[0]") || item.equals("[-]"))) {
                    areRemainingItemsValid = false;
                    break;
                }
            }

            isRuleValid = isAtLeastOneItemEqualDash && areRemainingItemsValid;
        }

        return isRuleValid;
    }
}
