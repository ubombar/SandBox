import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        JoshepusProblem.runMe();                
    }
}

/*
public class Algorithms 
{
    public static void ZLol()
    {
        int[] array_one = new int[]{1, 2, 3};
        int[] array_two = new int[]{0, 0, 0};

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        for (int i = 0; i < array_one.length; i++)
        {
            ListNode tmp = l1.next;
            l1.next = new ListNode(array_one[array_one.length - 1 - i]);
            l1.next.next = tmp;
        }

        for (int i = 0; i < array_two.length; i++)
        {
            ListNode tmp = l2.next;
            l2.next = new ListNode(array_two[array_two.length - 1 - i]);
            l2.next.next = tmp;
        }


        Main m = new Main();
        ListNode s = m.addTwoNumbers(l1, l2);
        ListNode s_t = s;
        ListNode l1_t = l1;
        ListNode l2_t = l2;
        ArrayList<Integer> list_s = new ArrayList<Integer>();
        ArrayList<Integer> list_l1 = new ArrayList<Integer>();
        ArrayList<Integer> list_l2 = new ArrayList<Integer>();

        if (s_t != null)
            while (s_t.next != null)
            {
                list_s.add(s_t.val);
                s_t = s_t.next;
            }
        
        while (l1_t.next != null)
        {
            list_l1.add(l1_t.val);
            l1_t = l1_t.next;
        }

        while (l2_t.next != null)
        {
            list_l2.add(l2_t.val);
            l2_t = l2_t.next;
        }
        System.out.println(list_l1);
        System.out.println(list_l2);
        System.out.println();
        
        System.out.println(list_s);
    }
     
    public static boolean contains(int[] big, int[] small)
    {
        if (big.length < small.length)
            return false;
        
        int bp1 = 0;
        int bp2 = 0;
        int sp = 0;
        boolean inside = false;

        while (true)
        {
            if (sp == small.length)
                return true;
            
            if (bp1 == big.length)
                return false;

            if (big[bp1] == small[sp])
            {
                if (inside)
                {
                    bp1++;
                    sp++;
                }
                else 
                {
                    bp1++;
                    bp2 = bp1;
                    inside = true;
                    sp++;
                }
            }
            else 
            {
                if (inside)
                {
                    inside = false;
                    sp = 0;
                    bp1 = bp2;
                }
                else 
                {
                    bp1++;
                    bp2++;
                }
            }
        }
    }

    public static int containerONN(int[] con)
    {
        int p1 = 0;
        int p2 = 0;
        int area = 0;

        while (p1 < con.length)
        {
            p2 = p1 + 1;

            while (p2 < con.length)
            {                
                int tempArea = (p2 - p1) * (con[p1] < con[p2] ? con[p1] : con[p2]);

                if (area < tempArea)
                    area = tempArea;
                p2++;
            }
            p1++;
        }

        return area;
    }

    public static int containerON(int[] height)
    {
        int left = 0;
        int right = height.length - 1;
        int area = 0;

        while (left < right)
        {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right])
                left++;
            else    
                right--;
        }

        return area;
    }
    
    public static class ListNode
    {
        public ListNode next;
        public int val;

        public ListNode(int val) {this.val = val;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode ret_head = new ListNode(0); // This will be the head node
        int sum = 0;
        int carry = 0;
        int size = 0;
        
        // Translate lists to fixed sized.
        int size_l1 = 1;
        int size_l2 = 1;
        ListNode l1_t = l1;
        ListNode l2_t = l2;
        
        while (l1_t.next != null)
        {
            l1_t = l1_t.next;
            size_l1++;
        }
        
        while (l2_t.next != null)
        {
            l2_t = l2_t.next;
            size_l2++;
        }
        
        if (size_l1 > size_l2)
            l2 = insert(l2, 0, size_l1 - size_l2);
        else
            l1 = insert(l1, 0, size_l2 - size_l1);
        
        size = size_l1 > size_l2 ? size_l1 : size_l2;
        l1_t = l1;
        l2_t = l2; // Back to the original position.
        
        // ret node should contain extra head in case of an overflow.
        
        for (int i = 0; i < size; i++) // Sadly makes the function O(n**2)
        {
            for (int j = i; j < size - 2; j++) // For traversing
            {
                l1_t = l1_t.next;
                l2_t = l2_t.next;
            }
            
            sum = l1_t.val + l2_t.val + carry;
            carry = sum / 10;

            // System.out.print(sum);

            ListNode tmp = ret_head.next;
            ret_head.next = new ListNode(sum % 10);
            ret_head.next.next = tmp;
            
            l1_t = l1;
            l2_t = l2;
        }
        
        if (ret_head.val == 0)
            return ret_head.next;
        
        return ret_head;
    }
    
    public ListNode insert(ListNode node, int val, int count)
    {
        if (count == 0)
            return node;
        
        ListNode first = node;
        ListNode second = new ListNode(val);
        
        for (int i = 0; i < count; i++)
        {
            second.next = first;
            first = second;
            second = new ListNode(val);
        }
        return first;
    }
}

// */