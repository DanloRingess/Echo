package org.academiadecodigo.hexaltistas.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import org.academiadecodigo.hexaltistas.Echo;
import org.academiadecodigo.hexaltistas.model.PlaceType;
import org.academiadecodigo.hexaltistas.service.UserService;


public class ActiveScreen extends AbstractScreen {

    private UserService userService;

    private Texture appBackground;
    private Table titleTable;
    private Label title;
    private Label description;

    private Label top3;
    private Label position1;
    private CheckBox voteBox1;
    private Label numberOfVotes1;
    private Label echo1;

    private Label position2;
    private CheckBox voteBox2;
    private Label numberOfVotes2;
    private Label echo2;

    private Label position3;
    private CheckBox voteBox3;
    private Label numberOfVotes3;
    private Label echo3;

    private Label last3;
    private Label lastEcho1;
    private CheckBox voteLast1;
    private Label numberOfVotesLast1;
    private Label echo4;

    private Label lastEcho2;
    private CheckBox voteLast2;
    private Label numberOfVotesLast2;
    private Label echo5;

    private Label lastEcho3;
    private CheckBox voteLast3;
    private Label numberOfVotesLast3;
    private Label echo6;


    private TextField textInput;
    private TextButton shoutButton;


    public ActiveScreen(Echo game, UserService userService) {
        super(game);

        this.userService=userService;

        this.appBackground = new Texture("map_background.png");

        titleTable = new Table();
        title = new Label("About this location", game.getAppSkin());
        description = new Label("", game.getAppSkin());
        top3 = new Label("Top 3 Echoes", game.getAppSkin());
        last3 = new Label("Last 3 Echoes", game.getAppSkin());

        position1 = new Label("#1", game.getAppSkin());
        voteBox1 = new CheckBox("Echo", game.getAppSkin());
        numberOfVotes1 = new Label("", game.getAppSkin());
        echo1 = new Label("", game.getAppSkin());

        position2 = new Label("#2", game.getAppSkin());
        voteBox2 = new CheckBox("Echo", game.getAppSkin());
        numberOfVotes2 = new Label("", game.getAppSkin());
        echo2 = new Label("", game.getAppSkin());

        position3 = new Label("#3", game.getAppSkin());
        voteBox3 = new CheckBox("Echo", game.getAppSkin());
        numberOfVotes3 = new Label("", game.getAppSkin());
        echo3 = new Label("", game.getAppSkin());

        lastEcho1 = new Label("#1", game.getAppSkin());
        voteLast1 = new CheckBox("Echo", game.getAppSkin());
        numberOfVotesLast1 = new Label("", game.getAppSkin());
        echo4 = new Label("", game.getAppSkin());

        lastEcho2 = new Label("#2", game.getAppSkin());
        voteLast2 = new CheckBox("Echo", game.getAppSkin());
        numberOfVotesLast2 = new Label("", game.getAppSkin());
        echo5 = new Label("", game.getAppSkin());

        lastEcho3 = new Label("#3", game.getAppSkin());
        voteLast3 = new CheckBox("Echo", game.getAppSkin());
        numberOfVotesLast3 = new Label("", game.getAppSkin());
        echo6 = new Label("", game.getAppSkin());


        textInput = new TextField("", game.getAppSkin());
        shoutButton = new TextButton("Shout", game.getAppSkin());

    }

    @Override
    public void init() {
        super.init();


        titleTable.setFillParent(true);

        titleTable.top().left();

        titleTable.add(title).pad(101, 30, 0, 0);
        titleTable.row().setActorHeight(1500);
        titleTable.add(description).pad(0, 30, 10, 0);
        titleTable.row();
        titleTable.add(top3).pad(10, 100, 5, 0);
        titleTable.row();

        titleTable.add(position1).padLeft(-75);
        titleTable.add(voteBox1).padLeft(-200);
        titleTable.add(numberOfVotes1).padLeft(-120);
        titleTable.row();
        titleTable.add(echo1).padLeft(20);
        titleTable.row();

        titleTable.add(position2).padLeft(-75);
        titleTable.add(voteBox2).padLeft(-200);
        titleTable.add(numberOfVotes2).padLeft(-120);
        titleTable.row();
        titleTable.add(echo2).padLeft(20);
        titleTable.row();

        titleTable.add(position3).padLeft(-75);
        titleTable.add(voteBox3).padLeft(-200);
        titleTable.add(numberOfVotes3).padLeft(-120);
        titleTable.row();
        titleTable.add(echo3).padLeft(20);
        titleTable.row();

        titleTable.add(last3).pad(10, 100, 5, 0);
        titleTable.row();

        titleTable.add(lastEcho1).padLeft(-75);
        titleTable.add(voteLast1).padLeft(-200);
        titleTable.add(numberOfVotesLast1).padLeft(-120);
        titleTable.row();
        titleTable.add(echo4).padLeft(20);
        titleTable.row();

        titleTable.add(lastEcho2).padLeft(-75);
        titleTable.add(voteLast2).padLeft(-200);
        titleTable.add(numberOfVotesLast2).padLeft(-120);
        titleTable.row();
        titleTable.add(echo5).padLeft(20);
        titleTable.row();

        titleTable.add(lastEcho3).padLeft(-75);
        titleTable.add(voteLast3).padLeft(-200);
        titleTable.add(numberOfVotesLast3).padLeft(-120);
        titleTable.row();
        titleTable.add(echo6).padLeft(20);
        titleTable.row().padTop(50);

        textInput.setMaxLength(40);
        titleTable.add(textInput).padLeft(20).padTop(10);
        titleTable.add(shoutButton).pad(10, 10, 0, 0);
    }

    @Override
    public void show() {

        super.show();
        setupAppTables();

    }

    private void setupAppTables() {


       // description.setText(userService.createShout("create shout", PlaceType.ANGOLA.ordinal()));

        echo1.setText("string from DB");
        numberOfVotes1.setText("54");

        echo2.setText("another string from DB");
        numberOfVotes2.setText("35");

        echo3.setText("another string from db");
        numberOfVotes3.setText("22");

        echo4.setText("another string from db");
        numberOfVotesLast1.setText("14");

        echo5.setText("another string from db");
        numberOfVotesLast2.setText("8");

        echo6.setText("another string from db");
        numberOfVotesLast3.setText("0");


        stage.addActor(titleTable);
    }

    @Override
    protected void loadSpriteBatch() {
        batch.begin();
        batch.draw(phone, 0, 0);
        batch.draw(map, 333, 0);
        batch.draw(appBackground, 26, 100);
        batch.end();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
