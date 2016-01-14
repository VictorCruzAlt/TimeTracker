package iuAndroid;

import timetracker.iuandroid.R;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private TabLayout tabLayout;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		int DELAY = 2000;

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				startActivity(intent);

			}
		}, DELAY);

		FloatingActionButton butoPerComensar = (FloatingActionButton) findViewById(R.id.button1);
		butoPerComensar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				startActivity(intent);
				//setContentView(R.layout.createactivity);
			}
		});

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection

		switch (item.getItemId()) {
			case R.id.action_all:
				Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				String m = null;
				intent.putExtra("proj",m);
				startActivity(intent);
				return true;
			case R.id.action_delete:
				AlertDialog diaBox = AskOption();
				diaBox.show();
				return true;
			case R.id.action_intervals:
				String ma=null;
				Intent intentt = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
				intentt.putExtra("task",ma);
				startActivity(intentt);
				return true;
			/*case R.id.action_details:

				return true;
			case R.id.action_intervals:

				return true;*/
			case R.id.action_report:
				Intent intent_r = new Intent(MainActivity.this, OnCreateReport.class);
				startActivity(intent_r);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	private AlertDialog AskOption()
	{
		AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
				.setTitle("Delete")
				.setMessage("Do you want to Delete")

				.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int whichButton) {
						//your deleting code
						dialog.dismiss();
					}

				})

				.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						dialog.dismiss();

					}
				})
				.create();
		return myQuittingDialogBox;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(new OneFragment(), "Projectes");
		adapter.addFragment(new TwoFragment(), "Tasques");
		viewPager.setAdapter(adapter);
	}

	class ViewPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragmentList = new ArrayList<>();
		private final List<String> mFragmentTitleList = new ArrayList<>();

		public ViewPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		public void addFragment(Fragment fragment, String title) {
			mFragmentList.add(fragment);
			mFragmentTitleList.add(title);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragmentTitleList.get(position);
		}
	}

}
