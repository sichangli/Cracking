public class ch4_1 {

	public static void main(String[] args) {
		
	}

	public static Result checkBalance(TreeNode t) {
		if (t == null) {
			return new Result(0, true);
		}
		Result left = checkBalance(t.left);
		Result right = checkBalance(t.right);

		if (!left.balance || !right.balance) {
			return new Result(0, false);
		}

		if (Math.abs(left.height - right.height) > 1) {
			return new Result(0, false);
		}

		int height = Math.max(left.height, right.height) + 1;
		return new Result(height, true);
	}
}

class Result {
	int height;
	boolean balance;

	public Result(int h, boolean b) {
		height = h;
		balance = b;
	}
}