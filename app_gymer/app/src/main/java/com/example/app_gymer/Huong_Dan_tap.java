package com.example.app_gymer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Huong_Dan_tap extends AppCompatActivity {
    VideoView videoView;
    TextView solan,noidung,tenbt;
    private Spinner spnCategory;
    Button btnquayve;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huongdantap);
        AnhXa();
        btnquayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Huong_Dan_tap.this,Exercise_Page.class);
                startActivity(intent);
            }
        });
        setCombobox();
        setNoidung();
    }

    private void AnhXa() {
        videoView = findViewById(R.id.video1);
        solan = findViewById(R.id.solan);
        noidung = findViewById(R.id.noidung);
        tenbt = findViewById(R.id.tenbt);
        btnquayve = findViewById(R.id.quaylai);
    }

    private void setCombobox()
    {
        spnCategory = (Spinner) findViewById(R.id.spnCategory);

        List<String> list = new ArrayList<>();
        list.add("khó");
        list.add("vừa");
        list.add("dễ");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spnCategory.setAdapter(adapter);
        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    solan.setText("Số lần tập: 40 lần");
                }else if(i==1)
                {
                    solan.setText("Số lần tập: 20 lần");
                }else
                {
                    solan.setText("Số lần tập: 10 lần");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void loadNoidung(int a,String b){
        String uriPath = "android.resource://" + getPackageName() +"/" + a ;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        noidung.setText(b);
    }

    private void setNoidung()
    {
        int so = (int) getIntent().getSerializableExtra("tenloaibt");
        if(so == 0)
        {
            tenbt.setText("Tên bài tập: Chống đẩy");
           loadNoidung(R.raw.chongday1,"Nằm áp xuống sàn lấy tay đỡ thân. Giữ thẳng thân trong khi nâng và hạ thân bằng tay. Bài tập này giúp tập ngực, vai , cơ tay sau, lưng và chân");
        }else if(so == 1)
        {
            tenbt.setText("Tên bài tập: Tấn sau");
            loadNoidung(R.raw.tansau1,"Đứng chân rộng bằng vai, hai tay để trên hông. Bước dài một bước dài một bước về sau bằng chân phải rồi hạ thân người xuống cho tới khi đùi trái song song với sàn. Trở lại tư thế và lặp lại với chân bên kia");
        }else if(so == 2)
        {
            tenbt.setText("Tên bài tập: Tập cơ bụng");
            loadNoidung(R.raw.tapcobung1,"Nằm ngửa cong gối và tay duỗi thẳng. Sau đó nhấc thân trên khỏi sàn. Giữ một vài giây rồi từ từ trở lại tư thế ban đầu. Bài tập này chủ yếu cho các cơ bụng thẳng và cơ liên sườn");
        }else if(so == 3)
        {
            tenbt.setText("Tên bài tập: Chống đẩy để tay rộng");
            loadNoidung(R.raw.chongdaydetayrong1,"Bắt đầu với thư thế chống đẩy thông thường nhưng tay dang rộng hơn vai. Sau đó đẩy cơ thể lên xuống. Nhớ phải giữ thẳng cơ thể.");
        }
        else if(so == 4)
        {
            tenbt.setText("Tên bài tập: hít đất chéo");
            loadNoidung(R.raw.hitdatcheo1,"Bắt đầu với thư thế hít đất thẳng tay. Nâng tay phải và chân trái lên cho đến khi song song với sàn. Trở lại tư thế  bắt đầu và lặp lại với bên kia.");
        }
        else if(so == 5)
        {
            tenbt.setText("Tên bài tập: gánh đùi");
            loadNoidung(R.raw.ganhdui1,"Chân đứng rộng bằng vai, tay để thẳng về trước, hạ thấp cơ thể cho tới khi đùi song song với sàn. Đầu gối cùng hướng với ngón chân. Quay lại tư thế ban đầu và lặp lại. Bài tập này giúp tập đùi, hông, cơ đùi trước, gân kheo và thân dưới");
        }
        else
        {
            tenbt.setText("Tên bài tập: kéo cơ thoi");
            loadNoidung(R.raw.keocothoi1,"Đứng với hai chân rộng bằng vai. Giơ hai tay song song với mặt đất và gập hai khuỷu tay về phía sau và siết chặt hai tay bên xương bả vai. Lặp lại bài tập này.");
        }
    }
}
