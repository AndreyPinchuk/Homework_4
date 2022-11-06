package homework_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args){
        try {
            String initDbFilename = "./sql/init_db.sql";
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(initDbFilename)));

            Database.getInstance().executeUpdate(sql);

        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
