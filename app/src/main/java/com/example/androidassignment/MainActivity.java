package com.example.androidassignment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidassignment.model.ChoicesItem;
import com.example.androidassignment.model.DataModel;
import com.example.androidassignment.model.Message;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView descriptionTextView;

    private Button copyButtontitle , copyButtondescription ,shareButtontitle ,shareButtondescription ;
    private CircularProgressBar circularProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyButtontitle = findViewById(R.id.copyButtontitle);
         shareButtontitle = findViewById(R.id.shareButtontitle);
        copyButtondescription = findViewById(R.id.copyButtondescription);
        shareButtondescription = findViewById(R.id.shareButtondescription);


        copyButtontitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView titleTextView = findViewById(R.id.titleTextView);
                String titleText = titleTextView.getText().toString();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Text", titleText);
                clipboard.setPrimaryClip(clip);


                Toast.makeText(MainActivity.this, "Title text copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });


        copyButtondescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView titleTextView = findViewById(R.id.titleTextView);
                String titleText = titleTextView.getText().toString();


                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Text", titleText);
                clipboard.setPrimaryClip(clip);


                Toast.makeText(MainActivity.this, "Title text copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        shareButtondescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView titleTextView = findViewById(R.id.titleTextView);
                String titleText = titleTextView.getText().toString();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, titleText);
                startActivity(Intent.createChooser(shareIntent, "Share Title"));
            }
        });


        shareButtontitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView titleTextView = findViewById(R.id.titleTextView);
                String titleText = titleTextView.getText().toString();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, titleText);
                startActivity(Intent.createChooser(shareIntent, "Share Title"));
            }
        });


        circularProgressBar = findViewById(R.id.circularProgressBar);


        circularProgressBar.setProgress(53);

        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        String baseUrl = "https://run.mocky.io";
        CourseService courseService = RetrofitClient.getClient(baseUrl).create(CourseService.class);


        Call<DataModel> call = courseService.getCourseDetails();
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (response.isSuccessful()) {
                    DataModel dataModel = response.body();
                    if (dataModel != null && dataModel.getChoices() != null && !dataModel.getChoices().isEmpty()) {

                        ChoicesItem firstChoice = dataModel.getChoices().get(0);

                        Message message = firstChoice.getMessage();


                        String content = message.getContent();
                        try {
                            JSONObject jsonObject = new JSONObject(content);
                            String title = jsonObject.getString("title");
                            String description = jsonObject.getString("description");

                            titleTextView.setText(title);
                            descriptionTextView.setText(description);
                        } catch (JSONException e) {
                            Log.e("MainActivity", "Failed to parse content JSON: " + e.getMessage());
                        }
                    } else {
                        Log.e("MainActivity", "Response body is null or empty");
                    }
                } else {
                    Log.e("MainActivity", "Failed to fetch course details. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.e("MainActivity", "Failed to fetch course details: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Failed to fetch course details. Check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
