
package fr.damaketo.basketmanager.batch;

import fr.damaketo.basketmanager.api.domain.League;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 *
 */
public class LeagueItemWriter implements ItemWriter<League> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeagueItemWriter.class);

    @Override
    public void write(List<? extends League> list) throws Exception {
        LOGGER.info("Write launched on " + list.size() +" elements");
    }
}
