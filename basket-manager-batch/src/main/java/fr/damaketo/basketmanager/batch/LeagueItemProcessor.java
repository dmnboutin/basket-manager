
package fr.damaketo.basketmanager.batch;

import fr.damaketo.basketmanager.api.domain.League;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 *
 */
public class LeagueItemProcessor implements ItemProcessor<League, League> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeagueItemProcessor.class);

    @Override
    public League process(League league) {
        LOGGER.info("League processing .. " + league.getName());
        return league;
    }
}
