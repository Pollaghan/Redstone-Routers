package com.fref.redstonerouters

import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack

class Commands {
    class ChangePingRange : BasicCommand {
        override fun execute(source: CommandSourceStack, p1: Array<String>) {
            val sender = source.sender
            if (p1.isEmpty()) {
                sender.sendRichMessage("<red>Usage: /ChangePingRange <PingRange>.... you know that right?")
                return
            }
            val PingArgs = p1[0]
            var PingRange = PingArgs.toIntOrNull()
            sender.sendMessage("Changed ping range to $PingRange")
        }
    }
    class PlacePingBlock : BasicCommand {
        override fun execute(source: CommandSourceStack, p1: Array<String>) {
            val player = source.sender as? org.bukkit.entity.Player ?: return
            val loc = player.location
            val snapX = if (loc.blockX < 0) "${loc.blockX + 1}.5" else "${loc.blockX}.5"
            val snapY = "${loc.blockY}"
            val snapZ = if (loc.blockZ < 0) "${loc.blockZ + 1}.5" else "${loc.blockZ}.5"
            val alignedLocationString = "$snapX $snapY $snapZ"
            Blocks.PingBlock.PlaceBlock(alignedLocationString, player.name)
        }
    }
    class PlaceRedstoneRouter : BasicCommand {
        override fun execute(source: CommandSourceStack, p1: Array<String>) {
            val player = source.sender as? org.bukkit.entity.Player ?: return
            val loc = player.location
            val snapX = if (loc.blockX < 0) "${loc.blockX + 1}.5" else "${loc.blockX}.5"
            val snapY = "${loc.blockY}"
            val snapZ = if (loc.blockZ < 0) "${loc.blockZ + 1}.5" else "${loc.blockZ}.5"
            val alignedLocationString = "$snapX $snapY $snapZ"
            Blocks.RedstoneRouter.PlaceBlock(alignedLocationString, player.name)
        }
    }
    class OpenPingBlockGUI : BasicCommand {
        override fun execute(source: CommandSourceStack, p1: Array<String>) {
            val player = source.sender as? org.bukkit.entity.Player ?: return
            Blocks.PingBlock.openGui(RedstoneRouters(), player)
        }
    }
}