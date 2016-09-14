package com.team.platformerrun;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CollectCoins extends AppCompatActivity {

    MediaPlayer coinSound;
    Coin            coin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_coins);
        coinSound = MediaPlayer.create(this, R.raw.coin_sound );
        coin = new Coin();
    }

    public void collectCoins(View view) {
        coin.addCoin();
        coinSound.start();
        String message = "Coins This Run: " + Integer.toString(coin.getCoinTotal());
        TextView textView = (TextView) findViewById(R.id.gameRunningTotalCoins);
        textView.setText(message);
    }

    public void endGame(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Coins", coin.getCoinTotal());
        startActivity(intent);
    }
}























