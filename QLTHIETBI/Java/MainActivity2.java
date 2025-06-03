package com.example.qlthietbi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lstTB;
    ArrayList<Thietbi> mangtb;
    ThietbiAdapter tbAdapter;
    String maloaimay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lstTB = findViewById(R.id.listViewDSLoaithietbi);
        mangtb = new ArrayList<>();
        // Lấy mã loại từ Intent
        Intent mh2 = getIntent();
        Bundle bundle = mh2.getExtras();
        maloaimay= bundle.getString("maloaimay","ddd");
        String url = "http://192.168.56.1/QLThietBi/getsanpham.php?maloaimay=" + maloaimay;
        ReadJSON(url);
        tbAdapter = new ThietbiAdapter(MainActivity2.this, R.layout.dongthietbi, mangtb);
        lstTB.setAdapter(tbAdapter);
    }

    private void ReadJSON(String url)
    {
        final RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try{
                                JSONObject object = response.getJSONObject(i);
                                mangtb.add(new Thietbi(object.getString("mamay"),
                                        object.getString("tenmay"),
                                        object.getString("maloaimay"),
                                        object.getString("donvitin"),
                                        object.getString("anh"),
                                        object.getInt("soluong")));
                            }catch (JSONException e){e.printStackTrace();}}
                        tbAdapter.notifyDataSetChanged();
                    }}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity2.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}