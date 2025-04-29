package com.example.githubprofile

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.githubprofile.databinding.ActivityMainBinding
import android.webkit.WebView
import android.webkit.WebSettings
import android.util.Base64
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    // Funkcja do konwertowania zasobu drawable (SVG) na Base64
    private fun getBase64FromDrawable(resourceId: Int): String? {
        return try {
            val inputStream: InputStream = resources.openRawResource(resourceId)
            val bytes = inputStream.readBytes()
            inputStream.close()
            Base64.encodeToString(bytes, Base64.DEFAULT)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val readmeSpace: WebView = binding.readmeSpace
        val webSettings: WebSettings = readmeSpace.settings
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        readmeSpace.setBackgroundColor(Color.parseColor("#1e1e1e"))

        val cppBase64 = getBase64FromDrawable(R.raw.cpp)
        val discordBase64 = getBase64FromDrawable(R.raw.discord)
        val javaBase64 = getBase64FromDrawable(R.raw.java)
        val linkedinBase64 = getBase64FromDrawable(R.raw.linkedin)
        val pytBase64 = getBase64FromDrawable(R.raw.pyt)
        val qtBase64 = getBase64FromDrawable(R.raw.qt)
        val unityBase64 = getBase64FromDrawable(R.raw.unity)
        val vsBase64 = getBase64FromDrawable(R.raw.vs)
        val vscodeBase64 = getBase64FromDrawable(R.raw.vscode)
        val linkedinSocialBase64 = getBase64FromDrawable(R.raw.linkedin)
        val discordSocialBase64 = getBase64FromDrawable(R.raw.discord)

        val htmlTekst = """
    <body style="background-color:#1e1e1e; color:white;">
        <h1 align="center" style="color:white;">Hey, I'm Alex! 👋</h1>
        <br>
        <p align="center" style="color:white;">A Passionate software developer from Poland</p>
        <br>
        <h2 align="left" style="color:white;">About me:</h2>
        <br>
        <p align="left" style="color:white;">💻 Desktop app developer<br>🏫 Computer Science student at Uniwersytet Łódzki<br>📚 Currently learning Java, Qt and GUI design<br>💡&nbsp;&nbsp;I'm also interested in photography, technology, cars and playing electric guitar<br>💼 Interested in an internship<br>🎙&nbsp;&nbsp; Discord: alexzrivii</p>
        <br>
        <h2 align="left" style="color:white;">I code with:</h2>
        <br>
        <div align="center">
            <img src="data:image/svg+xml;base64,$cppBase64" height="52" alt="cplusplus logo">&nbsp;
            <img src="data:image/svg+xml;base64,$discordBase64" height="52" alt="discord logo">&nbsp;
            <img src="data:image/svg+xml;base64,$javaBase64" height="52" alt="java logo">&nbsp;
            <img src="data:image/svg+xml;base64,$linkedinBase64" height="52" alt="linkedin logo">&nbsp;
            <img src="data:image/svg+xml;base64,$pytBase64" height="52" alt="python logo">
            <br>
            <img src="data:image/svg+xml;base64,$qtBase64" height="52" alt="qt logo">&nbsp;
            <img src="data:image/svg+xml;base64,$unityBase64" height="52" alt="unity logo">&nbsp;
            <img src="data:image/svg+xml;base64,$vsBase64" height="52" alt="visualstudio logo">&nbsp;
            <img src="data:image/svg+xml;base64,$vscodeBase64" height="52" alt="vscode logo">
        </div>
        <br>
        <h2 align="left" style="color:white;">You can also find me on:</h2>
        <br>
        <div align="center">
            <img src="data:image/svg+xml;base64,$linkedinSocialBase64" width="52" height="40" alt="linkedin logo">&nbsp;
            <img src="data:image/svg+xml;base64,$discordSocialBase64" width="52" height="40" alt="discord logo">
        </div>
        <br>
    </body>
""".trimIndent()

        readmeSpace.loadDataWithBaseURL(null, htmlTekst, "text/html", "UTF-8", null)
    }
}