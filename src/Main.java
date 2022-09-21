// Made by Arnas Abromavičius

import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args)
    {
        // directory for all test files
        String resourceFolder = "./resources";

        File dir = new File(resourceFolder);

        if(dir.exists() && dir.isDirectory() && dir.canRead())
        {
            File[] list = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith(".txt"));

            assert list != null;

            for( File file : list)
            {
                try
                {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    while (line != null)
                    {
                        Pattern pattern = Pattern.compile("\\d+");
                        Matcher matcher = pattern.matcher(line);

                        while(matcher.find())
                        {
                            int num = Integer.parseInt(matcher.group());
                            if(num >= 10)
                            {
                                System.out.println(line);
                                break;
                            }
                        }
                        line = reader.readLine();
                    }
                    reader.close();
                }
                catch (FileNotFoundException e)
                {
                    System.out.println("file " + file.getName() + " not found");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}