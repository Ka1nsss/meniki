package kg.backend.meniki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ImageResponseDto {
    Long id;
    String image;
    String name;
}
