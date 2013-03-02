package stuff;

import java.io.File;
import java.io.IOException;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import stuff.Main;

public class MainConfig {
 
 
 Main plugin;
 
 File fileConfig;
 FileConfiguration config;
 
 public MainConfig(Main plug, String file){
  
  plugin = plug;
  fileConfig = new File(plugin.getDataFolder() + file);
 }
 
 public void LoadConfig(){
  config = YamlConfiguration.loadConfiguration(fileConfig);
 }
 
 public void saveConfig() throws IOException {
  config.save(fileConfig);
 }
 
 public void addConfig(String key, Object value) {
  config.set(key, value);
 }
 
 public Object getConfigu(String path) {
  return config.get(path);
 }
 

}