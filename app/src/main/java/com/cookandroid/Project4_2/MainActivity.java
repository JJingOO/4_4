package com.cookandroid.Project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton RdoR, RdoS, RdoT;
    ImageView imgAOS;
    Button btnExit, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        RdoR = (RadioButton) findViewById(R.id.RdoR);
        RdoS = (RadioButton) findViewById(R.id.RdoS);
        RdoT = (RadioButton) findViewById(R.id.RdoT);

        imgAOS = (ImageView) findViewById(R.id.ImgAOS);

        btnExit = (Button) findViewById(R.id.btnExit);
        btnReset = (Button) findViewById(R.id.btnReset);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkAgree.isChecked()) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    imgAOS.setVisibility(View.VISIBLE);
                } else
                {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    imgAOS.setVisibility(android.view.View.INVISIBLE);
                }
                rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (rGroup1.getCheckedRadioButtonId()) {
                            case R.id.RdoR:
                                imgAOS.setImageResource(R.drawable.a11);
                                break;
                            case R.id.RdoS:
                                imgAOS.setImageResource(R.drawable.a12);
                                break;
                            case R.id.RdoT:
                                imgAOS.setImageResource(R.drawable.a13);
                                break;
                            default:
                                Toast.makeText(getApplicationContext(), "동물을 선택해주세요.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkAgree.setChecked(false);
                RdoR.setChecked(false);
                RdoS.setChecked(false);
                RdoT.setChecked(false);
            }
        });
    }
}