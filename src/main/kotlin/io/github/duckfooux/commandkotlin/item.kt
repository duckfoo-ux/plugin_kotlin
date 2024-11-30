package io.github.duckfooux.commandkotlin

import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack


object item {
    fun playSound(player: Player, sound: Sound?, volume: Float, pitch: Float) {
        if (!player.isOnline) return
        player.playSound(player.location, sound!!, volume, pitch)
    }

    fun setSlot(material: Material?, name: String?): ItemStack {
        val item = ItemStack(material!!)
        val meta = item.itemMeta
        meta.setDisplayName(name)
        meta.addItemFlags(*arrayOf(ItemFlag.HIDE_ATTRIBUTES))
        item.setItemMeta(meta)
        return item
    }

    fun setSlot(material: Material?, name: String?, lore: ArrayList<String>): ItemStack {
        val array = ArrayList<String>()
        for (s in lore) {
            array.add(s)
        }
        val item = ItemStack(material!!)
        val meta = item.itemMeta
        meta.setDisplayName(name)
        meta.lore = array
        item.setItemMeta(meta)
        return item
    }

    fun setSlot(itemStack: ItemStack, name: String?): ItemStack {
        val meta = itemStack.itemMeta
        meta.setDisplayName(name)
        meta.addItemFlags(*arrayOf(ItemFlag.HIDE_ATTRIBUTES))
        itemStack.setItemMeta(meta)
        return itemStack
    }


    fun setSlot(itemStack: ItemStack, name: String?, lore: ArrayList<String>): ItemStack {
        val array = ArrayList<String>()
        for (s in lore) {
            array.add(s)
        }
        val meta = itemStack.itemMeta
        meta.setDisplayName(name)
        meta.lore = array
        itemStack.setItemMeta(meta)
        return itemStack
    }
}
