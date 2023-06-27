package basaraba.adndrii.movieguide.features.main.persons

enum class PersonsView {
    GRID, LIST;

    companion object {
        fun PersonsView.getChangedView(): PersonsView =
            if (this == GRID) {
                LIST
            } else {
                GRID
            }
    }
}
