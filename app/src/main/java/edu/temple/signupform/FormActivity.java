package edu.temple.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        final EditText nameField = (EditText) findViewById(R.id.nameTextField);
        final EditText emailField = (EditText) findViewById(R.id.emailTextField);
        final EditText passwordField = (EditText) findViewById(R.id.passTextField);
        final EditText confirmPasswordField = (EditText) findViewById(R.id.confirmPassField);
        Button saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validName = !nameField.getText().equals("");
                boolean validEmail = isEmailValid(emailField.getText());
                boolean validPassword = passwordField.getText().equals(confirmPasswordField.getText());

                //Invalid name, email, or missing password.
                if(!validName || !validEmail || passwordField.getText().equals("")){
                    Toast.makeText(FormActivity.this,
                            "Please enter all information.", Toast.LENGTH_LONG).show();
                }
                //If passwords dont match
                else if(validPassword){
                    Toast.makeText(FormActivity.this, "Please ensure that password and " +
                            "confirm password are the same.", Toast.LENGTH_LONG).show();
                }
                //If everything is filled out correctly
                else{
                    Toast.makeText(FormActivity.this,
                            "Your data has been saved. Congrats!", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    /**
     * Ensures that text returned by email field is in fact an email.
     * Found on stack overflow : https://stackoverflow.com/questions/6119722/
     * @author Pointer Null
     */
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}


