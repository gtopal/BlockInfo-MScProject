package blockchainInfo.blockInfo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class Utils {
	
	
	private static SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
	private static SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
	
	static {
		dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	
	public final static String SHA256(String input) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(input);
	}
	
	public final static Timestamp getTimeStamp(Date d) {
		try {
			return new Timestamp(dateFormatLocal.parse( dateFormatUTC.format(d) ).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Integer> myRandomNumbers(int number) {
		ArrayList<Integer> mynumbers = new ArrayList<Integer>();
		Random rand = new Random();
		int i = 0;

		for (i = 0; i < number; i++) {
			int n = rand.nextInt(number) + 1;
			while (mynumbers.contains(n)) {
				// generate a different integer as id
				n = rand.nextInt(number) + 1;

			}
			mynumbers.add(n);

		}
		return mynumbers;
	}

}
