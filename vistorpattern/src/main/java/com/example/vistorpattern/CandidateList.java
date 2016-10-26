package com.example.vistorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjun on 2016/8/29.
 */
public class CandidateList {
    private List<Candidate> list = new ArrayList<Candidate>();

    public void addCandidate(Candidate candidate){
        list.add(candidate);
    }

    public void accept(Vistor vistor){
        for (Candidate candidate : list){
            candidate.accept(vistor);
        }
    }
}
