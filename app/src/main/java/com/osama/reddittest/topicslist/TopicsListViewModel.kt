package com.osama.reddittest.topicslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osama.reddittest.data.Topic
import com.osama.reddittest.data.TopicsRepository

class TopicsListViewModel : ViewModel() {

    private val topics = MutableLiveData<List<Topic>>().apply { value = ArrayList() }
    private val _topics = mutableMapOf<String, Topic>()
    fun getTopics() : LiveData<List<Topic>> {
        return topics
    }

    fun addTopic(topic: Topic) {
        _topics.put(topic.topicId, topic)
        topics.postValue(_topics.values.toList())
    }

}
