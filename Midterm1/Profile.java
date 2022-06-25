/**
 * Description: This is the profile class which stores
 * the data of a profile. This class utilizes getter and
 * setter methods to moddify/change the data in each
 * profile.
 *
 * Team Name: Falcon & The Winter Soldier
 * @authors Daiwik Swaminathan, Saravana Polisetti
 * @version 1.0
 */

import java.util.Iterator;

public class Profile
{
	private String name;
	private String status;
	private HashedDictionary<String, Profile> friends;
	
	public Profile()
	{
		name = "";
		status = "";
		friends = new HashedDictionary<String, Profile>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public HashedDictionary<String, Profile> getFriends()
	{
		return friends;
	}
	
	public void setName(String nameInput)
	{
		name = nameInput;
	}
	
	public void setStatus(String statusInput)
	{
		status = statusInput;
	}
	
	// ------------------------------------------------------------------------
	
	public boolean addFriend(String newFriendName, Profile newFriendProfile)
	{
		boolean success = false;
		if(newFriendName.equals(this.getName()))
			return false;
		else {
			friends.add(newFriendName, newFriendProfile);
			return true;
		}
	}
	
	public void removeFriend(String friendName)
	{
		friends.remove(friendName);
	}
	
	// ------------------------------------------------------------------------
	
	public void displayProfile() 
	{
        System.out.println("Name: " + name);
        System.out.println("Status: " + status);
        System.out.print("Friends: ");
        
        Iterator<String> i = friends.getKeyIterator();
        String name = "";
        while(i.hasNext()) {
        	name = i.next();

			if(i.hasNext()) {
				System.out.print(name + ", ");
			}

			else {
				System.out.println(name);
			}
		}
		System.out.println();
    }
}