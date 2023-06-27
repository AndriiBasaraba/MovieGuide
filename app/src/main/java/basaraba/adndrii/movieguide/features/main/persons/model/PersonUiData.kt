package basaraba.adndrii.movieguide.features.main.persons.model

sealed class PersonUiData(val itemId: Long, val viewType: ViewType) {
    data class Person(
        val id: Long,
        val name: String,
        val avatar: String,
        val popularity: Double,
        val knownFor: String
    ) : PersonUiData(itemId = id, viewType = ViewType.PERSON)

    data class LoadingMore(
        var isLoading: Boolean = false
    ) : PersonUiData(itemId = -1, viewType = ViewType.LOAD_MORE)
}

enum class ViewType {
    PERSON, LOAD_MORE
}
