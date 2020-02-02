package com.osama.reddittest.topicdetails


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.osama.reddittest.R
import com.osama.reddittest.Utils.DateUtils
import com.osama.reddittest.data.Topic
import com.osama.reddittest.topicslist.TopicsListViewModel
import kotlinx.android.synthetic.main.topic_details_fragment.*

/**
 * A simple [Fragment] subclass.
 */
class TopicDetailsFragment : Fragment() {

    private lateinit var topic: Topic
    val args: TopicDetailsFragmentArgs by navArgs()
    private val viewModel : TopicsListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.topic_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel: TopicsListViewModel by activityViewModels()
        viewModel.getTopic(args.topicId)?.let{
            topic = it
            setupTopic()
        }

    }

    private fun setupTopic() {
        topic_body.text = topic.body
        topic_date.text = (DateUtils.printDateFromUtc(topic.date))
        b_upvote.text = topic.upVotes.toString()
        b_downvote.text = topic.downVotes.toString()
        b_upvote.setOnClickListener {
            b_upvote.text = topic.upVotes.inc().toString()
            viewModel.upvoteTopic(args.topicId)
        }
        b_downvote.setOnClickListener {
            b_downvote.text = topic.downVotes.inc().toString()
            viewModel.downvoteTopic(args.topicId)
        }
    }

}