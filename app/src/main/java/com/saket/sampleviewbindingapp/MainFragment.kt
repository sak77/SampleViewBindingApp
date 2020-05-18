package com.saket.sampleviewbindingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saket.sampleviewbindingapp.databinding.FragmentMainBinding

/**
Created by sshriwas on 2020-05-18

 Using ViewBinding inside fragment.

Note: Fragments outlive their views.
Make sure you clean up any references to the binding class instance in the fragment's onDestroyView() method.
 */
class MainFragment : Fragment() {

    //Binding in fragment is only valid between onCreateView() and onDestroyView()
    //So we must override onDestroyView and set binding instance to null
    //But to set binding to null, we have to make its field a nullable.
    //But then we cannot use lateint as it is not allowed on nullable types.
    //So we remove lateint and initialize the var to null.
    //Instead we convert binding to _binding making it a backing property for another val binding
    //binding val's get() returns instance of _binding
    private var _binding : FragmentMainBinding? = null

    //the not-null assertion operator (!!) converts any value to a non-null type and throws an exception if the value is null.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        //Using binding instead of _binding since _binding is mutable property and smartcast does not work with it.
        val rootView = binding.root
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}