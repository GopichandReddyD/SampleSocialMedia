package mediaMain;

/**
 * 
 * @author Uyen Tran, Linda Vuong
 * This class stores information about a user including name,
 * online status, and friend list.
 */

import java.util.Arrays;
import java.util.Scanner;

import graphs.UndirectedGraph;

public class Profile {
	// variables for the user's information
	private String name; // key
	private String password;
	private String onlineStatus; // value
	public LList<String> friendsList = new LList<String>(); // a string type linked list to store a list of friends by
															// their names

	UndirectedGraph<String> unDirectedGraph = new UndirectedGraph<String>();

	public Profile() {
		name = null;
		password = null;
		onlineStatus = null;
		friendsList = new LList<String>();
	} // End default constructor

	public Profile(String fullname, String userPassword, String status) {
		name = fullname;
		password = userPassword;
		onlineStatus = status;
	} // End constructor

	// setters and getters
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setOnlineStatus(String status) {
		this.onlineStatus = status;
	}

	public String getOnlineStatus() {
		return onlineStatus;
	}

	public LList getFriendsList() {
		return friendsList;
	}

	// To create a profile
	public void createAccount(LList<Profile> profileList, Profile profileDetails) {
		System.out.println("Hello. Please create a profile.");
		System.out.println("Enter your name: ");
		String userInput = new Scanner(System.in).nextLine();
		System.out.println("Create a password:");
		String password = new Scanner(System.in).nextLine();
		profileDetails = new Profile(userInput, password, "Online");
		profileList.add(profileDetails);
		System.out.println("Hi " + profileDetails.getName() + " ,your profile is created");
	}

	// This method is to add friends to the profile
	public void addFriend(String userName) {
		System.out.println("Enter friend's name: \n");
		String name = new Scanner(System.in).nextLine();
		if (friendsList.contains(name)) {
			System.out.println("Friend is already added.\n");
		} else {
			friendsList.add(name);
			System.out.println("You have added " + name + "\n");

		}
	}

	// using graphs in this method to count friends
	public void countFriends(Profile profileDetails) {
		String userName = profileDetails.getName();
		unDirectedGraph.addVertex(userName);

		LList<String> friendsList = profileDetails.getFriendsList();

		for (int i = 1; i <= friendsList.getLength(); i++) {

			String friendName = friendsList.getEntry(i);

			unDirectedGraph.addVertex(friendName);
			unDirectedGraph.addEdge(userName, friendName);
		}

		System.out.println("number of friends: " + unDirectedGraph.getNumberOfEdges());
	}

	// this method is used to remove a friend from the friends list
	public void removeFriend() {
		System.out.println("Here's your friends list:");
		displayFriendsList();
		System.out.println("Please enter the position you want to remove.\n");
		int position = new Scanner(System.in).nextInt();
		friendsList.remove(position);
		System.out.println("Friend is removed for your list.\n");
	}

	// this method prints all the friends list
	public void displayFriendsList() {
		if (friendsList.isEmpty()) {
			System.out.println("Your current friend list is empty.\n");
		} else {
			for (int i = 1; i <= friendsList.getLength(); i++) {
				System.out.println(i + ". " + friendsList.getEntry(i) + "\n");
			}
		}
	}

	// This method deletes the account
	public void deleteAccount() {
		name = null;
		password = null;
		onlineStatus = null;
		friendsList.clear();
		System.out.print("Your account is deleted.\n");
	}

	// changes the status
	public void changeOnlineStatus() {
		System.out.println("Choose a status option: ");
		System.out.println("1. Online");
		System.out.println("2. Offline");
		System.out.println("3. Busy\n");
		int statusOption = new Scanner(System.in).nextInt();
		if (statusOption == 1) {
			setOnlineStatus("Online");
			System.out.println("Your current status is " + getOnlineStatus() + "\n");
		} else if (statusOption == 2) {
			setOnlineStatus("Offline");
			System.out.println("Your current status is " + getOnlineStatus() + "\n");
		} else if (statusOption == 3) {
			setOnlineStatus("Busy");
			System.out.println("Your current status is " + getOnlineStatus() + "\n");
		} else {
			System.out.println("Invalid option. Returing to the menu.\n");
		}
	}

	// changes the user name
	public void changeName() {
		System.out.println("Please enter your new name: \n");
		String newName = new Scanner(System.in).nextLine();
		setName(newName);
		System.out.println("Your new name is " + getName() + "\n");
	}

	// Gets the mutual friends out
	// checks whether the person name you entered is the friend of mine
	// if yes it the method shows the friends list
	public void mutualFriends(LList<Profile> profileList) {
		System.out.println("Enter your friends name:");
		String name = new Scanner(System.in).nextLine();

		for (int i = 1; i < friendsList.getLength(); i++) {
			String currentFriendsName = friendsList.getEntry(i);
			if (name.equals(currentFriendsName)) {

				for (int j = 1; j < profileList.getLength(); j++) {
					if (name.equals(profileList.getEntry(j).getName())) {

						Profile friendProfile = profileList.getEntry(j);
						LList<String> friendsList = friendProfile.getFriendsList();

						for (int k = 1; k <= friendsList.getLength(); k++) {
							System.out.println(k + ". " + friendsList.getEntry(k) + "\n");
						}

					}

				}

			} else {
				System.out.println("The name you entered is not ur friend");
			}

		}
	}

}