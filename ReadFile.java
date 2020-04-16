import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public static String ShowFile() throws IOException  {
		// TODO Auto-generated method stub
		String content = "";
        JFileChooser file = new JFileChooser();
        var result = file.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = file.getSelectedFile().getAbsolutePath();
            content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        }
        return content;
	}	
}
