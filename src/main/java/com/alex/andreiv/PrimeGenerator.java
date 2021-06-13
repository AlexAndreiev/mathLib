package com.alex.andreiv;

import java.util.ArrayList;
import java.util.List;
import static com.alex.andreiv.Utils.*;

public class PrimeGenerator {

    private List<Integer> _primeList;
    private int _currentPrime;

    public PrimeGenerator(){
        reset();
    }

    public int getNextPrime(){
        int genNum = _currentPrime;
        if (_currentPrime < 2)
            _currentPrime = 2;
        else
        {
            while (isDividedByExistingPrimes(++genNum));
            _currentPrime = genNum;
        }
        _primeList.add(_currentPrime);
        return _currentPrime;
    }

    public void reset(){
        _primeList = new ArrayList<>();
        _currentPrime = -1;
    }

    private boolean isDividedByExistingPrimes(int num){
        if (_primeList.size() == 0) return false;
        for (var factor : _primeList)
            if (isDividerFor(factor, num))
                return true;
        return false;
    }

}
