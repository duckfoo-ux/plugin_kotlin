package io.github.duckfooux.commandkotlin

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.plugin.java.JavaPlugin

class plugin : JavaPlugin(), Listener, CommandExecutor {

    override fun onEnable() {
        logger.info("시작")
        getCommand("jammand")!!.setExecutor(this)
        saveDefaultConfig() // 이건 config.yml 있을때 쓰기
        saveResource("config.yml", false)

    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            val player: Player = sender
            val item = createItem(Material.REDSTONE_LAMP, "BOMM")

            if (args.isEmpty()) {
                player.sendMessage("${ChatColor.RED}JammandㅣKommand")
                player.sendMessage("jammand")
            } else {
                if (args[0].equals("Kammand", ignoreCase = true)) {
                    player.sendMessage("${ChatColor.BLUE}kammand")
                    player.inventory.addItem(item)
                }
            }
        } else {
            sender.sendMessage("${ChatColor.RED}This command can only be used by players!")
        }
        return true
    }

    override fun onDisable() {
        logger.info("Jammand is disabled")
    }

    private fun createItem(material: Material, name: String): ItemStack {
        val item = ItemStack(material)
        val meta: ItemMeta? = item.itemMeta
        meta?.setDisplayName(name)
        item.itemMeta = meta
        return item
    }
}