package id.sch.smktelkom_mlg.project.xiirpl501112131.raportbukupenghubung_kelompok1;


/**
 * Created by KurniaNovita on 20/11/2016.
 */
public class koneksi {
    public static final String URL_ADD = "http://192.168.56.1/crud/create.php";
    public static final String URL_GET_ALL = "http://192.168.56.1/crud/read.php";
    public static final String URL_GET_ID = "http://192.168.56.1/crud/get_data.php?id=";

    // Field yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel Mahasiswa
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NIS = "nis";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_KELAS = "kelas";

    // Tags Ini kita samakan nantinya untuk pengambila data JSON
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_ID = "id";
    public static final String TAG_NIS = "nis";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_KELAS = "kelas";

    public static final String URL_ID = "emp_id";
}

