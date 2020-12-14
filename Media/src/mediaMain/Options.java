package mediaMain;

import java.util.Scanner;

import graphs.DirectedGraph;
import graphs.UndirectedGraph;

public class Options {

	public static void main(String[] args) {
		LList<Profile> profileList = new LList<Profile>();
		Profile profileDetails = new Profile();
		int choice = 0;

		while (choice >= 0 && choice < 3) {
			System.out.println("Please choose an option: ");
			System.out.println("1. Create acc");
			System.out.println("2. login");

			choice = new Scanner(System.in).nextInt();

			if (choice == 1) {
				profileDetails.createAccount(profileList, profileDetails);

			} else if (choice == 2) {
				System.out.println("Enter your user name: ");
				String userInput = new Scanner(System.in).nextLine();

				for (int i = 1; i <= profileList.getLength(); i++) {
					profileDetails = profileList.getEntry(i);

					if (userInput.equals(profileDetails.getName())) {
						System.out.println("please enter your password: ");
						String password = new Scanner(System.in).nextLine();

						if (password.equals(profileDetails.getPassword())) {

							System.out.println("Hi " + userInput + "Your current online status is "
									+ profileDetails.getOnlineStatus());

							System.out.println("Welcome to your personal page. Enter 1 to continue.");
							choice = new Scanner(System.in).nextInt();
							if (choice == 1) {
								while (choice > 0 && choice < 10) {
									System.out.println("Please choose an option: ");
									System.out.println("1. Add new friend");
									System.out.println("2. Remove friend");
									System.out.println("3. Change online status");
									System.out.println("4. Show friends list");
									System.out.println("5. Change my user name");
									System.out.println("6. Delete my account");
									System.out.println("7. log out");
									System.out.println("8. See friends of your friend");
									System.out.println("9. see number of friends");
									System.out.println("Enter anything else to exit.\n");
									choice = new Scanner(System.in).nextInt();

									if (choice == 1) {
										profileDetails.addFriend(profileDetails.getName());

									} else if (choice == 2) {
										profileDetails.removeFriend();
									} else if (choice == 3) {
										profileDetails.changeOnlineStatus();
									} else if (choice == 4) {
										profileDetails.displayFriendsList();
									} else if (choice == 5) {
										profileDetails.changeName();
									} else if (choice == 6) {
										profileDetails.deleteAccount();
										choice = 0;
									} else if (choice == 7) {
										System.out.println("logged out succesfully");
										choice = 0;
									} else if (choice == 8) {
										profileDetails.mutualFriends(profileList);

									} else if (choice == 9) {
										profileDetails.countFriends(profileDetails);
									}
								}
							} else {
								System.out.println("Exiting...\n");
								return;
							}
						} else {
							System.out.println("wrong password");
						}
					}
				}
			}
		}
	}
}
