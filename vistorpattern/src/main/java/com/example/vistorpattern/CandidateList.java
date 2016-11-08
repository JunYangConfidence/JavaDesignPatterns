package com.example.vistorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by **.
 * 相当于objectStructure
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
