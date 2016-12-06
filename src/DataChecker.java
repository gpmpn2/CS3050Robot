
public class DataChecker {

	/**
	 * Checks the format of a line.
	 * @param line
	 * @param isPosition
	 * @param size
	 * @return
	 */
	public static boolean checkFormat(String line, boolean isPosition,int size){
		String sizeUpdate = Integer.toString(size);
		int len = sizeUpdate.length();
		int minimum = 5;
		int maximumNotPos = (len*2) + 3;
		int maximumPos = 7;
		if(!isPosition){
			if(line.length() < minimum || line.length() > maximumNotPos){
				System.out.println("Error, line is to large for the grid size specified");
				return false;
			}
		} else {
			if(line.length() < minimum || line.length() > maximumPos){
				System.out.println("Error, line is to large for the grid size specified");
				return false;
			}
		}
		if(line.charAt(0) != '(' || line.charAt(line.length()-1) != ')'){
			System.out.println("Error, line does not start with \"(\" or end with \")\"");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if the size of the point is to large for the Grid's size.
	 * @param amount
	 * @param size
	 * @return
	 */
	public static boolean checkAmount(int amount, int size){
		if(amount > size){
			System.out.println("Data Point: " + amount + " is to large for the grid specified");
			return false;
		}
		return true;
	}
}
