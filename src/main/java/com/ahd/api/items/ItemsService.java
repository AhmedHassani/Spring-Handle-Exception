package com.ahd.api.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    public ItemsModel getItems(int id) {
        return itemsRepository.findById(id).get();
    }

    public List<ItemsModel> getListItems(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ItemsModel> pagedResult = itemsRepository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ItemsModel>();
        }
    }

    public ItemsModel addItems(ItemsModel items) {
        return itemsRepository.save(items);
    }

    public ItemsModel updateItems(ItemsModel items) {
        return itemsRepository.save(items);
    }

    public void deleteItems(int id) {
        itemsRepository.deleteById(id);
    }

    public ItemsModel findByName(String name) {
        Optional<ItemsModel> credentials = itemsRepository.findByName(name);
        return credentials.get();
    }


}

