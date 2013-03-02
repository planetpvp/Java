package stuff;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
 String hote;
 String user;
 String mdp;
 boolean disable = false;
 
 public void connect(){
  try {
   Object conn = DriverManager.getConnection(hote, user, mdp);
   System.out.println("[Login]: Connexion établie a MYSQL");
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   System.out.println("[Login]: erreur de connexion a MYSQL");
   Bukkit.getServer().getPluginManager().disablePlugin(this);
  }
  try {
   Class.forName("com.mysql.jdbc.Driver");
  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 @Override
 public void onEnable() {
  System.out.println("[Login]: Plugin chargé");
  MainConfig configManager;
  configManager = new MainConfig(this, "/config.yml");
    configManager.LoadConfig();
    if(configManager.getConfigu("hote") == null){
     configManager.addConfig("hote", "jdbc:mysql://localhost:3306/MyBase");
     disable = true;
    }
 }
 
 @Override
 public void onDisable() {
  System.out.println("[Login]: Plugin déchargé");
 }
}