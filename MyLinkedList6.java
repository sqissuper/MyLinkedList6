//判断回文
    public boolean chkPalindrome(Node A) {
        // write code here
        if(A == null) return false;
        Node fast = A;
        Node slow = A;
        //找到节点
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转slow后边节点
        Node cur = slow;
        while(cur != null){
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //判断是否是回文
        while(A != slow){
            if(A.val != slow.val){
                return false;
            }
            A = A.next;
            slow = slow.next;
        }
        //偶数情况下
        if(A.next.val == slow.val){
            return true;
        }
        return true;
    }
    //找到单链表相交的起始节点
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        Node pl = headA;
        Node ps = headB;
        while(pl != null){
            pl = pl.next;
            lenA++;
        }
        while(ps != null){
            ps = ps.next;
            lenB++;
        }
        int len = lenA - lenB;
        pl = headA;
        ps = headB;
        if(len < 0){
            len = lenB - lenA;
            while(len != 0){
                ps = ps.next;
                len--;
            }
        }else{
            while(len != 0){
                pl = pl.next;
                len--;
            }
        }
        while(pl != ps){
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }

    //给定一个链表，判断链表中是否有环
    public boolean hasCycle(Node head) {
        if(head == null){
            return false;
        }
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k < 0){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(k != 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            } else {
                fast = head;
                k--;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow == fast){
            return head;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        fast.next = head;
        head = tmp;

        return head;
    }