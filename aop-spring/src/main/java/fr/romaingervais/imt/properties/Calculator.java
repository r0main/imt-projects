package fr.romaingervais.imt.properties;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int add(int initial, int toAdd) {
        return initial + toAdd;
    }

    public int substract(int initial, int toSubstract) {
        return initial - toSubstract;
    }
}
