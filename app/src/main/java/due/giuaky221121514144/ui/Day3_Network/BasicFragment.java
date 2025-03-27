package due.giuaky221121514144.ui.Day3_Network;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.List;

import due.giuaky221121514144.databinding.FragmentDay3BasicBinding;
import due.giuaky221121514144.ui.Day3_Network.model.Item;
import due.giuaky221121514144.ui.Day3_Network.network.API250_movies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BasicFragment extends Fragment {
    private FragmentDay3BasicBinding binding;
    private TextView tvDate, tvTitle, tvContent;
    private ImageView ivCover;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDay3BasicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();
        getData();

        return root;
    }

    private void initView() {
        tvTitle = binding.tvTitle;
        tvContent = binding.tvContent;
        tvDate = binding.tvDate;
        ivCover = binding.ivCover;
    }

    private void getData() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(API250_movies.SERVER_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        API250_movies service = retrofit.create(API250_movies.class);
        API250_movies.apiService.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() == null) {
                    return;
                }

                List<Item> models = response.body();
                Item model = models.get(0);


                tvTitle.setText(model.getTitle());
                tvDate.setText(model.getDate());
                tvContent.setText(model.getDescription());

                Glide.with(BasicFragment.this)
                        .load(model.getImage())
                        .into(ivCover);

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.d("MainDay3BasicActivity", "onFailure: " + t);

            }
        });
    }

}
