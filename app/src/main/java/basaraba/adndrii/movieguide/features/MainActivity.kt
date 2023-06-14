package basaraba.adndrii.movieguide.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import basaraba.adndrii.movieguide.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = checkNotNull(_binding)

    private val movieDetailsViewModel: NowPlayingMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReload.setOnClickListener { movieDetailsViewModel.getNowPlayingMoviesUseCase() }
    }
}
