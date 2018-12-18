package ss.week1;

public class Student {

	int score = 60;
	
	private boolean passed() {
		if (score >= 70) {
			System.out.println("You passed!");
			return true;
		}
		System.out.println("You failed!");
		return false;
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		student.passed();
	}
}
