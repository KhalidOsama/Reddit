package com.osama.reddittest.topics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osama.reddittest.data.Topic
import com.osama.reddittest.data.TopicsRepository

class TopicsViewModel(
    private val topicsRepository: TopicsRepository
) : ViewModel() {

    private val topics = MutableLiveData<List<Topic>>().apply { value = emptyList() }

    fun getTopics() : LiveData<List<Topic>> {
        return topics
    }

}
