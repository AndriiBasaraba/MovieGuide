package basaraba.adndrii.movieguide.use_case.model

data class PersonDetailsDomainData(
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
    val imdbId: String,
    val movieRoles: List<RoleCredits>,
    val tvShowRoles: List<RoleCredits>
)

data class RoleCredits(
    val id: Long,
    val popularity: Double,
    val poster: String,
    val title: String,
    val role: String,
    val voteAverage: Double
)
