import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadInput {
	/**
	 * Opens the specified file and loads in the information line by line. The information is parsed per line and then loaded
	 * into the configuration supplied for further use throughout the program.
	 * 
	 * @param c
	 * @param fileName
	 */
	public static boolean readFile(Configuration c,String fileName){
		BufferedReader br = null;

		try {

			String sCurrentLine;
			String temp[];
			br = new BufferedReader(new FileReader("./" + fileName));
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				switch(i){
				case 0:
					c.setSize(Integer.parseInt(sCurrentLine));
					if(c.getSize() <= 1){
						System.out.println("Size must be greater than 1.");
						return false;
					}
					break;
				case 1:
					temp = sCurrentLine.split(",");
					if(temp.length != 2){
						System.out.println("Error, line does not contain a \",\"");
						return false;
					}
					if(!DataChecker.checkFormat(sCurrentLine, false, c.getSize())){
						System.out.println("Incorrect file format");
						return false;
					}
					temp[0] = temp[0].substring(1);
					temp[1] = temp[1].substring(0,1);
					if(!DataChecker.checkAmount(Integer.parseInt(temp[0]), c.getSize()) || !DataChecker.checkAmount(Integer.parseInt(temp[1]), c.getSize())){
						return false;
					}
					c.setStartX(Integer.parseInt(temp[0]));
					c.setStartY(Integer.parseInt(temp[1]));
					break;
				case 2:
					temp = sCurrentLine.split(",");
					if(temp.length != 2){
						System.out.println("Error, line does not contain a \",\"");
						return false;
					}
					if(!DataChecker.checkFormat(sCurrentLine, false, c.getSize())){
						System.out.println("Incorrect file format");
						return false;
					}
					temp[0] = temp[0].substring(1);
					temp[1] = temp[1].substring(0,1);
					if(!DataChecker.checkAmount(Integer.parseInt(temp[0]), c.getSize()) || !DataChecker.checkAmount(Integer.parseInt(temp[1]), c.getSize())){
						return false;
					}
					c.setEndX(Integer.parseInt(temp[0]));
					c.setEndY(Integer.parseInt(temp[1]));
					break;
				case 3:
					temp = sCurrentLine.split(",");
					if(temp.length != 2){
						System.out.println("Error, line does not contain a \",\"");
						return false;
					}
					if(!DataChecker.checkFormat(sCurrentLine, false, c.getSize())){
						System.out.println("Incorrect file format");
						return false;
					}
					temp[0] = temp[0].substring(1);
					temp[1] = temp[1].substring(0,1);
					if(!DataChecker.checkAmount(Integer.parseInt(temp[0]), c.getSize()) || !DataChecker.checkAmount(Integer.parseInt(temp[1]), c.getSize())){
						return false;
					}
					c.setStartObX(Integer.parseInt(temp[0]));
					c.setStartObY(Integer.parseInt(temp[1]));
					break;
				case 4:
					c.setSpeedOb(Integer.parseInt(sCurrentLine));
					if(c.getSpeedOb() < 0){
						System.out.println("Object speed must be greater than or equal to 0");
					}
					break;
				case 5:
					temp = sCurrentLine.split(",");
					if(temp.length != 2){
						System.out.println("Error, line does not contain a \",\"");
						return false;
					}
					if(!DataChecker.checkFormat(sCurrentLine, true, c.getSize())){
						System.out.println("Incorrect file format");
						return false;
					}
					temp[0] = temp[0].substring(1);
					if(temp[1].contains("+")){
						temp[1] = temp[1].substring(0, 2);
						temp[1] = temp[1].substring(1);
					} else {
						if(temp[1].contains("-")){
							temp[1] = temp[1].substring(0, 2);
						} else {
							temp[1] = temp[1].substring(0,1);
						}
					}
					
					if(temp[0].contains("+"))
						temp[0] = temp[0].substring(1);
					if(!DataChecker.checkAmount(Integer.parseInt(temp[0]), c.getSize()) || !DataChecker.checkAmount(Integer.parseInt(temp[1]), c.getSize())){
						return false;
					}
					c.setObDirNS(Integer.parseInt(temp[0]));
					c.setObDirEW(Integer.parseInt(temp[1]));
					break;
				case 6:
					temp = sCurrentLine.split(",");
					if(temp.length != 2){
						System.out.println("Error, line does not contain a \",\"");
						return false;
					}
					if(!DataChecker.checkFormat(sCurrentLine, false, c.getSize())){
						System.out.println("Incorrect file format");
						return false;
					}
					temp[0] = temp[0].substring(1);
					temp[1] = temp[1].substring(0,1);
					if(!DataChecker.checkAmount(Integer.parseInt(temp[0]), c.getSize()) || !DataChecker.checkAmount(Integer.parseInt(temp[1]), c.getSize())){
						return false;
					}
					c.setStartObXTwo(Integer.parseInt(temp[0]));
					c.setStartObYTwo(Integer.parseInt(temp[1]));
					break;
				case 7:
					c.setSpeedObTwo(Integer.parseInt(sCurrentLine));
					if(c.getSpeedObTwo() < 0){
						System.out.println("Object speed must be greater than or equal to 0");
					}
					break;
				case 8:
					temp = sCurrentLine.split(",");
					if(temp.length != 2){
						System.out.println("Error, line does not contain a \",\"");
						return false;
					}
					if(!DataChecker.checkFormat(sCurrentLine, true ,c.getSize())){
						System.out.println("Incorrect file format");
						return false;
					}
					temp[0] = temp[0].substring(1);
					if(temp[1].contains("+")){
						temp[1] = temp[1].substring(0, 2);
						temp[1] = temp[1].substring(1);
					} else {
						if(temp[1].contains("-")){
							temp[1] = temp[1].substring(0, 2);
						} else {
							temp[1] = temp[1].substring(0,1);
						}
					}
					if(temp[0].contains("+"))
						temp[0] = temp[0].substring(1);
					if(!DataChecker.checkAmount(Integer.parseInt(temp[0]), c.getSize()) || !DataChecker.checkAmount(Integer.parseInt(temp[1]), c.getSize())){
						return false;
					}
					c.setObDirNSTwo(Integer.parseInt(temp[0]));
					c.setObDirEWTwo(Integer.parseInt(temp[1]));
					break;
				}
				i++;
			}
			if(i != 9){
				System.out.println("File is of incorrect size.");
				return false;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return true;
	}
	
	public static int findGridSpace(Configuration c,int x, int y){
		int gridSpace;
		gridSpace = (c.getSize()*(x-1)) + y;
		return gridSpace;
	}
}

