package proj;

public class Achievement {
	
	private String acheivementTitle;
	private int achievementID;
	private Difficulty diff;
	
	public Achievement(String achievementTitle, int achievementID) {
		this.acheivementTitle = achievementTitle;
		this.achievementID = achievementID;
	}
	
	public String getTitle() {
		return acheivementTitle;
	}
	
	public int getAchievementID() {
		return achievementID;
	}
	
	//newly added
	public void setDifficulty(String levelOfDifficulty){
		diff.setDifficulty(levelOfDifficulty);
	}
	
}
