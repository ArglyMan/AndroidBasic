package com.example.scores;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> ScoresA;
    private MutableLiveData<Integer> ScoresB;
    private Integer PreA;
    private Integer PreB;

    public MutableLiveData<Integer> getScoresA() {
        if(ScoresA == null)
        {
            ScoresA = new MutableLiveData<Integer>();
            ScoresA.setValue(0);
        }

        return ScoresA;
    }

    public MutableLiveData<Integer> getScoresB() {
        if(ScoresB == null)
        {
            ScoresB = new MutableLiveData<Integer>();
            ScoresB.setValue(0);
        }
        return ScoresB;
    }

    public void AddA(int n) {
        PreA = ScoresA.getValue();
        PreB = ScoresB.getValue();
        ScoresA.setValue(ScoresA.getValue() + n);
    }

    public void AddB(int n){
        PreA = ScoresA.getValue();
        PreB = ScoresB.getValue();
        ScoresB.setValue(ScoresB.getValue() + n);
    }

    public void Reset(){
        PreA = ScoresA.getValue();
        PreB = ScoresB.getValue();
        ScoresA.setValue(0);
        ScoresB.setValue(0);
    }

    public  void Back(){
        ScoresA.setValue(PreA);
        ScoresB.setValue(PreB);
    }

}
