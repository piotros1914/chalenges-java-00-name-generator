package piotrowski.patryk.namegenerator.entity.enums;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Gender {
    FEMALE("f"), MALE("m");

    String symbol;

    Gender(String symbol){
        this.symbol = symbol;
    }

    private static final List<Gender> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final Random RANDOM = new Random();

    public static Gender random()  {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }

    public static Gender getGenderBySymbol(String symbol){
        if(Strings.isNullOrEmpty(symbol)){
            return null;
        }
        switch (symbol) {
            case "f": return FEMALE;
            case "m": return MALE;
            default: return null;
        }
    }

    public static boolean isGenderExist(String symbol){
        Gender gender = getGenderBySymbol(symbol);
        return gender != null ? true : false;
    }


}
