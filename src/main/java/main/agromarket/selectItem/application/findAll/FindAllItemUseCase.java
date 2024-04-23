package main.agromarket.selectItem.application.findAll;

import main.agromarket.selectItem.domain.model.SelectItem;
import main.agromarket.selectItem.domain.ports.out.SelectItemRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllItemUseCase {
    private final SelectItemRepositoryPort repository;

    public FindAllItemUseCase(SelectItemRepositoryPort repository) {
        this.repository = repository;
    }

    public List<SelectItem> getAll(){
        return repository.getAll();
    }
}
