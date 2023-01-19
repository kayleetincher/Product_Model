import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ProductReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        String Name = String.valueOf(target.getFileName());


        String heading1 = "  ID |";
        String heading2 = "Name |";
        String heading3 = "Description |";
        String heading4 = "   Cost";
        String divider = "================================================";


        chooser.setCurrentDirectory(target.toFile());

        try
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();


                inFile = new Scanner(target);

                System.out.printf("%-10s %-8s %-12s %-12s %n", heading1, heading2, heading3, heading4);
                System.out.println(divider);

                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();

                    System.out.println(line);
                    String.format(line);
                }

                inFile.close();
            }
            else
            {
                System.out.println("Must select file, terminating now");
                System.exit(0);
            }

        }
        catch (IOException e)
        {
            System.out.println("File Not Found Error");
        }



    }
}
