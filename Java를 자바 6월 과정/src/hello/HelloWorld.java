package hello;

class Student {
	float x, y, z;
	String a;
	
	Student(String a, float x, float y, float z ){
		this.a = a;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void getAverage() {
		System.out.printf("%sÀÇ Æò±Õ Á¡¼ö: %f\n", a, (x + y + z)/3);
	}
	
}

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Student student1 = new Student("ÄÚ¹Â", 100, 80, 75);
		Student student2 = new Student("±èº¯¼ö", 96, 58, 90);
		
		student1.getAverage();
		student2.getAverage();
		
		
	}

}
