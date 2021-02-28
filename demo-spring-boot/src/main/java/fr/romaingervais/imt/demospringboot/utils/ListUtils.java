package fr.romaingervais.imt.demospringboot.utils;

import fr.romaingervais.imt.demospringboot.account.Account;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static <T> List<T> asList(Iterable<T> all) {
        ArrayList<T> list = new ArrayList<>();
        all.iterator().forEachRemaining(list::add);
        return list;
    }
}
