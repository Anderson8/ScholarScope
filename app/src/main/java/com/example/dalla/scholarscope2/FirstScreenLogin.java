package com.example.dalla.scholarscope2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class FirstScreenLogin extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private LinearLayout profile;
    private Button Signout;
    private SignInButton SignIn;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions signInGoogle;
    private static final int REQ_CODE = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen_login);
       // profile = (LinearLayout)findViewById(R.id.profile);
        Signout= (Button)findViewById(R.id.btn_logout);
        SignIn = (SignInButton)findViewById(R.id.btn_login);
        SignIn.setOnClickListener(this);
        Signout.setOnClickListener(this);
        profile = (LinearLayout) findViewById(R.id.txt_view);
        GoogleSignInOptions signInGoogle = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, signInGoogle).build();

    }
private void signIn(){
    Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
    startActivityForResult(intent,REQ_CODE);
}
private void  handleResult(GoogleSignInResult result){
    if(result.isSuccess()){
        GoogleSignInAccount account = result.getSignInAccount();
        String name = account.getDisplayName();
        String email = account.getEmail();
        //Name.setText(name);
      //  Email.setText(email);
        updateUI(true);
    }else{
        updateUI(false);
    }
}
private void updateUI(boolean isLogin) {
    if (isLogin) {
        profile.setVisibility(View.VISIBLE);
        SignIn.setVisibility(View.GONE);
    } else {
        profile.setVisibility(View.GONE);
        SignIn.setVisibility(View.VISIBLE);
    }
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data){
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode== REQ_CODE) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        handleResult(result);

    }
}

    @Override
    public void onClick(View v) {
        startActivity(new Intent(FirstScreenLogin.this, RegistrationActivity.class));

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
