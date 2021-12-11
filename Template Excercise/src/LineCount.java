import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LineCount extends FileSeer {


	public LineCount(String directory, String pattern, boolean recurse) {
		super(directory, pattern, recurse);
		_totalHits = 0;
		_matcher = Pattern.compile(_pattern).matcher("");		
	}

	private void run() {
		directorySeer(new File(_directory));
		System.out.println("TOTAL: " + _totalHits);
	}
	
	public static void main(String[] args) {
		String directory = "";
		String pattern = "";
		boolean recurse = false;
		
		if (args.length == 2) {
			recurse = false;
			directory = args[0];
			pattern = args[1];
		}
		else if (args.length == 3 && args[0].equals("-r")) {
			recurse = true;
			directory = args[1];
			pattern = args[2];
		}
		else {
			usage();
			return;
		}

		LineCount lineCounter = new LineCount(directory, pattern, recurse);
		lineCounter.run();
	}
	
	private static void usage() {
		System.out.println("USAGE: java LineCount {-r} <dir> <file-pattern>");
	}

	@Override
	void countFile(File file) {
		String fileName = getFileName(file);
		_matcher.reset(fileName);
		if (_matcher.find()) {
			try {
				Reader reader = new BufferedReader(new FileReader(file));
				int curLineCount = 0;
				try {
					curLineCount = 0;
					Scanner input = new Scanner(reader);
					while (input.hasNextLine()) {
						String line = input.nextLine();
						++curLineCount;
						++_totalHits;
					}
				}
				finally {
					System.out.println(curLineCount + "  " + file);
					reader.close();
				}
			}
			catch (IOException e) {
				unreadableFile(file);
			}
		}
	}

}
