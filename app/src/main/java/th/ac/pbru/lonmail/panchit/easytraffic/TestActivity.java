package th.ac.pbru.lonmail.panchit.easytraffic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    // 1. Explicit ตัวแปร
    private TextView questionTextView;
    private ImageView trafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton, choice4RadioButton;
    // 7 กำหนดตัวแปรเพิ่ม เพื่อจะนำไปใช้ที่อื่นด้วย
    private String[] questionStrings;
    private int[] imageInts;
    // 10 ประกาศตัวแปรเพิ่ม
    private int radioAnInt, indexAnInt,scoreAnInt; // สำหรับการเลือกคำตอบ


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // 2. Bind ตัวแปรกับ widget
        bindWidget();
        // 3. alt -enter เพื่อสร้าง method bindWidget()

        // 9 สร้าง RadioController
        // alt -enter เพื่อสร้าง radioController()
        radioController();

    } // onCreate Main Method

    //10, 12
    public void clickAnswer(View view) {
        if (radioAnInt == 0) {
            Toast.makeText(TestActivity.this, "กรุณาตอบคำถาม ด้วยค่ะ", Toast.LENGTH_SHORT).show();
            // toast คือ การ alert
            // lenght-short lasts 4 sec
        } else {
            checkScore();
            myModel();
        }


    } // clickAnswer

    private void myModel() {
        if (indexAnInt == 9) {
            showAnswerDialog();
        } else {

            // Check Score
            // checkScore();

            indexAnInt += 1;


            // changeView method
            changeView(indexAnInt);

            // Clear Check
            choiceRadioGroup.clearCheck();

        }


    } //myModel method

    private void checkScore() {
        int[] intTrueAnswer = {1, 2, 3, 4, 1, 2, 3, 4, 1, 2};
        if (radioAnInt == intTrueAnswer[indexAnInt]) {
            scoreAnInt++;
        }
    }

    private void changeView(int anInt) {
        // Change Question when the user clicks Answer
        questionTextView.setText(questionStrings[anInt]);

        // Change Image when click Answer
        trafficImageView.setImageResource(imageInts[anInt]);


        // Change Choices when click Answer
        int[] intTimes = {R.array.times1, R.array.times2,
                R.array.times3, R.array.times4,
                R.array.times5, R.array.times6,
                R.array.times7, R.array.times8,
                R.array.times9, R.array.times10};
        String[] strChoice = getResources().getStringArray(intTimes[anInt]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);

        //

    } // changeView


    private void showAnswerDialog() {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this); // class used for creating alert message
        objBuilder.setIcon(R.drawable.icon_myaccount);
        objBuilder.setTitle("คะแนนสอบของคุณ");
        objBuilder.setMessage("คะแนนที่คุณสอบได้ " + Integer.toString(scoreAnInt) + "คะแนน");
        objBuilder.setCancelable(false);
        objBuilder.setNegativeButton("เล่นอีกครั้ง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onStart();
                choiceRadioGroup.clearCheck();
                dialogInterface.dismiss();
            }
        });
        objBuilder.setPositiveButton("อ่านบทเรียน", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent objIntent = new Intent(TestActivity.this, MainActivity.class);
                startActivity(objIntent);
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();
    } // showAnswerDialog


    private void radioController() {
        // ถ้าใช้ onclick แปลว่าเลือกแล้วเอาเลย จะเปลี่ยนไม่ได้ จึงต้องใช้ onChecked
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }
            }
        });
    }

    // การดึง method สำเร็จรูป จะใช้ override
    // 6. เพิ่ม method onStart นั่นคือ จะเปลี่ยน state ของ activity ของ life cycle ให้มาเริ่มที่ method นี้ก่อน
    @Override
    protected void onStart() {
        // 8 เขียนโค้ด
        // 8.1set up จะดึงตัวแปร 10 ตัวมาอยู่ที่นี่
        questionStrings = getResources().getStringArray(R.array.question);
        // 8.2 นำรูปภาพมาวาง
        imageInts = new int[10];
        imageInts[0] = R.drawable.traffic_01;
        imageInts[1] = R.drawable.traffic_02;
        imageInts[2] = R.drawable.traffic_03;
        imageInts[3] = R.drawable.traffic_04;
        imageInts[4] = R.drawable.traffic_05;
        imageInts[5] = R.drawable.traffic_06;
        imageInts[6] = R.drawable.traffic_07;
        imageInts[7] = R.drawable.traffic_08;
        imageInts[8] = R.drawable.traffic_09;
        imageInts[9] = R.drawable.traffic_10;

        // เพิ่มคำสั่ง
        indexAnInt = 0; // เพื่อ clear ค่าพื้นฐานเริ่มต้นให้เป็น 0 จะได้เริ่มต้นเล่นใหม่ได้
        scoreAnInt = 0; // เพื่อ clear ค่าพื้นฐานเริ่มต้นให้เป็น 0 จะได้เริ่มต้นเล่นใหม่ได้

        // 8.3 can only be used here and only once
        String[] strChoice = getResources().getStringArray(R.array.times1);

        // 8.4 when start
        questionTextView.setText(questionStrings[0]);
        trafficImageView.setImageResource(imageInts[0]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);

        super.onStart();
    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        trafficImageView = (ImageView) findViewById(R.id.imvTrafficTest);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);

    } // 4. เขียนโค้ด

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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
} // Main Class
