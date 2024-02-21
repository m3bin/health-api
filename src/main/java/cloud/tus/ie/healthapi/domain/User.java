package cloud.tus.ie.healthapi.domain;

public class User {

	private int userId;
	private int id;
	private String title;
	private String completed;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}

	

}
