
package fr.damaketo.basketmanager.batch;

import fr.damaketo.basketmanager.api.domain.League;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job createLeague(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("createLeague")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<League, League> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(new LeagueItemWriter())
                .build();
    }

    private LeagueItemProcessor processor() {
        return new LeagueItemProcessor();
    }


    private LeagueItemReader reader() {
        // Call API to get list of league
        final List<League> leagues = IntStream.range(0, 50).mapToObj(
                id -> {
                    final League league = new League();
                    league.setName("Team-" + id);
                    return league;
                }
        ).collect(Collectors.toList());

        return new LeagueItemReader(leagues);
    }
}
