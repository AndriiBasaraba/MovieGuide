package basaraba.adndrii.movieguide.features.main.model

sealed class PersonUiData(val viewType: ViewType) {
    data class Person(
        val id: Long,
        val name: String,
        val avatar: String,
        val department: String
    ) : PersonUiData(ViewType.PERSON)

    data class LoadingMore(
        var isLoading: Boolean = false
    ) : PersonUiData(ViewType.LOAD_MORE)
}

enum class ViewType {
    PERSON, LOAD_MORE
}
