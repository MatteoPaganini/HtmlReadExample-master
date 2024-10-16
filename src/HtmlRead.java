import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {

                if((line.contains("href=")))  {
                //   System.out.println("og line: " + line);

                    //methods needed: indexof, substring
                    int indexhttp = line.indexOf("href=") +6;
                    String newLine = line.substring(indexhttp);

                    int end = newLine.indexOf("\"");
                    int oEnd = newLine.indexOf("\'");

                    if(oEnd == -1){
                        System.out.println(newLine.substring(0,end));
                    }else if (end == -1){
                        System.out.println(newLine.substring(0,oEnd));
                    }else {
                        if(oEnd > end){
                            System.out.println(newLine.substring(0,end));
                        }else{
                            System.out.println(newLine.substring(0,oEnd));
                        }
                    }
                    //System.out.println(newLine);
                }

            }

            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
