package com.mnm.rockink.recipe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mnm.rockink.recipe.http.HttpClass;
import com.mnm.rockink.recipe.jsonData.Food;

import java.io.IOException;

public class URLForm extends Fragment {

    private OnFragmentInteractionListener mListener;
    private HttpClass httpClient;

    public URLForm() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        httpClient = new HttpClass();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_urlform, container, false);
        final EditText url = (EditText) view.findViewById(R.id.url);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), RecipeListActivity.class);
                intent.putExtra("url", url.getText().toString());
                getActivity().startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);

        void setFoodList(Food s);
    }



//    public class GetItFromServer extends AsyncTask<String, Object, Food> {
//
//
//        @Override
//        protected Food doInBackground(String... params) {
//            try {
//                return httpClient.get(params[0]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//
//        }
//
//
//        @Override
//        protected void onPostExecute(Food s) {
//
//            Log.d(getClass().getCanonicalName() + " RECIPESS ", String.valueOf(s.getCount()));
//            mListener.setFoodList(s);
//        }
//    }
}
