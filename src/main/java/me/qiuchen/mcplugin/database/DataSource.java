package me.qiuchen.mcplugin.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.qiuchen.mcplugin.utils.ConfigUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static final HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    private DataSource() {

    }

    public static void setup(ConfigUtil configUtil) {
        config.setJdbcUrl(ConfigUtil.getConfig().getString("database.host") );
        config.setUsername(ConfigUtil.getConfig().getString("database.username"));
        config.setPassword(ConfigUtil.getConfig().getString("database.password"));
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}