package jp.co.yumemi.android.code_check.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.databinding.FragmentRepoItemDetailsBinding
import jp.co.yumemi.android.code_check.view.RepoItemDetailsViewModel
import jp.co.yumemi.android.code_check.view.RepoSearchViewModel
@AndroidEntryPoint
class RepoItemDetailsFragment : Fragment(R.layout.fragment_repo_item_details) {

    private var _binding: FragmentRepoItemDetailsBinding? = null
    private val binding get() = _binding!!

    //private val viewModel: RepoSearchViewModel by activityViewModels()

    private val viewModel: RepoItemDetailsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRepoItemDetailsBinding.bind(view)

        viewModel.selectedItem.observe(viewLifecycleOwner) { item ->
            item?.let {
                with(item) {
                    binding.apply {
                        ownerIconView.load(owner.avatarUrl)
                        nameView.text = name
                        languageView.text = language
                        starsView.text = getString(R.string.stars, stargazersCount)
                        watchersView.text = getString(R.string.watchers, watchersCount)
                        forksView.text = getString(R.string.forks, forksCount)
                        openIssuesView.text = getString(R.string.open_issues, openIssuesCount)
                    }
                }
            }
        }
    }
}