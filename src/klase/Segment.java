package klase;

import java.util.LinkedList;

public class Segment {

	private LinkedList<User> users;
	private int redniBr;
	
	public LinkedList<User> getUsers() {
		return users;
	}

	public void setUsers(LinkedList<User> users) {
		this.users = users;
	}

	public int getRedniBr() {
		return redniBr;
	}

	public void setRedniBr(int redniBr) {
		this.redniBr = redniBr;
	}

	public Segment(int redniBr) {
		super();
		users = new LinkedList<User>();
		this.redniBr = redniBr;
	}
	
	
	
}
