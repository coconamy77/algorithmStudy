package practice;

class ListNode{
	private String data;
	public ListNode link;
	
	public ListNode(String data) {
		this.data = data;
	}
	
	public ListNode(String data, ListNode link) {
		this.data = data;
		this.link = link;
	}
	
	public String getData() {
		return data;
	}
}

public class LinkedList {
	ListNode head = null;
	
	
	public void insert(ListNode preNode, String data) {
		//중간에 데이터 삽입
		 ListNode tmpNode = new ListNode(data);
		 if (preNode.link!=null) {
			 tmpNode.link = preNode.link;
		 }
		 preNode.link = tmpNode;
		
	}
	
	public void insert(String data) {
		//마지막에 데이터 추가
		ListNode tmpNode = head;
		if (tmpNode==null) {
			head = new ListNode(data);
		}
		
		else {
			while(true) {
				if (tmpNode.link==null){
					tmpNode.link = new ListNode(data);
					break;
				}
				tmpNode = tmpNode.link;
			}
		}
	}
	
	public void delete(String data) {
		
		ListNode tmpNode = head;
		if (tmpNode == null) {
			
		}else {
			while(true) {
				if (tmpNode.link==null){
					break;
				}
				if (tmpNode.link.getData().equals(data)) {
					tmpNode.link = tmpNode.link.link;
					break;
				}
				tmpNode = tmpNode.link;
			}
		}
		
	}
	public void delete() {
		ListNode tmp = head;
		if (tmp!=null) {
			while(tmp.link!=null) {
				if (tmp.link.link==null) {
					tmp.link = null;
				}else {
					tmp = tmp.link;
				}
			}
		}
	}
	
}
