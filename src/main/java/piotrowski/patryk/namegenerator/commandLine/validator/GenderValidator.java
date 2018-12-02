package piotrowski.patryk.namegenerator.commandLine.validator;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import piotrowski.patryk.namegenerator.entity.enums.Gender;

public class GenderValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(value != null && value !=""){
            if(!Gender.isGenderExist(value)){
                throw new ParameterException("Parameter " + name + " has unknown value " + value +")");
            }
        }
    }
}
