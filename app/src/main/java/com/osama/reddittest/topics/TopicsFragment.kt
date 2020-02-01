package com.osama.reddittest.topics

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.osama.reddittest.R

class TopicsFragment : Fragment() {

    companion object {
        fun newInstance() = TopicsFragment()
    }

    private lateinit var viewModel: TopicsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.topics_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopicsViewModel::class.java)
        // TODO: Use the ViewModel

        setupFab()
    }

    private fun setupFab() {
        activity?.findViewById<FloatingActionButton>(R.id.fab_add_topic)?.let {
            it.setOnClickListener {
                navigateToAddNewTask()
            }
        }
    }

    private fun navigateToAddNewTask() {
        val action = TopicsFragmentDirections
            .actionTopicsFragmentToAddTopicFragment()
        findNavController().navigate(action)
    }
}
