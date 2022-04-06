object WallService {
    private var notes = mutableListOf<Notes>()
    private var notesRemove = mutableListOf<Notes>()
    private var comments = mutableListOf<Notes.Comments>()
    private var commentsRemove = mutableListOf<Notes.Comments>()

    fun add(note: Notes): Notes {
        notes.add(note)
        return notes.last()
    }

    fun addComment(notes: Notes, comment: Notes.Comments): Notes {
        notes.comments = comment
        comments.add(comment)
        return notes
    }

    fun removeComment(notes: Notes, comment: Notes.Comments): Boolean {
        if (notes.comments == comment) notes.comments = Notes.Comments(null, null)
        commentsRemove.add(comment)
        comments.remove(comment)
        return true
    }

    fun remove(note: Notes): Boolean {
        notesRemove.add(note)
        notes.remove(note)
        return true
    }

    fun edit(notess: Notes): Notes {
        val noteId = notess.noteIds
        for ((index, note) in notes.withIndex()) {
            if (note.noteIds == noteId) {
                notes.remove(note)
                notes.add(notess)
                comments.add(notess.comments)
            }
        }
        return notes.last()
    }

    fun editComment(commentNew: Notes.Comments): Notes.Comments? {
        val commentId = commentNew.id
        for (comment in comments)
            if (comment.id == commentId) {
                comments.remove(comment)
                comments.add(commentNew)
                return comments.last()
            } else throw PostNotFoundException()
        return null
    }

    fun get(note: Notes): Notes {
        for ((index, notesi) in notes.withIndex())
            if (note.noteIds == notesi.noteIds)
                notes[index] = note
        return note
    }


    fun getComment(comment: Notes.Comments): Notes.Comments {
        for ((index, commenti) in comments.withIndex())
            if (commenti.id == comment.id)
                comments[index] = comment
        return comment
    }

    private var memoryIdPost: Int = 1

    private fun generationId(): Int {
        memoryIdPost += 1
        return memoryIdPost - 1
    }

    fun clearArr() {
        comments.clear()
        notes.clear()
        memoryIdPost = 1
    }
}