package dev.idee.rxjavacoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BlankViewModel : ViewModel() {

    lateinit var liveDataString: LiveData<String>

    init {

        viewModelScope.launch {

            liveDataString = liveData(Dispatchers.IO) {
                emit("Test String")
            }

        }

    }


}
