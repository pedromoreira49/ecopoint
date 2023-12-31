package br.com.pedromoreira.ecopoint.api.location_item;

import br.com.pedromoreira.ecopoint.api.item.Item;
import br.com.pedromoreira.ecopoint.api.location.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "location_item")
@NoArgsConstructor
@AllArgsConstructor
public class Location_Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotBlank(message = "É necessário fornecer uma descrição!")
    private String descricao;
    @NotNull(message = "É necessário fornecer a data de associação!")
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "##########")
    private Timestamp associacao;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
