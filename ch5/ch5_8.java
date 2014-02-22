import java.util.*;

public class ch5_8 {

	public static void main(String[] args) {
	}

	public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		int beginOfRow = (width / 8) * y;
		int firstByte = x1 / 8 + beginOfRow;
		int firstByteOffset = x1 % 8;
		int firstFullByte = firstByte + 1;

		int lastByte = x2 / 8 + beginOfRow;
		int lastByteOffset = x2 % 8;
		int lastFullByte = lastByte - 1;

		// set full bytes first
		for (int i = firstFullByte; i <= lastFullByte; i++) {
			screen[i] = (byte) 0xFF;
		}

		byte firstByteMask = (byte) (0xFF >> firstByteOffset);
		byte lastByteMask = (byte) (0xFF << lastByteOffset);

		screen[firstByte] |= firstByteMask;
		screen[lastByte] |= lastByteOffset;
	}

}