package tech.ericwathome.moments.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tech.ericwathome.moments.repository.Repository

class ImagesFragmentViewModel: ViewModel() {
    private val _allImagesState = MutableStateFlow<List<Image>>(emptyList())
    val allImagesSate: StateFlow<List<Image>> = _allImagesState
    var isCreated = false

    fun getAllPhotos() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            _allImagesState.value = Repository.getAllPhotos()
        }
    }
}