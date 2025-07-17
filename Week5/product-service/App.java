@RestController
@RequestMapping("/products")
public class ProductController {
    private Map<String, Integer> stockMap = new HashMap<>();

    @PostMapping("/{name}")
    public String addProduct(@PathVariable String name, @RequestParam int stock) {
        stockMap.put(name, stock);
        return "Product added: " + name;
    }

    @GetMapping
    public Map<String, Integer> getAll() {
        return stockMap;
    }

    @PutMapping("/{name}")
    public String updateStock(@PathVariable String name, @RequestParam int stock) {
        stockMap.put(name, stock);
        return "Stock updated for: " + name;
    }
}
