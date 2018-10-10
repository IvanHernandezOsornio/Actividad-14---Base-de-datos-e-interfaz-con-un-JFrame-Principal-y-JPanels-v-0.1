
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelAgenda {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String nombre;
    private String email;
    private String telefono;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que realiza las siguietnes acciones:
     * 1- Conecta con la base agenda_mvc,
     * 2- Consulta todo los registros de la tabla contactos,
     * 3- Obtiene el nombre y el email y los guarda en las variables globales nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenda_mvc", "user_mvc", "pass_mvc.2018");
            st = conexion.createStatement();
            String sql = "SELECT * FROM contactos;";
//            System.out.println(sql);
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: " + err.getMessage());
        }
    }

    /**
     * Lee los valores del registro seleccionado y los asigna a las variables miembro nombre y email.
     */
    public void setValues() {
        try {
            nombre = rs.getString("nombre");
            email = rs.getString("email");
            telefono = rs.getString("telefono");
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverPrimerRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.first(); //Primer registro

                nombre = rs.getString("nombre");
                email = rs.getString("email");
                telefono = rs.getString("telefono");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al anterior registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverAnteriorRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.previous(); //Registro anterior

                nombre = rs.getString("nombre");
                email = rs.getString("email");
                telefono = rs.getString("telefono");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al siguiente registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverSiguienteRegistro() {
        try{
            if(rs.isLast()==false) {
                rs.next(); // Siguiente registro 
                
                this.setNombre(rs.getString("nombre"));
                this.setEmail(rs.getString("email"));
                this.setTelefono(rs.getString("telefono"));
            }
        } catch(Exception err) {
            JOptionPane.showMessageDialog(null,"Error " + err.getMessage());
        }
    }
    
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la ariable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.last(); //Último registro

                this.setNombre(rs.getString("nombre"));
                this.setEmail(rs.getString("email"));
                this.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
} // Cierre de la Clase Principal.
