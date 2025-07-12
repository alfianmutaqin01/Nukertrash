package com.app.nukertrash.view.masyarakat.artikel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.nukertrash.data.model.request.Article
import java.util.Locale

class ArtikelViewModel : ViewModel(){

    val articles = arrayListOf(
        Article(
            "Cara Menjadi Kontributor NUKERTRASH",
            "Ingin berkontribusi untuk keberlanjutan lingkungan? Temukan caranya di sini!",
            "January 25, 2024"
        ),
        Article(
            "Tips Mengelola Sampah Rumah Tangga",
            "Pelajari cara efektif mengelola sampah di rumah tangga untuk hidup lebih berkelanjutan.",
            "January 24, 2024"
        ),
        Article(
            "Manfaat Daur Ulang Plastik",
            "Daur ulang plastik dapat membantu mengurangi dampak limbah plastik terhadap lingkungan. Yuk, ketahui manfaatnya!",
            "January 23, 2024"
        ),
        Article(
            "Mengenal Jenis-jenis Sampah Elektronik",
            "Sampah elektronik mengandung bahan berbahaya. Kenali jenis-jenisnya agar bisa didaur ulang dengan benar.",
            "January 22, 2024"
        ),
        Article(
            "Tips Hemat Energi di Rumah",
            "Dengan mengadopsi kebiasaan hemat energi, kita dapat membantu mengurangi dampak perubahan iklim.",
            "January 21, 2024"
        ),
        Article(
            "Cara Mengurangi Penggunaan Plastik Secara Bertahap",
            "Mulailah mengurangi penggunaan plastik dengan langkah-langkah sederhana. Setiap usaha kita berarti!",
            "January 20, 2024"
        ),
        Article(
            "Keuntungan Memilah Sampah di Rumah",
            "Memilah sampah di rumah membawa banyak keuntungan, termasuk membantu proses daur ulang.",
            "January 19, 2024"
        ),
        Article(
            "Mengenal Konsep Zero Waste",
            "Zero Waste adalah gaya hidup yang berupaya untuk mengurangi produksi sampah. Bagaimana cara menerapkannya?",
            "January 18, 2024"
        ),
        Article(
            "Tips Berkebun di Rumah untuk Pemula",
            "Berkebun di rumah dapat menjadi kegiatan yang menyenangkan dan bermanfaat. Yuk, mulai tanam tanaman!",
            "January 17, 2024"
        ),
        Article(
            "Pentingnya Penghijauan Kota",
            "Penghijauan kota memiliki dampak positif terhadap kesehatan dan lingkungan. Mari dukung penghijauan!",
            "January 16, 2024"
        ),
        Article(
            "Cara Menyelamatkan Satwa Liar",
            "Satwa liar seringkali terancam oleh aktivitas manusia. Mari ikut serta dalam upaya penyelamatan satwa liar!",
            "January 15, 2024"
        ),
        Article(
            "Tips Memilih Produk Ramah Lingkungan",
            "Ketahui cara memilih produk yang ramah lingkungan untuk mendukung gaya hidup berkelanjutan.",
            "January 14, 2024"
        ),
        Article(
            "Mengenal Pola Makan Berkelanjutan",
            "Pola makan berkelanjutan dapat membantu mengurangi jejak karbon dan dampak lingkungan lainnya.",
            "January 13, 2024"
        ),
        Article(
            "Manfaat Menggunakan Transportasi Publik",
            "Menggunakan transportasi publik tidak hanya efisien, tapi juga membantu mengurangi polusi udara.",
            "January 12, 2024"
        ),
        Article(
            "Cara Mengurangi Jejak Karbon Pribadi",
            "Kita dapat mengurangi jejak karbon pribadi dengan langkah-langkah sederhana sehari-hari.",
            "January 11, 2024"
        ),
        Article(
            "Peran Komunitas dalam Keberlanjutan",
            "Komunitas memainkan peran penting dalam mendorong keberlanjutan dan kesadaran lingkungan.",
            "January 10, 2024"
        ),
        Article(
            "Tips Mengatasi Limbah Plastik di Laut",
            "Limbah plastik di laut menjadi masalah serius. Yuk, kita lihat tips untuk mengatasinya!",
            "January 9, 2024"
        ),
        Article(
            "Keuntungan Memakai Produk Secondhand",
            "Menggunakan produk bekas atau secondhand memiliki berbagai keuntungan, termasuk mengurangi limbah.",
            "January 8, 2024"
        ),
        Article(
            "Cara Mendaur Ulang Baterai Bekas",
            "Baterai bekas mengandung bahan beracun. Ketahui cara yang aman untuk mendaur ulangnya.",
            "January 7, 2024"
        )
    )

    val _listArticle : MutableLiveData<List<Article>> = MutableLiveData()

    fun getArticleList(){
        var article = articles
        _listArticle.value = article
    }

    fun searchArticle(query : String){
        val filteredList = articles.filter { article ->
            article.title!!.toLowerCase(Locale.getDefault()).contains(query.toLowerCase(Locale.getDefault()))
        }
        _listArticle.value = filteredList
    }
}