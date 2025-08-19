package me.dominikhun250.hu.plugin.economy.storage;

import me.dominikhun250.hu.plugin.KT;

import java.sql.Connection;
import java.sql.DriverManager;

public class KillCoinsDatabaseManager {

    private final KT plugin;
    private Connection connection;

    public KillCoinsDatabaseManager(KT plugin) {
        this.plugin = plugin;
    }

    public void loadDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() + "/killcoins.db");
            new KillCoinsSQLInitializer(connection).createTables();
            KillCoinsStorage.init(connection);
        } catch (Exception e) {
            e.printStackTrace();
            plugin.getLogger().severe("Could not load KillCoins database!");
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
