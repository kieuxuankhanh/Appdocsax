package com.example.appdocsax;

import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.appdocsax.adapter.Truyentranhapdapter;
import com.example.appdocsax.adapter.photo_adapter;
import com.example.appdocsax.object.photo;
import com.example.appdocsax.object.truyentranh;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity2 extends AppCompatActivity {

    Truyentranhapdapter apdapter;
    Truyentranhapdapter apdapter1;
    ArrayList<truyentranh> truyentranhArrayList;
    ArrayList<truyentranh> truyendammyArrayList;


    ArrayList<Integer> images;
    GridView gdvdstruyen, gdv1,gdv2;

    ViewPager viewPager;
    CircleIndicator mcircleindicator;
    List<photo> listphoto;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager.getCurrentItem() == listphoto.size() - 1)
            {
                viewPager.setCurrentItem(0);
            }
            else {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        }
    };

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

        viewPager = findViewById(R.id.ViewPager);
        mcircleindicator = findViewById(R.id.circle_indicator);

        listphoto = getlistphoto();
        photo_adapter adapter = new photo_adapter(listphoto);
        viewPager.setAdapter(adapter);

        mcircleindicator.setViewPager(viewPager);

        handler.postDelayed(runnable, 4000);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        init();
        anhXa();
        setUp();
        setClick();
    }
    //listphoto add anh
    private List<photo> getlistphoto()
    {
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.bg2));
        list.add(new photo(R.drawable.bg2));
        list.add(new photo(R.drawable.bg2));
        return list;
    }
    private void init(){
        truyentranhArrayList = new ArrayList<>();
        truyentranhArrayList.add(new truyentranh("Shinju No Nectar","Chapter 3","https://i.hinhhinh.com/ebook/190x247/le-cau-hon-cua-shinsengumi_1720002887.png?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new truyentranh("Elf Ngực Bự Và Kho Báu Hầm Ngục","Chapter 8.1","https://i.hinhhinh.com/ebook/190x247/elf-nguc-bu-va-kho-bau-ham-nguc_1720346135.png?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new truyentranh("Đại Chu Tiên Lại","Chapter 4.5","https://truyenqqviet.com/truyen-tranh/dai-chu-tien-lai-11796"));
        truyentranhArrayList.add(new truyentranh("Unmei No Makimodoshi","Chapter 5.2","https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new truyentranh("Unmei No Makimodoshi","Chapter 5.2","https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new truyentranh("Unmei No Makimodoshi","Chapter 5.2","https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        apdapter = new Truyentranhapdapter(this, 0, truyentranhArrayList);

        truyendammyArrayList = new ArrayList<>();
        truyendammyArrayList.add(new truyentranh("Unmei No Makimodoshi","Chapter 5.2","https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        truyendammyArrayList.add(new truyentranh("1001 Cách Chinh Phục Chồng Yêu","Chapter 632","https://i.hinhhinh.com/ebook/190x247/1001-cach-chinh-phuc-chong-yeu_1669708202.jpg?gt=hdfgdfg&mobile=2"));
        truyendammyArrayList.add(new truyentranh("Ca Ca Gần Đây Có Chút Gay","Chapter 5.2","https://i.hinhhinh.com/ebook/190x247/ca-ca-gan-day-co-chut-gay_1490360484.jpg?gt=hdfgdfg&mobile=2"));
        apdapter1 = new Truyentranhapdapter(this,0,truyendammyArrayList);
    }
    private void anhXa(){
        gdvdstruyen = findViewById(R.id.gdvdstruyen);
        gdv1 = findViewById(R.id.gdv1);
        gdv2 = findViewById(R.id.gdv2);
    }
    private void setUp(){
        gdvdstruyen.setAdapter(apdapter);
        gdv1.setAdapter(apdapter1);
        gdv2.setAdapter(apdapter1);

    }
    private void setClick(){}

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable,3000);
    }
}