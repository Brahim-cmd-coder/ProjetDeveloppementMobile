package com.example.projetdveloppementmobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

    public class HomeActivity extends Activity {

        private ListView articlesListView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            // Récupérer la liste des articles depuis la base de données ou une autre source
            String[] articles = { "Article 1", "Article 2", "Article 3" };

            articlesListView = findViewById(R.id.articlesListView);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, articles);
            articlesListView.setAdapter(adapter);

        }

    }
