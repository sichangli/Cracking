import java.util.*;

public class ch17_14 {

	public static void main(String[] args) {
	}

	public static HashSet<String> dictionary = new HashSet<String>();

	// the idea is to try all the combinations
	// we can either break the current word or extend it to the next char
	public static Result parse(String sentence, int start, int end) {
		if (end >= sentence.length()) {
			return new Result(end - start, sentence.substring(start).toUpperCase());
		}

		String current = sentence.substring(start, end + 1);

		// break the current word
		Result brk = parse(sentence, end + 1, end + 1);

		if (!dictionary.contains(current)) {
			brk.invalid += current.length();
			brk.parsed = current.toUpperCase() + " " + brk.parsed;
		} else {
			brk.parsed = current + " " + brk.parsed;
		}

		// extend the current word
		Result ext = parse(sentence, start, end + 1);

		// find the min invalid
		return Result.min(brk, ext);

	}


}

class Result {
	int invalid;
	String parsed;

	public Result(int i, String p) {
		invalid = i;
		parsed = p;
	}

	public static Result min(Result r1, Result r2) {
		return r1.invalid < r2.invalid ? r1 : r2;
	}

}