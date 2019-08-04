package www.vibhorgupta.in.implicitintentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String url = "https://www.google.com";

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =  findViewById(R.id.Open_website);
        Button Button2 =  findViewById(R.id.sharedIntent);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage();
            }
        });


        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedTextButton();
            }
        });
    }


    public void openWebPage(){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

        if(intent.resolveActivity(getPackageManager()) != null){

            startActivity(intent);
        }

    }


    public void SharedTextButton(){


        Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject here");
        String app_url = " https://play.google.com/store/apps/details?id=";
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }




}
