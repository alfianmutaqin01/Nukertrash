package com.app.nukertrash.view.petugas.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.nukertrash.data.model.request.DaftarPickup
import java.util.Locale

class ViewModelHome : ViewModel() {

    val daftarPickup = arrayListOf(
        DaftarPickup("Raynaldi Zulfikar", "01", "02"),
        DaftarPickup("Amanda Johnson", "03", "04"),
        DaftarPickup("John Doe", "05", "06"),
        DaftarPickup("Emily Smith", "07", "08"),
        DaftarPickup("Michael Brown", "09", "10"),
        DaftarPickup("Sophia Lee", "11", "12"),
        DaftarPickup("David Miller", "13", "14"),
        DaftarPickup("Olivia Wilson", "15", "16"),
        DaftarPickup("Daniel White", "17", "18"),
        DaftarPickup("Emma Harris", "19", "20")
    )

    val _listPickup: MutableLiveData<List<DaftarPickup>> = MutableLiveData()

    fun getPickupList() {
        _listPickup.value = daftarPickup
    }

    fun searchPickup(query: String) {
        val filteredList = daftarPickup.filter { pickup ->
            pickup.nama?.toLowerCase(Locale.getDefault())
                ?.contains(query.toLowerCase(Locale.getDefault())) == true
        }
        _listPickup.value = filteredList
    }
}
