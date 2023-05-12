package com.example.finallyprojectuts.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finallyprojectuts.R
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finallyprojectuts.Komik
import com.example.finallyprojectuts.detailKomikActivity

class UntukmuFragment : Fragment() {
    private lateinit var adapter:komikAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var komikArrayList: ArrayList<Komik>

    lateinit var image: Array<Int>
    lateinit var detailimage: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var chapter: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_untukmu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            komikAdapter(it, komikArrayList){
                val intent = Intent(context, detailKomikActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }
    private fun dataInitialize(){
        komikArrayList = arrayListOf<Komik>()

        detailimage = arrayOf(
            R.drawable.ahmad_yani,
            R.drawable.dewi_sartika,
            R.drawable.ki_hajar_dewantara,
            R.drawable.kartini,
            R.drawable.donald_isaac_panjaitan,
            R.drawable.mas_tirtodarmo_haryono,
            R.drawable.mohamad_hatta,
            R.drawable.mohammad_yamin,
            R.drawable.pierre_tendean,
            R.drawable.siswondo_parman,
        )

        image = arrayOf(
            R.drawable.ahmad_yani,
            R.drawable.dewi_sartika,
            R.drawable.ki_hajar_dewantara,
            R.drawable.kartini,
            R.drawable.donald_isaac_panjaitan,
            R.drawable.mas_tirtodarmo_haryono,
            R.drawable.mohamad_hatta,
            R.drawable.mohammad_yamin,
            R.drawable.pierre_tendean,
            R.drawable.siswondo_parman,
        )

        title = arrayOf(
           "ahmad_yani",
           "dewi_sartika",
           "ki_hajar_dewantara",
           "kartini",
           "donald_isaac_panjaitan",
           "mas_tirtodarmo_haryono",
           "mohamad_hatta",
           "mohammad_yamin",
           "pierre_tendean",
           "siswondo_parman",

        )

        description = arrayOf(
            "seorang jenderal dan pahlawan nasional Indonesia yang lahir pada 19 Juni 1922 dan meninggal pada 1 Oktober 1965 dalam peristiwa G30S/PKI.",
            "seorang tokoh pendidikan Indonesia yang lahir pada 4 Desember 1884 di Bandung, Jawa Barat, dan meninggal pada 11 September 1947 di Cimahi, Jawa Barat",
            "seorang tokoh pendidikan, aktivis, dan penulis Indonesia. Ia juga dikenal sebagai Bapak Pendidikan Nasional Indonesia.",
            "seorang tokoh perempuan Indonesia yang dikenal karena perjuangannya dalam memperjuangkan hak-hak perempuan dan pendidikan bagi perempuan.",
            "Brigadir Jenderal TNI, tetapi karena gugur dalam tugas, maka diberikan Kenaikan Pangkat Luar Biasa (KPLB) menjadi Mayjen",
            "salah satu pahlawan revolusi Indonesia yang terbunuh pada peristiwa G30SPKI. Ia dimakamkan di TMP Kalibata - Jakarta.",
            "salah satu pendiri Republik Indonesia yang juga menjabat sebagai Wakil Presiden Indonesia pertama bersama Presiden Soekarno dari tahun 1945 hingga 1966. ",
            "seorang pejuang kemerdekaan Indonesia, ahli hukum, dan penulis yang sangat dihormati di Indonesia. Ia lahir pada tanggal 17 Agustus 1903 di Talawi, Sumatera Barat dan meninggal pada tanggal 17 Oktober 1962 di Jakarta.",
            "seorang politisi dan aktivis mahasiswa Indonesia yang terkenal. Ia lahir pada tanggal 23 Januari 1943 di Manado, Sulawesi Utara dan meninggal dunia pada tanggal 12 Februari 1974 di Jakarta.",
            "seorang tokoh militer dan politisi Indonesia yang lahir pada tanggal 14 Agustus 1925 di Kudus, Jawa Tengah dan meninggal pada tanggal 5 Oktober 1965 di Jakarta.",
            )

        chapter = arrayOf(
            "Chapter 2",
            "Chapter 5",
            "Chapter 4",
            "Chapter 2",
            "Chapter 6",
            "Chapter 3",
            "Chapter 5",
            "Chapter 4",
            "Chapter 4",
            "Chapter 5",
        )
        for (i in image.indices){
            val komik = Komik(image[i], title[i], description[i], detailimage[i], chapter[i],)
            komikArrayList.add(komik)
        }
    }


}