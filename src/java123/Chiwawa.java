package java123;

public class Chiwawa extends Dog{

	public Chiwawa() {
		System.out.println("I'm a Chiwawa");
	}
	
	public void foo() {
		System.out.println("Chiwawa foo()");
	}
	
	public static void main(String[] args) {
		Dog dog = new Chiwawa();
		dog.foo();
	}
}
