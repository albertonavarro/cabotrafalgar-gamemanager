import com.navid.gamemanager.Application;
import com.navid.gamemanager.domain.Game;
import com.navid.gamemanager.rest.*;
import com.navid.gamemanager.rest.impl.GameManagerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertNull;


public class ComponentTest {

    ConfigurableApplicationContext app;

    RestTemplate template = new TestRestTemplate();

    @BeforeClass
    public void init() {
        app = new SpringApplication(Application.class).run(new String[0]);
    }

    @Test
    public void shouldCreateGameWithClient() {
        GameManagerClient client = new GameManagerClient("http://localhost:8080");
        RestGame game = client.createNewGame(RestScope.PUBLIC, "mode1", "map01");

        assertThat(game.getMap(), is("map01"));
        assertThat(game.getMode(), is("mode1"));
        assertThat(game.getScope(), is(RestScope.PUBLIC));
    }

    @Test
    public void shouldCreateGame() {
        HttpEntity<GameCreationRequest> request = new HttpEntity<GameCreationRequest>(new GameCreationRequest(RestScope.PUBLIC, "mode1", "map01"));
        ResponseEntity<GameCreationResponse> response = template.exchange("http://localhost:8080/games", HttpMethod.PUT, request, GameCreationResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getStatus(), is(GenericResponse.Status.OK));
        assertNull(response.getBody().getErrorCode());
        assertNull(response.getBody().getErrorDescription());
        assertThat(response.getBody().getGame().getMap(), is("map01"));
        assertThat(response.getBody().getGame().getMode(), is("mode1"));
        assertThat(response.getBody().getGame().getScope(), is(RestScope.PUBLIC));
    }

    @Test
    public void shouldNotCreateGameIfFieldsAreMissing() {
        HttpEntity<GameCreationRequest> request = new HttpEntity<GameCreationRequest>(new GameCreationRequest(RestScope.PUBLIC, "mode1", null));
        ResponseEntity<GameCreationResponse> response = template.exchange("http://localhost:8080/games", HttpMethod.PUT, request, GameCreationResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
        assertThat(response.getBody().getStatus(), is(GenericResponse.Status.ERROR));
        assertNotNull(response.getBody().getErrorCode());
        assertNotNull(response.getBody().getErrorDescription());
        assertNull(response.getBody().getGame());
    }


    @Test
    public void shouldAddPlayerWithClient() {
        GameManagerClient client = new GameManagerClient("http://localhost:8080");
        RestGame game = client.createNewGame(RestScope.PUBLIC, "mode1", "map01");

        URL url = client.addPlayer(game,"playerName", "roleName", new ArrayList(){{
            add(new RestControl("controlName1", "float", "group1"));
            add(new RestControl("controlName2", "float", "group1"));
        }});


    }

    @Test
    public void shouldAddPlayer() {
        HttpEntity<GameCreationRequest> requestGame = new HttpEntity<GameCreationRequest>(new GameCreationRequest(RestScope.PUBLIC, "mode1", "map01"));
        ResponseEntity<GameCreationResponse> responseGame = template.exchange("http://localhost:8080/games", HttpMethod.PUT, requestGame, GameCreationResponse.class);

        AddPlayerRequest addPlayerRequest = new AddPlayerRequest("playerName", "roleName", new ArrayList(){{
            add(new RestControl("controlName1", "float", "group1"));
            add(new RestControl("controlName2", "float", "group1"));
        }});
        HttpEntity<AddPlayerRequest> request = new HttpEntity<AddPlayerRequest>(addPlayerRequest);
        ResponseEntity<AddPlayerResponse> response = template.exchange("http://localhost:8080/games/"+responseGame.getBody().getGame().getId(), HttpMethod.PUT, request, AddPlayerResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getStatus(), is(GenericResponse.Status.OK));
        assertNull(response.getBody().getErrorCode());
        assertNull(response.getBody().getErrorDescription());
    }

    @Test
    public void invitationShouldExist() {
        HttpEntity<GameCreationRequest> requestGame = new HttpEntity<GameCreationRequest>(new GameCreationRequest(RestScope.PUBLIC, "mode1", "map01"));
        ResponseEntity<GameCreationResponse> responseGame = template.exchange("http://localhost:8080/games", HttpMethod.PUT, requestGame, GameCreationResponse.class);

        AddPlayerRequest addPlayerRequest = new AddPlayerRequest("playerName", "roleName", new ArrayList(){{
            add(new RestControl("controlName1", "float", "group1"));
            add(new RestControl("controlName2", "float", "group1"));
        }});
        HttpEntity<AddPlayerRequest> request = new HttpEntity<AddPlayerRequest>(addPlayerRequest);
        ResponseEntity<AddPlayerResponse> response = template.exchange("http://localhost:8080/games/" + responseGame.getBody().getGame().getId(), HttpMethod.PUT, request, AddPlayerResponse.class);

        JmsTemplate template = new JmsTemplate();
       // template.getForObject()
    }

}
