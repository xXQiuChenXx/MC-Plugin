package me.qiuchen.mcplugin.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.qiuchen.mcplugin.utils.ConfigUtil;
import org.bukkit.configuration.file.YamlConfiguration;

import java.sql.Connection;
import java.sql.SQLException;



public class DataSource {

    private static final HikariConfig config = new HikariConfig();
    private static  HikariDataSource ds;

    public DataSource() {
        YamlConfiguration configUtil = ConfigUtil.getConfig();
        config.setJdbcUrl("jdbc:mysql://" + configUtil.getString("mysql.host") + ":" + configUtil.getString("mysql.port")+ "/" + configUtil.getString("mysql.database"));
        config.setUsername(configUtil.getString("mysql.username"));
        config.setPassword(configUtil.getString("mysql.password"));
        config.setMaxLifetime(60000);
        config.addDataSourceProperty("connectionTimeout", "10000");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheServerConfiguration", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");
        config.addDataSourceProperty("allowPublicKeyRetrieval", "true");
        config.addDataSourceProperty("useSSL", configUtil.getString("mysql.useSSL"));
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    public  Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}