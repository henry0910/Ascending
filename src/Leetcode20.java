import java.util.Stack;

public class Leetcode20 {
    // TLE
//    public boolean isValid(String s)
//    {
//        return isValid(s, 0, s.length() - 1);
//    }
//
//    private boolean isValid(String s, int left, int right)
//    {
//        if (left > right) return true;
//        if (left == right) return false;
//
//        char leftCh = s.charAt(left);
//        char rightCh = s.charAt(right);
//
//        if (isMatch(leftCh, rightCh) && isValid(s, left + 1, right - 1))
//            return true;
//
//        for (int i = left; i < right; ++i)
//        {
//            if (isValid(s, left, i) && isValid(s, i + 1, right))
//                return true;
//        }
//
//        return false;
//    }
//
    private boolean isMatch(char left, char right)
    {
        return (left == '(' && right == ')')
                || (left == '[' && right == ']'
                || (left == '{' && right == '}'));
    }


    public boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray())
        {
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else
            {
                if (st.isEmpty()) return false;
                char last = st.peek();
                if (isMatch(last, ch)) st.pop();
                else return false;
            }
        }

        return st.isEmpty();
    }
}
