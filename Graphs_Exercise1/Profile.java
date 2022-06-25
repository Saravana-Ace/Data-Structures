/**
 * Description: This is the profile class which stores
 * the data of a profile. This class utilizes getter and
 * setter methods to moddify/change the data in each
 * profile. The displayProfile method also implements
 * the getBreadthFirstTraversal of the Undirected Graph
 * data structure.
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

	public Profile()
	{
		name = "";
		status = "";
	}

	public String getName()
	{
		return name;
	}

	public String getStatus()
	{
		return status;
	}

	public void setName(String nameInput)
	{
		name = nameInput;
	}

	public void setStatus(String statusInput)
	{
		status = statusInput;
	}

	public void displayProfile(QueueInterface<Profile> friendQueue, HashedDictionary<String, Profile> networkOfProfiles) {
		System.out.println("Name: " + name);
		System.out.println("Status: " + status);
		System.out.print("Friends: ");

		String friendname = "";
		while(!friendQueue.isEmpty()) {
			friendname = friendQueue.dequeue().getName();

			if(friendname == this.getName() || networkOfProfiles.getValue(friendname) == null)
				System.out.print("");
			else
				System.out.print(friendname + " ");
		}
		System.out.println();
	}
}