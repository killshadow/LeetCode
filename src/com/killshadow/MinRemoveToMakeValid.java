package com.killshadow;

class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == '(') {
                left++;
            } else if (s.charAt(right) == ')') {
                right--;
            } else {
                right--;
                left++;
            }

            if (s.charAt(left) == ')') {
                s = cutBracket(s, left);
                right--;
                continue;
            }
            if (s.charAt(right) == '(') {
                s = cutBracket(s, right);
                right--;
                continue;
            }

        }
        return s;
    }
// ))(( 会出现数组越界
    public String cutBracket(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1, str.length());
    }
}