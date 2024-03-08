package com.example.atvmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Spinner
import androidx.core.view.get

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s1: Spinner = findViewById(R.id.fdropdown)
        val s2: Spinner = findViewById(R.id.sdropdown)


        val source = arrayOf(
            "Chhatrapati Shivaji Maharaj Terminus (CSMT)",
            "Masjid Bunder",
            "Sandhurst Road",
            "Dockyard Road",
            "Reay Road",
            "Cotton Green",
            "Sewri",
            "Wadala Road",
            "Guru Tegh Bahadur Nagar (GTBN)",
            "Chunabhatti",
            "Kurla",
            "Tilak Nagar",
            "Chembur",
            "Govandi",
            "Mankhurd",
            "Vashi",
            "Sanpada",
            "Juinagar",
            "Nerul",
            "Seawoods–Darave",
            "CBD Belapur",
            "Kharghar",
            "Mansarovar",
            "Khandeshwar",
            "Panvel",
            "Churchgate",
            "Marine Lines",
            "Charni Road",
            "Grant Road",
            "Mumbai Central",
            "Lower Parel",
            "Mahalaxmi",
            "Elphinstone Road",
            "Dadar",
            "Matunga Road",
            "Mahim",
            "Bandra",
            "Khar Road",
            "Santacruz",
            "Vile Parle",
            "Andheri",
            "Jogeshwari",
            "Ram Mandir",
            "Goregaon",
            "Malad",
            "Kandivali",
            "Borivali",
            "Dahisar",
            "Mira Road",
            "Bhayandar",
            "Naigaon",
            "Vasai Road",
            "Nallasopara",
            "Virar",
            "Byculla",
            "Chinchpokli",
            "Currey Road",
            "Parel",
            "Dadar",
            "Matunga",
            "Sion",
            "Kurla",
            "Vidyavihar",
            "Ghatkopar",
            "Vikhroli",
            "Kanjurmarg",
            "Bhandup",
            "Nahur",
            "Mulund",
            "Thane",
            "Diva Junction",
            "Mumbra",
            "Kalwa",
            "Thakurli",
            "Dombivli",
            "Kopar",
            "kalyan",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara",
            "Sheelar",
            "Neral",
            "Bhivpuri Road",
            "Karjat",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara")
       // s1.setSelection(0,false)
        val arrayAdp1 = ArrayAdapter(this@MainActivity ,android.R.layout.simple_spinner_dropdown_item,source)
       s1.adapter=arrayAdp1

        val destination= arrayOf("Select destination",
            "Chhatrapati Shivaji Maharaj Terminus (CSMT)",
            "Masjid Bunder",
            "Sandhurst Road",
            "Dockyard Road",
            "Reay Road",
            "Cotton Green",
            "Sewri",
            "Wadala Road",
            "Guru Tegh Bahadur Nagar (GTBN)",
            "Chunabhatti",
            "Kurla",
            "Tilak Nagar",
            "Chembur",
            "Govandi",
            "Mankhurd",
            "Vashi",
            "Sanpada",
            "Juinagar",
            "Nerul",
            "Seawoods–Darave",
            "CBD Belapur",
            "Kharghar",
            "Mansarovar",
            "Khandeshwar",
            "Panvel",
            "Churchgate",
            "Marine Lines",
            "Charni Road",
            "Grant Road",
            "Mumbai Central",
            "Lower Parel",
            "Mahalaxmi",
            "Elphinstone Road",
            "Dadar",
            "Matunga Road",
            "Mahim",
            "Bandra",
            "Khar Road",
            "Santacruz",
            "Vile Parle",
            "Andheri",
            "Jogeshwari",
            "Ram Mandir",
            "Goregaon",
            "Malad",
            "Kandivali",
            "Borivali",
            "Dahisar",
            "Mira Road",
            "Bhayandar",
            "Naigaon",
            "Vasai Road",
            "Nallasopara",
            "Virar",
            "Byculla",
            "Chinchpokli",
            "Currey Road",
            "Parel",
            "Dadar",
            "Matunga",
            "Sion",
            "Kurla",
            "Vidyavihar",
            "Ghatkopar",
            "Vikhroli",
            "Kanjurmarg",
            "Bhandup",
            "Nahur",
            "Mulund",
            "Thane",
            "Diva Junction",
            "Mumbra",
            "Kalwa",
            "Thakurli",
            "Dombivli",
            "Kopar",
            "kalyan",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara",
            "Sheelar",
            "Neral",
            "Bhivpuri Road",
            "Karjat",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara")
        s2.setSelection(0,false)
        val arrayAdp2 = ArrayAdapter(this@MainActivity ,android.R.layout.simple_spinner_dropdown_item,destination)
        s2.adapter=arrayAdp2

        //searchbar
        val spinner: Spinner = findViewById(R.id.fdropdown)
         val spinner1: Spinner = findViewById(R.id.sdropdown)

        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.searchbar1)
        val autoCompleteTextView1: AutoCompleteTextView = findViewById(R.id.searchbar2)

        // Replace this array with your list of items
        val searchsource = arrayOf( "Chhatrapati Shivaji Maharaj Terminus (CSMT)",
            "Masjid Bunder",
            "Sandhurst Road",
            "Dockyard Road",
            "Reay Road",
            "Cotton Green",
            "Sewri",
            "Wadala Road",
            "Guru Tegh Bahadur Nagar (GTBN)",
            "Chunabhatti",
            "Kurla",
            "Tilak Nagar",
            "Chembur",
            "Govandi",
            "Mankhurd",
            "Vashi",
            "Sanpada",
            "Juinagar",
            "Nerul",
            "Seawoods–Darave",
            "CBD Belapur",
            "Kharghar",
            "Mansarovar",
            "Khandeshwar",
            "Panvel",
            "Churchgate",
            "Marine Lines",
            "Charni Road",
            "Grant Road",
            "Mumbai Central",
            "Lower Parel",
            "Mahalaxmi",
            "Elphinstone Road",
            "Dadar",
            "Matunga Road",
            "Mahim",
            "Bandra",
            "Khar Road",
            "Santacruz",
            "Vile Parle",
            "Andheri",
            "Jogeshwari",
            "Ram Mandir",
            "Goregaon",
            "Malad",
            "Kandivali",
            "Borivali",
            "Dahisar",
            "Mira Road",
            "Bhayandar",
            "Naigaon",
            "Vasai Road",
            "Nallasopara",
            "Virar",
            "Byculla",
            "Chinchpokli",
            "Currey Road",
            "Parel",
            "Dadar",
            "Matunga",
            "Sion",
            "Kurla",
            "Vidyavihar",
            "Ghatkopar",
            "Vikhroli",
            "Kanjurmarg",
            "Bhandup",
            "Nahur",
            "Mulund",
            "Thane",
            "Diva Junction",
            "Mumbra",
            "Kalwa",
            "Thakurli",
            "Dombivli",
            "Kopar",
            "kalyan",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara",
            "Sheelar",
            "Neral",
            "Bhivpuri Road",
            "Karjat",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara")

        val items1 = arrayOf("Chhatrapati Shivaji Maharaj Terminus (CSMT)",
            "Masjid Bunder",
            "Sandhurst Road",
            "Dockyard Road",
            "Reay Road",
            "Cotton Green",
            "Sewri",
            "Wadala Road",
            "Guru Tegh Bahadur Nagar (GTBN)",
            "Chunabhatti",
            "Kurla",
            "Tilak Nagar",
            "Chembur",
            "Govandi",
            "Mankhurd",
            "Vashi",
            "Sanpada",
            "Juinagar",
            "Nerul",
            "Seawoods–Darave",
            "CBD Belapur",
            "Kharghar",
            "Mansarovar",
            "Khandeshwar",
            "Panvel",
            "Churchgate",
            "Marine Lines",
            "Charni Road",
            "Grant Road",
            "Mumbai Central",
            "Lower Parel",
            "Mahalaxmi",
            "Elphinstone Road",
            "Dadar",
            "Matunga Road",
            "Mahim",
            "Bandra",
            "Khar Road",
            "Santacruz",
            "Vile Parle",
            "Andheri",
            "Jogeshwari",
            "Ram Mandir",
            "Goregaon",
            "Malad",
            "Kandivali",
            "Borivali",
            "Dahisar",
            "Mira Road",
            "Bhayandar",
            "Naigaon",
            "Vasai Road",
            "Nallasopara",
            "Virar",
            "Byculla",
            "Chinchpokli",
            "Currey Road",
            "Parel",
            "Dadar",
            "Matunga",
            "Sion",
            "Kurla",
            "Vidyavihar",
            "Ghatkopar",
            "Vikhroli",
            "Kanjurmarg",
            "Bhandup",
            "Nahur",
            "Mulund",
            "Thane",
            "Diva Junction",
            "Mumbra",
            "Kalwa",
            "Thakurli",
            "Dombivli",
            "Kopar",
            "kalyan",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara",
            "Sheelar",
            "Neral",
            "Bhivpuri Road",
            "Karjat",
            "Shahad",
            "Ambivli",
            "Titwala",
            "Khadavli",
            "Vasind",
            "Asangaon",
            "Atgaon",
            "Khardi",
            "Kasara")

        // Create ArrayAdapter with your data for Spinner
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, searchsource)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        // spinner items selected store in a variable
     /*   spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: android.view.View?,
                position: Int,
                id: Long
            ) {
                // Item selected from the Spinner
                val selectedItem = spinner[position]
                // Do something with the selected item
                // For example, you can store it in a variable (selectedItem)
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Handle the case where nothing is selected (optional)
            }
        }
*/
        // spinner 2 item selected
        val spinnerAdapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, items1)
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = spinnerAdapter1

       /* spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: android.view.View?,
                position: Int,
                id: Long
            ) {
                // Item selected from the Spinner
                val selecteditem1 = spinner1[position]
                // Do something with the selected item
                // For example, you can store it in a variable (selectedItem)
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Handle the case where nothing is selected (optional)
            }
        }*/


        // Create ArrayAdapter with your data for AutoCompleteTextView
        // search bar
        val autoCompleteAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, searchsource)
        autoCompleteTextView.setAdapter(autoCompleteAdapter)
         val autoCompleteAdapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items1)
         autoCompleteTextView1.setAdapter(autoCompleteAdapter1)

        // Set a listener for the AutoCompleteTextView to update the selected item in the Spinner
        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            spinner.setSelection(position)
        }
        autoCompleteTextView1.setOnItemClickListener { _, _, position, _ ->
             spinner1.setSelection(position)
         }

        //buttons
        val a = "50 INR"
        val pay : Button=findViewById(R.id.pay)
        pay.setOnClickListener{
            val intent1=Intent(this,Payment::class.java)
            intent.putExtra("keyName",a )
            startActivity(intent1)
        }



    }
}