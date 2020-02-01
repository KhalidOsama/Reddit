package com.osama.reddittest.topics

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.osama.reddittest.R
import com.osama.reddittest.Utils.CardviewSpacingHelper
import com.osama.reddittest.data.Topic
import kotlinx.android.synthetic.main.topics_fragment.*
import java.util.*

class TopicsFragment : Fragment() {

    private lateinit var topicsAdapter: TopicsAdapter
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
        // TODO: Use the ViewModel

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
        val action = TopicsFragmentDirections
            .actionTopicsFragmentToAddTopicFragment()
        findNavController().navigate(action)
    }

    private fun setRecyclerView() {
        rv_topics.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(CardviewSpacingHelper(30))
            topicsAdapter = TopicsAdapter()
            adapter = topicsAdapter
        }
    }

}
