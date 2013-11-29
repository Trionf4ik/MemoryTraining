import java.io.*;
import java.util.*;

public class TxtFileWriter
{ public static void main (String[] args) throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter(new FileOutputStream("TxtFileWriter.txt"), true);
		String a1 = "На русском языке сможешь записать в файл";
		String a2 = "This is English language";
		out.println("a1");
		out.println(a2);
		out.println(a1);
	}
}