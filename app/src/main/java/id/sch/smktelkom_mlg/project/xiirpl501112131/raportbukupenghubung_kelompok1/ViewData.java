package id.sch.smktelkom_mlg.project.xiirpl501112131.raportbukupenghubung_kelompok1;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by KurniaNovita on 20/11/2016.
 */
public class ViewData extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextNis;
    private EditText editTextKelas;
    // Inisialisasi Button

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdata);
        Intent intent = getIntent();
        // ID
        id = intent.getStringExtra(koneksi.URL_ID);
        // Inisialisasi View dan Button
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextNis = (EditText) findViewById(R.id.editTextNis);
        editTextName = (EditText) findViewById(R.id.editTextNama);
        editTextKelas = (EditText) findViewById(R.id.editTextKelas);


        getData();

    }

    @Override
    public void onClick(View view) {

    }

    public void getData() {
        class getData extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewData.this, "Proses Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                // Method Show Data
                ShowData(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(koneksi.URL_GET_ID, id);
                return s;
            }
        }
        getData ge = new getData();
        ge.execute();
    }

    private void ShowData(String json) {
        try {
            // Jadikan sebagai JSON object
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(koneksi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            // Data berdasarkan di Tabel Database
            String nis = c.getString(koneksi.TAG_NIS);
            String nama = c.getString(koneksi.TAG_NAMA);
            String kelas = c.getString(koneksi.TAG_KELAS);
// Tampilkan setiap data JSON format kedalam setiap EditText
            editTextNis.setText(nis);
            editTextName.setText(nama);
            editTextKelas.setText(kelas);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}


