package com.example.pacho.animationstest;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Splash extends AppCompatActivity {

    int secretLevel=0;
    boolean click1=false,click2=false,click3=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startAnimating();
        //aqui existen dos maneras de pasar al otro menu:
        //Una es poner un timer como hice la primera vez y la otra es poner un timer a la animacion mas larga
        //por lo tanto voy a añadir un listener a la animación más larga :)

    }



    private void startAnimating() {
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        final Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        final Animation fadethem = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        final Animation fadeB = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        final Animation end= AnimationUtils.loadAnimation(this,R.anim.magic_disapear);
        final Animation cya= AnimationUtils.loadAnimation(this,R.anim.magic_disapear);
        final  Animation bye = AnimationUtils.loadAnimation(this,R.anim.magic_disapear);
        final  ImageView img1 = (ImageView) findViewById(R.id.ImageView2_Left);
        final  ImageView img2 = (ImageView) findViewById(R.id.ImageView2_Right);
        final  ImageView img3 = (ImageView) findViewById(R.id.ImageView3_Left);
        final  ImageView img4 = (ImageView) findViewById(R.id.ImageView3_Right);
        final  GifImageView boobs = (GifImageView) findViewById(R.id.boobs);
        final  TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
        final  TextView logo2 = (TextView) findViewById(R.id.TextViewBottomTitle);
        final Animation lowRider = AnimationUtils.loadAnimation(this,R.anim.custom_anim);
        final Animation lowRider2 = AnimationUtils.loadAnimation(this,R.anim.custom_anim2);
        final  Animation carBye = AnimationUtils.loadAnimation(this,R.anim.run_lowrider);
        final  Animation zoom = AnimationUtils.loadAnimation(this,R.anim.zoom);
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.music);
        final MediaPlayer pl = MediaPlayer.create(getApplicationContext(), R.raw.police);
        final GifImageView snoop= (GifImageView) findViewById(R.id.snoop);
        final GifImageView crew = (GifImageView) findViewById(R.id.crew);
        //final ImageView car2= (ImageView) findViewById(R.id.car2);
        //Intent i = new Intent(Splash.this, MainActivity.class);
        //startActivity(i);

        zoom.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                pl.stop();
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fadeB.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                boobs.startAnimation(zoom);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        carBye.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                boobs.setVisibility(View.VISIBLE);
                boobs.startAnimation(fadeB);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lowRider2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ImageView car = (ImageView) findViewById(R.id.car);
                secretLevel++;
                if(secretLevel==10){
                    pl.start();
                    snoop.startAnimation(cya);
                    crew.startAnimation(cya);
                    snoop.setVisibility(View.INVISIBLE);
                    crew.setVisibility(View.INVISIBLE);
                }
                if(secretLevel==13){
                    car.startAnimation(carBye);
                    car.setVisibility(View.INVISIBLE);
                }else {
                    car.startAnimation(lowRider);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lowRider.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ImageView car = (ImageView) findViewById(R.id.car);
                car.startAnimation(lowRider2);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        end.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(secretLevel==0){mp.start();}
                ImageView car = (ImageView) findViewById(R.id.car);
                car.setVisibility(View.VISIBLE);
                car.startAnimation(fadethem);
                snoop.setVisibility(View.VISIBLE);
                snoop.startAnimation(fadethem);
                crew.setVisibility(View.VISIBLE);
                crew.startAnimation(fadethem);
                car.startAnimation(lowRider);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fade1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        TableLayout  t = (TableLayout) findViewById(R.id.TableLayout01);
                        t.setAnimation(bye);
                        t.startAnimation(bye);
                        t.setVisibility(View.INVISIBLE);
                        logo1.setAnimation(bye);
                        logo2.setAnimation(end);
                        logo2.startAnimation(end);
                        logo1.setVisibility(View.INVISIBLE);
                        logo2.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

        logo1.startAnimation(fade1);
        logo2.startAnimation(fade2);

        img1.setAnimation(fade2);
        img2.setAnimation(fade2);
        img3.setAnimation(fade2);
        img4.setAnimation(fade2);
    }


}
