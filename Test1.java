import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class Test1 {
	public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new FileReader("C:/Users/Snahil/Downloads/Password Dump/yahoo/yahoo/password.file"));
            File statText = new File("C:/Users/Snahil/Downloads/Password Dump/yahoo/yahoo/decrypted.file");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            String foundLine = "user_id   :  user_name  : clear_passwd : passwd";
            System.out.println("begin");
            Boolean flag = false;
            while ((line = reader.readLine()) != null) {
              if (line.equals(foundLine))
            	{	
            		flag = true;
            		reader.readLine();
            		line = reader.readLine();
            		while(!line.equals(""))
             		{
            			String[] words = line.split(":");
             			System.out.println("paswds : "+words[words.length-1]);
             			if (words.length>=2)
             			{
             			w.write(words[words.length-2] + "                        " + words[words.length-1]);
             			w.write(System.getProperty( "line.separator"));
             			}
             			line = reader.readLine();
             		}
            	}
            	if(flag == true)
            		break;
               }
            w.close();
          } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             reader.close();
        }
    }
}
