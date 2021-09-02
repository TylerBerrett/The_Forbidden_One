package com.tylerb.testapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tylerb.testapp.databinding.FragmentDefaultBinding
import com.tylerb.testapp.util.DataStoreManager
import com.tylerb.testapp.util.Result
import com.tylerb.testapp.viewmodel.DefaultViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DefaultFragment : Fragment() {

    private lateinit var binding: FragmentDefaultBinding

    @Inject
    lateinit var dataStoreManager: DataStoreManager

    private val viewModel: DefaultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDefaultBinding.inflate(inflater, container, false)

        binding.textView.text = this.javaClass.name

        viewModel.getPokemon("mewtwo").observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    binding.textView.text = result.data.toString()

                }
                is Result.Error -> binding.textView.text = result.exception.toString()
            }
        }


        return binding.root
    }

}