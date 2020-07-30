import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s)
    {
        Stack<Integer> st = new Stack<>();

        int maxlen = 0;

        st.push(-1);

        for (int i = 0; i < s.length(); ++i)
        {
            char ch = s.charAt(i);

            if (ch == '(') st.push(i);

            else
            {
                // pop the bracket before the earliest valid
                st.pop();
                if (st.isEmpty()) st.push(i);
                else maxlen = Math.max(maxlen, i - st.peek());
            }
        }

        return maxlen;
    }
}
