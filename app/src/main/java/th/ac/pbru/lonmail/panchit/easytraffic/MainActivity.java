package th.ac.pbru.lonmail.panchit.easytraffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // this area is for declaring variables (explicit ประกาศตัวแปร)
    // to prepare RAM for running the code
    private ListView trafficListView; //this variable is for used in this class only


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial widget = การผูกตัวแปรที่ประกาศ
        initialWidget();

        // create ListView
        createListView();
    } // Main Method: this will first start when this class is called


    // this method will be called from outside, so making it public
    // void is a no return function
    public void clickTest(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }

    private void createListView() {
        // to explicit array Type A
        final String[] strTitle = new String[20];
        strTitle[0] = "ห้ามเลี้ยวซ้าย";
        strTitle[1] = "ห้ามเลี้ยวขวา";
        strTitle[2] = "ตรงไป";
        strTitle[3] = "เลี้ยวขวา";
        strTitle[4] = "เลี้ยวซ้าย";
        strTitle[5] = "ออก";
        strTitle[6] = "เข้าสำหรับฝรั่ง";
        strTitle[7] = "ออกสำหรับฝรั่ง";
        strTitle[8] = "หยุด";
        strTitle[9] = "จำกัดความสูงที่ 2.50 เมตร";
        strTitle[10] = "ทางแยก";
        strTitle[11] = "ห้ามกลับรถ";
        strTitle[12] = "ห้ามจอด";
        strTitle[13] = "ระวังรถสวน";
        strTitle[14] = "ห้ามแซง";
        strTitle[15] = "เข้า";
        strTitle[16] = "หยุดตรวจ";
        strTitle[17] = "จำกัดความเร็วที่ 50 ก.ม.";
        strTitle[18] = "จำกัดความกว้างที่ 2.50 ม.";
        strTitle[19] = "จำกัดความสูงที่ 5 ม.";

        // another way to explicit array Type B
        final int[] intImage = {R.drawable.traffic_01, R.drawable.traffic_02,
                R.drawable.traffic_03, R.drawable.traffic_04,
                R.drawable.traffic_05, R.drawable.traffic_06,
                R.drawable.traffic_07, R.drawable.traffic_08,
                R.drawable.traffic_10, R.drawable.traffic_11,
                R.drawable.traffic_12, R.drawable.traffic_13,
                R.drawable.traffic_14, R.drawable.traffic_15,
                R.drawable.traffic_16, R.drawable.traffic_17,
                R.drawable.traffic_18, R.drawable.traffic_19,
                R.drawable.traffic_20};


        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, intImage, strTitle);
        trafficListView.setAdapter(objMyAdapter);

        // create ListView
        // activate onClick on ListView เมื่อคลิกแล้วให้เกิดการตอบสนอง
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i is used to specify the position of the click
                // Intent (คำสั่ง link) to detail
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);

                objIntent.putExtra("Title", strTitle[i]);
                objIntent.putExtra("Image", intImage[i]);
                objIntent.putExtra("Detail", i);

                startActivity(objIntent);
            }
        });

    }


    private void initialWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    } //

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
} // Main Class
