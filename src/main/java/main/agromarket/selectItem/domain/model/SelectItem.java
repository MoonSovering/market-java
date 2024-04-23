package main.agromarket.selectItem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SelectItem {
    private int amountSelect;
    private String idCompany;
    private String idStatus;
    private String idProduct;
}
