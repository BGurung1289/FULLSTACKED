package proj;

public class Difficulty {
	
	private enum difficulty {easy,medium,hard};
	private difficulty level;
	
	public Difficulty() {
		
	}
	
	public void setDifficulty(String diff) {
		if(diff.equals("easy")) {
			level = level.easy;
		}
		else if(diff.equals("medium")) {
			level = level.medium;
		}
		else if(diff.equals("hard")) {
			level = level.hard;
		}
		else {
			System.out.println("Entered difficulty not understood");
		}
	}
	
	public difficulty getDifficulty() {
		return level;
	}
	
}
