package com.fref.redstonerouters
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin
import xyz.xenondevs.nova.api.Nova
class RedstoneRouters : JavaPlugin() {
    override fun onEnable() {
        logger.info("Aaa... MIC OK! note: why did i make the startup log this oh yeah because i have the humour of a shoe i hope i remember to remove this for the release")
        this.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val registrar = event.registrar()
            registrar.register("ChangePingRange", ChangePingRange())
        }
        val nova = Nova.getNova()
        val itemRegistry = nova.itemRegistry
        val item = itemRegistry.get("redstone-routers:Signal_Reader")
        val items = itemRegistry.getNonNamespaced("Signal_Reader")
        val id = item.id
        val namespace = id.namespace
        val name = id.name
        val idString = id.toString()

    }
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
}