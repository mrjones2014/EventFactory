package eventfactory.model;

public class Notification {
	private String type;
	private String color;
	private String audioFile;
	public Notification(String type, String audioFile, String color){
		this.type = type;
		this.audioFile = audioFile;
		this.color = color;
	}
	public String getType(){
		return type;
	}
	public String getAudioFile(){
		return audioFile;
	}
	public String getColor(){
		return color;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setColor(String color){
		this.color = color;
	}
	public void setAudiofile(String audioFile){
		this.audioFile = audioFile;
	}
	
}
