package com.example.genshinassistant.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.genshinassistant.navigation.NavigationItem

class NavigatorViewModel : ViewModel() {
    private val _currentItem = mutableStateOf<NavigationItem>(NavigationItem.Grid)
    val currentItem: State<NavigationItem> get() = _currentItem

    fun navigateTo(navigationItem: NavigationItem) {
        _currentItem.value = navigationItem
    }
}