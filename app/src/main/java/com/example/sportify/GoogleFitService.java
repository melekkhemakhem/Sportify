package com.example.sportify;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.FitnessOptions.Builder;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class GoogleFitService {

    private GoogleApiClient mGoogleApiClient;
    private Context mContext;
    private FitnessOptions fitnessOptions; // Declare fitnessOptions here

    public GoogleFitService(Context context) {
        mContext = context;

        // Initialize fitnessOptions here
        fitnessOptions = new FitnessOptions.Builder()
                .addFitnessRecordDataType(DataType.TYPE_STEP_COUNT_DELTA)
                .build();

    }
   /* public GoogleFitService(Context context) {
        mContext = context;
        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
                .addApi(Fitness.HISTORY_API)
                .build();
    }*/

    public void connect() {
        mGoogleApiClient.connect();
    }

    public void disconnect() {
        mGoogleApiClient.disconnect();
    }
    private Pair<Long, Long> getTodayTimeRange() {
        Calendar cal = Calendar.getInstance();
        long endTime = cal.getTimeInMillis();
        cal.add(Calendar.DAY_OF_MONTH, -1); // Subtracting 1 day
        long startTime = cal.getTimeInMillis();
        return new Pair<>(startTime, endTime);
    }





    public void readStepsData(final DataReadResultListener listener) {
        Fitness.getHistoryClient(mContext, fitnessOptions) // Use fitnessOptions here
                .readData(new DataReadRequest.Builder()
                        .read(DataType.TYPE_STEP_COUNT_DELTA)
                        .setTimeRange(getTodayTimeRange().first, getTodayTimeRange().second, TimeUnit.MILLISECONDS)
                        .build())
                .addOnSuccessListener(new OnSuccessListener<DataReadResponse>() {
                    @Override
                    public void onSuccess(DataReadResponse dataReadResponse) {
                        // Handle successful data read (logic remains the same)
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle failure (logic remains the same)
                    }
                });
    }







    public interface DataReadResultListener {
        void onStepsRead(int steps);
        void onError(int status);
    }
}
