package micheal.cob.developerprofile;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;

import micheal.cob.developerprofile.fragment.GithubFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    GithubFragment githubFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView startTextView = view.findViewById(R.id.start);
        startTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                githubFragment = new GithubFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment, githubFragment);
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_left);
                fragmentTransaction.commit();

                //data can be passed using bundle here
                /*Bundle bundle = new Bundle();
                bundle.putString("ToShowthere", clickedDesp);
                healthTipsDescriptionFragment.setArguments(bundle);*/
            }
        });
        return view;
    }
}
