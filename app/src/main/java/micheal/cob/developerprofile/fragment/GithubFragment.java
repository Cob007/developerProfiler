package micheal.cob.developerprofile.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import micheal.cob.developerprofile.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class GithubFragment extends Fragment {


    public GithubFragment() {
        // Required empty public constructor
    }

    GitLabFragment gitLabFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_github, container, false);
        final EditText githubUsername = view.findViewById(R.id.github_username);
        githubUsername.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    Log.i(TAG,"Enter pressed");
                    String getStrng = githubUsername.getText().toString().trim();

                    gitLabFragment = new GitLabFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.replace(R.id.fragment, gitLabFragment);
                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left);
                    fragmentTransaction.commit();
                }
                return false;
            }
        });
        return view;
    }

}
