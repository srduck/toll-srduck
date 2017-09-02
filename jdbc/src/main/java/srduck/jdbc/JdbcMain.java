package srduck.jdbc;

import java.sql.*;

public class JdbcMain {
    public static void main(String... args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
        createTable(connection);

        read(connection);

        create(connection, 1, "Soyuz");
        create(connection,2, "Falcon");
        create(connection, 3, "Angara");
        read(connection);
        System.out.println("=======================> after CREATE\n");

        update(connection, 1 , "Soyuz 2");
        update(connection, 2, "Falcon 9");
        update(connection, 3, "Angara A5");
        read(connection);
        System.out.println("=======================> after UPDATE\n");

        remove(connection, "Soyuz 2");
        read(connection);
        System.out.println("=======================> afeter DELETE 1\n");

        remove(connection, "Falcon 9");
        read(connection);
        System.out.println("=======================> afeter DELETE 2\n");

        remove(connection, "Angara");
        read(connection);
        System.out.println("=======================> afeter DELETE 3\n");

        remove(connection, "Angara A5");
        read(connection);
        System.out.println("=======================> afeter DELETE 4\n");

    }

    private static void createTable(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE ROCKETS" +
                "(" +
                    " ID integer PRIMARY KEY NOT NULL," +
                    " MODEL varchar(32) NOT NULL" +
                ")";

        statement.execute(sql);
    }

    private static void read(Connection connection) throws  SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM ROCKETS";
        ResultSet rs = statement.executeQuery(sql);
        int records = 0;
        while (rs.next()){
            records++;
            int id = rs.getInt("id");
            String model = rs.getString("model");
            System.out.println("id -> " + id + "; model -> " + model);
        }
        if (records == 0){
            System.out.println("NO RECORDS");
        }
    }

    private static void create (Connection connection, int id, String model) throws SQLException {
        Statement statment = connection.createStatement();
        String sql = "INSERT into ROCKETS VALUES(" + id + ", '" + model + "')";
        statment.executeUpdate(sql);
    }

    private static void remove (Connection connection, String model) throws SQLException{
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM ROCKETS WHERE model = '" + model + "'";
        statement.executeUpdate(sql);
    }

    private static void update (Connection connection, int id, String model) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "UPDATE ROCKETS SET  model = '" + model + "' WHERE id = " + id;
        statement.executeUpdate(sql);
    }




}
