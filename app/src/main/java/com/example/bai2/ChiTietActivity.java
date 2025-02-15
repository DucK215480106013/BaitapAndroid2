package com.example.bai2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChiTietActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvId = findViewById(R.id.tv_id_detail);
        TextView tvUserID = findViewById(R.id.tv_userID_detail);
        TextView tvTomtat = findViewById(R.id.tv_tomtat_detail);
        TextView tvFullbody = findViewById(R.id.tv_fullbody_detail);

        // Get data from intent
        int id = getIntent().getIntExtra("id",0);
        int userID = getIntent().getIntExtra("userID",0);
        String tomtat = getIntent().getStringExtra("tomtat");
        String fullbody = getIntent().getStringExtra("fullbody");

        // Set data
        tvId.setText("ID: " + id);
        tvUserID.setText("User ID: " + userID);
        tvTomtat.setText("Tóm tắt: " + tomtat);
        tvFullbody.setText("Nội dung đầy đủ: " + fullbody);
    }
}