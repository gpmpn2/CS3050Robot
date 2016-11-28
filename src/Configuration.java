
/**
 * Loaded data is stored here
 * 
 * @author grant
 *
 */
public class Configuration {
	private int size;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int startObX;
	private int startObY;
	private int speedOb;
	private int obDirNS;//Determines if it moves north/south
	private int obDirEW;//Determines if it moves east/west
	private int startObXTwo;
	private int startObYTwo;
	private int speedObTwo;
	private int obDirNSTwo;
	private int obDirEWTwo;
	public Configuration(int size,int startX, int startY, int endX, int endY, int startObX, int startObY,
			int speedOb, int obDirNS, int obDirEW, int startObXTwo, int startObYTwo,int speedObTwo,
				int obDirNSTwo, int obDirEWTwo){
		this.setSize(size);
		this.setStartX(startX);
		this.setStartY(startY);
		this.setEndX(endX);
		this.setEndY(endY);
		this.setStartObX(startObX);
		this.setStartObY(startObY);
		this.setSpeedOb(speedOb);
		this.setObDirNS(obDirNS);
		this.setObDirEW(obDirEW);
		this.setStartObXTwo(startObXTwo);
		this.setStartObYTwo(startObYTwo);
		this.setSpeedObTwo(speedObTwo);
		this.setObDirNSTwo(obDirNSTwo);
		this.setObDirEWTwo(obDirEWTwo);
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStartY() {
		return startY;
	}
	public void setStartY(int startY) {
		this.startY = startY;
	}
	public int getEndX() {
		return endX;
	}
	public void setEndX(int endX) {
		this.endX = endX;
	}
	public int getEndY() {
		return endY;
	}
	public void setEndY(int endY) {
		this.endY = endY;
	}
	public int getStartObX() {
		return startObX;
	}
	public void setStartObX(int startObX) {
		this.startObX = startObX;
	}
	public int getStartObY() {
		return startObY;
	}
	public void setStartObY(int startObY) {
		this.startObY = startObY;
	}
	public int getSpeedOb() {
		return speedOb;
	}
	public void setSpeedOb(int speedOb) {
		this.speedOb = speedOb;
	}
	public int getObDirNS() {
		return obDirNS;
	}
	public void setObDirNS(int obDirNS) {
		this.obDirNS = obDirNS;
	}
	public int getObDirEW() {
		return obDirEW;
	}
	public void setObDirEW(int obDirEW) {
		this.obDirEW = obDirEW;
	}
	public int getStartObXTwo() {
		return startObXTwo;
	}
	public void setStartObXTwo(int startObXTwo) {
		this.startObXTwo = startObXTwo;
	}
	public int getStartObYTwo() {
		return startObYTwo;
	}
	public void setStartObYTwo(int startObYTwo) {
		this.startObYTwo = startObYTwo;
	}
	public int getSpeedObTwo() {
		return speedObTwo;
	}
	public void setSpeedObTwo(int speedObTwo) {
		this.speedObTwo = speedObTwo;
	}
	public int getObDirNSTwo() {
		return obDirNSTwo;
	}
	public void setObDirNSTwo(int obDirNSTwo) {
		this.obDirNSTwo = obDirNSTwo;
	}
	public int getObDirEWTwo() {
		return obDirEWTwo;
	}
	public void setObDirEWTwo(int obDirEWTwo) {
		this.obDirEWTwo = obDirEWTwo;
	}
	
	
	
}
