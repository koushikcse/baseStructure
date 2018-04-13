package com.basestructure.modules.auth.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.basestructure.R;
import com.basestructure.databinding.ActivityLoginBinding;
import com.basestructure.dependencyInjection.PresenterComponent;
import com.basestructure.modules.auth.AuthApplicationModule;
import com.basestructure.modules.auth.AuthPresenterComponent;
import com.basestructure.modules.auth.DaggerAuthPresenterComponent;
import com.basestructure.modules.main.MainActivity;
import com.basestructure.modules.view.activity.PresentedActivity;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.services.AccountService;

/**
 * Created by innofied on 29/3/18.
 */

public class LoginActivity extends PresentedActivity<LoginPresenter> implements LoginPresenter.ILoginActivity {
    private ActivityLoginBinding binding;
    private LoginPresenter presenter;

    private TwitterCore twitterCore;
    private TwitterAuthClient client;
    private Twitter twitter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        setTwitter();
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
        binding.twitterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twitter = Twitter.getInstance();
                if (twitter != null) {
                    client = new TwitterAuthClient();
                    client.authorize(LoginActivity.this, new Callback<TwitterSession>() {
                        @Override
                        public void success(Result<TwitterSession> twitterSessionResult) {
                            Toast.makeText(LoginActivity.this, "success" + "--" + twitterSessionResult.data.getUserId(), Toast.LENGTH_SHORT).show();
                            Log.e("Twitter-->", twitterSessionResult.data.getUserName() + "," + twitterSessionResult.data.getUserId());
                            getTwitterEmail(twitterSessionResult);
                        }

                        @Override
                        public void failure(TwitterException e) {
                            Toast.makeText(LoginActivity.this, "failure", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private void setTwitter() {
        TwitterConfig twitterConfig = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(getString(R.string.CONSUMER_KEY),
                        getString(R.string.CONSUMER_SECRET)))
                .debug(true)
                .build();
        Twitter.initialize(twitterConfig);
    }

    private void getTwitterEmail(Result<TwitterSession> twitterSessionResult) {
        TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
        if (twitterSessionResult != null) {
            client.requestEmail(session, new Callback<String>() {
                @Override
                public void success(Result<String> result) {
                    // Do something with the result, which provides the email address
                    Log.e("twitter email->", result.data + "");
                }

                @Override
                public void failure(TwitterException exception) {
                    // Do something on failure
                }
            });
        }

    }

    @Override
    protected LoginPresenter onCreatePresenter() {
        presenter = new LoginPresenter(this);
        return presenter;
    }

    @Override
    protected void injectPresenter(PresenterComponent component, LoginPresenter presenter) {
        AuthPresenterComponent authPresenterComponent = DaggerAuthPresenterComponent.builder()
                .presenterComponent(component)
                .authApplicationModule(new AuthApplicationModule(this))
                .build();
        authPresenterComponent.inject(presenter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        client.onActivityResult(requestCode, resultCode, data);
    }
}
