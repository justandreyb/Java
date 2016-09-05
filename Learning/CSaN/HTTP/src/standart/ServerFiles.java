package standart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ServerFiles {
    private File file;

    ServerFiles (String path) {
        file = new File(path);
    }

    public boolean isExists () {
        return file.exists();
    }

    public long getSize () {
        return file.length();
    }

    public String getData() {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String temp;
                while ((temp = reader.readLine()) != null) {
                    result.append(temp);
                    result.append("\n");
                }
            } finally {
                reader.close();
            }
            return result.toString();
        } catch (Exception e) {
            System.out.println(e);
            return "1";
        }
    }
}
