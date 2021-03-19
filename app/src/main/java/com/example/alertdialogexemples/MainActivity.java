package com.example.alertdialogexemples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_alt , standard , btn3; //버튼값 전역변수

    final String[] words = new String[]{"사랑", "감사", "이해", "성공", "노력", "행운"};
    //리스너 안에서 변수사용 하기떄문에 파이널 변수선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alt = findViewById(R.id.btn_alt);
        standard = findViewById(R.id.standard);
        btn3 = findViewById(R.id.btn3);

        //리스트 형태의 AlertDialog를 만들 때는 메시지를 작성하면 안된다고 하네요.
        //만역 메시지를 입력하게되면, 리스트 영역을 메시지영역으로 덮어써버리게 된다고 합니다.
        // = > AlertDialog에 item배열을 장착할때 , 메세지 x

        btn_alt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("선택")
                        .setIcon(R.drawable.ic_launcher_background)
                        .setNegativeButton("취소", null)
                        .setItems(words, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {

                                switch (words[which]) {

                                    case "사랑":
                                        Toast.makeText(MainActivity.this, "사랑", Toast.LENGTH_SHORT).show();
                                        break;

                                    case "감사":
                                        Toast.makeText(MainActivity.this, "감사", Toast.LENGTH_SHORT).show();
                                        break;

                                    case "이해":
                                        Toast.makeText(MainActivity.this, "이해", Toast.LENGTH_SHORT).show();
                                        break;

                                }

                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("setTitle")
                .setMessage("setMessage");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


        //  setCancelable(false);
        //  영역 외 클릭 시, 창이 사라지지 않게 하기 위해서 사용함
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("버튼추가예제").setMessage("선택해주세요").setCancelable(false);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this ,"Ok 클릭!" , Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this ,"cancel 클릭!" , Toast.LENGTH_SHORT).show();
                    }
                });


                builder.setNeutralButton("nautral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this ,"nautral 클릭!" , Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}


