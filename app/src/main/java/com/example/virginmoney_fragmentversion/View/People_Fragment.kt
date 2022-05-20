package com.example.virginmoney_fragmentversion.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney_fragmentversion.Adapter.PeopleAdapter
import com.example.virginmoney_fragmentversion.Viewmodel.PeopleViewModel
import com.example.virginmoney_fragmentversion.databinding.FragmentPeopleFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class People_Fragment : Fragment() {


    private lateinit var binding: FragmentPeopleFragmentBinding
    private lateinit var recyclerview: RecyclerView
   private val viewModel: PeopleViewModel by viewModels()
    private lateinit var peopleadapter: PeopleAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPeopleFragmentBinding.inflate(
            inflater,
            container,
            false,
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview = binding.RecyclerView
        peopleadapter = PeopleAdapter()
        recyclerview.apply {
            adapter = peopleadapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
        populatingRecyclerView()


    }

    private fun populatingRecyclerView(){


        viewModel.responsePeople.observe(viewLifecycleOwner) { it ->
            peopleadapter.submitList(it)


        }


            }
        }








