package com.nasch.apps.boardGamesApp
//clase de los juegos de mesa
data class Game (val name:String, val category: GameCategory, var isSelected:Boolean = false)
