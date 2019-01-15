import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
	public static void main (String[] args) throws FileNotFoundException {
		BufferedReader reader = null;
		File outputFile = new File("C:/Users/Snahil/Downloads/Password Dump/linkedin/linkedin/output11.rtf");
        FileOutputStream is1 = new FileOutputStream(outputFile);
        OutputStreamWriter osw1 = new OutputStreamWriter(is1);    
        Writer w1 = new BufferedWriter(osw1);
        String line;
	    try{
	        reader = new BufferedReader(new FileReader("C:/Users/Snahil/Downloads/Password Dump/linkedin/linkedin/linkedin_passwords_dump11.txt"));
	        File statText = new File("C:/Users/Snahil/Downloads/Password Dump/linkedin/linkedin/comp1_encrypted11.rtf");
	        File file2 = new File("C:/Users/Snahil/Downloads/Password Dump/linkedin/linkedin/SHA1.txt");
	        Scanner scan = null;
	        Scanner scan1= null;
	        scan = new Scanner(file2);
	        FileOutputStream is = new FileOutputStream(statText);
	        OutputStreamWriter osw = new OutputStreamWriter(is);    
	        Writer w = new BufferedWriter(osw);
	        while ((line = reader.readLine()) != null) {
	        	String base = line;
	        	MessageDigest digest = MessageDigest.getInstance("SHA-1");
		        byte[] hash = digest.digest(base.getBytes("UTF-8"));
		        StringBuffer hexString = new StringBuffer();

		        for (int i = 0; i < hash.length; i++) {
		            String hex = Integer.toHexString(0xff & hash[i]);
		            if(hex.length() == 1) hexString.append('0');
		            hexString.append(hex);
		        }
		        System.out.println(hexString.toString());
		        String[] words = line.split(":");
		        String hexCode = "00000" + hexString.substring(5);
		        w.write(hexCode+","+words[0]);
		        w.write(System.getProperty( "line.separator"));
   	        }
	        w.close();
	        scan1 = new Scanner(statText);
	       ArrayList<String> dictionary = new ArrayList<String>();
	        while(scan1.hasNextLine())
	        {
	        	String str = null;
	            str = scan1.nextLine();
	            dictionary.add(str);
	        }
	        int counting = 0;
	        while(scan.hasNextLine())
	        {
	        	String str1 = scan.nextLine();
	        	System.out.println("str1: "+str1);
	       		boolean flag = false;
	        	for (String s: dictionary)
	        	{
	        		String[] words = s.split(",");
	        		System.out.println("s is : "+s);
	        		if(str1.equals(words[0]))
	        		{
	        			counting++;
	        			w1.write(s);
             			w1.write(System.getProperty( "line.separator"));
             			flag = true;
	        		}
	        		if (flag == true)
	    				break;;
	           	}
	        	
	        	System.out.println("counting: "+counting);
	        }
	       
	        w1.close();
	        scan.close();
	        scan1.close();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
}
