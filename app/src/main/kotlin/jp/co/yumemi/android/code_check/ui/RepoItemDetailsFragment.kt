package jp.co.yumemi.android.code_check.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.databinding.FragmentRepoItemDetailsBinding
import jp.co.yumemi.android.code_check.view.RepoItemDetailsViewModel

/**
 * A fragment that displays the details of a repository item.
 * It utilizes data binding to bind UI components to LiveData within the [RepoItemDetailsViewModel].
 *
 * This fragment is annotated with [AndroidEntryPoint] which allows Hilt to inject the required dependencies,
 * particularly the ViewModel which is scoped to the activity.
 *
 * @property _binding Holds the binding reference between the layout XML and the corresponding data.
 * @property binding Provides a non-nullable version of the binding property through a custom getter,
 * ensuring it is never used uninitialized.
 * @property viewModel Scoped to the activity, it provides the data and functionality to the UI.
 */
@AndroidEntryPoint
class RepoItemDetailsFragment : Fragment(R.layout.fragment_repo_item_details) {

    private var _binding: FragmentRepoItemDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RepoItemDetailsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRepoItemDetailsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
