package helpers;

public class Constant {
    private static final String URL = "jdbc:mysql://localhost:3306/adrressbook?autoReconnect=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "psw1234";

    private static final String ADD_QUERY = "INSERT INTO abtabla (firstname, phone, email, created) VALUES( ?, ?, ?, ?)";

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getAddQuery() {
        return ADD_QUERY;
    }
}
