
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexion {
    
    
    public static void main(String[] args) {
        
        //1. REQUERIMIENTOS:
         
        String driver = "com.mysql.cj.jdbc.Driver";
        
        
        //2. URL (CADENA DE CONEXIÓN)
        String url = "jdbc:mysql://localhost:3306/hr";  //  "jdbc:mysql://localhost:3306"/ ---dbc:mysql:127.0.0.1@localhost:3306
        
        
        try{
            Class.forName(driver);
            System.out.println("Carga de driver exitosa");
            
        }catch(Exception e){
            System.err.println("Error de Conexion !!!" + e.getMessage());
            return;
        }
        
        
        
        try{
            Connection cn = DriverManager.getConnection(url, "root", "ORACLE555");
            System.out.println("Conectado a la base de datos Mysql");
            System.out.println("-------------------------------------");
            
            String sql = "select  * from employees";
            
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
         /*   while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getInt(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getInt(6));
                System.out.println(rs.getDouble(7));
                System.out.println(rs.getString(8));
                System.out.println("-------------------------------------");*/
                
                
                
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("firstname"));
                System.out.println(rs.getString("lastname"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getInt("phonenumber"));
                System.out.println(rs.getDouble("salary"));
                System.out.println(rs.getString("hiredate"));
                System.out.println("-------------------------------------");
                
                
                
            }
            
        }catch (Exception e){
            System.err.println("Sin conexion a la base de Datos" + e.getMessage());
            return;
            
        }
        
    }
    
    
}
