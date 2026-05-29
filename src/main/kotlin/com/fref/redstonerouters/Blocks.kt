package com.fref.redstonerouters

import net.wesjd.anvilgui.AnvilGUI
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.Collections

class Blocks {
    object PingBlock {
        fun openGui(plugin: JavaPlugin, player: Player) {
            AnvilGUI.Builder()
                .onClose { _ -> }
                .onClick { slot, stateSnapshot ->
                    if (slot != AnvilGUI.Slot.OUTPUT) {
                        return@onClick Collections.emptyList()
                    }

                    val input = stateSnapshot.text

                    if (input.matches(Regex("^\\d{6}$"))) {
                        player.sendMessage("PingID accepted: $input")
                        return@onClick Collections.singletonList(AnvilGUI.ResponseAction.close())
                    } else {
                        player.sendMessage("§cError: Enter an actual PingID")
                        return@onClick Collections.singletonList(AnvilGUI.ResponseAction.replaceInputText("Try again"))
                    }
                }
                .text("000000")
                .title("Enter 6-Digit PingID")
                .plugin(plugin)
                .open(player)
        }
        fun PlaceBlock(PlaceLocation: String, sendingPlayer: String) {
            RedstoneRouters.index += 1
            var currentPingBlockIndex = RedstoneRouters.index
            Functions.RunCommand("execute at $sendingPlayer run summon minecraft:shulker $PlaceLocation {Silent:1b,Invulnerable:1b,NoAI:1b,AttachFace:0b,Tags:[\"PingBlock${currentPingBlockIndex}\"],active_effects:[{id:\"minecraft:invisibility\",amplifier:255,duration:999999,show_particles:0b,show_icon:0b,ambient:1b}],Passengers:[{id:\"minecraft:item_display\",Tags:[\"PingBlock$currentPingBlockIndex\"],transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,-0.5f,0f],scale:[1.0f,1.0f,1.0f]},item:{id:\"minecraft:iron_block\",components:{\"minecraft:item_name\":\"Ping Block\"}}}]}")
        }
    }
    object RedstoneRouter {
        fun PlaceBlock(PlaceLocation: String, sendingPlayer: String) {
            RedstoneRouters.index += 1
            var currentRouterIndex = RedstoneRouters.index
            Functions.RunCommand("execute at $sendingPlayer run summon minecraft:shulker $PlaceLocation {Silent:1b,Invulnerable:1b,NoAI:1b,AttachFace:0b,Tags:[\"PingBlock${currentRouterIndex}\"],active_effects:[{id:\"minecraft:invisibility\",amplifier:255,duration:999999,show_particles:0b,show_icon:0b,ambient:1b}],Passengers:[{id:\"minecraft:item_display\",Tags:[\"PingBlock${currentRouterIndex}\"],transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,-0.5f,0f],scale:[1.0f,1.0f,1.0f]},item:{id:\"minecraft:copper_block\",components:{\"minecraft:item_name\":\"Redstone Router\"}}}]}")
        }
    }
}