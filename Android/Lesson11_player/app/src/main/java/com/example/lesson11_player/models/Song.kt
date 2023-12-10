package com.example.lesson11_player.models

data class Song(private val id: Int, public val songName: String, public val artistName: String) {

    var state: SongState = SongState.PAUSE
    var likes: Int = 0
        get() = field

    var dislikes: Int = 0
        get() = field

    public fun like() {
        this.likes++
    }

    public fun dislike() {
        this.dislikes++
    }
}