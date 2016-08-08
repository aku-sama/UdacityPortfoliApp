package raspopova.diana.portfolioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.buttonMovies)
    Button mMovieButton;
    @BindView(R.id.buttonAppMaterial)
    Button mAppMaterialButton;
    @BindView(R.id.buttonBuildBigger)
    Button mBuildBiggerButton;
    @BindView(R.id.buttonCapstone)
    Button mCapstoneButton;
    @BindView(R.id.buttonStockHawk)
    Button mStockHawkButton;
    @BindView(R.id.buttonUbiquitous)
    Button mUbiquitousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init Butterknife
        ButterKnife.bind(this);

        //set listeners
        mMovieButton.setOnClickListener(this);
        mAppMaterialButton.setOnClickListener(this);
        mBuildBiggerButton.setOnClickListener(this);
        mCapstoneButton.setOnClickListener(this);
        mStockHawkButton.setOnClickListener(this);
        mUbiquitousButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonMovies:
                startApp(null, R.string.button_movies);

                break;
            case R.id.buttonAppMaterial:
                startApp(null, R.string.button_material);

                break;
            case R.id.buttonBuildBigger:
                startApp(null, R.string.button_build_bigger);

                break;
            case R.id.buttonCapstone:
                startApp(null, R.string.button_capstone);

                break;
            case R.id.buttonStockHawk:
                startApp(null, R.string.button_stock);

                break;
            case R.id.buttonUbiquitous:
                startApp(null, R.string.button_ubiquitous);

                break;
        }
    }


    /**
     * START ANOTHER APP FROM PORTFOLIO
     * @param packageName
     * @param appName
     */
    private void startApp(String packageName, int appName) {
        startApp(packageName, getResources().getString(appName));
    }

    private void startApp(String packageName, String appName) {
        if (packageName == null) {
            String message = String.format(getResources().getString(R.string.message_app_not_seted_yet), appName);

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                Toast.makeText(this, R.string.error_app_not_installed, Toast.LENGTH_LONG).show();
            }
        }
    }
}
