package com.example.sc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sc.databinding.FragmentTypeMovieBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TypeMovieFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var mBindinging: FragmentTypeMovieBinding? = null
    private val binding get() = mBindinging!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBindinging = FragmentTypeMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        mBindinging = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textviewMovie.text = param1
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TypeMovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


