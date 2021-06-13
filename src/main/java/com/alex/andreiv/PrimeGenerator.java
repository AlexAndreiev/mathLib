package com.alex.andreiv;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {

    private List<Integer> _primeList;
    private int _currentPrime;

    public PrimeGenerator(){
        _primeList = new ArrayList<>();
        _currentPrime = -1;
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

    private boolean isDividedByExistingPrimes(int num){
        if (_primeList.size() == 0) return false;
        for (var factor : _primeList)
            if (num % factor == 0)
                return true;
        return false;
    }

}
