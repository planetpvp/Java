package fr.hugo;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin{
 
 
 @SuppressWarnings("deprecation")
 public void randompotion(Player receiver) {
  
  Random rd = new Random();
  int po = rd.nextInt(16)+1;
  
  ItemStack is = new ItemStack(Material.POTION, 1);
  PotionMeta meta = (PotionMeta) is.getItemMeta();
  
  switch (po)
  {
   case 0:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.CONFUSION, 2000, 4)), true);
    break;
   case 1:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000, 4)), true);
    break;
   case 2:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.BLINDNESS, 2000, 4)), true);
    break;
   case 3:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000, 4)), true);
    break;
   case 4:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.FAST_DIGGING, 2000, 4)), true);
    break;
   case 5:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.HARM, 2000, 4)), true);
    break;
   case 6:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.HEAL, 2000, 4)), true);
    break;
   case 7:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.HUNGER, 2000, 4)), true);
    break;
   case 8:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2000, 4)), true);
    break;
   case 9:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.INVISIBILITY, 2000, 4)), true);
    break;
   case 10:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.JUMP, 2000, 4)), true);
    break;
   case 11:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.NIGHT_VISION, 2000, 4)), true);
    break;
   case 12:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.POISON, 2000, 4)), true);
    break;
   case 13:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.REGENERATION, 2000, 4)), true);
    break;
   case 14:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.SLOW, 2000, 4)), true);
    break;
   case 15:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, 2000, 4)), true);
    break;
   case 16:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.SPEED, 2000, 4)), true);
    break;
   case 17:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.WATER_BREATHING, 2000, 4)), true);
    break;
   case 18:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.WEAKNESS, 2000, 4)), true);
    break;
   case 19:
    meta.addCustomEffect((new PotionEffect(PotionEffectType.WITHER, 2000, 4)), true);
    break;
  }
  meta.setMainEffect(PotionEffectType.FIRE_RESISTANCE);
  is.setItemMeta(meta); 
  receiver.getInventory().addItem(is);
  receiver.updateInventory();
 }

 
 @Override
 public void onEnable() {
  System.out.println("RP is ready !");
 }
 
 @Override
 public void onDisable() {
  System.out.println("RIP RP ...");
 }
 
 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
  if(cmd.getName().equalsIgnoreCase("rpotion")){
   Player player = null;
   if (sender instanceof Player) { 
    player = (Player) sender;
    randompotion(player);
   }
   else{
     sender.sendMessage("La console ne peut pas ce giver des potions !");
   }
  }
  return true;
 }
}