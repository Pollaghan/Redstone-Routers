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
            Blocks.PingBlock.PlaceBlock("~ ~ ~")
        }
    }
}