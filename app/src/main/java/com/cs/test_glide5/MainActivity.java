package com.cs.test_glide5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private String[] URLs = new String[]{
            "http://ww4.sinaimg.cn/large/610dc034jw1f7z9uxopq0j20u011hju5.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f80uxtwgxrj20u011hdhq.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f9rc3qcfm1j20u011hmyk.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f820oxtdzzj20hs0hsdhl.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f9mp3xhjdhj20u00u0ta9.jpg",
            "http://ww2.sinaimg.cn/large/610dc034gw1f9lmfwy2nij20u00u076w.jpg",
            "http://ww2.sinaimg.cn/large/610dc034gw1f9kjnm8uo1j20u00u0q5q.jpg",
            "http://ww2.sinaimg.cn/large/610dc034jw1f9j7nvnwjdj20u00k0jsl.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f9frojtu31j20u00u0go9.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f9em0sj3yvj20u00w4acj.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f9dh2ohx2vj20u011hn0r.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f9cayjaa96j20u011hqbs.jpg",
            "http://ww2.sinaimg.cn/large/610dc034jw1f9b46kpoeoj20ku0kuwhc.jpg",
            "http://ww2.sinaimg.cn/large/610dc034jw1f978bh1cerj20u00u0767.jpg",
            "http://ww4.sinaimg.cn/large/610dc034gw1f96kp6faayj20u00jywg9.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f95hzq3p4rj20u011htbm.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f9469eoojtj20u011hdjy.jpg",
            "http://ww2.sinaimg.cn/large/610dc034jw1f91ypzqaivj20u00k0jui.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f8zlenaornj20u011idhv.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f8xz7ip2u5j20u011h78h.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f8xff48zauj20u00x5jws.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f8w2tr9bgzj20ku0mjdi8.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f8uxlbptw7j20ku0q1did.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f8rgvvm5htj20u00u0q8s.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f8qd9a4fx7j20u011hq78.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f8p9eahanlj20u011h42y.jpg",
            "http://ww2.sinaimg.cn/large/610dc034jw1f8o2ov8xi0j20u00u0q61.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f8mssipb9sj20u011hgqk.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f8lox7c1pbj20u011h12x.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f8kmud15q1j20u011hdjg.jpg",
            "http://ww4.sinaimg.cn/large/610dc034jw1f8bc5c5n4nj20u00irgn8.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f8a5uj64mpj20u00u0tca.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f88ylsqjvqj20u011hn5i.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f87z2n2taej20u011h11h.jpg",
            "http://ww1.sinaimg.cn/large/610dc034jw1f867mvc6qjj20u00u0wh7.jpg",
            "http://ww3.sinaimg.cn/large/610dc034jw1f837uocox8j20f00mggoo.jpg"

    };
    private MyAdapter adapter;
    private List<String > mDatas=new ArrayList<>();
    private List<Integer> mHeight=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerview.addItemDecoration(new SpacesItemDecoration(3));
        for (int i = 0; i < URLs.length; i++) {
            mDatas.add(URLs[i]);
            mHeight.add( (int) (100 + Math.random() * 200));

        }
        adapter=new MyAdapter(MainActivity.this,mDatas,mHeight);
        recyclerview.setAdapter(adapter);

        adapter.setOnItemClickLitener(new MyAdapter.OnItemClickLitener() {
           @Override
           public void onItemClick(View view, int position) {
               //Toast.makeText(MainActivity.this, position+"g", Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(MainActivity.this,Photoview.class);

               Bundle bundle = new Bundle();
               bundle.putInt("pos",position);

               bundle.putStringArray("cs",URLs);
               intent.putExtras(bundle);
               startActivity(intent);
           }
       });

    }
}
