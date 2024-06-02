
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App2 {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Lab";
    static final String USER = "root";
    static final String PASS = "sanjayppp3001@2005";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null) {
                System.out.println("Connected to the database.");
                conn.setAutoCommit(false);
                st = conn.createStatement();
                // CREATE
                String createUser = "INSERT INTO VehicleManagement(V_id,Manufacture,Model,Color,Year,Fuel,Price) VALUES('3','Toyota','Camry','Silver',2022,'Petrol',650000.00),('4','Honda','Civic','Black',2020,'Hybrid',12000.00)";
                int rowsInserted = st.executeUpdate(createUser);
                System.out.println(rowsInserted + " row(s) inserted.");
                // READ
                String readUser = "SELECT * FROM VehicleManagement";
                ResultSet rs = st.executeQuery(readUser);
                while (rs.next()) {
                    int vehicle_id = rs.getInt("V_id");
                    String manufacture = rs.getString("Manufacture");
                    String model = rs.getString("Model");
                    String color = rs.getString("Color");
                    String yearOfManufacture = rs.getString("Year");
                    String fuelType = rs.getString("Fuel");
                    String price = rs.getString("Price");
                    System.out.println("Vehicle ID: " + vehicle_id + "\nManufacture: " + manufacture +
                            "\nModel: " + model + "\nColor: " + color + "\nYear Of Manufacture: " + yearOfManufacture
                            + "\nFuel Type: " + fuelType + "\nPrice: " + price + "\n");
                }
                rs.close();
                // UPDATE
                String updateUser = "UPDATE VehicleManagement SET Price = '800000.00' WHERE Manufacture = 'Toyota'";
                int rowsUpdated = st.executeUpdate(updateUser);
                System.out.println(rowsUpdated + " row(s) updated.");
                // DELETE
                String deleteUser = "DELETE FROM VehicleManagement WHERE Model = 'Civic'";
                int rowsDeleted = st.executeUpdate(deleteUser);
                System.out.println(rowsDeleted + " row(s) deleted.");
                conn.commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }
}
