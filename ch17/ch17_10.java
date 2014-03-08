import java.util.*;

public class ch17_10 {

	public static void main(String[] args) {
	}

	public static String encode(Element e) {
		StringBuffer sb = new StringBuffer();
		if (null != e) {
			encode(e, sb);
		}

		return sb.toString();
	}

	private static void encode(Element e, StringBuffer sb) {
		// append the code
		sb.append(e.tag).append(" ");

		// append attributes
		for (Attribute attr : e.attributes) {
			sb.append(attr.tag).append(" ");
			sb.append(attr.value).append(" ");
		}

		//append 0
		sb.append("0 ");

		// append children or value
		if (null == e.value) {
			for (Element c : e.children) {
				encode(c, sb);
			}
		} else {
			sb.append(e.value).append(" ");
		}

		//append 0
		sb.append("0 ");
	}

	class Element {
		int tag;
		ArrayList<Attribute> attributes;
		ArrayList<Element> children;
		String value; // null if it has children
	}

	class Attribute {
		int tag;
		String value;
	}

}