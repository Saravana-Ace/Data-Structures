/**
 * Description: This program is a simple implementation
 * of a social network. We have utilized the Hashed Dictionary
 * data structure to map the different profiles and their data.
 *
 * Team Name: Falcon & The Winter Soldier
 * @authors Daiwik Swaminathan, Saravana Polisetti
 * @version 1.0
 */

import java.util.Scanner;
import java.util.Iterator;

public class SimpleSocialNetwork
{
	private HashedDictionary<String, Profile> networkOfProfiles;
	
	public static void main(String[] args)
	{
		SimpleSocialNetwork network = new SimpleSocialNetwork();
		network.run();
	}
	
	public SimpleSocialNetwork()
	{
		networkOfProfiles = new HashedDictionary<String, Profile>();
	}
	
	public void run()
	{
		String userOption = "";
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Please choose an option shown below:");
		System.out.println("Join the network - Enter J");
		System.out.println("Leave the network - Enter Q\n");
			
		userOption = scanner.next();
		
		while(!userOption.toUpperCase().equals("Q")) //  != "Q"
		{
			if(userOption.toUpperCase().equals("J")) //  != "J"
			{
				userOption = userJoinedNetwork(scanner);
			}
			else
			{
				System.out.println("Please enter a valid option.\n");
				
				System.out.println("Please choose an option shown below:");
				System.out.println("Join the network - Enter J");
				System.out.println("Leave the network - Enter Q\n");
			
				userOption = scanner.next();
			}
		}
	}
	
	public String userJoinedNetwork(Scanner scanner)
	{
		String userOption = "";
		
		System.out.println("Welcome to the simple social network!\n");
		System.out.println("These are the profiles in the system: "); // will show all the added profiles
		DisplayAllProfiles();
		System.out.println("\nPlease choose an option shown below:");
		System.out.println("Search for a profile - Enter S");
		System.out.println("Edit a profile - Enter E");
		System.out.println("Add a profile - Enter A");
		System.out.println("Remove a profile - Enter R");
		System.out.println("Leave the network - Enter Q\n");
		
		userOption = scanner.next();
		
		while(!userOption.toUpperCase().equals("Q"))
		{
			if(userOption.toUpperCase().equals("S"))
			{
				System.out.print("Who would you like to search for?: ");
				searchProfile(scanner);
			}
			else if(userOption.toUpperCase().equals("A"))
			{
				Profile newProfile = new Profile();
				
				System.out.print("\nWhat is the name of the new profile?: ");
				scanner.nextLine();
				userOption = scanner.nextLine();
				newProfile.setName(userOption);
				
				System.out.print("What is the status of the new profile?: ");
				userOption = scanner.nextLine();
				newProfile.setStatus(userOption);
				
				System.out.println("Here is the information of the new profile:");
				newProfile.displayProfile();
				
				networkOfProfiles.add(newProfile.getName(), newProfile);
				System.out.println("Profile successfully added to the network.\n");
				
				//networkOfProfiles.displayHashTable();
			}
			else if(userOption.toUpperCase().equals("R"))
			{
				System.out.print("\nWhat is the name of the profile you want to remove?: ");
				scanner.nextLine();
				userOption = scanner.nextLine();
				
				if(networkOfProfiles.remove(userOption) != null)
				{
					System.out.println("Profile successfully removed from the network.\n");
				}
				else
				{
					System.out.println("This profile does not exist.\n");
				}
			}
			else if(userOption.toUpperCase().equals("E"))
			{
				System.out.print("Whose profile would you like to edit?: ");
				Profile profileToEdit = searchProfile(scanner);
				if(profileToEdit != null)
				{
					editProfile(profileToEdit, scanner);
				}
			}
			else
			{
				System.out.println("Please enter a valid option.\n");
			}
			
			System.out.println("\nPlease choose an option shown below:");
			System.out.println("These are the profiles in the system: "); // will show all the added profiles
			DisplayAllProfiles();
			System.out.println("\nSearch for a profile - Enter S");
			System.out.println("Edit a profile - Enter E");
			System.out.println("Add a profile - Enter A");
			System.out.println("Remove a profile - Enter R");
			System.out.println("Leave the network - Enter Q\n");
			
			userOption = scanner.next();
		}
		
		return userOption;
	}

	public void DisplayAllProfiles() {
		Iterator<String> profiles = networkOfProfiles.getKeyIterator();
		String name = "";

		while(profiles.hasNext()) {
			name = profiles.next();

			if(profiles.hasNext()) {
				System.out.print(name + ", ");
			}
			else {
				System.out.println(name);
			}
		}
	}
	
	public Profile searchProfile(Scanner scanner)
	{
		String userOption = "";
		scanner.nextLine();
				
		userOption = scanner.nextLine();
		
		//System.out.println("userOption is " + userOption);
		
		if(networkOfProfiles.contains(userOption))
		{
			networkOfProfiles.getValue(userOption).displayProfile();
		}
		else
		{
			System.out.println("This profile does not exist.\n");
		}
		return networkOfProfiles.getValue(userOption);
	}
	
	public void editProfile(Profile profileToEdit, Scanner scanner)
	{
		String userOption = "";
		//scanner.nextLine();
		
		System.out.println("\nPlease choose an option shown below:");
		System.out.println("Change the profile name - Enter N");
		System.out.println("Change the profile status - Enter S");
		System.out.println("Add a friend - Enter A");
		System.out.println("Remove a friend - Enter R");
		System.out.println("I am done editing this profile - Enter D\n");
		
		userOption = scanner.next();
		
		while(!userOption.toUpperCase().equals("D"))
		{
			if(userOption.toUpperCase().equals("N"))
			{
				System.out.print("\nWhat is the new name of the profile?: ");
				//scanner.nextLine();
				String newName = scanner.next();
				Profile newProf = new Profile();
				newProf.setName(newName);
				String status = networkOfProfiles.remove(profileToEdit.getName()).getStatus();
				newProf.setStatus(status);
				networkOfProfiles.add(newName, newProf);
				System.out.println("Name successfully changed.");
			}
			else if(userOption.toUpperCase().equals("S"))
			{
				System.out.print("What is the status of the new profile?: ");
				userOption = scanner.next();
				profileToEdit.setStatus(userOption);
				System.out.println("Status successfully changed.");
			}
			else if(userOption.toUpperCase().equals("A"))
			{
				System.out.print("Who is the friend you would like to add for this profile?: ");
				Profile friendToAdd = searchProfile(scanner);
				if(friendToAdd != null)
				{
					boolean success = false;
					success = profileToEdit.addFriend(friendToAdd.getName(), friendToAdd);

					if(success == true)
						System.out.println("Friend successfully added.");
					else {
						System.out.println("Sorry, you can't be friends with yourself!\n");
					}
				}
			}
			else if(userOption.toUpperCase().equals("R"))
			{
				System.out.print("Who is the friend you would like to remove from this profile?: ");
				Profile friendToRemove = searchProfile(scanner);
				if(friendToRemove != null)
				{
					profileToEdit.removeFriend(friendToRemove.getName());
					System.out.println("Friend successfully removed.");
				}
			}
			else
			{
				System.out.println("Please enter a valid option.\n");
			}
			
			System.out.println("Please choose an option shown below:");
			System.out.println("Change the profile name - Enter N");
			System.out.println("Change the profile status - Enter S");
			System.out.println("Add a friend - Enter A");
			System.out.println("Remove a friend - Enter R");
			System.out.println("I am done editing this profile - Enter D\n");
		
			userOption = scanner.next();
		}
	}
}
