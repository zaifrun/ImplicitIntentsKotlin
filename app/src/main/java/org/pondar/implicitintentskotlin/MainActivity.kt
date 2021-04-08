package org.pondar.implicitintentskotlin

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /* you can see a list of intents and their meaning here:
	   NOTE: press ctrl down and then you can click on the link below
	@see <a href="http://developer.android.com/reference/android/content/Intent.html"> this link </a>
	 */
    fun browseWeb(view: View) {
        val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com"))
        startActivity(intent)
    }

    fun shareText(view: View) {
        val text = inputText.text.toString() //from EditText
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain" //MIME-TYPE
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Shared Data")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(sharingIntent, "Share Using"))
    }

    fun showMap(view: View) {
        val intent = Intent(Intent.ACTION_VIEW,Uri.parse("geo:56.119605, 10.158907"))
        startActivity(intent)
    }

    //start the phone chooser.
    fun makeCall(view: View) {
        val intent = Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:+82345623"))
        startActivity(intent)
    }
}
