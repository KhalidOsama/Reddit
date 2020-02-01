package com.osama.reddittest.topicslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.osama.reddittest.R
import com.osama.reddittest.Utils.CardviewSpacingHelper
import com.osama.reddittest.data.Topic
import kotlinx.android.synthetic.main.topics_fragment.*

class TopicsListFragment : Fragment() {

    private lateinit var topicsListAdapter: TopicsListAdapter
    companion object {
        fun newInstance() = TopicsListFragment()
    }

    private lateinit var listViewModel: TopicsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.topics_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel: TopicsListViewModel by activityViewModels()
        viewModel.getTopics().observe(viewLifecycleOwner,
            Observer<List<Topic>> {
                topics -> topicsListAdapter.submitList(topics)
            })
        setRecyclerView()
        setupFab()
    }

    private fun setupFab() {
        activity?.findViewById<FloatingActionButton>(R.id.fab_add_topic)?.let {
            it.setOnClickListener {
                navigateToAddNewTopic()
            }
        }
    }

    private fun navigateToAddNewTopic() {
        val action = TopicsListFragmentDirections
            .actionTopicsFragmentToAddTopicFragment()
        findNavController().navigate(action)
    }

    private fun setRecyclerView() {
        rv_topics.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(CardviewSpacingHelper(30))
            topicsListAdapter = TopicsListAdapter()
            adapter = topicsListAdapter
        }
    }

}
