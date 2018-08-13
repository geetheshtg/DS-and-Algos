import java.util.Scanner;
 
 class QueueTest {
	public static void RoundRobin(int count, int CPUtime, String input, int qsize){
		String[] times = input.split(" ");
		Queue<Integer> Q =new QueueArray<Integer>();
		
		for(int i=0 ;i<count && i < qsize;i++ ){
			
			int temp=Integer.parseInt(times[i]);
			Q.enqueue(temp);
		}
		while(!Q.isEmpty()){
			//Your logic of Round Robin Algorithm
			int c=Q.dequeue();
			System.out.print(c+":");
			if(!((c-CPUtime)<=0))
			{
				Q.enqueue(c-CPUtime);
			}
		}
		System.out.println();	//to separate outputs of each testcase
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CapacityGetterSetter getset = new CapacityGetterSetter();
		int testcases = Integer.parseInt(scan.nextLine());
		
 
		for(int i=0; i<testcases; i++){
			int queuesize = Integer.parseInt(scan.nextLine());
			getset.setCapacity(queuesize);
			int numberOfProcesses = Integer.parseInt(scan.nextLine());
			int CPUexecutionTime = Integer.parseInt(scan.nextLine());
			
			String input = scan.nextLine(); //Collecting run times
			RoundRobin(numberOfProcesses,CPUexecutionTime, input, queuesize);
		}
		
	}
}
 
interface Queue<E> {
int size();
boolean isEmpty();
void enqueue(E e);
E dequeue();
E front();
void printQueue();
//void RoundRobin(int count, int CPUtime, String input);
}
 
class CapacityGetterSetter {
	private static int queuecap;
 
	public int getCapacity() {
		return this.queuecap;
	}
 
	public void setCapacity(int cap) {
		queuecap = cap;
	}
}
 
class QueueArray<E> implements Queue<E> {
 
	CapacityGetterSetter getset = new CapacityGetterSetter();
 
	int CAPACITY=0;
	private E[] data;
	private int f=0;
	private int r=-1;
	private int sz=0;
 
	public QueueArray() {
		CAPACITY = getset.getCapacity();
		data= (E[]) new Object[CAPACITY];
	}
	public int size() {
		return sz;
	}
 
	public boolean isEmpty() {
		return(size()==0);
	}
 
	public void enqueue(E e){
		if(sz==CAPACITY)
		{
			//System.out.println("QueueFullException");
			return;
		}
		else{
			r=(r+1)%CAPACITY;
			data[r]=e;
			sz++;
		}
	}
	public E dequeue() {
        if(!isEmpty()){
    		E temp= data[f];
    		data[f]=null;
    		f=(f+1)%CAPACITY;
    		sz--;
    		return temp;
        }
        else{
            System.out.println("QueueEmptyException");
			return null;
        }
	}
 
	public E front() {
		if(isEmpty()){
			System.out.println("QueueEmptyException");
			return null;
		}
		else{
			return data[f];
		}
	}
 
	public void printQueue(){
		for (int i=0;i<CAPACITY;i++){
			System.out.print(data[i] + ":");
		}
		System.out.print("\n");
	}
 
	
} 
