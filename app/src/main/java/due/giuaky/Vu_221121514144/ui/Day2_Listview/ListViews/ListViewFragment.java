package due.giuaky.Vu_221121514144.ui.Day2_Listview.ListViews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import due.giuaky.Vu_221121514144.R;
import due.giuaky.Vu_221121514144.databinding.FragmentDay2ListviewBinding;

public class ListViewFragment extends Fragment{
    private FragmentDay2ListviewBinding binding;
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Bước 1: Inflate binding
        binding = FragmentDay2ListviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Bước 2: Ánh xạ view qua binding
        initData();
        initView();

        mAdapter = new ContactAdapter(requireContext(), listContact);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(requireContext(), model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }


    private void initView(){
        lvContact = binding.lvContact1;
    }

    private void initData(){
        listContact.add(new ContactModel("Trần Trường Sơn", "0988111222", R.drawable.avt_khi));
        listContact.add(new ContactModel("Trần Trường", "0988112222", R.drawable.avt_meo));
        listContact.add(new ContactModel("Trần Trường Thuy", "0988111244", R.drawable.avt_ga));
        listContact.add(new ContactModel("Trần Trường Sx", "0988111288", R.drawable.avt_heo));
        listContact.add(new ContactModel("Trần Trường TX", "0988111299", R.drawable.avt_khi));
        listContact.add(new ContactModel("Trần Trường PA", "0988111200", R.drawable.avt_meo));
        listContact.add(new ContactModel("Trần Trường SDD", "0988111888", R.drawable.avt_ga));
        listContact.add(new ContactModel("Trần Trường ÂSS", "0988111555", R.drawable.avt_heo));
        listContact.add(new ContactModel("Trần Trường DDF", "0988111255", R.drawable.avt_khi));
        listContact.add(new ContactModel("Trần Trường AAA", "0988111233", R.drawable.avt_meo));
        listContact.add(new ContactModel("Trần Trường ÊWW", "0988111556", R.drawable.avt_ga));
        listContact.add(new ContactModel("Trần Trường ĐAA", "0988111277", R.drawable.avt_heo));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
