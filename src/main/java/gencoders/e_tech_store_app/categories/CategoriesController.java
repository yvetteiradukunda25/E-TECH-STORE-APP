package gencoders.e_tech_store_app.categories;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoriesService categoriesService;

    @PostMapping("/create")
    public Categories create(@RequestBody CategoriesDto dto) {
        return categoriesService.createCategories(dto);
    }

    @GetMapping
    public List<Categories> getAll() {
        return categoriesService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categories getById(@PathVariable Long id) {
        return categoriesService.getCategoriesById(id);
    }

    @PutMapping("/update/{id}")
    public Categories update(@PathVariable Long id, @RequestBody CategoriesDto dto) {
        return categoriesService.updateCategories(id, dto);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoriesService.deleteCategories(id);
    }
}
