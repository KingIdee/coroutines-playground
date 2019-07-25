package dev.idee.rxjavacoroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.*


class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel

    private val uiDispatcher: CoroutineDispatcher = Dispatchers.Main
    private val bgDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val uiScope = CoroutineScope(uiDispatcher)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)
        // TODO: Use the ViewModel




        uiScope.launch {

            coroutineScope {

            }


            val task = async(bgDispatcher) { // background thread
                // your blocking call
            }

            // recommended
            val result = withContext(bgDispatcher) { // background thread
                // your blocking call
            }



        }



        GlobalScope.launch {

        }


    }

}
