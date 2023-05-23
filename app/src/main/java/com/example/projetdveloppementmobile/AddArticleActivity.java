package com.example.projetdveloppementmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class AddArticleActivity extends Activity {

        private EditText titleEditText;
        private EditText contentEditText;
        private Button addButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_article);

            titleEditText = findViewById(R.id.titleEditText);
            contentEditText = findViewById(R.id.contentEditText);
            addButton = findViewById(R.id.addButton);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = titleEditText.getText().toString();
                    String content = contentEditText.getText().toString();

                    // Vérifier si le titre et le contenu ne sont pas vides
                    if (!title.isEmpty() && !content.isEmpty()) {
                        // Sauvegarder l'article dans la base de données ou une autre source
                        Toast.makeText(AddArticleActivity.this, "Article ajouté avec succès", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddArticleActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
