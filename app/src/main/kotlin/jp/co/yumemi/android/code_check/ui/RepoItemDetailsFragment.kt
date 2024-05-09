package jp.co.yumemi.android.code_check.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.databinding.FragmentRepoItemDetailsBinding
import jp.co.yumemi.android.code_check.view.RepoItemDetailsViewModel

@AndroidEntryPoint
class RepoItemDetailsFragment : Fragment(R.layout.fragment_repo_item_details) {

    private var _binding: FragmentRepoItemDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RepoItemDetailsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRepoItemDetailsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner // Important for LiveData binding
        binding.viewModel = viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
