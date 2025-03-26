import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class practice{
    public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a.val));

    for (final ListNode list : lists)
      if (list != null)
        minHeap.offer(list);

    while (!minHeap.isEmpty()) {
      ListNode minNode = minHeap.poll();
      if (minNode.next != null)
        minHeap.offer(minNode.next);
      curr.next = minNode;
      curr = curr.next;
    }

    return dummy.next;
  }
  public static void main(String[] args) {
    practice p = new practice();
    ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode l3 = new ListNode(2, new ListNode(6));
    ListNode[] lists = new ListNode[]{l1, l2, l3};
    ListNode result = p.mergeKLists(lists);
    while(result != null){
        System.out.print(result.val + " ");
        result = result.next;
    }
  }
}