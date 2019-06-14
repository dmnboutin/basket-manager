package fr.damaketo.basketmanager.api.infrastructure.basket.league;

import fr.damaketo.basketmanager.api.domain.*;
import fr.damaketo.basketmanager.api.infrastructure.account.AccountDocument;
import fr.damaketo.basketmanager.api.infrastructure.basket.team.TeamDocument;
import fr.damaketo.basketmanager.api.infrastructure.basket.team.TeamMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 */
public class LeagueDefaultRepository implements LeagueRepository {

    private final LeagueMongoRepository leagueMongoRepository;
    private final TeamMongoRepository teamMongoRepository;

    public LeagueDefaultRepository(LeagueMongoRepository leagueMongoRepository, TeamMongoRepository teamMongoRepository) {
        this.leagueMongoRepository = leagueMongoRepository;
        this.teamMongoRepository = teamMongoRepository;
    }

    public Mono<League> create(League league) {
        final LeagueDocument leagueDocument = new LeagueDocument();
        leagueDocument.setName(league.getName());
        leagueDocument.setCreationDate(LocalDateTime.now());
        leagueDocument.setUpdateDate(LocalDateTime.now());
        leagueDocument.setNumberOfTeam(league.getNumberOfTeam());
        leagueDocument.setStatus(LeagueStatus.CREATED.name());
        final AccountDocument accountDocument = new AccountDocument();
        accountDocument.setId(league.getAdministrator().getId());
        accountDocument.setLogin(league.getAdministrator().getLogin());
        leagueDocument.setAdministrator(accountDocument);
        return leagueMongoRepository.save(leagueDocument)
            .map(document -> {
                league.setId(document.getId());
                league.setStatus(LeagueStatus.valueOf(document.getStatus()));
                return league;
            })
                .doOnError(throwable -> Mono.error(new Exception(throwable)));
    }

    public Mono<League> getById(String id) {
        return leagueMongoRepository.findById(id)
                .map(leagueDocument -> {
                    final League league = new League();
                    league.setId(leagueDocument.getId());
                    league.setCreationDate(leagueDocument.getCreationDate());
                    league.setUpdateDate(leagueDocument.getUpdateDate());
                    league.setName(leagueDocument.getName());
                    league.setNumberOfTeam(leagueDocument.getNumberOfTeam());
                    league.setStatus(LeagueStatus.valueOf(leagueDocument.getStatus()));
                    league.setAdministrator(leagueDocument.getAdministrator().toAccount());
                    if(leagueDocument.getTeams() != null) {
                        league.setTeams(leagueDocument.getTeams().stream().map(TeamDocument::toTeam).collect(Collectors.toList()));
                    }
                    return league;
                });
    }

    public Flux<League> getAll() {
        return null;
    }

    public Mono<Team> createTeam(Team team, String leagueId, Account accountId) {
        return leagueMongoRepository.findById(leagueId)
                .map(AddTeamContext::new)
                .flatMap(addTeamContext -> createTeam(team, accountId, addTeamContext))
                .flatMap(addTeamContext -> {
                    final LeagueDocument leagueDocument = addTeamContext.getLeagueDocument();
                    leagueDocument.setUpdateDate(LocalDateTime.now());
                    if(leagueDocument.getTeams() == null) {
                        leagueDocument.setTeams(new ArrayList<>());
                    }
                    leagueDocument.getTeams().add(addTeamContext.getTeamDocument());
                    if(leagueDocument.getTeams().size() == leagueDocument.getNumberOfTeam()) {
                        leagueDocument.setStatus(LeagueStatus.WAITING_GENERATION.name());
                    }
                    return leagueMongoRepository.save(leagueDocument)
                            .map(leagueDocument1 -> addTeamContext.getTeamDocument().toTeam());
                });
    }

    private Mono<AddTeamContext> createTeam(Team team, Account accountId, AddTeamContext addTeamContext) {
        final TeamDocument teamDocument = new TeamDocument();
        teamDocument.setCity(team.getCity().getName());
        teamDocument.setCreationDate(LocalDateTime.now());
        final AccountDocument manager = new AccountDocument();
        manager.setId(accountId.getId());
        manager.setLogin(accountId.getLogin());
        teamDocument.setManager(manager);
        return teamMongoRepository.save(teamDocument)
                .map(teamDocument1 -> {
                    addTeamContext.setTeamDocument(teamDocument);
                    return addTeamContext;
                });
    }

    class AddTeamContext {
        private TeamDocument teamDocument;
        private LeagueDocument leagueDocument;

        public AddTeamContext(LeagueDocument leagueDocument) {
            this.leagueDocument = leagueDocument;
        }

        public TeamDocument getTeamDocument() {
            return teamDocument;
        }

        public void setTeamDocument(TeamDocument teamDocument) {
            this.teamDocument = teamDocument;
        }

        public LeagueDocument getLeagueDocument() {
            return leagueDocument;
        }

        public void setLeagueDocument(LeagueDocument leagueDocument) {
            this.leagueDocument = leagueDocument;
        }
    }
}




