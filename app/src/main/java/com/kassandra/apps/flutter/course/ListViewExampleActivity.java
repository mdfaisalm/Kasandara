package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewExampleActivity extends AppCompatActivity {

    String studentName = "abc";
    String secondStudentName = "xyz";

    String[] studentNamesArray;
    int[] studentRollNosArray = new int[]{1, 2, 3, 4};

    ArrayList<String> studentNamesArrayList = new ArrayList<>();
    ArrayList<Integer> studentImagesArrayList = new ArrayList<>();

    ListView lvStudentsNames;
    ArrayAdapter<String> arrayAdapter;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvStudentsNames = findViewById(R.id.lvStudentsNames);

        studentNamesArray = new String[]{"abc", "xyz", "studentName3"};
        studentNamesArray = new String[]{"abc", "xyz", "studentName4", "studentName5"};
        studentNamesArray = new String[]{"abc", "xyz", "studentName3", "studentName4"};

        studentNamesArray[0] = "new Value";

        studentNamesArrayList.add("abc");//0
        studentNamesArrayList.add("xyz");//1
        studentNamesArrayList.add(2,"3rd value");

        //2 arrays, 1 for roll numbers and second for names
        //structure of all display should be like below
        //1 Name
        //2 Name
        //3 Name
        //using a for loop


        studentImagesArrayList.add(R.drawable.bg_login_et);
        studentImagesArrayList.add(R.drawable.download);
        studentImagesArrayList.add(R.drawable.ic_launcher_background);


        /*arrayAdapter = new ArrayAdapter<String>(this, R.layout.custom_lv_item, studentNamesArrayList);
        lvStudentsNames.setAdapter(arrayAdapter);*/

        customAdapter = new CustomAdapter();
        lvStudentsNames.setAdapter(customAdapter);
    }

    public void addItem(View view) {
        int size = studentNamesArrayList.size() + 1;
        studentNamesArrayList.add("new Item " + size);
        studentImagesArrayList.add(R.mipmap.ic_launcher);
        customAdapter.notifyDataSetChanged();
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return studentNamesArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(ListViewExampleActivity.this);
            View view = layoutInflater.inflate(R.layout.custom_lv_item, null);
            TextView tvTitle = view.findViewById(R.id.tvTitle);
            ImageView ivLogo = view.findViewById(R.id.ivLogo);
            String data = studentNamesArrayList.get(position);
            ivLogo.setImageResource(studentImagesArrayList.get(position));
            tvTitle.setText(data);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ListViewExampleActivity.this, "Position=" + position, Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }
}