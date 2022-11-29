package com.example.geulmeok

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

    fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    } // 뒤로가기 버튼 클릭했을 때 홈으로 이동하기

}