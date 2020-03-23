/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;




import java.util.HashMap;

import org.assertj.core.api.AbstractAssert;
import org.junit.Before;

import static org.assertj.core.api.Assertions.*;
//import static org.hamcrest.MatcherAssert.assertThat; 
//import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;



public class FriendshipsFTest {
	Friendships friends = new Friendships();

	@Before
	public void setup() {
		friends.friendships = new HashMap<>();
	}


	@Test
	public void TestExceptionPerson1null() {

		try {
			friends.makeFriends(null, "Tomek");
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}

	}

	@Test
	public void TestExceptionPerson2null() {

		try {
			friends.makeFriends("Tomek", null);
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}


	}

	@Test
	public void TestExceptionPerson1empty() {

		try {
			friends.makeFriends("", "Tomek");
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}


	}

	@Test
	public void TestExceptionPerson2empty() {

		try {
			friends.makeFriends("Tomek", "");
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}

	}

	@Test
	public void TestMakeFriendsWithEmptyList() {
		friends.makeFriends("Tomek", "Atomek");

		assertThat(friends.friendships.get("Tomek").get(0)).isEqualTo("Atomek");


		assertThat(friends.friendships.get("Tomek").size()).isEqualTo(1);
	}

	@Test
	public void TestMakeFriendsAppendingList() {

		friends.makeFriends("Tomek", "Atomek");
		friends.makeFriends("Tomek", "Tomasz");

		assertThat(friends.friendships.get("Tomek").get(0)).isEqualTo("Atomek");
		assertThat(friends.friendships.get("Tomek").get(1)).isEqualTo("Tomasz");
		assertThat(friends.friendships.get("Tomek").size()).isEqualTo(2);
	}

	@Test
	public void TestCheckIfSecondPersonIsFriend() {
		friends.makeFriends("Tomek", "Atomek");
		assertThat(friends.friendships.get("Atomek").get(0)).isEqualTo("Tomek");
	}

	@Test
	public void ShouldRaiseAnExceptionWhenPerson1IsNullInAreFriends() {

		try {
			friends.areFriends(null, "Tomek");
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}


	}

	@Test
	public void TestPerson2Null() {
		try {
			friends.areFriends("Tomek", null);
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}


	}

	@Test
	public void TestPerson1Empty() {
		try {
			friends.areFriends("", "Tomek");
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}



	}

	@Test
	public void TestPerson2Empty() {

		try {
			friends.areFriends("Tomek", "");
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}



	}


	@Test
	public void TestTrueFriends() {
		friends.makeFriends("Tomek", "Atomek");
		assertThat(friends.areFriends("Tomek", "Atomek")).isTrue();
	}

	@Test
	public void TestFalseFriends () {
		friends.makeFriends("Tomek", "Atomek");
		assertThat(friends.areFriends("Tomek", "a")).isFalse();
	}

	@Test
	public void Testgetfriendlistnull() {
		try {
			friends.getFriendsList(null);
			failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(IllegalArgumentException.class);
		}
		
		
	}


	@Test
	public void ShouldReturnFriendshipList() {
		friends.makeFriends("Tomek", "t");
		assertThat(friends.getFriendsList("Tomek").size()).isGreaterThan(0);
	}
	@Test
	public void StartsWithUpperCase() {
		friends.makeFriends("Tomek", "Tomasz");
		TestAssert.assertThat(friends.getFriendsList("Tomek").get(0)).startsWithUpperCase();
	}
	@Test
	public void TestIsTomek() {
		friends.makeFriends("ATomek", "Tomek");
		TestAssert.assertThat(friends.getFriendsList("ATomek").get(0)).isTomek();
	}
	

}
class TestAssert extends AbstractAssert<TestAssert, String> {
	 
    public TestAssert(String actual) {
        super(actual, TestAssert.class);
    }
 
    public static TestAssert assertThat(String actual) {
        return new TestAssert(actual);
    }
    
    public TestAssert isTomek() {
        isNotNull();
        if (actual != "Tomek") {
            failWithMessage("Expected person to be Tomek");
        }
        return this;
    }
    
    public TestAssert startsWithUpperCase() {
        isNotNull();
        
        if (Character.isLowerCase(actual.charAt(0))) {
            failWithMessage("Expected to start with UpperCase");
        }
        return this;
    }
    // assertion methods described later
}