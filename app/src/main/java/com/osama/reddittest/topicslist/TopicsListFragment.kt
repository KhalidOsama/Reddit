package com.osama.reddittest.topicslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.osama.reddittest.R
import com.osama.reddittest.utils.CardviewSpacingHelper
import com.osama.reddittest.data.Topic
import kotlinx.android.synthetic.main.topics_fragment.*

class TopicsListFragment : Fragment(){

    private lateinit var topicsListAdapter: TopicsListAdapter

    private val viewModel : TopicsListViewModel by activityViewModels()

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
                if (it.isEmpty()) {no_topics.visibility = View.VISIBLE}
                else {no_topics.visibility = View.GONE}
                topicsListAdapter.submitList(it.take(20))
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

    private fun navigateToTopicDetails(topicId: String) {
        val action = TopicsListFragmentDirections
            .actionTopicsFragmentToTopicDetailsFragment(topicId)
        findNavController().navigate(action)
    }

    private fun setRecyclerView() {
        rv_topics.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(CardviewSpacingHelper(30))
            topicsListAdapter = TopicsListAdapter(object: VoteAndSelectInterface {
                override fun upVote(topicId: String) {
//                    update the VM for other observers out there
                    viewModel.upvoteTopic(topicId)
                }

                override fun downVote(topicId: String) {
                    viewModel.downvoteTopic(topicId)
                }

//                Go to the details of this clicked topic
                override fun itemSelected(topicId: String) {
                    navigateToTopicDetails(topicId)
                }
            })
            adapter = topicsListAdapter
        }
    }

}
