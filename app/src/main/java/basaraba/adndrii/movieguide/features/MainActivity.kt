package basaraba.adndrii.movieguide.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import basaraba.adndrii.movieguide.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val movieDetailsViewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this is for test purpose
        movieDetailsViewModel.getMovieDetail()
    }
}
