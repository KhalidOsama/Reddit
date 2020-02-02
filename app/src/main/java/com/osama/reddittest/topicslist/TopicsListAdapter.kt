package com.osama.reddittest.topicslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osama.reddittest.R
import com.osama.reddittest.Utils.DateUtils
import com.osama.reddittest.data.Topic
import kotlinx.android.synthetic.main.topic_list_item.view.*

class TopicsListAdapter(private val upvotesDownvotesInterface: UpvotesDownvotesInterface) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<Topic> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TopicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.topic_list_item, parent, false),
            upvotesDownvotesInterface
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is TopicViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(topicsList: List<Topic>) {
        items = topicsList
    }


    inner class TopicViewHolder(
        itemView: View,
        var upvotesDownvotesInterface: UpvotesDownvotesInterface
    ): RecyclerView.ViewHolder(itemView) {
        val topicBody = itemView.topic_body
        val topiDate = itemView.topic_date
        val bUpvote = itemView.b_upvote
        val bDownvote = itemView.b_downvote

        fun bind(topic: Topic) {
            topicBody.text = topic.body
            topiDate.text = (DateUtils.printDateFromUtc(topic.date))
            bUpvote.text = topic.upVotes.toString()
            bDownvote.text = topic.downVotes.toString()
            bUpvote.setOnClickListener {
//                inform fragment in order to increment upvote
                bUpvote.text = topic.upVotes.inc().toString()
                notifyItemMoved(adapterPosition, calculateNewPosition(topic.upVotes.inc())?:adapterPosition)
                upvotesDownvotesInterface.upVote(topic.topicId)
            }
            bDownvote.setOnClickListener {
                //                inform fragment in order to increment downvotes
                bDownvote.text = topic.downVotes.inc().toString()
                upvotesDownvotesInterface.downVote(topic.topicId)
            }
        }
    }

    private fun calculateNewPosition(newUpVotes: Int): Int? {
        for ((index, topic) in items.withIndex()) {
            if (topic.upVotes < newUpVotes) {
                return index
            }
        }
        return null
    }

}