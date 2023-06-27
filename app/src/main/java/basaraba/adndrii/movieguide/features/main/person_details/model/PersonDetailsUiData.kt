package basaraba.adndrii.movieguide.features.main.person_details.model

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
    val movieRoles: List<RoleCreditsUi>,
    val tvShowRoles: List<RoleCreditsUi>
) {
    companion object {
        val initial = PersonDetailsUiData(
            id = -1,
            alsoKnownAs = emptyList(),
            department = "",
            name = "",
            avatar = "",
            biography = "",
            birthday = "",
            deathday = "",
            placeOfBirth = "",
            popularity = 0.0,
            images = emptyList(),
            movieRoles = emptyList(),
            tvShowRoles = emptyList()
        )
    }
}

data class RoleCreditsUi(
    val id: Long,
    val popularity: Double,
    val poster: String,
    val title: String,
    val role: String
)
