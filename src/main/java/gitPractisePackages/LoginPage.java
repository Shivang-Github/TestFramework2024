package gitPractisePackages;

public class LoginPage {

	public static void main(String[] args) {

		System.out.println("this is the page logic");

		String username = "Ravi";

		int size = username.length();

		if (size != 0) {

			System.out.println("its correct username");
		} else {

			System.out.println("user not found");

		}

	}

}
