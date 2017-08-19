package stellium.stellium.NavigationDrawer;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import stellium.stellium.MyApplication;
import stellium.stellium.R;


public class FragmentDrawer extends Fragment implements View.OnClickListener {


    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View containerView;
    LinearLayout Home, SalesHistory, Transactions, PriceChanger, DateLock, EditProfile, Settings, Logout;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public FragmentDrawer() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        sharedPreferences = getActivity().getSharedPreferences("global data", getActivity().MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Home = (LinearLayout) layout.findViewById(R.id.home_drawer);
        SalesHistory = (LinearLayout) layout.findViewById(R.id.sales_history);
        Transactions = (LinearLayout) layout.findViewById(R.id.transaction);
        PriceChanger = (LinearLayout) layout.findViewById(R.id.price_changer);


        Home.setOnClickListener(this);
        SalesHistory.setOnClickListener(this);
        Transactions.setOnClickListener(this);
        PriceChanger.setOnClickListener(this);

        return layout;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
//                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    @Override
    public void onClick(View v) {
        mDrawerLayout.closeDrawer(Gravity.LEFT);
        switch (v.getId()) {
            case R.id.home_drawer:
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        int answer = 12 / 0;
                    }
                };

                Handler h = new Handler();
                h.postDelayed(r, 1000);
                Toast.makeText(getActivity(),"crash",Toast.LENGTH_LONG).show();
                break;


        }
    }


    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Tracking the screen view
        MyApplication.getInstance().trackScreenView("Navigation Fragment");
    }
}
