import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.JDBC;
public class DbHandler {
    private static final String CON_STR = "jdbc:sqlite:D:/database/steps.db";

    private static DbHandler instance = null;

    private final Connection connection;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    private DbHandler () throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public Connection getConnection() {
        return connection;
    }
}
