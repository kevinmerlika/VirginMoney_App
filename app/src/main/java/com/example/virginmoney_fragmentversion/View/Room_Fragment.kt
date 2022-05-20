package com.example.virginmoney_fragmentversion.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney_fragmentversion.Adapter.RoomAdapter
import com.example.virginmoney_fragmentversion.Viewmodel.PeopleViewModel
import com.example.virginmoney_fragmentversion.databinding.FragmentRoomFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Room_Fragment : Fragment() {


    private lateinit var binding: FragmentRoomFragmentBinding
    private lateinit var recyclerview: RecyclerView
    private val viewModel: PeopleViewModel by viewModels()
    private lateinit var roomadapter: RoomAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRoomFragmentBinding.inflate(
            inflater,
            container,
            false,
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview = binding.RoomRecyclerView
        roomadapter = RoomAdapter()
        recyclerview.apply {
            adapter = roomadapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
        populatingRecyclerView()


    }

    private fun populatingRecyclerView(){


        viewModel.responseRoom.observe(viewLifecycleOwner) { it ->
            roomadapter.submitList(it)


        }



    }
}
