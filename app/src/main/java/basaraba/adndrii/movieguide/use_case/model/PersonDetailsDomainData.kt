package basaraba.adndrii.movieguide.use_case.model

data class PersonDetailsDomainData(
    val id: Long,
    val alsoKnownAs: List<String>,
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
    val poster: String,
    val title: String,
    val role: String
)
