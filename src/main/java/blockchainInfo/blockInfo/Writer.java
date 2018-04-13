package blockchainInfo.blockInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.shiro.crypto.hash.Sha256Hash;

public class Writer {
	
	
	
	
	public static File writeToFile(File results){
		
		if (results.exists())
			System.out.println("The file already exists!");
		else
		{
			try {
				results.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try
			{
				FileWriter fileW=new FileWriter(results);
				BufferedWriter buffW = new BufferedWriter(fileW);
				buffW.write(ThirdFrame.concatenated);
				buffW.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		return results;
	}


	public static Sha256Hash hashTheFile(File hashResult){
		
		
		Sha256Hash hash=new Sha256Hash(hashResult);
		return hash;
		
	}

	
	

}
