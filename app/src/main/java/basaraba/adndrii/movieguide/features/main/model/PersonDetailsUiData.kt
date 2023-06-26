package basaraba.adndrii.movieguide.features.main.model

data class PersonDetailsUiData(
    val id: Long,
    val alsoKnownAs: List<String>,
    val department: String,
    val name: String,
    val avatar: String,
    val biography: String,
    val birthday: String,
    val deathday: String,
    val placeOfBirth: String,
    val popularity: Double,
    val images: List<String>,
    val movieRoles: List<MovieRoles>
)

data class MovieRoles(
    val id: Long,
    val popularity: Double,
    val poster: String,
    val title: String,
    val role: String
)
