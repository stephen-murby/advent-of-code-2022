package utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

    public static List<String> readLines(Class c, String resourceName) throws URISyntaxException, IOException {
        Path path = Paths.get(c.getClassLoader()
                .getResource(resourceName).toURI());

        File f = new File(path.toUri());

         return Files.readAllLines(path);
    }

}
