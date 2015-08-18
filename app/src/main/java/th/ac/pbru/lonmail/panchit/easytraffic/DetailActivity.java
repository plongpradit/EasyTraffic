package th.ac.pbru.lonmail.panchit.easytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    // Explicit, if we don't specify private, it will be private by default
    TextView titleTextView, detailTextView;
    ImageView trafficImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // bind Widget (ผูกตัวแปร) = mapping point = initial widget
        bindWidget();

        // show title
        showTitle();

        // show image
        showImage();

    } // onCreate คือ Main Method

    private void showImage() {
        int intImage = getIntent().getIntExtra("Image", R.drawable.traffic_01);
        trafficImageView.setImageResource(intImage);

    }

    private void showTitle() {
        // receive from intent
        String strTitle = getIntent().getStringExtra("Title"); // คำสั่งนี้ใช้ในการรับค่า
        titleTextView.setText(strTitle);

    }

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        detailTextView = (TextView) findViewById(R.id.txtDetail);
        trafficImageView = (ImageView) findViewById(R.id.imvTrafficDetail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

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
} // main Class
