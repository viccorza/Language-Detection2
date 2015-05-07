/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import beans.unoporuno_snippet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vickorza
 */
public class dbmanager {
    public List<unoporuno_snippet> obtenerDatos() {
        List<unoporuno_snippet> snippetList = new ArrayList<unoporuno_snippet>();
        Connection cn = null;
        try {
            cn = getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from unoporuno_snippet LIMIT 100");
            while (rs.next()) {
                unoporuno_snippet snippet = new unoporuno_snippet();
                snippet.setId(rs.getInt("id"));
                snippet.setTitle(rs.getString("title"));
                snippet.setDescription(rs.getString("description"));
                snippetList.add(snippet);
            }
        } catch (Exception error) {
            error.printStackTrace();
            System.out.println("Error al obtener los datos");
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {

            }
        }
        return snippetList;
    }

    public Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost/unoporuno", "unoporuno", "unoporuno");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Hubo un problema en la conexión :(");
        }
        return cn;
    }
    
    public void grabarIdioma()
}
