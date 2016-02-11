package fanXing;

//define fanXing class
public class Point<T1,T2> {
	T1 x;
	T2 y;
	public T1 getX() {
		return x;
	}
	public void setX(T1 x) {
		this.x = x;
	}
	public T2 getY() {
		return y;
	}
	public void setY(T2 y) {
		this.y = y;
	}
	
	public static void main(String[] args){
		Point<Integer,Integer> p1 = new Point<>();
		p1.setX(1);
		p1.setY(2);
		System.out.println("This point is :" + p1.getX() +"," + p1.getY());
		p1.printPoint(p1.getX(), p1.getY());
		
		Point<Integer,String> p2 = new Point();
		p2.setX(1);
		p2.setY("hello");
		System.out.println("This point is :" + p2.getX() +"," + p2.getY());
		
		p2.printPoint(p2.getX(), p2.getY());
		
	}
	
	//define fanXing method
	public <T1,T2> void printPoint(T1 x,T2 y){
		System.out.println("This point is :" + x + "," + y);
	}
	
}
