package io.github.duckfooux.commandkotlin.kvent

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin

class Iv : JavaPlugin(), Listener, CommandExecutor {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
        getCommand("iv")?.setExecutor(this)
    }

    override fun onDisable() {

    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}This command can only be used by players!")
            return true
        }

        val player: Player = sender
        val inventory: Inventory = Bukkit.createInventory(null, 27, "${ChatColor.BLACK}Iv")

        if (args.isEmpty()) {
            player.sendMessage("${ChatColor.RED}Usage: /iv <player>")
        } else if (args.size == 1 && args[0].equals("player", ignoreCase = true)) {
            player.openInventory(inventory)
        }

        return true
    }
}
