 import java.util.*;
        import java.io.*;
        class test {
        	public static void main(String args[])throws IOException {
        		DLL<Integer> list = new Doubly<Integer>();
        		Scanner sc=new Scanner(System.in);
        		InputStreamReader in = new InputStreamReader(System.in);
        		BufferedReader br = new BufferedReader(in);
        		int test= Integer.parseInt(br.readLine());
        		int inp= Integer.parseInt(br.readLine());
        		for(int j=0;j<test;j++) {
        			for(int i=0;i<inp;i++) {
        				String s = br.readLine();
        				String temp[] = s.split(" ");
        				if(temp[0].equals("I")) {
        					System.out.println(list.isEmpty());
        				}
        				if(temp[0].equals("S")) {
        					System.out.println(list.size());
        				}
        				if(temp[0].equals("AF")) {
        					list.addFirst(Integer.parseInt(temp[1]));
        					list.print();
        				}
        				if(temp[0].equals("AL")) {
        					list.addLast(Integer.parseInt(temp[1]));
        					list.print();
        				}
        				if(temp[0].equals("RF")) {
        					list.remFirst();
        					list.print();
        				}
        				if(temp[0].equals("RL")) {
        					list.remLast();
        					list.print();
        					
        				}
        				if(temp[0].equals("L")) {
        					System.out.println(list.last());
        				}
         
        				if(temp[0].equals("F")) {
        					System.out.println(list.first());
        				}
        				if(temp[0].equals("FIND")) {
        					list.find(Integer.parseInt(temp[1]));
        				}
        			}
        		}
        	}
        }
         
        interface DLL<E> {
        	
        	Object getHead();
        	E first();
        	E last();
        	Object getTail();
        	void addFirst(E e);
        	void addLast(E e);
        	void remFirst();
        	void remLast();
        	void print();
        	void find(E e);
        	int size();
        	boolean isEmpty();
        }
         
        class Node<E> {
         
        	E element;
        	Node<E> next;
        	Node<E> prev;
        	public Node() {
        		element = null;
        		next = null;
        		prev = null;
        	}
        	public Node(E e, Node<E> n, Node<E> p) {
        		element = e;
        		next = n;
        		prev = p;
        	}
        	Node<E> getNext(){
        		return next;
        	}
        	Node<E> getPrev(){
        		return next;
        	}
        	E getEl() {
        		return element;
        	}
        	void setNext(Node<E> n) {
        		next=n;
        	}
        	void setPrev(Node<E> p) {
        		prev=p;
        	}
        }
         
        class Doubly<E> implements DLL<E>{
        	Node<E> head=null;
        	Node<E> tail=null;
        	int sz=0;
        	
        	public E first() {
        		return head.getEl();
        	}
        	
        	public E last() {
        		return tail.getEl();
        	}
        	public Object getHead() {
        		// TODO Auto-generated method stub
        		return head;
        	}
         
        	
        	public Object getTail() {
        		// TODO Auto-generated method stub
        		return tail;
        	}
         
       
        	public void addFirst(E e) {
        		Node<E> temp = new Node<E>(e,null,null);
        		if(sz==0) {
        			head=temp;
        			tail=head;
        			sz++;
        			return;
        		}
        		temp.next=head;
        		head.prev=temp;
        		head=temp;
        		sz++;
        		
        	}
       
        	public void addLast(E e) {
        		Node<E> temp = new Node<E>(e,null,null);
        		if(sz==0) {
        			head=temp;
        			tail=head;
        			sz++;
        			return;
        		}
        		tail.next=temp;
        		temp.prev=tail;
        		tail=temp;
        		sz++;
        		
        	}
        	public void remFirst() {
        		if(sz==0) {
        			System.out.println("ListEmptyException");
        			return;
        		}
        		if(sz==1) {
        			E e=head.getEl();
        			head=head.next;
        			sz--;
        			return;
        		}
        		E e=head.getEl();
        		head=head.next;
        		head.prev=null;
        		sz--;
        		return;
        	}
         
        	
        	public void remLast() {
        		if(sz==0) {
        			System.out.println("ListEmptyException");
        			return;
        		}
        		if(sz==1) {
        		    E e=tail.getEl();
        		    tail=tail.prev;
        			sz--;
        			return;
        		}
        		E e=tail.getEl();
        		tail=tail.prev;
        		tail.next=null;
        		sz--;
        		return;
        	}
         
        	
        	public void print() {
        		if (size()==0) {
        			System.out.println("List Empty");
        		}
        		else {
        			Node<E> temp = head;
        			while (temp != null) {
        				System.out.print(temp.getEl() + "->");
        				temp = temp.getNext();
        			}
        			System.out.print("null\n");
        			temp = tail;
        			while (temp != null) {
        				System.out.print(temp.getEl() + "->");
        				temp = temp.prev;
        			}
        			System.out.print("null\n");
        		}
        	}
         
               	public void find(E e) {
        		Node<E> p=head;
        		for(int i=0;i<sz;i++) {
        			if(p.element==e) {
        				System.out.println(p.element);
        				return;
        			}
        			p=p.next;
        		}
        		System.out.println("null");
        		return ;
        	}
         
               	public int size() {
        		return sz;
        	}
         
        	public boolean isEmpty() {
        		return sz==0;
        	}
        	
        }    
