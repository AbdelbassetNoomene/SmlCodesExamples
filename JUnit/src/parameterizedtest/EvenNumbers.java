package parameterizedtest;

public class EvenNumbers {
	public Boolean checkEven(final Integer num) {

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				return true;
			}
		}
		return false;
	}
}
