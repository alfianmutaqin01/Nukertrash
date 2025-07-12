package com.app.nukertrash.view.petugas.sampah.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.nukertrash.data.model.request.Sampah

class SampahViewModel : ViewModel() {

    val sampah = arrayListOf(
        Sampah("Kaca", 1000),
        Sampah("Plastik", 500),
        Sampah("Logam", 1200),
        Sampah("Kertas", 800),
        Sampah("Elektronik", 2500),
        Sampah("Kain", 600),
        Sampah("Kayu", 1500),
        Sampah("Botol", 300),
        Sampah("Keramik", 900),
        Sampah("Besi", 2000)
    )

    val leftInputs: MutableLiveData<List<String>> = MutableLiveData()
    val rightInputs: MutableLiveData<List<Double>> = MutableLiveData()

    init {
        val defaultLeftInputs = sampah.map { it.jenisSampah.toString() }
        val defaultRightInputs = sampah.map { it.harga!!.toDouble() }

        leftInputs.value = defaultLeftInputs
        rightInputs.value = defaultRightInputs
    }

    val sampahList: MutableLiveData<List<Sampah>> = MutableLiveData()

    fun getSampahList() {
        sampahList.value = sampah
    }
}
