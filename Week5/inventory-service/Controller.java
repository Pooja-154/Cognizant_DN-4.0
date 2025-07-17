@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{productName}")
    public String checkStock(@PathVariable String productName) {
        String url = "http://product-service/products";
        Map<String, Integer> stockMap = restTemplate.getForObject(url, Map.class);

        if (stockMap.containsKey(productName)) {
            return "Stock of " + productName + ": " + stockMap.get(productName);
        }
        return "Product not found.";
    }
}
