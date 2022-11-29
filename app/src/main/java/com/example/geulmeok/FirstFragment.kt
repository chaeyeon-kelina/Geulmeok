package com.example.geulmeok

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.geulmeok.databinding.FragmentFirstBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

//    private var _binding: FragmentFirstBinding? = null
//    private val binding get() = _binding!!
//    lateinit var binding: FragmentFirstBinding



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
//        val fab = (FloatingActionButton) findViewById(R.id.fab);

        val fab: View = view.findViewById<FloatingActionButton>(R.id.fab_routine)

        fab.setOnClickListener(({
            val intent = Intent(context, Recommend::class.java)
            startActivity(intent)
            activity?.finish()
        }))
        return view;
//        _binding = FragmentFirstBinding.inflate(inflater, container, false)
////        initView()
//        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
    }

//    private fun initView()= with(binding) {
////        binding.view.findViewById<FloatingActionButton>(R.id.fab_routine).setOnClickListener {
//        binding.fabRoutine.setOnClickListener {
//            Navigation.findNavController(binding.root)
//                .navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        Navigation.findNavController(binding.root)
//        navController = Navigation.findNavController(view)

//        binding.fabRoutine.setOnClickListener {
//            Navigation.findNavController(binding.root)
//                .navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

//
//        view.findViewById<FloatingActionButton>(R.id.fab_routine).setOnClickListener {
//            navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }
}