import java.util.*;

public class ch5_6 {

	public static void main(String[] args) {
							
	}

	// the idea is to create 2 masks
	public static int swap(int n) {
		return (((n & 0x55555555) << 1)  |  ((n & 0xaaaaaaaa) >> 1));
	}

}