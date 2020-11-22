package com.example.primertrabajo;

import android.app.AlertDialog;
        import android.app.Dialog;
        import android.os.Bundle;

        import androidx.fragment.app.DialogFragment;

public class Negocio1 extends DialogFragment {
    public static final String ARGUMENTO_TITLE = "TITLE";
    public static final String ARGUMENTO_FULL_SNIPPET = "FULL_SNIPPET";

    private String title;
    private String fullSnippet;

    public static Negocio1 newInstamnce(String title, String fullSnippet){
        Negocio1 fragment = new Negocio1();
        Bundle b = new Bundle();
        b.putString(ARGUMENTO_TITLE, title);
        b.putString(ARGUMENTO_FULL_SNIPPET, fullSnippet);
        fragment.setArguments(b);
        return  fragment;
    }

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        Bundle args = getArguments();

        title = args.getString(ARGUMENTO_TITLE);
        fullSnippet = args.getString(ARGUMENTO_FULL_SNIPPET);
    }

    public Dialog onCreateDialog(Bundle saveInstanceState){
        Dialog dialog = new AlertDialog.Builder(getActivity()).setTitle(title).setMessage(fullSnippet).create();
        return dialog;
    }
}