import java.util.*;

public class ch9_10 {

	public static void main(String[] args) {

	}


	public static ArrayList<Box> createStack(Box[] boxes) {
		HashMap<Box, ArrayList<Box>> map = new HashMap<Box, ArrayList<Box>>();
		return helper(boxes, boxes[0], map);
	}



	private static ArrayList<Box> helper(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> map) {
		if (map.containsKey(bottom)) {
			return map.get(bottom);
		}

		int maxHeight = 0;
		ArrayList<Box> maxStack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (bottom.canBeAbove(boxes[i])) {
				ArrayList<Box> newStack = helper(boxes, boxes[i], map);
				int newHeight = getHeight(newStack);
				if (newHeight > maxHeight) {
					maxHeight = newHeight;
					maxStack = newStack;
				}
			}
		}

		if (maxStack == null) {
			maxStack = new ArrayList<Box>();
		}

		maxStack.add(0, bottom);

		// can cache the result
		map.put(bottom, maxStack);

		return maxStack;
	}

	private static int getHeight(ArrayList<Box> stack) {
		if (stack == null)
			return 0;

		int height = 0;
		for (Box b : stack) {
			height += b.getHeight();
		}

		return height;
	}

}

class Box {
	private int width;
	private int height;
	private int depth;

	public boolean canBeAbove(Box a) {
		return a.width < width && a.height < height && a.depth < depth;
	}

	public int getHeight() {
		return height;
	}
}