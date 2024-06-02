// QUESTION 1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App1
{
    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/Lab";
    static final String USER="root";
    static final String PASS="Selva@123";
    public static void main(String []args) throws Exception
    {
        Connection conn=null;
        Statement st=null;
        Class.forName(JDBC_DRIVER);
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        if(conn!=null)
        {
            System.out.println("Connected ti the database");
            conn.setAutoCommit(false);
            st=conn.createStatement();
            //CREATE
            String createUser="INSERT INTO StudentManagement(id,name,dept,cgpa)values(5,'Sanjaa','IT','7.9')";
            int rowInserted=st.executeUpdate(createUser);
            System.out.println(rowInserted+"row(s) inserted.");
            //READ
            String readUser="SELECT * FROM StudentManagement";
            ResultSet rs=st.executeQuery(readUser);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String dept=rs.getString("dept");
                float cgpa=rs.getFloat("cgpa");
                System.out.println("id: "+id+",Name: "+name+",Dept: "+dept+",Cgpa: "+cgpa);
            }
            //UPDATE
            String updateUser="UPDATE StudentManagement SET cgpa='8.1' where id=1";
            int rowsUpdated=st.executeUpdate(updateUser);
            System.out.println(rowsUpdated+"row(s) updated.");
            //DELETE
            String deleteUser="DELETE FROM StudentManagement where id=1";
            int rowsDeleted=st.executeUpdate(deleteUser);
            System.out.println(rowsDeleted+"row(s) deleted.");
            rs.close();
            conn.setAutoCommit(true);        
        }
    }
}
