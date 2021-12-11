package spellcheck;

import java.io.IOException;
import java.net.URL;

public interface MyURL {
    String fetch(URL url) throws IOException;
}
