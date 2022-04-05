data class Notes(
    val noteIds: String?,
    val tittle: String?,
    val text: String?,
    val privacy: Privacy?,
    val commentPrivacy: Privacy?,
    var comments: Comments,
) {

    enum class Privacy {
        All, Friends, FriendsFriend, Noone
    }

    data class Comments(
        val id: Int?,
        val message: String?
    )
}