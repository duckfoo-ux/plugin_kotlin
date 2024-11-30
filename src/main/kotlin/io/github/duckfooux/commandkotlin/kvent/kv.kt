package io.github.duckfooux.commandkotlin.kvent

import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.*
import org.bukkit.plugin.java.JavaPlugin

class kv : JavaPlugin(), Listener {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {

    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player: Player = event.player
        player.sendMessage("${ChatColor.RED}joined the game!")
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        val player: Player = event.player
        player.sendMessage("${ChatColor.YELLOW}left the game!")
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onPlayerMove(event: PlayerMoveEvent) {
        val player: Player = event.player
        player.sendMessage("${ChatColor.GREEN}you Move")
    }

    @EventHandler
    fun onPlayerKick(event: PlayerKickEvent) {
        val player: Player = event.player
        player.sendMessage("${ChatColor.BLUE}you Kick")
    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val player: Player = event.entity
        player.sendMessage("${ChatColor.DARK_BLUE}you Death")
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player: Player = event.player
        player.sendMessage("${ChatColor.DARK_PURPLE}you Interact")
    }
}