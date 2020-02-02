package com.osama.reddittest.topicslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osama.reddittest.data.Topic
import com.osama.reddittest.data.TopicsRepository

class TopicsListViewModel : ViewModel() {

    private val topics = MutableLiveData<List<Topic>>().apply { value = ArrayList() }
    private var _topics = mutableMapOf<String, Topic>()
    fun getTopics() : LiveData<List<Topic>> {
        return topics
    }

    fun getTopic(topicId: String): Topic? {
        return _topics.get(topicId)
    }

    fun addTopic(topic: Topic) {
        _topics.put(topic.topicId, topic)
        //        Sort by upvotes descendingly
        sort()
        topics.postValue(_topics.values.toList())
    }

    fun upvoteTopic(topicId: String) {
        _topics.get(topicId)?.upVotes = _topics.get(topicId)?.upVotes!!.inc()
//        Sort by upvotes descendingly
        sort()
        topics.postValue(_topics.values.toList())
    }

    fun downvoteTopic(topicId: String) {
        _topics.get(topicId)?.downVotes = _topics.get(topicId)?.downVotes!!.inc()
        topics.postValue(_topics.values.toList())
    }

    //        Sort by upvotes descendingly
    private fun sort() {
        _topics = _topics.toList().sortedByDescending {it.second.upVotes}.toMap().toMutableMap()
    }
}
