
public class TypesandRelationships {
	public static class U extends X implements G {
		U(){
		}
	}
	public static interface G{
	}
	public static class B extends X{
		B(){
		}
		
	}
	public static class Z extends U{
		Z(){	
		}
	}
	public static class X implements G{
		X(){
		}
	}
	public static void main (String[]args) {
		System.out.println("U u");
		System.out.println("X x");
		System.out.println("Z z");
		System.out.println("B b");
		System.out.println("G g");
		U u = new U();
		X x = new X();
		Z z = new Z();
		B b = new B();
		G g ;
		//Pass
		System.out.println("u = z");
		u = z; // z extends u
		System.out.println("x = b");
		x = b;  // b extends x
		System.out.println("g = u");
		g = u; // u implements g
		System.out.println("x = u");
		x = u;  // u extends x
		//Failed
		//u = b; 
		//x = g;
		//b = u;
		//z = u;
		//g = x;		
	}
}
