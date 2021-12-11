import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.*;
import java.util.regex.*;

abstract public class FileSeer {

    protected String _directory;
    protected String _pattern;
    protected boolean _recurse;
    protected Matcher _matcher;
    protected int _totalHits;


    public FileSeer(String directory, String pattern, boolean recurse) {
        _directory = directory;
        _pattern = pattern;
        _recurse = recurse;
    }

    protected void directorySeer(File dir) {
        if (dir.isDirectory())
        {
            if (dir.canRead())
            {
                for (File file : dir.listFiles()) {
                    if (file.isFile()) {
                        if (file.canRead()) {
                            countFile(file);
                        }
                        else {
                            System.out.println("File " + file + " is unreadable");
                        }
                    }
                }

                if (_recurse) {
                    for (File file : dir.listFiles()) {
                        if (file.isDirectory()) {
                            countFile(file);
                        }
                    }
                }
            }
            else {
                System.out.println("Directory " + dir + " is unreadable");
            }
        }
        else {
            System.out.println(dir + " is not a directory");
        }
    }

    protected String getFileName(File file) {
        try {
            return file.getCanonicalPath();
        }
        catch (IOException e) {
            return "";
        }
    }

    protected void unreadableFile(File file) {
        System.out.println("File " + file + " is unreadable");
    }
    abstract void countFile(File file);
}
