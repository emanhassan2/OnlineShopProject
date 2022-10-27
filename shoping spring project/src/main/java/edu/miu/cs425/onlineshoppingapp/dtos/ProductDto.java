package edu.miu.cs425.onlineshoppingapp.dtos;

import edu.miu.cs425.onlineshoppingapp.model.Image;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private String name;
    private String category;
    private Double price;
    private String description;
    private List<Image> images;
}
