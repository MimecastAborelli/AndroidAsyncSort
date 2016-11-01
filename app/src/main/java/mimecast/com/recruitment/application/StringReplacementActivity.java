package mimecast.com.recruitment.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mimecast.com.recruitment.R;

public class StringReplacementActivity extends Activity {
    private EditText editSource;
    private EditText editTargets;
    private EditText editReplacements;
    private Button btnReplace;
    private TextView txtViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_replacement);

        editSource = (EditText) findViewById(R.id.editTextSourceString);
        editTargets = (EditText) findViewById(R.id.editTextTarget);
        editReplacements = (EditText) findViewById(R.id.editTextReplacements);
        btnReplace = (Button) findViewById(R.id.buttonResult);
        txtViewResult = (TextView) findViewById(R.id.textViewResult);

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onReplaceButtonClick();
            }
        });
    }

    private void onReplaceButtonClick() {
        //Get the source string
        String source = null;
        source = editSource.getText().toString();

        //get comma separated targets
        String targetString = editTargets.getText().toString();
        String[] targetArray = null;
        if (null != targetString && !targetString.isEmpty()) {
            targetArray = targetString.split(",");
        }

        //get comma separated Replacements
        String replacementString = editReplacements.getText().toString();
        String[] replacementArray = null;
        if (null != replacementString && !replacementString.isEmpty()) {
            replacementArray = replacementString.split(",");
        }

        String replacedString = replaceOccurrenceOfStrings(source, targetArray, replacementArray);
        txtViewResult.setText(replacedString);
    }

    /**
     * Coding test
     *
     * Implements replaceOccurrenceOfStrings() to atomically replace multiple strings at once within the sourceString
     *
     * Return the result
     *
     * @param sourceString
     * @param targetArray
     * @param replacementArray
     * @return
     */

    private String replaceOccurrenceOfStrings(String sourceString, String[] targetArray, String[] replacementArray) {
        return null;
    }
}
