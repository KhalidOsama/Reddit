package com.osama.reddittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.osama.reddittest.ui.topics.TopicsFragment

class TopicsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topics_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TopicsFragment.newInstance())
                .commitNow()
        }
    }

}
