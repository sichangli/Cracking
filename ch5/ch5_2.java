import java.util.*;

public class ch5_2 {

	public static void main(String[] args) {
		printBR2(0.54);
	
	}

	public static void printBR(double d) {
		if (d <= 0 || d >= 1) {
			System.out.println("ERROR");
		}

		double temp = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		double count = 1;
		while (sb.length() <= 32) {
			double newTemp = temp + Math.pow(2.0, -count);
			if (newTemp == d) {
				sb.append('1');
				System.out.println(sb.toString());
				return;
			} else if (newTemp < d) {
				temp = newTemp;
				sb.append('1');
			} else {
				sb.append('0');
			}
			count++;
		}

	    System.out.println("ERROR");		
	}

	public static void printBR2(double d) {
		if (d <= 0 || d >= 1) {
			System.out.println("ERROR");
		}

		StringBuilder sb = new StringBuilder();
		sb.append("0.");

		while (d != 0) {
			d *= 2;
			if (d >= 1) {
				sb.append('1');
				d -= 1;
			} else {
				sb.append('0');
			}

			if (sb.length() > 32) {
				System.out.println("ERROR");
				return;
			}
		}
		System.out.println(sb.toString());

	}

}