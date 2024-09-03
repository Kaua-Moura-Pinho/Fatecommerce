package br.com.fatecommerce.api.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Long idProduct;

    @Column(name = "name_product", nullable = false, length = 300, unique = true)
    @NotBlank(message = "O campo nome é obrigatório!")
    @Length(min = 2, max = 300, message = "O nome do produto deve ter entre 2 e 300 caracteres!")
    private String nameProduct;

    @Column(name = "description_product", length = 1000, nullable = false)
    @NotBlank(message = "O campo descrição é obrigatório!")
    @Length(min = 2, max = 300, message = "A descrição do produto deve ter entre 2 e 300 caracteres!")
    private String descriptionProduct;

    @Column(name = "sku_product", length = 100000, nullable = false)
    @NotBlank(message = "O campo SKU é obrigatório!")
    @Length(min = 2, max = 300, message = "O SKU do produto deve ter entre 2 e 300 caracteres!")
    private String skuProduct;

    @Column(name = "ean_product", length = 100000, nullable = false)
    @NotBlank(message = "O campo EAN é obrigatório!")
    @Length(min = 2, max = 300, message = "O EAN deve ter entre 2 e 15 caracteres!")
    private String eanProduct;

    @Column(name = "cost_price_product", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "O campo de custo do produto é obrigatório!")
    private BigDecimal costPriceProduct;

    @Column(name = "amount_product", nullable = false)
    @NotNull(message = "O campo de venda do produto é obrigatório!")
    private BigDecimal amountProduct;

    @Column(name = "published_product", nullable = false)
    private Boolean publishedProduct;

    @Column(name = "stock_product", nullable = false)
    @NotNull(message = "O estoque do produto é obrigatório!")
    private Long stockProduct;

    @Column(name = "date_created_product", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreatedProduct;

    @Column(name = "date_update_product")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateUpdateProduct;

    @PrePersist
    private void prePersist() {
        this.setPublishedProduct(false);
        this.setDateCreatedProduct(LocalDate.now());
    }

    @PreUpdate
    private void preUpdate(){
        this.setDateUpdateProduct(LocalDate.now());
    }
}