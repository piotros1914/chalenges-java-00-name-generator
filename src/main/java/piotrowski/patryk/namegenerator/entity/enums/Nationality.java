package piotrowski.patryk.namegenerator.entity.enums;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Nationality {
    PL("pl"), EN("en");

    String symbol;

    Nationality(String symbol){
       this.symbol = symbol;
    }

    private static final List<Nationality> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final Random RANDOM = new Random();

    public static Nationality random()  {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }

    public static Nationality getNationalityBySymbol(String symbol){
        if(Strings.isNullOrEmpty(symbol)){
            return null;
        }
        switch (symbol) {
            case "pl": return PL;
            case "en":  return EN;
            default: return null;
        }
    }
    public static boolean isNationalityExist(String symbol){
        Nationality country = getNationalityBySymbol(symbol);
        return country != null ? true : false;
    }

}
