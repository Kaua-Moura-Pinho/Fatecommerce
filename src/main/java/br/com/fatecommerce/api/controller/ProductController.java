package br.com.fatecommerce.api.controller;

import br.com.fatecommerce.api.entity.Product;
import br.com.fatecommerce.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/product")
@CrossOrigin(value = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getInfoCategories() {
        List<Product> result = productService.getInfoCategories();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        Product result = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/delete/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long idProduct) {
        HashMap<String, Object> result = productService.deleteProduct(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/findProduct/{idProduct}")
    public ResponseEntity<Object> getProductById(@PathVariable Long idProduct){
        Product result = productService.findProductById(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        Product result = productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/findProductByEan/{eanProduct}")
    public ResponseEntity<Object> getProductByEan(@PathVariable String eanProduct){
        Optional<Product> result = productService.findByEanProduct(eanProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping(value = "/list/{skuProduct}")
    public ResponseEntity<Object> findProductBySkuProduct(@PathVariable String skuProduct) {
        List<Product> result = productService.findBySkuProduct(skuProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}

