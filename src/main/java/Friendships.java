import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!	
    public void makeFriends(String person1, String person2) {
    	if(person1 == null || person2 == null || person1 == "" || person2 == "")
    		throw new IllegalArgumentException();
        addFriend(person1, person2);
        addFriend(person2, person1);
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
    	if(person == null || person == "")
    		throw new IllegalArgumentException();
        return friendships.get(person);
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
    	if(person1 == null || person2 == null || person2 == "" || person1 == "")
    		throw new IllegalArgumentException();
    	for(String friend : getFriendsList(person1)) {
    		if(friend == person2)
    			return true;
    	}
		return false;
    }
    //Dodanie do listy przyjaciol do danej osoby
    
    private void addFriend(String person, String friend) {
    	//Sprwadzamy czy istnieje lista
    	if(friendships.containsKey(person)) {
            List<String> friends = friendships.get(person);
            friends.add(friend);
            friendships.put(person, friends);
            return;
    	}
    	//Jak nie ma to robimy nowa liste i dodajemy ja
        List<String> list = new ArrayList<>();
        list.add(friend);
        friendships.put(person, list);
    }
}