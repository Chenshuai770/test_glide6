package com.cs.test_glide5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * Created by chenshuai on 2016/11/14.
 */
public class Photoview extends Activity {



    private ViewPager viewPager;

    private String[] img;
    private VpAdapter mAdapter;
    private List<View> viewList=new ArrayList<>();
    private String[] URLs = new String[]{
            "http://pic3.nipic.com/20090617/1242397_083514091_2.jpg",
            "http://pic28.nipic.com/20130422/12457151_164027506188_2.jpg",
            "http://pic4.nipic.com/20091120/805653_183746006558_2.jpg",
            "http://pic7.nipic.com/20100606/4899050_135353003843_2.jpg",
            "http://pic4.nipic.com/20091218/3557379_083034065299_2.jpg",
            "http://pic4.nipic.com/20090924/3308315_095324041734_2.jpg",
            "http://pica.nipic.com/2008-01-18/2008118212025258_2.jpg",
            "http://pica.nipic.com/2007-11-15/20071115103157516_2.jpg",
            "http://pic6.nipic.com/20100427/4365846_231110093316_2.jpg",
            "http://a2.att.hudong.com/79/22/01000000000000119062273272179.jpg",
            "http://img4.duitang.com/uploads/item/201209/20/20120920165508_EuenZ.jpeg",
            "http://img5.duitang.com/uploads/item/201207/25/20120725171947_CV3ZA.jpeg",
            "http://pic24.nipic.com/20121029/3822951_090444696000_2.jpg",
            "http://d.3987.com/lyzr_130620/004.jpg",
            "http://pic14.nipic.com/20110527/2531170_101932834000_2.jpg",
            "http://pica.nipic.com/2008-01-12/200811215275498_2.jpg",
            "http://pica.nipic.com/2007-07-15/200771515512480_2.jpg",
            "http://pic3.nipic.com/20090514/2639204_233912087_2.jpg",
            "http://img4.chinaface.com/original/212dlz514BUdSEyhs4mJrrPXe1a4E.jpg",
            "http://image.tianjimedia.com/uploadImages/2011/306/EQ2E3ZUPNMNV.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/0b55b319ebc4b7452c1b0e16cdfc1e178a821526.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/9f510fb30f2442a751a29476d543ad4bd01302b0.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/f2deb48f8c5494eec48c66ca29f5e0fe98257eb2.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/1e30e924b899a901f19c32e519950a7b0308f5bc.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/63d0f703918fa0eca4042edf229759ee3c6ddb25.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697f631428f51fbb2fb4216d806.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/ac4bd11373f08202034236d14ffbfbedaa641b0f.jpg",
            "http://e.hiphotos.baidu.com/image/pic/item/58ee3d6d55fbb2fbafb52bfa4b4a20a44723dcb8.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/c8177f3e6709c93d08d97a679a3df8dcd1005472.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/bd3eb13533fa828b01fbafb2ff1f4134960a5a82.jpg",
            "http://b.hiphotos.baidu.com/image/pic/item/8326cffc1e178a82689d65adf403738da977e81e.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/9825bc315c6034a8d141851dce1349540823768e.jpg",
            "http://h.hiphotos.baidu.com/image/pic/item/72f082025aafa40f7c884d31af64034f79f0198b.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/d53f8794a4c27d1eaa8358171fd5ad6edcc438bf.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/902397dda144ad344a35e454d4a20cf430ad855e.jpg",
            "http://a.hiphotos.baidu.com/image/pic/item/728da9773912b31be0f04c498318367adab4e136.jpg",
            "http://d.hiphotos.baidu.com/image/pic/item/5bafa40f4bfbfbed88e0cfa07cf0f736aec31fb7.jpg",
            "http://c.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a299fff02c79b25bc315c607c80.jpg",
            "http://pic7.nipic.com/20100522/1263764_002013845527_2.jpg",
            "http://a2.att.hudong.com/12/26/19300000362045133857269184471_950.jpg",
            "http://pic.nipic.com/2008-03-01/2008319174451_2.jpg",
            "http://pic23.nipic.com/20120824/8218020_193654254129_2.jpg",
            "http://pic24.nipic.com/20121010/4388163_025151474144_2.jpg",
            "http://pic11.nipic.com/20100803/4038389_093502059852_2.jpg",
            "http://d.3987.com/mlxw_130629/002.jpg",
            "http://pic.sayingfly.com/Photo/UpLoadFiles/2008-7-24/20087249442527.jpg",
            "http://pic12.nipic.com/20110223/2709576_111836168000_2.jpg",
            "http://pic14.nipic.com/20110609/2531170_055926229173_2.jpg",
            "http://d.3987.com/dgblcsyjgqbz_20130314/001.jpg",
            "http://pic.yesky.com/imagelist/06/47/985202_5664.jpg",
            "http://pic19.nipic.com/20120324/3484432_092618805000_2.jpg"
    };
    private Intent intent;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        initView();

    }

    private void initView() {
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater inflater = LayoutInflater.from(this);
        intent = getIntent();
        //String[] datas = intent.getStringArrayExtra("cs");
        bundle = intent.getExtras();
        String[] datas = (String[]) bundle.get("cs");

        for (int i = 0; i < datas.length; i++) {
            View view = inflater.inflate(R.layout.photoview, null);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.pv_photo);
            final ProgressBar mProgressBar = (ProgressBar) view.findViewById(R.id.progress);

            Glide.with(Photoview.this)
                    .load(datas[i])
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            mProgressBar.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                           // 这里可以设置进度条是否可见
                            mProgressBar.setVisibility(View.GONE);
                           // Toast.makeText(Photoview.this, "我加载成功了", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .into(photoView);
            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    finish();
                }

                @Override
                public void onOutsidePhotoTap() {

                }
            });

            viewList.add(view);
        }
        mAdapter=new VpAdapter(Photoview.this,viewList);
        viewPager.setAdapter(mAdapter);


        int pos = (int) bundle.get("pos");
        viewPager.setCurrentItem(pos);

        int currentItem = viewPager.getCurrentItem();
        Log.d("TGG",currentItem+"");
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

      /*  for (int i = 0; i < images.length; i++) {
            View view = inflater.inflate(R.layout.item_photo, null);
            ImageView imageView= (ImageView) view.findViewById(R.id.image);
            imageView.setImageResource(images[i]);
            viewList.add(view);

        }*/









       /* Intent intent = getIntent();
        if (intent!=null) {
            String url = intent.getStringExtra("url");
            Log.d("TAG",url);
            Glide.with(this)
                    .load(url)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                           mProgressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv_photo);
        }*/

    }


}
