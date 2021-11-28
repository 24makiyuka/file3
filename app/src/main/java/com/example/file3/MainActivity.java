package com.example.file3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.file3.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    class TestItem {
        public int number;
        public String string;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> toGSON());
        binding.button2.setOnClickListener(v -> fromGSON());
    }

    private void toGSON() {
        TestItem item = new TestItem();
        item.number = 100;
        item.string = "안녕하세요";

        String json = gson.toJson(item);
        binding.textView.setText(json);
        binding.editTextTextPersonName.setText(json);
    }

    private void fromGSON() {
        String read = binding.editTextTextPersonName.getText().toString();
        TestItem item = gson.fromJson(read, TestItem.class);
        String text = String.format("%d -> %s", item.number, item.string);
        binding.textView.setText(text);
    }
}