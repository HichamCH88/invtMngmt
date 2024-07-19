package com.hicham.stockmanagment.DTO;

import com.hicham.stockmanagment.model.Article;
import com.hicham.stockmanagment.model.ClientOrder;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientOrderLineDTO {

    private Integer id;

    private ArticleDTO article;


    private ClientOrderDTO clientOrder;
}
