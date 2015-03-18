package br.com.brunokawakami.suggarormexample;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            UserEntity userInsertRohde = new UserEntity("Felipe Rohde", "fr.rohde@gmail.com");
            userInsertRohde.save();

            UserEntity userInsertBruno = new UserEntity("Bruno Akio", "bru.kawakami@gmail.com");
            userInsertBruno.save();

            UserEntity userFind = UserEntity.findById(UserEntity.class, (long) 1);

            ((TextView) rootView.findViewById(R.id.userName)).setText(userFind.name);

            UserEntity userUpdate = UserEntity.findById(UserEntity.class, (long)2);
            userUpdate.name = "Bruno Kawakami"; // modify the values
            userUpdate.save();


            UserEntity userDeleteRohde = UserEntity.findById(UserEntity.class, (long)1);
            userDeleteRohde.delete();

            UserEntity userDeleteBruno = UserEntity.findById(UserEntity.class, (long)2);
            userDeleteBruno.delete();


            return rootView;
        }
    }
}
