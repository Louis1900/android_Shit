package com.example.qlthietbi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class MainActivity extends AppCompatActivity {
    ListView lstLoaithietbi;
    LoaiThietbiAdapter adap;
    ArrayList<LoaiThietbi> mangloaithietbi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lstLoaithietbi=(ListView) findViewById(R.id.listViewDSLoaithietbi);
        mangloaithietbi=new ArrayList<>();
        ReadJSON("http://192.168.56.1/QLThietBi/getloaisp.php");
        adap = new LoaiThietbiAdapter(MainActivity.this, R.layout.dongloaithietbi, mangloaithietbi);
        lstLoaithietbi.setAdapter(adap);

        lstLoaithietbi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LoaiThietbi loaitb = mangloaithietbi.get(position);
                Intent mh2 = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle=new Bundle();
                bundle.putString("maloaimay",loaitb.getMaloaimay());
                //intent.putExtra("maloai", loaixe.getMaloai());
                mh2.putExtras(bundle);
                startActivity(mh2);
            }
        });
    }
    private void ReadJSON(String url) {
        final RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try{
                        JSONObject object = response.getJSONObject(i);
                        mangloaithietbi.add(new LoaiThietbi(object.getString("maloaimay"),
                                object.getString("tenloaimay")));
                    }catch (JSONException e){
                        e.printStackTrace();
                    }}
                adap.notifyDataSetChanged();
            }}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}