import java.math.BigInteger;
public class fnv {
	public static long fon(byte[] c) {
		BigInteger h = new BigInteger("14695981039346656037");
		BigInteger r = new BigInteger("1099511628211");
		for (int i = 0; i < c.length; i++) {
			BigInteger d = BigInteger.valueOf(c[i]);
			h = d.xor((h.multiply(r))); 
		}
		return h.longValue();
	}
	public static void main(String[]args) {

		byte[] c = "Apple".getBytes();
		System.out.print("Apple: "  + fon(c));
	}
}
