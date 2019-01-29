package erkaneroglu.com.lolguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    TextView mHeroName, mHeroLongName, mHeroLane, mHeroNation, mRP, mTuruncuOz, mPopularity, mHeroStory, mCan, mManaYenilenmesi, mSaldiriHizi, mCanYenilenmesi, mMenzil, mZirh, mHaraketHizi, mMana, mSaldiriHasari, mBuyuDirenci, mSkillName, mSkillDescription;
    ImageView mHeroImage;
    CircleImageView mPassiveImage, mQImage, mWImage, mEImage, mRImage;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        XmlElements();
        GetDatasFromAdapters();
    }

    public void XmlElements() {
        mHeroName = findViewById(R.id.hero_id);
        mHeroLongName = findViewById(R.id.hero_long_name_id);
        mHeroLane = findViewById(R.id.hero_lane_id);
        mHeroNation = findViewById(R.id.hero_nation_id);
        mRP = findViewById(R.id.rp_id);
        mTuruncuOz = findViewById(R.id.turuncu_oz_id);
        mPopularity = findViewById(R.id.popularity_id);
        mHeroStory = findViewById(R.id.story_id);
        mCan = findViewById(R.id.i_can_id);
        mManaYenilenmesi = findViewById(R.id.i_mana_yenilenmesi_id);
        mSaldiriHizi = findViewById(R.id.i_saldiri_hizi_id);
        mCanYenilenmesi = findViewById(R.id.i_can_yenilenmesi_id);
        mMenzil = findViewById(R.id.i_menzil_id);
        mZirh = findViewById(R.id.i_zirh_id);
        mHaraketHizi = findViewById(R.id.i_haraket_hizi_id);
        mMana = findViewById(R.id.i_mana_id);
        mSaldiriHasari = findViewById(R.id.i_saldiri_hasari_id);
        mBuyuDirenci = findViewById(R.id.i_buyu_direnci_id);

        mHeroImage = findViewById(R.id.hero_image_id);
        mPassiveImage = findViewById(R.id.passive_id);
        mQImage = findViewById(R.id.skill_q_id);
        mWImage = findViewById(R.id.skill_w_id);
        mEImage = findViewById(R.id.skill_e_id);
        mRImage = findViewById(R.id.skill_r_id);
        mSkillName = findViewById(R.id.skill_name);
        mSkillDescription = findViewById(R.id.skill_description);

    }

    public void GetDatasFromAdapters() {
        //Adapterdan veriler alınıyor.
        Intent intent = getIntent();
        String hero_image = intent.getExtras().getString("hero_image");
        String hero_name = intent.getExtras().getString("hero_name");
        String hero_long_name = intent.getExtras().getString("hero_long_name");
        String hero_lane = intent.getExtras().getString("hero_lane");
        String hero_nation = intent.getExtras().getString("hero_nation");
        String rp = intent.getExtras().getString("rp");
        String turuncu_oz = intent.getExtras().getString("turuncu_oz");
        String popularity = intent.getExtras().getString("popularity");

        String hero_story = intent.getExtras().getString("hero_story");

        String can = intent.getExtras().getString("can");
        String mana_yenilenmesi = intent.getExtras().getString("mana_yenilenmesi");
        String saldiri_hizi = intent.getExtras().getString("saldiri_hizi");
        String can_yenilenmesi = intent.getExtras().getString("can_yenilenmesi");
        String menzil = intent.getExtras().getString("menzil");
        String zirh = intent.getExtras().getString("zirh");
        String haraket_hizi = intent.getExtras().getString("haraket_hizi");
        String mana = intent.getExtras().getString("mana");
        String saldiri_hasari = intent.getExtras().getString("saldiri_hasari");
        String buyu_direnci = intent.getExtras().getString("buyu_direnci");

        final String passive_name = intent.getExtras().getString("passive_name");
        final String passive_description = intent.getExtras().getString("passive_description");
        String passive_image = intent.getExtras().getString("passive_image");

        final String qName = intent.getExtras().getString("q_name");
        final String qDescription = intent.getExtras().getString("q_description");
        String qImage = intent.getExtras().getString("q_image");

        final String wName = intent.getExtras().getString("w_name");
        final String wDescription = intent.getExtras().getString("w_description");
        String wImage = intent.getExtras().getString("w_image");

        final String eName = intent.getExtras().getString("e_name");
        final String eDescription = intent.getExtras().getString("e_description");
        String eImage = intent.getExtras().getString("e_image");

        final String rName = intent.getExtras().getString("r_name");
        final String rDescription = intent.getExtras().getString("r_description");
        String rImage = intent.getExtras().getString("r_image");

        //Adapterdan alınan veriler nesnelere atanıyor.
        Picasso.get().load(hero_image).into(mHeroImage);
        Picasso.get().load(passive_image).into(mPassiveImage);
        Picasso.get().load(qImage).into(mQImage);
        Picasso.get().load(wImage).into(mWImage);
        Picasso.get().load(eImage).into(mEImage);
        Picasso.get().load(rImage).into(mRImage);

        mHeroName.setText(hero_name);
        mHeroLongName.setText(hero_long_name);
        mHeroLane.setText(hero_lane);
        mHeroNation.setText(hero_nation);
        mRP.setText(rp);
        mTuruncuOz.setText(turuncu_oz);
        mPopularity.setText(popularity);

        mHeroStory.setText(hero_story);

        mCan.setText(can);
        mManaYenilenmesi.setText(mana_yenilenmesi);
        mSaldiriHizi.setText(saldiri_hizi);
        mCanYenilenmesi.setText(can_yenilenmesi);
        mMenzil.setText(menzil);
        mZirh.setText(zirh);
        mHaraketHizi.setText(haraket_hizi);
        mMana.setText(mana);
        mSaldiriHasari.setText(saldiri_hasari);
        mBuyuDirenci.setText(buyu_direnci);

        //Actionbar isimleri değiştiriliyor..
        getSupportActionBar().setTitle(hero_name);
        getSupportActionBar().setSubtitle(hero_long_name);

        //Skill resimlerinin tıklama olayları..
        mSkillName.setText("P - " + passive_name);
        mSkillDescription.setText(passive_description);
        mPassiveImage.setBorderColor(Color.argb(255, 39, 174, 96));

        mPassiveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSkillName.setText("P - " + passive_name);
                mSkillDescription.setText(passive_description);
                mPassiveImage.setBorderColor(Color.argb(255, 39, 174, 96));
                mQImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mWImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mEImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mRImage.setBorderColor(Color.argb(255, 44, 62, 80));
            }
        });
        mQImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSkillName.setText("Q - " + qName);
                mSkillDescription.setText(qDescription);
                mQImage.setBorderColor(Color.argb(255, 39, 174, 96));
                mPassiveImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mWImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mEImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mRImage.setBorderColor(Color.argb(255, 44, 62, 80));
            }
        });
        mWImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSkillName.setText("W - " + wName);
                mSkillDescription.setText(wDescription);
                mWImage.setBorderColor(Color.argb(255, 39, 174, 96));
                mQImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mEImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mRImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mPassiveImage.setBorderColor(Color.argb(255, 44, 62, 80));
            }
        });
        mEImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSkillName.setText("E - " + eName);
                mSkillDescription.setText(eDescription);
                mEImage.setBorderColor(Color.argb(255, 39, 174, 96));
                mQImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mWImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mRImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mPassiveImage.setBorderColor(Color.argb(255, 44, 62, 80));
            }
        });
        mRImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSkillName.setText("R - " + rName);
                mSkillDescription.setText(rDescription);
                mRImage.setBorderColor(Color.argb(255, 39, 174, 96));
                mQImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mWImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mEImage.setBorderColor(Color.argb(255, 44, 62, 80));
                mPassiveImage.setBorderColor(Color.argb(255, 44, 62, 80));
            }
        });

    }
}
