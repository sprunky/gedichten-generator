package com.jcore.gedichtengenerator.service;

import com.jcore.gedichtengenerator.model.Rhyme;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class RhymeService {

    public List<Rhyme> getRhymes() throws FileNotFoundException {
        List<Rhyme> generatedPoem = getRhymes("src/main/resources/static/filler.txt");
        List<Rhyme> starters = getRhymes("src/main/resources/static/beginner.txt");
        List<Rhyme> enders = getRhymes("src/main/resources/static/enders.txt");
        generatedPoem.add(0, starters.get(0));
        generatedPoem.add(enders.get(0));
        return generatedPoem;
    }

    private List<Rhyme> getRhymes(String source) throws FileNotFoundException {
        List<Rhyme> getRhymes = new ArrayList<>();
        Scanner scanner = new Scanner(new File(source));
        List<Rhyme> generatedPoem = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        while(scanner.hasNextLine()){
            deque.addLast(scanner.nextLine());
        }
        while (!deque.isEmpty()){
            getRhymes.add(new Rhyme(deque.pop(),deque.pop()));
        }
        Collections.shuffle(getRhymes);

        for (int i = 0; i < 3; i++) {
            generatedPoem.add(getRhymes.get(i));
        }
        return generatedPoem;
    }

}
