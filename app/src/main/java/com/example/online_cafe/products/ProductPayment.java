package com.example.online_cafe.products;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.online_cafe.CONST;
import com.example.online_cafe.ChoosePaymentFragment;
import com.example.online_cafe.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.WriterException;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class ProductPayment extends Fragment {
    ImageView qrImageView;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_payment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        qrImageView = view.findViewById(R.id.qr_image_view);
        generateUUID();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("orders");
        reference.child(CONST.UUID).child("order").setValue(CONST.listOfOrders);
        CONST.usersNameAndSurname.setTotalAmount(CONST.totalAmount);
        reference.child(CONST.UUID).child("user").setValue(CONST.usersNameAndSurname);

        QRGEncoder qrgEncoder = new QRGEncoder(CONST.UUID,null, QRGContents.Type.TEXT,1000);
        Bitmap qrBit = qrgEncoder.getBitmap();
        qrImageView.setImageBitmap(qrBit);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("orders/"+CONST.UUID +"/user");
        Query checkQr = reference.orderByChild("qrRead").equalTo(true);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot.exists()){
                    boolean checkQrBool = snapshot.child("qrRead").getValue(Boolean.class);
                    if(checkQrBool){
                        ChoosePaymentFragment fragment = new ChoosePaymentFragment();
                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer,fragment, "FragmentReplaced")
                                .addToBackStack(null)
                                .commit();

                    }else{
                        System.out.println("Halen Okunmadı");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    public void generateUUID(){
        UUID uuid = UUID.randomUUID();
        CONST.UUID = uuid.toString();
    }
}