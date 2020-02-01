package com.osama.reddittest.addtopics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.osama.reddittest.R
import com.osama.reddittest.data.Topic
import com.osama.reddittest.topicslist.TopicsListFragmentDirections
import com.osama.reddittest.topicslist.TopicsListViewModel
import kotlinx.android.synthetic.main.add_topic_fragment.*
import kotlinx.android.synthetic.main.topics_fragment.*
import kotlinx.coroutines.flow.callbackFlow
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AddTopicFragment : Fragment() {

    private val viewModel : TopicsListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_topic_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel

        setupFab()
    }

    private fun setupFab() {
        activity?.findViewById<FloatingActionButton>(R.id.fab_save_topic)?.let {
            it.setOnClickListener {
                when (et_topic_body.text?.length?:0){
//                    If no content prompt
                    0 -> Snackbar.make(
                        it, // Parent view
                        "Kindly enter a topic", // Message to show
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
//                    If there is content, add it to the view model and navigate back to the list
                    else -> {
                        viewModel.addTopic(
                            Topic(
                                UUID.randomUUID().toString(),
                                et_topic_body.text.toString(),
                                Calendar.getInstance().timeInMillis
                            ))
                        Toast.makeText(activity,
                            "Topic entered successfully",
                            Toast.LENGTH_SHORT)
                            .show()
                        navigateToTopicsList()
                    }
                }
            }
        }
    }

    private fun navigateToTopicsList() {
        val action = AddTopicFragmentDirections
            .actionAddTopicFragmentToTopicsFragment()
        findNavController().navigate(action)
    }

}
