package piotrowski.patryk.namegenerator.entity.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Gender {
    FEMALE, MALE;

    private static final List<Gender> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final Random RANDOM = new Random();

    public static Gender random()  {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }

}
