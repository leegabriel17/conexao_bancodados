package inclusao_bancodados;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class GerenciadorPool {

    private BasicDataSource ds;

    private static GerenciadorPool instance;
    public static GerenciadorPool getInstance() {
        if (instance == null){
            instance = new GerenciadorPool();
        }
        return instance;
    }

    private GerenciadorPool() {
        ds = new BasicDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("gabriel_lee");
        ds.setPassword("root");
        //System.out.print(ds.getInitialSize()); 
        //System.out.print(ds.getMaxIdle());
    }

    public Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

}
