package com.fref.redstonerouters
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerJoinEvent

class RedstoneRouters : JavaPlugin() {
    override fun onEnable() {
        logger.info("Aaa... MIC OK! note: why did i make the startup log this oh yeah because i have the humour of a shoe i hope i remember to remove this for the release")
        this.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val registrar = event.registrar()
            registrar.register("ChangePingRange", Commands.ChangePingRange())
        }
        this.lifecycleManager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val registrar = event.registrar()
            registrar.register("PlacePingBlock", Commands.PlacePingBlock())
        }
    }
}