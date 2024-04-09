package main.agromarket.farmer.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;
import main.agromarket.shared.valueObject.Identifier;

public class FarmType {
    private String typeFarm;
    private String farm;

    public FarmType(String typeFarm, String farm) {
        this.typeFarm = typeFarm;
        this.farm = farm;
        ensureIsValidLength(typeFarm, farm);
    }
    public String getTypeFarm() {
        return typeFarm;
    }
    public String getFarm() {
        return farm;
    }
    private void ensureIsValidLength(String typeFarm, String farm){
        if(typeFarm.length() <= 1){
            throw new IllegalArgumentException("Type Contact must have more than two characters. ");
        }
        if(farm.length() <= 1){
            throw new IllegalArgumentException("Contact must have more than two characters. ");
        }
    }
}