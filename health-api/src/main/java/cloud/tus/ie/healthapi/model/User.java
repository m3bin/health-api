package cloud.tus.ie.healthapi.model;

public class User {

	private int userId;
	private int id;
	private String title;
	private String status;
	private String dateTime;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", id=" + id + ", title=" + title + ", status=" + status + ", dateTime="
				+ dateTime + "]";
	}
	
	

	

}
