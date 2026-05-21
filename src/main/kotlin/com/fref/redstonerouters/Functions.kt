package com.fref.redstonerouters

import org.bukkit.Bukkit

object Functions {
    fun RunCommand(Command: String) {
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "/$Command");
    }
}