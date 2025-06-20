package gencoders.e_tech_store_app.categories;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    public Categories createCategories(@Valid @RequestBody CategoriesDto dto) {

        Categories categories = new Categories();
       categories.setName(dto.getName());
       categories.setDescription(dto.getDescription());
       categories.setImageUrl(dto.getImageUrl());

        return categoriesRepository.save(categories);
    }

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public Categories getCategoriesById(Long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categories not found"));
    }


    public Categories updateCategories(Long id, CategoriesDto dto) {
        Categories  categories = categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categories not found"));
        categories.setName(dto.getName());
        categories.setDescription(dto.getDescription());
        categories.setImageUrl(dto.getImageUrl());

        return categoriesRepository.save(categories);
    }


    public void deleteCategories(Long id) {
        categoriesRepository.deleteById(id);
    }
}
