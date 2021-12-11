import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FileSearch extends FileSeer {

	private Matcher _searchMatcher;

	public FileSearch(String dirName, String filePattern, String searchPattern, boolean recurse) {
		super(dirName, filePattern, recurse);
		_matcher = Pattern.compile(_pattern).matcher("");
		_searchMatcher = Pattern.compile(searchPattern).matcher("");
		_totalHits = 0;
		
		directorySeer(new File(dirName));
		
		System.out.println("");
		System.out.println("TOTAL MATCHES: " + _totalHits);
	}
	
	public static void main(String[] args) {

		String dirName = "";
		String filePattern = "";
		String searchPattern = "";
		boolean recurse = false;
		
		if (args.length == 3) {
			recurse = false;
			dirName = args[0];
			filePattern = args[1];
			searchPattern = args[2];
		}
		else if (args.length == 4 && args[0].equals("-r")) {
			recurse = true;
			dirName = args[1];
			filePattern = args[2];
			searchPattern = args[3];
		}
		else {
			usage();
			return;
		}
		
		new FileSearch(dirName, filePattern, searchPattern, recurse);
	}
	
	private static void usage() {
		System.out.println("USAGE: java FileSearch {-r} <dir> <file-pattern> <search-pattern>");
	}

	@Override
	void countFile(File file) {
		String fileName = getFileName(file);
		_matcher.reset(fileName);
		if (_matcher.find()) {
			try {
				int curMatches = 0;

				InputStream data = new BufferedInputStream(new FileInputStream(file));
				try {
					Scanner input = new Scanner(data);
					while (input.hasNextLine()) {
						String line = input.nextLine();

						_searchMatcher.reset(line);
						if (_searchMatcher.find()) {
							if (++curMatches == 1) {
								System.out.println("");
								System.out.println("FILE: " + file);
							}

							System.out.println(line);
							++_totalHits;
						}
					}
				}
				finally {
					data.close();

					if (curMatches > 0) {
						System.out.println("MATCHES: " + curMatches);
					}
				}
			}
			catch (IOException e) {
				unreadableFile(file);
			}
		}
	}
}
