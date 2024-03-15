import java.util.Comparator;

public class Person {
	private int age;
	Person(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
}
class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person arg0, Person arg1) {
		return arg0.getAge() - arg1.getAge();
	}

	
}
