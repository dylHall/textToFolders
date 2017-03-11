package rankTest;

import java.io.File;

public class Text2Folders {
	
	public Text2Folders(String muleFolderName, String textBoxInput, Boolean appendEnd){
		//Have it inside a mule kind of thing
		String fileString = textBoxInput;
		String[] lineArray = fileString.split("\n");
		String[] formattedArray = new String[lineArray.length];
		int counter = 0;
		for(String fileLine : lineArray){
			String formattedString = fileLine.replaceAll(" ","_").replaceAll("&", "_").replaceAll(",","").replaceAll("'","");
			if(appendEnd){
				formattedString = formattedString+"_Out";
			}
			formattedArray[counter] = formattedString;
			counter++;
		}
		for(String fileLine2 : formattedArray){
			File file = new File(muleFolderName+"/"+fileLine2);
			file.mkdirs();
			System.out.println(fileLine2);
		} 	
	}

}
