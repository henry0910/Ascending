import java.util.Stack;

public class Leetcode678 {
//    public boolean checkValidString(String s)
//    {
//        Stack<Integer> open = new Stack<>();
//        Stack<Integer> asterisk = new Stack<>();
//
//        for (int i = 0; i < s.length(); ++i)
//        {
//            char ch = s.charAt(i);
//
//            if (ch == '(') open.push(i);
//            else if (ch == '*') asterisk.push(i);
//            else
//            {
//                if (!open.isEmpty()) open.pop();
//                else if (!asterisk.isEmpty()) asterisk.pop();
//                else return false;
//            }
//        }
//
//        while (!open.isEmpty() && !asterisk.isEmpty()) {
//            if (open.peek() > asterisk.peek()) return false;
//            else
//            {
//                open.pop();
//                asterisk.pop();
//            }
//        }
//
//        return open.isEmpty();
//    }


    boolean[][] dp;
    public boolean checkValidString(String s)
    {
        int l = s.length();
        dp = new boolean[l][l];

        return isValid(s, 0, l - 1);
    }

    private boolean isValid(String s, int left, int right)
    {
        if (left > right) return true;

        if (dp[left][right]) return dp[left][right];

        if (left == right)
        {
            dp[left][right] = (s.charAt(left) == '*');
            return dp[left][right];
        }

        if ((s.charAt(left) == '(' || s.charAt(left) == '*') && (s.charAt(right) == ')' || s.charAt(right) == '*') && isValid(s, left + 1, right - 1))
        {
            dp[left][right] = true;
            return dp[left][right];
        }

        for (int br = left; br < right; ++br)
        {
            if (isValid(s, left, br) && isValid(s, br + 1, right))
            {
                dp[left][right] = true;
                return dp[left][right];
            }
        }

        return dp[left][right] = false;
    }

}
