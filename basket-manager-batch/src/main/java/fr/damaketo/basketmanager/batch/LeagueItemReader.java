
package fr.damaketo.basketmanager.batch;

import fr.damaketo.basketmanager.api.domain.League;
import org.springframework.batch.item.support.ListItemReader;

import java.util.List;

/**
 *
 */
public class LeagueItemReader extends ListItemReader<League> {

    public LeagueItemReader(List<League> list) {
        super(list);
    }
}
