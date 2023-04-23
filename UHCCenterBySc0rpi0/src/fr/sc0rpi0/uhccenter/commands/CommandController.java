package fr.sc0rpi0.uhccenter.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sc0rpi0.uhccenter.Main;
import fr.sc0rpi0.uhccenter.tools.ColorTool;
import fr.sc0rpi0.uhccenter.tools.GameControl;

public class CommandController implements CommandExecutor {
	private Main main;

	public CommandController(Main main) {
		this.main = main;
	}

	/**
	 * This is when the command /uhc is called by a sender
	 * 
	 * @param CommandSender : sender
	 * @param Command : cmd
	 * @param String : msg
	 * @param String[] : args
	 * @return boolean : false if failed or useless, true otherwise
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (args.length > 0) {
				switch (args[0]) {
					case "start":
						return onStart(player, args);
						
					case "stop":
						return onStop(player, args);
						
					case "cancel":
						return onCancel(player, args);
						
					case "heal":
						return onHeal(player, args);
						
					case "clear":
						return onClear(player, args);
						
					case "help":
						return onHelp(player, args);
	
					default:
						sender.sendMessage(ColorTool.getMainColorAqua() + "The command is wrong, try \"/uhc help\" for help");
						return false;
				}
			} else {
				return onHelp(player, args);
			}
			
		}
		
		return false;
	}

	/**
	 * The host wants to start the uhc
	 * 
	 * @param Player : sender
	 * @param String[] : args
	 * @return boolean : false if failed, true otherwise
	 */
	public boolean onStart(Player sender, String[] args) {
		if (args.length == 1) {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The UHC will start soon");
			GameControl.teleport(main);
			return true;
		} else {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The command is wrong, try \"/uhc help\" for help");
		}
		return false;
	}
	
	/**
	 * The host wants to stop the uhc
	 * 
	 * @param Player : sender
	 * @param String[] : args
	 * @return boolean : false if failed, true otherwise
	 */
	public boolean onStop(Player sender, String[] args) {
		if (args.length == 1) {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The UHC will start soon");
			sender.sendMessage(ColorTool.getMainColorAqua() + "---TODO---");
			return true;
		} else {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The command is wrong, try \"/uhc help\" for help");
		}
		return false;
	}

	/**
	 * The host wants to cancel the start of the uhc
	 * 
	 * @param Player : sender
	 * @param String[] : args
	 * @return boolean : false if failed, true otherwise
	 */
	public boolean onCancel(Player sender, String[] args) {
		if (args.length == 1) {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The start of the UHC is canceled");
			sender.sendMessage(ColorTool.getMainColorAqua() + "---TODO---");
			return true;
		} else {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The command is wrong, try \"/uhc help\" for help");
		}
		return false;
	}
	
	/**
	 * The host wants to heal someone or everyone
	 * 
	 * @param Player : sender
	 * @param String[] : args
	 * @return boolean : false if failed, true otherwise
	 */
	public boolean onHeal(Player sender, String[] args) {
		if (args.length > 0) {
			if (args.length == 1) {
				sender.sendMessage(ColorTool.getMainColorAqua() + "Everyone has been healed !");
				sender.sendMessage(ColorTool.getMainColorAqua() + "---TODO---");
				
			} else {
				for (int i = 1; i < args.length; i++) {
					sender.sendMessage(ColorTool.getMainColorAqua() + "" + args[i] + " has been healed !");
					sender.sendMessage(ColorTool.getMainColorAqua() + "---TODO---");
				}
			}
			
			return true;
		
		} else {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The command is wrong, try \"/uhc help\" for help");
		}
		return false;
	}
	
	/**
	 * The host wants to clear someone or everyone
	 * 
	 * @param Player : sender
	 * @param String[] : args
	 * @return boolean : false if failed, true otherwise
	 */
	public boolean onClear(Player sender, String[] args) {
		if (args.length > 0) {
			if (args.length == 1) {
				sender.sendMessage(ColorTool.getMainColorAqua() + "Everyone has been cleared !");
				sender.sendMessage(ColorTool.getMainColorAqua() + "---TODO---");
				
			} else {
				for (int i = 1; i < args.length; i++) {
					sender.sendMessage(ColorTool.getMainColorAqua() + "" + args[i] + " has been cleared !");
					sender.sendMessage(ColorTool.getMainColorAqua() + "---TODO---");
				}
			}
			
			return true;
		
		} else {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The command is wrong, try \"/uhc help\" for help");
		}
		return false;
	}
	
	/**
	 * The user wants to get help on the command
	 * 
	 * @param Player : sender
	 * @param String[] : args
	 * @return boolean : false if failed, true otherwise
	 */
	public boolean onHelp(Player sender, String[] args) {
		if (args.length <= 1) {
			sender.sendMessage(ColorTool.getMainColorGray() + "---------------------------------------------");
			sender.sendMessage(ColorTool.getMainColorAqua() + "/uhc");
			sender.sendMessage(ColorTool.getMainColorAqua() + "  start : to start the uhc");
			sender.sendMessage(ColorTool.getMainColorAqua() + "  stop : to stop the uhc");
			sender.sendMessage(ColorTool.getMainColorAqua() + "  cancel : to cancel the start of the uhc");
			sender.sendMessage(ColorTool.getMainColorAqua() + "  heal [PlayerName...] : to heal someone or everyone by default");
			sender.sendMessage(ColorTool.getMainColorAqua() + "  clear [PlayerName...] : to clear someone or everyone by default");
			sender.sendMessage(ColorTool.getMainColorGray() + "---------------------------------------------");
			return true;
		} else {
			sender.sendMessage(ColorTool.getMainColorAqua() + "The command is wrong, try \"/uhc help\" for help");
		}
		return false;
	}
}
