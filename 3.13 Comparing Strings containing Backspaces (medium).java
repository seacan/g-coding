package com.solution;

// Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
public class Main {
    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int nextIndex1 = validNextIndex(str1, index1);
            int nextIndex2 = validNextIndex(str2, index2);

            if (nextIndex1 < 0 && nextIndex2 < 0) return true;
            if (nextIndex1 < 0 || nextIndex2 < 0) return false;
            if (str1.charAt(nextIndex1) != str2.charAt(nextIndex2)) return false;

            index1 = nextIndex1 - 1;
            index2 = nextIndex2 - 1;
        }
        return true;
    }

    // separate function to get valid next char
    public static int validNextIndex(String str, int curIndex) {
        int spaceCount = 0;
        while (curIndex >= 0) {
            if (str.charAt(curIndex) == '#') {
                spaceCount++;
                curIndex--;
            } else if (spaceCount > 0) {
                spaceCount--;
                curIndex--;
            } else break;
        }
        return curIndex;
    }

    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#"));
        System.out.println(compare("xy#z", "xyz#"));
        System.out.println(compare("xp#", "xyz##"));
        System.out.println(compare("xywrrmp", "xywrrmu#p"));
        System.out.println(compare("#abc", "abc"));
    }
}
