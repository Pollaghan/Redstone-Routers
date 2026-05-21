package com.fref.redstonerouters

class Blocks {
    object PingBlock {
        fun PlaceBlock(PlaceLocation: String) {
            var index = 1
            Functions.RunCommand("/summon block_display $PlaceLocation {Tags:[\"PingBlock$index\"],transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[-0.5f,0.0f,-0.5f],scale:[1.0f,1.0f,1.0f]},Passengers:[{id:\"minecraft:shulker\",Silent:1b,Invulnerable:1b,NoAI:1b,AttachFace:0b,Tags:[\"PingBlockCollider$index\"],active_effects:[{id:\"minecraft:invisibility\",amplifier:255,duration:999999,show_particles:0b,show_icon:0b,ambient:1b}]}],block_state:{Name:\"minecraft:stone\"}}")
        }
    }
}