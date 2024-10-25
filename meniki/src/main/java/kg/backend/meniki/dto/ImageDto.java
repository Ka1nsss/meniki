package kg.backend.meniki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageDto {
    Long id;
    byte[] imageBytes;
    String name;
}
